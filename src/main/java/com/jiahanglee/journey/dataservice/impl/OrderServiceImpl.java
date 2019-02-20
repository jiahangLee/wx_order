package com.jiahanglee.journey.dataservice.impl;

import com.jiahanglee.journey.converter.OrderMaster2OrderDTOConverter;
import com.jiahanglee.journey.dataobject.OrderDetail;
import com.jiahanglee.journey.dataobject.OrderMaster;
import com.jiahanglee.journey.dataobject.ProductInfo;
import com.jiahanglee.journey.dataservice.OrderService;
import com.jiahanglee.journey.dataservice.ProductService;
import com.jiahanglee.journey.dto.CatDTO;
import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.enums.OrderStatusEnum;
import com.jiahanglee.journey.enums.PayStatusEnum;
import com.jiahanglee.journey.enums.ResultEnum;
import com.jiahanglee.journey.exception.SellException;
import com.jiahanglee.journey.repository.OrderDetailRepository;
import com.jiahanglee.journey.repository.OrderMasterRepository;
import com.jiahanglee.journey.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 21:52
 * @Description: //TODO
 * @version: V1.0
 */

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(String.valueOf(BigDecimal.ZERO));
        for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);
        }

        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);

        List<CatDTO> catDTOS = orderDTO.getOrderDetails().stream().map(x -> new CatDTO(x.getProductId(), x.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(catDTOS);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {

        Optional<OrderMaster> option = orderMasterRepository.findById(orderId);
        OrderMaster orderMaster;
        if (!option.isPresent())
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        else
            orderMaster = option.get();
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetails(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasters = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        List<OrderDTO> orderDTOS = OrderMaster2OrderDTOConverter.convert(orderMasters.getContent());
        Page<OrderDTO> orderDTOPage = new PageImpl<OrderDTO>(orderDTOS, pageable, orderMasters.getTotalElements());
        return orderDTOPage;
    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();

        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.New.getCode())) {
            log.info("【取消订单】订单状态不正常");
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null) {
            log.error("【取消订单】更新失败");
            throw new SellException(ResultEnum.ORDER_UPDATE_ERROR);
        }

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            throw new SellException(ResultEnum.ORDER_UPDATE_ERROR);
        }
        List<CatDTO> catDTOs = orderDTO.getOrderDetails().stream()
                .map(e -> new CatDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.increaseStock(catDTOs);

        if (orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            //TODO
        }


        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.New.getCode())) {
            log.error("");
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null) {
            log.error("");
            throw new SellException(ResultEnum.ORDER_UPDATE_ERROR);
        }

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO pay(OrderDTO orderDTO) {
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.New.getCode())) {
            log.error("");
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        if (!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.error("");
            throw new SellException(ResultEnum.ORDER_PAY_ERROR);
        }
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null) {
            log.error("");
            throw new SellException(ResultEnum.ORDER_UPDATE_ERROR);
        }
        return orderDTO;
    }
}
