package com.jsg.dzfbhealthcard.model;

import lombok.Data;

import java.util.Date;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 公共请求参数
 * @since 2019/8/29 17:26
 */
@Data
public class RequestParamModel {
    private String method ; //->接口名称 ->String(50)必填
    private String appId = "053AF345-D4AC-4C7D-A5F7-193440BF799D";  //->应用编号 ->String(32)必填
//    private String appId = "6d8bb1b860724faa97164e87b654cd3c";  //->应用编号 ->String(32)必填
    //4565aacc7c9349208fce65ca748213f4
    private String version = "0.1";    //->接口版本号 ->String(10)必填
    private String timestamp  = Long.toString(new Date().getTime());  //->请求、响应报文时间戳 ->String(20)必填
    private String digestType = "md5"; //->摘要类型 ->String(10)必填
    private String digest ; //->摘要值 ->String(256)必填
    private String encType = "AES/ECB/PKCS5Padding";    //->加密类型 ->String(10)必填
    private String bizContent ; //->响应参数集合 ->String(-)必填
}
