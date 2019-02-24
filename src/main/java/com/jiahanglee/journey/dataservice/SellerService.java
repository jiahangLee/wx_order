package com.jiahanglee.journey.dataservice;

import com.jiahanglee.journey.dataobject.SellerInfo;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/24 22:36
 * @Description: //TODO
 * @version: V1.0
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
