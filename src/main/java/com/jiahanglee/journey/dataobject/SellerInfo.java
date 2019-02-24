package com.jiahanglee.journey.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/24 22:16
 * @Description: //TODO
 * @version: V1.0
 */
@Data
@Entity
public class SellerInfo {
    @Id
    private String sellerId;
    private String username;
    private String password;
    private String openid;
}
