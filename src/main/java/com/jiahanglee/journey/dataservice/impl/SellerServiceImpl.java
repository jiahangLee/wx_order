package com.jiahanglee.journey.dataservice.impl;

import com.jiahanglee.journey.dataobject.SellerInfo;
import com.jiahanglee.journey.dataservice.SellerService;
import com.jiahanglee.journey.repository.SellerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/24 22:38
 * @Description: //TODO
 * @version: V1.0
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerService;
    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerService.findByOpenid(openid);
    }
}
