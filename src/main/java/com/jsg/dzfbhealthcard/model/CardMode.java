package com.jsg.dzfbhealthcard.model;

import lombok.Data;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 类描述
 * @since 2019/8/31 15:09
 */
@Data
public class CardMode {
    private String cardType;    //->证件类型 ->String(2)
    private String cardNo;  //->证件号 ->String(32)
}
