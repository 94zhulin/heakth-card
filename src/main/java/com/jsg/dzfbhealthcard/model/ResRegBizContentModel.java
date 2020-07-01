package com.jsg.dzfbhealthcard.model;

import lombok.Data;

import java.util.List;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 健康卡注册 返回的 bizContent 对象
 * @since 2019/8/31 15:03
 */
@Data
public class ResRegBizContentModel {
    private String ehealthCardId;   //->电子健康卡ID ->String(128)
    private String mindexId;    //->居民健康卡主索引ID ->String(128)
    private String healthCardNo;    //->居民健康卡卡号 ->String(32)
    private String xmanId;  //->市民健康系统ID ->String(32)
    private String idType;  //->证件类型 ->String(2)
    private String idNo;    //->证件号 ->String(32)
    private String name;    //->用户姓名 ->String(50)
    private String cardType;    //->卡类型 ->String(2)
    private String cardNo;  //->就诊卡号 ->String(32)
    private List<CardMode> cards;   //->绑定卡列表 ->[]
}
