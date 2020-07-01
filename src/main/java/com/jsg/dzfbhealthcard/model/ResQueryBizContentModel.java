package com.jsg.dzfbhealthcard.model;

import lombok.Data;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 类描述
 * @since 2019/9/1 11:47
 */
@Data
public class ResQueryBizContentModel {
    private String ehealthCardId;   //->电子健康卡ID ->String(128)
    private String mindexId;    //->居民健康卡主索引ID ->String(128)
    private String idType;  //->证件类型 ->String(2)
    private String idNo;    //->证件号 ->String(32)
    private String name;    //->用户姓名 ->String(50)
    private String gender;  //->用户性别 ->String(1)
    private String birthday;    //->出生日期 ->Long(20)（年月日，毫秒）
    private String cellphone;   //->手机号码 ->String(32)
    private String telephone;   //->联系电话 ->String(32)
    private String address; //->居住地址 ->String(200)
    private String unit;    //->工作单位 ->String(100)
}
