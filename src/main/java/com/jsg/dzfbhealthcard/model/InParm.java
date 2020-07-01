package com.jsg.dzfbhealthcard.model;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NotNull(message = "请求失败，参数为空！")
public class InParm {
	String yljgbm;//医疗机构编码
	String czybm; //操作员编码
	String czyxm; //操作员姓名
	String cardId;	//卡号
	String ksbm;
	String medstepcode;
	String terminalcode;
	@NotNull(message = "请求失败，参数为空！")
	@NotEmpty(message = "请求失败，参数为空！")
	String inJson; //入参Json字符串
}
