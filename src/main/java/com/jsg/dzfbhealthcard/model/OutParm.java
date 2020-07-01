package com.jsg.dzfbhealthcard.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class OutParm {

	String returnCode = "0";//返回代码0=成功，1=失败
	String msgInfo;//返回错误信息
	String outJson;//返回交易成功json字符串
	String outResult;//返回结果集
	Map<String, Object> resResult = new HashMap<String , Object>();

	public void setNullParamValidate(){
		this.setMsgInfo("参数为空！");
		this.setReturnCode("1");
		this.setOutJson("参数为空!");
	}

	public void setExcutionError(String msg){
		this.setMsgInfo(msg);
		this.setReturnCode("1");
		this.setOutJson(msg);
	}

	public void setExcutionSuccess(String msg){
		this.setMsgInfo(msg);
		this.setReturnCode("0");
		this.setOutJson(msg);
	}
	
}
