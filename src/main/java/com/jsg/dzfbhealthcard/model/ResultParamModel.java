package com.jsg.dzfbhealthcard.model;

import lombok.Data;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 类描述
 * @since 2019/8/31 15:07
 */

@Data
public class ResultParamModel<T> {
    private String code;   //->返回结果码 ->String(10)
    private String message ;    //->返回结果说明 ->String(100)
    private String method ; //->接口名称 ->String(50)
    private String appId ;  //->应用编号 ->String(32)
    private String version ;    //->接口版本号 ->String(10)
    private String timestamp ;  //->请求、响应报文时间戳 ->Long(20)（毫秒）
    private String digestType ; //->摘要类型 ->String(10)
    private String digest ; //->摘要值 ->String(256)
    private String encType ;    //->加密类型 ->String(10)
    private T bizContent ; //->响应参数集合 ->String(-)
}
