package com.jsg.dzfbhealthcard.model;

import lombok.Data;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 健康卡注册请求参数bizContent 对象
 * @since 2019/8/31 11:59
 */
@Data
public class ReqRegBizContentModel {
        private String registerNo;  //->外部注册流水号->String(32)必填
        private String registerTime;    //->外部注册时间->Long(32)必填（毫秒）
        private String applyType    ;   //申请方式->String(1)
        private String idType;  //->证件类型->String(2)必填
        private String idNo;    //->证件号->String(32)必填
        private String name;    //->用户姓名  ->String(50)  必填
        private String gender;  //->用户性别->String(1)必填
        private String birthday;    //->出生日期->Long(20) （年月日，毫秒)必填
        private String cellphone;   //->手机号码->String(32)
        private String telephone;   //->联系电话->String(32)
        private String address; //->居住地址->String(200)
        private String unit;    //->工作单位->String(100)
}
