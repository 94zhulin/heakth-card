package com.jsg.dzfbhealthcard.util;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTimeUtil
{

    // 格式：2007年06月07日 12时12分12秒234毫秒
    private final static String[] FORMAT_CHINA      = {"年", "月", "日", "时", "分", "秒", "毫秒"};
    // 格式：2007年06月07日
    private final static String[] FORMAT_DATE_CHINA = {"年", "月", "日"};
    // 格式：2007-06-07 12:12:12 234
    private final static String[] FORMAT_NORMAL     = {"-", "-", "", ":", ":", "", ""};
    // 格式：2007/06/07 12:12:12 234
    private final static String[] FORMAT_DATATIME   = {"/", "/", "", ":", ":", "", ""};
    // 格式：中文星期
    private final static String[] FORMAT_WEEK       = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    /**
     * 时间转大写（hh:mm:ss）
     * 
     * @Title: dateToCnDate
     * @Description: TODO
     * @Param: @param date 需要转换的日期
     * @Param: @return
     * @Return: String
     * @Comment:
     * @Author: 肖大帅
     * @CreateDate: 2018.01.11
     */
    public static String dateToCnDate(String date) {
        String result = "";
        String[]  cnDate = new String[]{"零","一","二","三","四","五","六","七","八","九"};
        String ten = "十";
        String[] dateStr = date.split(":");
        for (int i=0; i<dateStr.length; i++) {     
            for (int j=0; j<dateStr[i].length(); j++) {    
                String charStr = dateStr[i];
                String str = String.valueOf(charStr.charAt(j));
                	if((i==0)&&(charStr.equals("00")))  
                	{  
                    result +=cnDate[0];  
                    break;  
                	} 
                    if((i==0)&&(charStr.equals("01")))  
                    {  
                        result += cnDate[0]+cnDate[1];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("02")))  
                    {  
                        result += cnDate[0]+cnDate[2];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("03")))  
                    {  
                        result += cnDate[0]+cnDate[3];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("04")))  
                    {  
                        result += cnDate[0]+cnDate[4];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("05")))  
                    {  
                        result += cnDate[0]+cnDate[5];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("06")))  
                    {  
                        result += cnDate[0]+cnDate[6];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("07")))  
                    {  
                        result += cnDate[0]+cnDate[7];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("08")))  
                    {  
                        result += cnDate[0]+cnDate[8];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("09")))  
                    {  
                        result += cnDate[0]+cnDate[9];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("10")))  
                    {  
                        result += ten;  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("11")))  
                    {  
                        result += ten+cnDate[1];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("12")))  
                    {  
                        result += ten+cnDate[2];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("13")))  
                    {  
                        result += ten+cnDate[3];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("14")))  
                    {  
                        result += ten+cnDate[4];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("15")))  
                    {  
                        result += ten+cnDate[5];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("16")))  
                    {  
                        result += ten+cnDate[6];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("17")))  
                    {  
                        result += ten+cnDate[7];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("18")))  
                    {  
                        result += ten+cnDate[8];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("19")))  
                    {  
                        result += ten+cnDate[9];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("20")))  
                    {  
                        result +=cnDate[2]+ten;  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("21")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[1];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("22")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[2];  
                        break;  
                    }  
                    if((i==0)&&(charStr.equals("23")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[3];  
                        break;  
                    }  
                 	if((i==1)&&(charStr.equals("00")))  
                	{  
                    result +=cnDate[0];  
                    break;  
                	} 
                    if((i==1)&&(charStr.equals("01")))  
                    {  
                        result += cnDate[0]+cnDate[1];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("02")))  
                    {  
                        result += cnDate[0]+cnDate[2];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("03")))  
                    {  
                        result += cnDate[0]+cnDate[3];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("04")))  
                    {  
                        result += cnDate[0]+cnDate[4];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("05")))  
                    {  
                        result += cnDate[0]+cnDate[5];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("06")))  
                    {  
                        result += cnDate[0]+cnDate[6];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("07")))  
                    {  
                        result += cnDate[0]+cnDate[7];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("08")))  
                    {  
                        result += cnDate[0]+cnDate[8];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("09")))  
                    {  
                        result += cnDate[0]+cnDate[9];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("10")))  
                    {  
                        result += ten;  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("11")))  
                    {  
                        result += ten+cnDate[1];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("12")))  
                    {  
                        result += ten+cnDate[2];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("13")))  
                    {  
                        result += ten+cnDate[3];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("14")))  
                    {  
                        result += ten+cnDate[4];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("15")))  
                    {  
                        result += ten+cnDate[5];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("16")))  
                    {  
                        result += ten+cnDate[6];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("17")))  
                    {  
                        result += ten+cnDate[7];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("18")))  
                    {  
                        result += ten+cnDate[8];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("19")))  
                    {  
                        result += ten+cnDate[9];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("20")))  
                    {  
                        result +=cnDate[2]+ten;  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("21")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[1];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("22")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[2];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("23")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[3];  
                        break;  
                    }  
                 	if((i==1)&&(charStr.equals("24")))  
                	{  
                    result +=cnDate[2]+ten+cnDate[4];  
                    break;  
                	} 
                    if((i==1)&&(charStr.equals("25")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[5];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("26")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[6];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("27")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[7];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("28")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[8];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("29")))  
                    {  
                        result +=cnDate[2]+ten+cnDate[9];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("30")))  
                    {  
                        result += cnDate[3]+ten;  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("31")))  
                    {  
                        result += cnDate[3]+ten+cnDate[1];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("32")))  
                    {  
                        result +=cnDate[3]+ten+cnDate[2];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("33")))  
                    {  
                        result += cnDate[3]+ten+cnDate[3];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("34")))  
                    {  
                        result +=cnDate[3]+ten+cnDate[4];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("35")))  
                    {  
                        result += cnDate[3]+ten+cnDate[5];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("36")))  
                    {  
                        result +=cnDate[3]+ten+cnDate[6];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("37")))  
                    {  
                        result +=cnDate[3]+ten+cnDate[7];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("38")))  
                    {  
                        result += cnDate[3]+ten+cnDate[8];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("39")))  
                    {  
                        result +=cnDate[3]+ten+cnDate[9];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("40")))  
                    {  
                        result +=cnDate[4]+ten;  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("41")))  
                    {  
                        result +=cnDate[4]+ten+cnDate[1];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("42")))  
                    {  
                        result +=cnDate[4]+ten+cnDate[2];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("43")))  
                    {  
                        result +=cnDate[4]+ten+cnDate[3];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("44")))  
                    {  
                        result +=cnDate[4]+ten+cnDate[4];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("45")))  
                    {  
                        result +=cnDate[4]+ten+cnDate[5];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("46")))  
                    {  
                        result +=cnDate[4]+ten+cnDate[6];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("47")))  
                    {  
                        result +=cnDate[4]+ten+cnDate[7];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("48")))  
                    {  
                        result +=cnDate[4]+ten+cnDate[8];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("49")))  
                    {  
                        result +=cnDate[4]+ten+cnDate[9];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("50")))  
                    {  
                        result += cnDate[5]+ten;  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("51")))  
                    {  
                        result +=cnDate[5]+ten+cnDate[1];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("52")))  
                    {  
                        result +=cnDate[5]+ten+cnDate[2];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("53")))  
                    {  
                        result +=cnDate[5]+ten+cnDate[3];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("54")))  
                    {  
                        result += cnDate[5]+ten+cnDate[4];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("55")))  
                    {  
                        result += cnDate[5]+ten+cnDate[5];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("56")))  
                    {  
                        result +=cnDate[5]+ten+cnDate[6];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("57")))  
                    {  
                        result +=cnDate[5]+ten+cnDate[7];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("58")))  
                    {  
                        result +=cnDate[5]+ten+cnDate[8];  
                        break;  
                    }  
                    if((i==1)&&(charStr.equals("59")))  
                    {  
                        result += cnDate[5]+ten+cnDate[9];  
                        break;  
                    }  
//                	if((i==2)&&(charStr.equals("00")))  
//                	{  
//                    result +=cnDate[0];  
//                    break;  
//                	} 
//                    if((i==2)&&(charStr.equals("01")))  
//                    {  
//                        result += cnDate[0]+cnDate[1];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("02")))  
//                    {  
//                        result += cnDate[0]+cnDate[2];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("03")))  
//                    {  
//                        result += cnDate[0]+cnDate[3];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("04")))  
//                    {  
//                        result += cnDate[0]+cnDate[4];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("05")))  
//                    {  
//                        result += cnDate[0]+cnDate[5];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("06")))  
//                    {  
//                        result += cnDate[0]+cnDate[6];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("07")))  
//                    {  
//                        result += cnDate[0]+cnDate[7];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("08")))  
//                    {  
//                        result += cnDate[0]+cnDate[8];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("09")))  
//                    {  
//                        result += cnDate[0]+cnDate[9];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("10")))  
//                    {  
//                        result += ten;  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("11")))  
//                    {  
//                        result += ten+cnDate[1];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("12")))  
//                    {  
//                        result += ten+cnDate[2];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("13")))  
//                    {  
//                        result += ten+cnDate[3];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("14")))  
//                    {  
//                        result += ten+cnDate[4];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("15")))  
//                    {  
//                        result += ten+cnDate[5];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("16")))  
//                    {  
//                        result += ten+cnDate[6];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("17")))  
//                    {  
//                        result += ten+cnDate[7];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("18")))  
//                    {  
//                        result += ten+cnDate[8];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("19")))  
//                    {  
//                        result += ten+cnDate[9];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("20")))  
//                    {  
//                        result +=cnDate[2]+ten;  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("21")))  
//                    {  
//                        result +=cnDate[2]+ten+cnDate[1];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("22")))  
//                    {  
//                        result +=cnDate[2]+ten+cnDate[2];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("23")))  
//                    {  
//                        result +=cnDate[2]+ten+cnDate[3];  
//                        break;  
//                    }  
//                 	if((i==2)&&(charStr.equals("24")))  
//                	{  
//                    result +=cnDate[2]+ten+cnDate[4];  
//                    break;  
//                	} 
//                    if((i==2)&&(charStr.equals("25")))  
//                    {  
//                        result +=cnDate[2]+ten+cnDate[5];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("26")))  
//                    {  
//                        result +=cnDate[2]+ten+cnDate[6];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("27")))  
//                    {  
//                        result +=cnDate[2]+ten+cnDate[7];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("28")))  
//                    {  
//                        result +=cnDate[2]+ten+cnDate[8];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("29")))  
//                    {  
//                        result +=cnDate[2]+ten+cnDate[9];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("30")))  
//                    {  
//                        result += cnDate[3]+ten;  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("31")))  
//                    {  
//                        result += cnDate[3]+ten+cnDate[1];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("32")))  
//                    {  
//                        result +=cnDate[3]+ten+cnDate[2];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("33")))  
//                    {  
//                        result += cnDate[3]+ten+cnDate[3];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("34")))  
//                    {  
//                        result +=cnDate[3]+ten+cnDate[4];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("35")))  
//                    {  
//                        result += cnDate[3]+ten+cnDate[5];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("36")))  
//                    {  
//                        result +=cnDate[3]+ten+cnDate[6];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("37")))  
//                    {  
//                        result +=cnDate[3]+ten+cnDate[7];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("38")))  
//                    {  
//                        result += cnDate[3]+ten+cnDate[8];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("39")))  
//                    {  
//                        result +=cnDate[3]+ten+cnDate[9];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("40")))  
//                    {  
//                        result +=cnDate[4]+ten;  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("41")))  
//                    {  
//                        result +=cnDate[4]+ten+cnDate[1];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("42")))  
//                    {  
//                        result +=cnDate[4]+ten+cnDate[2];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("43")))  
//                    {  
//                        result +=cnDate[4]+ten+cnDate[3];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("44")))  
//                    {  
//                        result +=cnDate[4]+ten+cnDate[4];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("45")))  
//                    {  
//                        result +=cnDate[4]+ten+cnDate[5];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("46")))  
//                    {  
//                        result +=cnDate[4]+ten+cnDate[6];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("47")))  
//                    {  
//                        result +=cnDate[4]+ten+cnDate[7];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("48")))  
//                    {  
//                        result +=cnDate[4]+ten+cnDate[8];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("49")))  
//                    {  
//                        result +=cnDate[4]+ten+cnDate[9];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("50")))  
//                    {  
//                        result += cnDate[5]+ten;  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("51")))  
//                    {  
//                        result +=cnDate[5]+ten+cnDate[1];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("52")))  
//                    {  
//                        result +=cnDate[5]+ten+cnDate[2];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("53")))  
//                    {  
//                        result +=cnDate[5]+ten+cnDate[3];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("54")))  
//                    {  
//                        result += cnDate[5]+ten+cnDate[4];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("55")))  
//                    {  
//                        result += cnDate[5]+ten+cnDate[5];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("56")))  
//                    {  
//                        result +=cnDate[5]+ten+cnDate[6];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("57")))  
//                    {  
//                        result +=cnDate[5]+ten+cnDate[7];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("58")))  
//                    {  
//                        result +=cnDate[5]+ten+cnDate[8];  
//                        break;  
//                    }  
//                    if((i==2)&&(charStr.equals("59")))  
//                    {  
//                        result += cnDate[5]+ten+cnDate[9];  
//                        break;  
//                    }    
            }     
            if (i == 0) {     
                result += "时";     
                continue;     
            }     
            if (i == 1) {     
                result += "分";     
                continue;     
            }     
//            if (i == 2) {     
//                result += "秒";     
//                continue;     
//            }     
        }     
        return result;     
    }    
    
    /**
     * 获取上月信息
     * 
     * @Title: getLastMonth
     * @Description: TODO
     * @Param: @param formart 给定转换格式
     * @Param: @return
     * @Return: String
     * @Comment:
     * @Author: Administrator
     * @CreateDate: Mar 29, 2012 8:54:59 PM
     */
    public static String getLastMonth(String strFormart)
    {
        SimpleDateFormat df = new SimpleDateFormat(strFormart);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        return df.format(calendar.getTime()).toString();
    }
    /**
     *用于获取两个DATE之间相差的天数 
     * @param date1
     * @param date2
     * @return
     */
    public static int dateToDays(Date date1, Date date2){
    	Calendar cal1= Calendar.getInstance();
    	Calendar cal2= Calendar.getInstance();
    	cal1.setTime(date1);
    	cal2.setTime(date2);
    	long datte1=date1.getTime()+cal1.get(Calendar.ZONE_OFFSET)+cal1.get(Calendar.DST_OFFSET);
    	long datte2=date2.getTime()+cal2.get(Calendar.ZONE_OFFSET)+cal2.get(Calendar.DST_OFFSET);
    	int hr1=(int)(datte1/3600000);
    	int hr2=(int)(datte2/3600000);
    	int d1=hr1/24;
    	int d2=hr2/24;
    	int day=d1-d2;
    	return day;
    }
    
    /**
     * 获取今日年份
     * 
     * @return yyyy
     */
    public static String getTodayYear()
    {
        return DateFormatUtils.format(new Date(), "yyyy");
    }

    /**
     * 
    * @Title: getYear  
    * @Description: TODO(获取日期年份)  
    * @param @param date
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
     */
    public static String getYear(Date date){
    	return DateFormatUtils.format(date, "yyyy");
    }
    
    /**
     * 获取今日月份
     * 
     * @return MM
     */
    public static String getTodayMonth()
    {
        return DateFormatUtils.format(new Date(), "MM");
    }

    /*
     * 获取日期月份
     */
    public static String getMonth(Date date){
    	return DateFormatUtils.format(date, "MM");
    }
    
    
    /**
     * 获取上月信息 以yyyymm格式返回
     * 
     * @Title: getLastMonthChar6
     * @Description: TODO
     * @Param: @return
     * @Return: String
     * @Comment:
     * @Author: Administrator
     * @CreateDate: 2012-6-9 下午03:37:12
     */
    public static String getLastMonthChar6()
    {
        GregorianCalendar gerCal = new GregorianCalendar();
        gerCal.setTime(new Date());
        gerCal.add(GregorianCalendar.MONTH, -1);// 在日期上减一个月
        SimpleDateFormat lastDf = new SimpleDateFormat("yyyyMM");
        return lastDf.format(gerCal.getTime()).toString();
    }

    /**
     * 
     * @Title: getLastMonthChar6ByMonth
     * @Description: 根据穿入的月份获取相应的加减月份
     * @return
     * @return String 返回类型
     * @throws
     */
    public static String getLastMonthChar6ByMonth(int month)
    {
        GregorianCalendar gerCal = new GregorianCalendar();
        gerCal.setTime(new Date());
        gerCal.add(GregorianCalendar.MONTH, month);// 在日期上减一个月
        SimpleDateFormat lastDf = new SimpleDateFormat("yyyyMM");
        return lastDf.format(gerCal.getTime()).toString();
    }

    /**
     * 
     * @Title: getDateChar8
     * @Description: 根据穿入的年月日获取日期
     * @param year
     * @param month
     * @param day
     * @return
     * @return String 返回类型
     * @throws
     */
    public static String getDateChar8(int year, int month, int day)
    {
        GregorianCalendar gerCal = new GregorianCalendar();
        gerCal.setTime(new Date());
        gerCal.add(GregorianCalendar.YEAR, year);// 在日期上减一个月
        gerCal.add(GregorianCalendar.MONTH, month);// 在日期上减一个月
        gerCal.add(GregorianCalendar.DATE, day);// 在日期上减1天
        SimpleDateFormat lastDf = new SimpleDateFormat("yyyyMMdd");
        return lastDf.format(gerCal.getTime()).toString();
    }

    /**
     * 获取今日日期
     * 
     * @return dd
     */
    public static String getTodayDay()
    {
        return DateFormatUtils.format(new Date(), "dd");
    }

    /*
     * 获取日期  天
     */
    public static String getDay(Date date){
    	return DateFormatUtils.format(date, "dd");
    }
    /**
     * 获取短日月
     * 
     * @return MMdd
     */
    public static String getTodayChar4()
    {
        return DateFormatUtils.format(new Date(), "MMdd");
    }

    /**
     * 
    * @Title: getChar4  
    * @Description: TODO(获取日期的短日月)  
    * @param @param date
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
     */
    public static String getChar4(Date date){
    	return DateFormatUtils.format(date, "MMdd");
    }
    /**
     * 获取短日月
     * 
     * @return MMdd
     */
    public static String getTodayChar4En()
    {
        return DateFormatUtils.format(new Date(), "MM-dd");
    }

    /**
     * 获取日期短日月
    * @Title: getChar4En  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param @param date
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
     */
    public static String getChar4En(Date date){
    	return DateFormatUtils.format(date, "MM-dd");
    }
    /**
     * 返回年月
     * 
     * @return yyyyMM
     */
    public static String getTodayChar6()
    {
        return DateFormatUtils.format(new Date(), "yyyyMM");
    }

    /**
     * 
    * @Title: getChar6  
    * @Description: TODO(返回日期的年月)  
    * @param @param date
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
     */
    public static String getChar6(Date date){
    	return DateFormatUtils.format(date, "yyyyMM");
    }
    /**
     * 返回年月
     * 
     * @return yyyyMM
     */
    public static String getTodayChar6En()
    {
        return DateFormatUtils.format(new Date(), "yyyy-MM");
    }

    /**
     * 
    * @Title: getChar6En  
    * @Description: TODO(返回日期的年月)  
    * @param @param date
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
     */
    public static String getChar6En(Date date){
    	return DateFormatUtils.format(date, "yyyy-MM");
    }
    /**
     * 返回年月日
     * 
     * @return yyyyMMdd
     */
    public static String getTodayChar8()
    {
        return DateFormatUtils.format(new Date(), "yyyyMMdd");
    }
    /**
     * 
    * @Title: getChar8  
    * @Description: TODO(返回日期的年月日)  
    * @param @param date
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
     */
    public static String getChar8(Date date){
    	return DateFormatUtils.format(date, "yyyyMMdd");
    }

    /**
     * 返回年月日
     * 
     * @return yyyyMMdd
     */
    public static String getTodayChar8En()
    {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd");
    }
    
    /**
     * 返回年月日
     * 
     * @return yyyyMMdd
     */
    public static Date getTodayDate()
    {
    	//dateFormat_3
    	try{
    		String rqString = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
            return dateFormat_3.parse(rqString);
    	}catch (Exception ex){
    		return null;
    	}
    	
    }
    /**
     * 
    * @Title: getDatebegin  
    * @Description: 将格式化的日期字符串转Date型 
    * @param @param date
    * @param @return    参数  
    * @return Date    返回类型  
    * @throws
     */
    public static Date getStringToDate(String rqString){
    	try{
            return dateFormat_2.parse(rqString);
    	}catch (Exception ex){
    		return null;
    	}
    }

    /**
     * 返回Data型的 年 月 日 时 分 秒
     * 
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static Date getTodayDateTime()
    {
    	try{
    		String rqString = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            return dateFormat_2.parse(rqString);
    	}catch (Exception ex){
    		return null;
    	}
    }
    /**
     * 日期加减 返回格式 yyyy-MM-dd HH:mm:ss S
     * 
     * @Title: getLastDayChar8En
     * @Description: TODO
     * @Param: @return
     * @Return: String
     * @Comment:
     * @Author: Administrator
     * @CreateDate: 2012-5-29 上午11:20:37
     */
    public static Date getDayChar21ByDays(Date rq, int days)
    {
    	try{
    		GregorianCalendar gerCal = new GregorianCalendar();
            gerCal.setTime(rq);
            gerCal.add(GregorianCalendar.DATE, days);// 在日期上加减天数
            SimpleDateFormat lastDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
            //return lastDf.format(gerCal.getTime());
            String rqString = lastDf.format(gerCal.getTime());
            return dateFormat_8.parse(rqString);
    	}catch (Exception ex){
    		return null;
    	}
    }

    /**
     * 返回Data型的 年 月 日 时 分 秒 毫 秒
     * 
     * @return yyyy-MM-dd HH:mm:ss.s
     */
    public static Date getTodayDateTimeS()
    {
    	try{
    		String rqString = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss S");
            return dateFormat_8.parse(rqString);
    	}catch (Exception ex){
    		return null;
    	}
    }
    
	/**
	 * 
	* @Title: getChar8En  
	* @Description: TODO(返回日期的年月日)  
	* @param @param date
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
    public static String getChar8En(Date date){
    	return DateFormatUtils.format(date, "yyyy-MM-dd");
    }
    /**
     * 
    * @Title: getDatebegin  
    * @Description: 返回当前日期00:00:00  
    * @param @param date
    * @param @return    参数  
    * @return Date    返回类型  
    * @throws
     */
    public static Date getDateBegin(Date date){
    	try{
    		String rqString = DateFormatUtils.format(date, "yyyy-MM-dd") + " 00:00:00";
    		date = dateFormat_2.parse(rqString);
            return date;
    	}catch (Exception ex){
    		return null;
    	}
    }
    /**
     * 
    * @Title: getDatebegin  
    * @Description: 返回当前日期23:59:59  
    * @param @param date
    * @param @return    参数  
    * @return Date    返回类型  
    * @throws
     */

    public static Date getDateEnd(Date date){
    	try{
    		String rqString = DateFormatUtils.format(date, "yyyy-MM-dd") + " 23:59:59";
    		date = dateFormat_2.parse(rqString);
            return date;
    		//return dateFormat_2.parse(rqString);
    	}catch (Exception ex){
    		return null;
    	}
    }
    
    /**
     * 
    * @Title: getDatebegin  
    * @Description: 返回当前日期23:59:59  
    * @param @param date
    * @param @return    参数  
    * @return Date    返回类型  
    * @throws
     */
    public static Date getDateEnd(Date date, int days){
    	try{
    		GregorianCalendar gerCal = new GregorianCalendar();
    	    gerCal.setTime(date);
    	    gerCal.add(GregorianCalendar.DATE, days);
    		String rqString = DateFormatUtils.format(gerCal.getTime(), "yyyy-MM-dd") + " 23:59:59";
    		date = dateFormat_2.parse(rqString);
            return date;
    		//return dateFormat_2.parse(rqString);
    	}catch (Exception ex){
    		return null;
    	}
    }
    
    /**
     * 获取昨天日期 格式 yyyy-MM-dd
     * 
     * @Title: getLastDayChar8En
     * @Description: TODO
     * @Param: @return
     * @Return: String
     * @Comment:
     * @Author: Administrator
     * @CreateDate: 2012-5-29 上午11:20:37
     */
    public static String getLastDayChar8En()
    {
        GregorianCalendar gerCal = new GregorianCalendar();
        gerCal.setTime(new Date());
        gerCal.add(GregorianCalendar.DATE, -1);// 在日期上减1天
        SimpleDateFormat lastDf = new SimpleDateFormat("yyyy-MM-dd");
        return lastDf.format(gerCal.getTime());
    }

    /**
     * 返回 年月日小时分
     * 
     * @return yyyyMMddHHmm
     */
    public static String getTodayChar12()
    {
        return DateFormatUtils.format(new Date(), "yyyyMMddHHmm");
    }

    /**
     * 
    * @Title: getChar12  
    * @Description: TODO(返回日期的年月日小时分)  
    * @param @param date
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
     */
    public static String getChar12(Date date){
    	return DateFormatUtils.format(date, "yyyyMMddHHmm");
    }
    /**
     * 返回 年月日小时分
     * 
     * @return yyyyMMddHHmm
     */
    public static String getTodayChar12En()
    {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm");
    }

    /**
     * 
    * @Title: getChar12En  
    * @Description: TODO(返回 年月日小时分)  
    * @param @param date
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
     */
    public static String getChar12En(Date date){
    	if (date == null){
    		return null;
    	}
    	return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm");
    }
    /**
     * 返回 年月日小时分秒
     * 
     * @return
     */
    public static String getTodayChar14()
    {
        return DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
    }

    /**
     * 
    * @Title: getChar14  
    * @Description: TODO(根据日期返回 年月日小时分秒)  
    * @param @param date
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
     */
    public static String getChar14(Date date){
    	return DateFormatUtils.format(date, "yyyyMMddHHmmss");
    }
    /**
     * 
     * @Title: getDayChar14ByDays
     * @Description: 根据天数加减当前日期
     * @param days
     * @return
     * @return String 返回类型
     * @throws
     */
    public static String getDayChar14ByDays(int days)
    {
        GregorianCalendar gerCal = new GregorianCalendar();
        gerCal.setTime(new Date());
        gerCal.add(GregorianCalendar.DATE, days);// 在日期上加减天数
        SimpleDateFormat lastDf = new SimpleDateFormat("yyyyMMddHHmmss");
        return lastDf.format(gerCal.getTime());
    }

    /**
     * 返回 年月日小时分秒
     * 
     * @return
     */
    public static String getTodayChar14En()
    {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 
    * @Title: getChar14En  
    * @Description: TODO(根据返回 年月日小时分秒)  
    * @param @param date
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
     */
    public static String getChar14En(Date date){
    	return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }
    // /**
    // * 返回 年月日小时分秒 毫秒
    // *
    // * @return
    // */
    // public static String getTodayChar17()
    // {
    // return DateFormatUtils.format(new Date(), "yyyyMMddHHmmssS");
    // }
    //

    /**
     * 返回 年月日小时分秒 毫秒
     * 
     * @return yyyyMMddHHmmssS
     */
    public static String getTodayChar17()
    {
        String dateString = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssS");
        int length = dateString.length();

        if (length < 17)
        {
            String endStr = dateString.substring(14, length);
            int len = endStr.length();
            for (int i = 0; i < 3 - len; i++)
            {
                endStr = "0" + endStr;
            }
            dateString = dateString.substring(0, 14) + endStr;
        }
        return dateString;
    }

    /**
     * 根据返回 年月日小时分秒 毫秒
     * 
     * @return yyyyMMddHHmmssS
     */
    public static String getChar17(Date date)
    {
        String dateString = DateFormatUtils.format(date, "yyyyMMddHHmmssS");
        int length = dateString.length();

        if (length < 17)
        {
            String endStr = dateString.substring(14, length);
            int len = endStr.length();
            for (int i = 0; i < 3 - len; i++)
            {
                endStr = "0" + endStr;
            }
            dateString = dateString.substring(0, 14) + endStr;
        }
        return dateString;
    }
    /**
     * 返回 年月日小时分秒 毫秒
     * 
     * @return
     */
    public static String getTodayChar17En()
    {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss S");
    }

    /**
     * 根据日期返回 年月日小时分秒 毫秒
     * 
     * @return
     */
    public static String getChar17En(Date date)
    {
        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss S");
    }
    /**
     * 返回 年月日小时分秒 毫秒
     * 
     * @return
     */
    public static String getToDateCn()
    {
        return DateFormatUtils.format(new Date(), "yyyy年MM月dd日");
    }

    /**
     * 根据日期返回 年月日小时分秒 毫秒
     * 
     * @return
     */
    public static String getDateCn(Date date)
    {
        return DateFormatUtils.format(date, "yyyy年MM月dd日");
    }
    /**
     * 返回 年-月-日
     * 
     * @return
     */
    public static String getToDateEn()
    {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd");
    }

    /**
     * 根据日期返回 年-月-日
     * 
     * @return
     */
    public static String getDateEn(Date date)
    {
        return DateFormatUtils.format(date, "yyyy-MM-dd");
    }
    /**
     * 返回中文日期格式 支持4、6、8、12、14、17位转换
     * 
     * @param charDateTime
     *            长整型 CHAR
     * @return 2007年12月12日 12时12分12秒 234毫秒
     */
    public static String getFormatChina(String charDateTime)
    {
        return getFormatDateTime(charDateTime, "FORMAT_CHINA");
    }

    /**
     * 返回标准日期格式 支持4、6、8、12、14、17位转换
     * 
     * @param charDateTime
     *            长整型 CHAR
     * @return 2007-12-12 12:12:12 234
     */
    public static String getFormatNormal(String charDateTime)
    {
        return getFormatDateTime(charDateTime, "FORMAT_NORMAL");
    }

    /**
     * 返回标准日期格式 支持4、6、8、12、14、17位转换
     * 
     * @param charDateTime
     *            长整型 CHAR
     * @return 2007/12/12 12:12:12 234
     */
    public static String getFormatDateTime(String charDateTime)
    {
        return getFormatDateTime(charDateTime, "FORMAT_DATATIME");
    }

    /**
     * 把日期格式转换为长整型格式
     * 
     * @param inputDateTime
     * @return
     */
    public static String getDateTimeToChar(String inputDateTime)
    {
        String strResult = "";
        if (null == inputDateTime)
        {
            return strResult = "";
        }

        if (("".equals(inputDateTime.trim())))
        {
            return strResult = "";
        }

        // 替换
        strResult = inputDateTime.replaceAll("年", "");
        strResult = strResult.replaceAll("月", "");
        strResult = strResult.replaceAll("日", "");
        strResult = strResult.replaceAll("时", "");
        strResult = strResult.replaceAll("分", "");
        strResult = strResult.replaceAll("秒", "");
        strResult = strResult.replaceAll("毫", "");
        strResult = strResult.replaceAll(" ", "");
        strResult = strResult.replaceAll("-", "");
        strResult = strResult.replaceAll("/", "");
        strResult = strResult.replaceAll(":", "");
        return strResult;

    }

    /**
     * 对日期进行转换
     * 
     * @Title: getFormatDateTime
     * @Description: TODO
     * @Param: @param charDateTime
     * @Param: @param formatType FORMAT_CHINA 中文 FORMAT_NORMAL以‘-’先分隔
     *         FORMAT_DATATIME 以‘/’分隔
     * @Param: @return
     * @Return: String
     * @Comment:
     * @Author: Administrator
     * @CreateDate: Mar 29, 2012 8:35:29 PM
     */
    private static String getFormatDateTime(String charDateTime, String formatType)
    {
        String strResult = "";
        if (null == charDateTime)
        {
            return strResult = "";
        }

        if (("".equals(charDateTime.trim())))
        {
            return strResult = "";
        }

        String[] FORMAT_CHAR = null;
        if (formatType.equals("FORMAT_CHINA"))
        {
            FORMAT_CHAR = FORMAT_CHINA;
        }
        else if (formatType.equals("FORMAT_NORMAL"))
        {
            FORMAT_CHAR = FORMAT_NORMAL;
        }
        else if (formatType.equals("FORMAT_DATATIME"))
        {
            FORMAT_CHAR = FORMAT_DATATIME;
        }
        else
        {
            return strResult = charDateTime;
        }

        // 去掉空格
        charDateTime = charDateTime.trim();

        if (charDateTime.length() == 4)
        {
            // MMdd 转换 MM月dd日
            strResult = charDateTime.substring(0, 2) + FORMAT_CHAR[1] + charDateTime.substring(2, 4) + FORMAT_CHAR[2];
        }
        else if (charDateTime.length() == 6)
        {
            // yyyyMM 转换 yyyy年MM月
            strResult = charDateTime.substring(0, 4) + FORMAT_CHAR[0] + charDateTime.substring(4, 6) + FORMAT_CHAR[1];
        }
        else if (charDateTime.length() == 8)
        {
            // yyyyMMdd
            strResult = charDateTime.substring(0, 4) + FORMAT_CHAR[0] + charDateTime.substring(4, 6) + FORMAT_CHAR[1] + charDateTime.substring(6, 8)
                    + FORMAT_CHAR[2];
        }
        else if (charDateTime.length() == 12)
        {
            // yyyyMMddHHmm
            strResult = charDateTime.substring(0, 4) + FORMAT_CHAR[0] + charDateTime.substring(4, 6) + FORMAT_CHAR[1] + charDateTime.substring(6, 8)
                    + FORMAT_CHAR[2] + " " + charDateTime.substring(8, 10) + FORMAT_CHAR[3] + charDateTime.substring(10, 12) + FORMAT_CHAR[4];
        }
        else if (charDateTime.length() == 14)
        {
            // yyyyMMddHHmmss
            strResult = charDateTime.substring(0, 4) + FORMAT_CHAR[0] + charDateTime.substring(4, 6) + FORMAT_CHAR[1] + charDateTime.substring(6, 8)
                    + FORMAT_CHAR[2] + " " + charDateTime.substring(8, 10) + FORMAT_CHAR[3] + charDateTime.substring(10, 12) + FORMAT_CHAR[4]
                    + charDateTime.substring(12, 14) + FORMAT_CHAR[5];
        }
        else if (charDateTime.length() == 17)
        {
            // yyyyMMddHHmmssS
            strResult = charDateTime.substring(0, 4) + FORMAT_CHAR[0] + charDateTime.substring(4, 6) + FORMAT_CHAR[1] + charDateTime.substring(6, 8)
                    + FORMAT_CHAR[2] + " " + charDateTime.substring(8, 10) + FORMAT_CHAR[3] + charDateTime.substring(10, 12) + FORMAT_CHAR[4]
                    + charDateTime.substring(12, 14) + FORMAT_CHAR[5] + " " + charDateTime.substring(14, 17) + FORMAT_CHAR[6];
        }
        else
        {
            strResult = charDateTime;
        }

        return strResult;
    }

    /**
     * 将指定Date类型参数转换为指定的Oracle日期时间格式字符串
     * 
     * @param inputDateTime
     *            传入Date类型参数
     * @return String
     */
    public static String getOracleDate(Date inputDateTime) throws NullPointerException
    {
        if (null == inputDateTime)
        {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(inputDateTime);
    }

    /**
     * 比对两个时间间隔
     * 
     * @param startDateTime
     *            开始时间
     * @param endDateTime
     *            结束时间
     * @param distanceType
     *            计算间隔类型 天d 小时h 分钟m 秒s
     * @return
     */
    public static String getDistanceDT(String startDateTime, String endDateTime, String distanceType)
    {
        String strResult = "";
        long lngDistancVal = 0;
        try
        {
            SimpleDateFormat tempDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date startDate = tempDateFormat.parse(startDateTime);
            Date endDate = tempDateFormat.parse(endDateTime);
            if (distanceType.equals("d"))
            {
                lngDistancVal = (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
            }
            else if (distanceType.equals("h"))
            {
                lngDistancVal = (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60);
            }
            else if (distanceType.equals("m"))
            {
                lngDistancVal = (endDate.getTime() - startDate.getTime()) / (1000 * 60);
            }
            else if (distanceType.equals("s"))
            {
                lngDistancVal = (endDate.getTime() - startDate.getTime()) / (1000);
            }
            strResult = String.valueOf(lngDistancVal);
        }
        catch (Exception e)
        {
            strResult = "0";
        }
        return strResult;
    }

    /**
     * 日期差计算 例如在某个日期增加几天后的日期 返回几天后日期
     * 
     * @param startDate
     * @param addDate
     * @return
     */
    public static String getIncreaseDT(String startDate, int addDate)
    {
        String strResult = "0000-00-00";

        try
        {
            Calendar localDate = new GregorianCalendar();
            // 把字符串型日期转换为日期
            Date tempDate = new Date();
            if (!"".equals(startDate))
            {
                SimpleDateFormat tempDateFormat = new SimpleDateFormat("yyyyMMdd");
                tempDate = tempDateFormat.parse(startDate);
            }
            localDate.setTime(tempDate);
            localDate.add(Calendar.DATE, addDate);
            String curyear = "" + localDate.get(Calendar.YEAR);
            int intmonth = localDate.get(Calendar.MONTH) + 1;
            String curmonth = "" + intmonth;
            String curday = "" + localDate.get(Calendar.DAY_OF_MONTH);

            if (curmonth.length() == 1)
            {
                curmonth = "0" + curmonth;
            }
            if (curday.length() == 1)
            {
                curday = "0" + curday;
            }
            strResult = curyear + "" + curmonth + "" + curday;
        }
        catch (Exception e)
        {
            strResult = "";
        }
        return strResult;
    }

    /**
     * 获取本周的开始日期 （星期天的日期）20070201
     * 
     * @return
     */
    public static String getWeekStartDate()
    {
        String strResult = "19000101";
        try
        {
            Calendar calendar = Calendar.getInstance();
            int intWeekNum = calendar.get(Calendar.DAY_OF_WEEK);
            intWeekNum = intWeekNum - 1;
            strResult = getIncreaseDT(getTodayChar8(), -intWeekNum);
        }
        catch (Exception ex)
        {
            strResult = "19000101";
        }
        return strResult;
    }

    /**
     * 获取今天星期几 中文
     * 
     * @return
     */
    public static String getWeekChina()
    {
        String strResult = " ";
        try
        {
            Calendar calendar = Calendar.getInstance();
            int intWeekNum = calendar.get(Calendar.DAY_OF_WEEK);
            intWeekNum = intWeekNum - 1;
            strResult = FORMAT_WEEK[intWeekNum];
        }
        catch (Exception ex)
        {
            strResult = " ";
        }
        return strResult;
    }

    private static SimpleDateFormat dateFormat   = new SimpleDateFormat("yyyyMMddHHmmss");
    private static SimpleDateFormat dateFormat_1 = new SimpleDateFormat("yyyyMM");
    private static SimpleDateFormat dateFormat_2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat dateFormat_3 = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat dateFormat_4 = new SimpleDateFormat("yyyy年MM月");
    private static SimpleDateFormat dateFormat_5 = new SimpleDateFormat("yyyy年MM月dd日");
    private static SimpleDateFormat dateFormat_6 = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat dateFormat_7 = new SimpleDateFormat("yyyyMMddHHmmss");
    private static SimpleDateFormat dateFormat_8 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
    private static SimpleDateFormat dateFormat_9 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    
    //时间加一秒
    public static String formatDateStrToStr(String strdatetime){
    	String reTime = "";
        try
        {
        	Date date = dateFormat_9.parse(strdatetime);
        	reTime = dateFormat_9.format(date).toString();
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }
    
    public static String formatDateStrToOtherStr(String time)
    {
        String reTime = "";
        try
        {
            reTime = dateFormat_2.format(dateFormat.parse(time));
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }

    public static String formatDateStrToOtherStr3(String time)
    {
        String reTime = "";
        try
        {
            reTime = dateFormat_3.format(dateFormat.parse(time));
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }

    public static String formatDateStr2ToOtherStr(String time)
    {
        String reTime = "";
        try
        {
            reTime = dateFormat.format(dateFormat_2.parse(time));
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }

    public static String formatDateStrToOtherStr4(String time)
    {
        String reTime = "";
        try
        {
            reTime = dateFormat_4.format(dateFormat_1.parse(time));
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }

    public static String formatDateStrToOtherStr5(String time)
    {
        String reTime = "";
        try
        {
            reTime = dateFormat_5.format(dateFormat_6.parse(time));
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }

    public static String formatDateStrToOtherStr6(String time)
    {
        String reTime = "";
        try
        {
            reTime = dateFormat_5.format(dateFormat_7.parse(time));
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }

    public static String formatDateStrToOtherStr8(String time)
    {
        String reTime = "";
        try
        {
            reTime = dateFormat_6.format(dateFormat_6.parse(time));
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }

    /**
     * 将 "2012-5-1" 转换成 "20120501"
     * 
     * @Title: formatDateStrToOtherStr9
     * @Description: TODO
     * @Param: @param time
     * @Param: @return
     * @Return: String
     * @Comment:
     * @Author: Administrator
     * @CreateDate: Apr 24, 2012 10:09:38 AM
     */
    public static String formatDateStrToOtherStr9(String time)
    {
        String reTime = "";
        try
        {
            reTime = dateFormat_6.format(dateFormat_3.parse(time));
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }

    /**
     * 将 "20120501" 转换成 "2012-5-1"
     * 
     * @Title: formatDateStrToOtherStr10
     * @Description: TODO
     * @Param: @param time
     * @Param: @return
     * @Return: String
     * @Comment:
     * @Author: Administrator
     * @CreateDate: Apr 29, 2012 3:45:54 PM
     */
    public static String formatDateStrToOtherStr10(String time)
    {
        String reTime = "";
        try
        {
            reTime = dateFormat_3.format(dateFormat_6.parse(time));
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }

    /**
     * 将 yyyy-MM-dd HH:mm:ss 转换成 yyyy-MM-dd
     * 
     * @Title: formatDateStrToOtherStr11
     * @Description: TODO
     * @Param: @param time
     * @Param: @return
     * @Return: String
     * @Comment:
     * @Author: Administrator
     * @CreateDate: May 4, 2012 10:52:59 AM
     */
    public static String formatDateStrToOtherStr11(String time)
    {
        String reTime = "";
        try
        {
            reTime = dateFormat_3.format(dateFormat_2.parse(time));
        }
        catch (ParseException e)
        {
        }
        return reTime;
    }

    /**
     * 
     * @Title: getDayChar8EnByDays
     * @Description: 根据传入的天数获取日期
     * @param days
     * @return
     * @return String 返回类型
     * @throws
     */
    public static String getDayChar8EnByDays(int days)
    {
        GregorianCalendar gerCal = new GregorianCalendar();
        gerCal.setTime(new Date());
        gerCal.add(GregorianCalendar.DATE, days);// 在日期上减1天
        SimpleDateFormat lastDf = new SimpleDateFormat("yyyy-MM-dd");
        return lastDf.format(gerCal.getTime());
    }

    /**
     * 比较时间与当前时间先后
     * 
     * @Title: compareTime
     * @Description: TODO
     * @Param: @param startTime
     * @Param: @return
     * @Return: 1 晚于当前时间 2 与当前时间相等 3 早于当前时间
     * @Comment:
     * @Author: Administrator
     * @CreateDate: Mar 29, 2012 8:34:11 PM
     */
    public static String compareTime(String startTime)
    {
        Date date = new Date();
        startTime = startTime.substring(0, 4) + "-" + startTime.substring(4, 6) + "-" + startTime.substring(6, 8);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try
        {
            c1.setTime(date);
            c2.setTime(df.parse(startTime));
        }
        catch (ParseException e)
        {
        }
        int result = c1.compareTo(c2);
        if (result == 0)
        {
            return "2";
        }
        else if (result < 0)
        {
            return "1";
        }
        else
        {
            return "3";
        }
    }

    /**
     * 当月第一天
     * 
     * @return
     */
    public static String getFirstDay()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();

        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first);
        return str.toString();

    }

    /**
     * 当月最后一天
     * 
     * @return
     */
    public static String getLastDay()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date theDate = calendar.getTime();
        String s = df.format(theDate);
        StringBuffer str = new StringBuffer().append(s);
        return str.toString();

    }

    /**
     * @Title: getEndTime
     * @Description: TODO(根据传入单位和数量，确定时间)
     * @return
     * @return String 返回类型
     * @throws
     */
    public static String getEndTime(String unit, int scope, String beginTime)
    {
        String endTime = "";
        try
        {
            if ("MM".equals(unit))
            {
                GregorianCalendar gerCal = new GregorianCalendar();
                gerCal.setTime(dateFormat.parse(beginTime));
                gerCal.add(GregorianCalendar.MONTH, -scope);// 在日期上减1天
                SimpleDateFormat lastDf = new SimpleDateFormat("yyyyMMddHHmmss");
                endTime = lastDf.format(gerCal.getTime());
            }
            else if ("dd".equals(unit))
            {
                GregorianCalendar gerCal = new GregorianCalendar();
                gerCal.setTime(dateFormat.parse(beginTime));
                gerCal.add(GregorianCalendar.DATE, -scope);// 在日期上减1天
                SimpleDateFormat lastDf = new SimpleDateFormat("yyyyMMddHHmmss");
                endTime = lastDf.format(gerCal.getTime());
            }
            else if ("HH".equals(unit))
            {
                GregorianCalendar gerCal = new GregorianCalendar();
                gerCal.setTime(dateFormat.parse(beginTime));
                gerCal.add(GregorianCalendar.HOUR, -scope);// 在日期上减1天
                SimpleDateFormat lastDf = new SimpleDateFormat("yyyyMMddHHmmss");
                endTime = lastDf.format(gerCal.getTime());
            }
            else if ("mm".equals(unit))
            {
                GregorianCalendar gerCal = new GregorianCalendar();
                gerCal.setTime(dateFormat.parse(beginTime));
                gerCal.add(GregorianCalendar.MINUTE, -scope);// 在日期上减1天
                SimpleDateFormat lastDf = new SimpleDateFormat("yyyyMMddHHmmss");
                endTime = lastDf.format(gerCal.getTime());
            }
            else if ("ss".equals(unit))
            {
                GregorianCalendar gerCal = new GregorianCalendar();
                gerCal.setTime(dateFormat.parse(beginTime));
                gerCal.add(GregorianCalendar.MILLISECOND, -scope);// 在日期上减1天
                SimpleDateFormat lastDf = new SimpleDateFormat("yyyyMMddHHmmss");
                endTime = lastDf.format(gerCal.getTime());
            }
        }
        catch (Exception e)
        {
        }

        return endTime;
    }

    /**
     * 
     * @Title: getWeekNumber
     * @Description:获取今天是本周的第几天（数字）
     * @return
     * @return int 返回类型
     * @throws
     */
    public static int getWeekNumber()
    {
        int strResult = 0;
        try
        {
            Calendar calendar = Calendar.getInstance();
            int intWeekNum = calendar.get(Calendar.DAY_OF_WEEK);
            intWeekNum = intWeekNum - 1;
            if (intWeekNum == 0)
            {
                intWeekNum = 7;
            }
            strResult = intWeekNum;
        }
        catch (Exception ex)
        {
            strResult = 0;
        }
        return strResult;
    }
    
    /**
     * 
    * @Title: getWeekNumber  
    * @Description: TODO(获取日期是本周的第几天（数字）)  
    * @param @param date
    * @param @return    参数  
    * @return int    返回类型  
    * @throws
     */
    public static int getWeekNumber(Date date){
    	int strResult = 0;
        try
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int intWeekNum = calendar.get(Calendar.DAY_OF_WEEK);
            intWeekNum = intWeekNum - 1;
            if (intWeekNum == 0)
            {
                intWeekNum = 7;
            }
            strResult = intWeekNum;
        }
        catch (Exception ex)
        {
            strResult = 0;
        }
        return strResult;
    }

    /**
     * 
     * @Title: getTodayHours
     * @Description:获取当前小时（0~23）
     * @return
     * @return int 返回类型
     * @throws
     */
    public static int getTodayHours()
    {
        int result = 0;
        Calendar calendar = Calendar.getInstance();
        result = calendar.get(Calendar.HOUR_OF_DAY);
        return result;
    }

    /**
     * 
     * @Title: getStartTimeAndEndTimeBetweenTime
     * @Description: TODO(获取两个日期之间的所有日期)
     * @param startTime
     * @param endTime
     * @return
     * @return List<String> 返回类型
     * @throws
     */
    public static List<String> getStartTimeAndEndTimeBetweenDays(String startTime, String endTime, String format)
    {
        SimpleDateFormat formatTime = new SimpleDateFormat(format);
        List<String> list = new ArrayList<String>();
        if (startTime.equals(endTime))// 开始时间和结束时间相等 就返回开始时间
            list.add(startTime);
        else
        {
            try
            {
                list.add(startTime);
                String tmp = formatTime.format(formatTime.parse(startTime).getTime() + 3600 * 24 * 1000);
                while (tmp.compareTo(endTime) <= 0)
                {
                    list.add(tmp);
                    tmp = formatTime.format(formatTime.parse(tmp).getTime() + 3600 * 24 * 1000);
                }
                // list.add(endTime);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 
     * @Title: getStartTimeAndEndTimeBetweenMonths
     * @Description: TODO(获取俩个时间之间所有的月份)
     * @param startTime
     * @param endTime
     * @param format
     * @return
     * @return List<String> 返回类型
     * @throws
     */
    public static List<String> getStartTimeAndEndTimeBetweenMonths(String startTime, String endTime, String format)
    {
        SimpleDateFormat formatTime = new SimpleDateFormat(format);
        List<String> list = new ArrayList<String>();
        try
        {
            Date startDate = formatTime.parse(startTime);
            Date endDate = formatTime.parse(endTime); // 结束日期
            Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);
            endCalendar.setTime(endDate);
            String result = null;
            while (startCalendar.compareTo(endCalendar) <= 0)
            {
                startDate = startCalendar.getTime();
                result = new SimpleDateFormat(format).format(startDate);
                // result = result.substring(0, result.length());
                list.add(result);
                // 开始日期加一个月直到等于结束日期为止
                startCalendar.add(Calendar.MONTH, 1);
            }

        }
        catch (ParseException e)
        {
            e.printStackTrace();
        } // 开始日期

        return list;
    }

    /**
     * 
     * @Title: getStartTimeAndEndTimeNumbers
     * @Description: TODO(获取两个时间段内月份只差)
     * @return
     * @return int 返回类型
     * @throws
     */
    public static int getStartTimeAndEndTimeNumbers(String startTime, String endTime, String format)
    {
        SimpleDateFormat formatTime = new SimpleDateFormat(format);
        try
        {
            Date startDate = formatTime.parse(startTime);
            Date endDate = formatTime.parse(endTime); // 结束日期
            Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);
            endCalendar.setTime(endDate);
            return endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * 
    * @Title: getStartAndEndYear  
    * @Description: TODO(两日期之间差几年)  
    * @param @param startDate
    * @param @param endDate
    * @param @return    参数  
    * @return int    返回类型  
    * @throws
     */
    public static int getStartAndEndYear(Date startDate, Date endDate){
    	try{
    		Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);
            endCalendar.setTime(endDate);
            return endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return 0;
    }
    /**
     * 
    * @Title: getStartAndEndYear  
    * @Description: TODO(两日期之间差几月)  
    * @param @param startDate
    * @param @param endDate
    * @param @return    参数  
    * @return int    返回类型  
    * @throws
     */
    public static int getStartAndEndMonth(Date startDate, Date endDate){
    	try{
    		Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);
            endCalendar.setTime(endDate);
            return endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return 0;
    }//Between
    
    /**
     * 
    * @Title: getStartAndEndYear  
    * @Description: TODO(两日期之间差几星期)  
    * @param @param startDate
    * @param @param endDate
    * @param @return    参数  
    * @return int    返回类型  
    * @throws
     */
    public static int getStartAndEndBetween(Date startDate, Date endDate){
    	int Between = 0;
    	try{
    		Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);
            endCalendar.setTime(endDate);
            Between = ((int)(endCalendar.getTime().getTime()/1000)-(int)(startCalendar.getTime().getTime()/1000))/3600/24/7;
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return Between;
    }
    /**
     * 
    * @Title: getStartAndEndYear  
    * @Description: TODO(两日期之间差几天)  
    * @param @param startDate
    * @param @param endDate
    * @param @return    参数  
    * @return int    返回类型  
    * @throws
     */
    public static int getStartAndEndDay(Date startDate, Date endDate){
    	int days = 0;
    	try{
    		Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);
            endCalendar.setTime(endDate);
            int il1 = (int)(endCalendar.getTime().getTime()/1000);
            int il2 = (int)(startCalendar.getTime().getTime()/1000);
            days = ((int)(endCalendar.getTime().getTime()/1000)-(int)(startCalendar.getTime().getTime()/1000))/3600/24;   
            //return endCalendar.get(Calendar.mo) - startCalendar.get(Calendar.MONTH);
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return days;
    }
    /**
     * 获取当前月最后一天
     * 
     * @Title: getEndDayofMonth
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param sYear
     * @param sMonth
     * @return
     */
    public static String getEndDayofMonth(int sYear, int sMonth)
    {
        Calendar c = Calendar.getInstance();
        String tEnddate = "";
        c.set(c.YEAR, sYear);
        c.set(c.MONTH, sMonth);
        tEnddate = c.getActualMaximum(c.DAY_OF_MONTH)+"";
        return tEnddate;
    }

    public static void main(String[] args)
    {
        String testString = getEndDayofMonth(2016, 8);
        // List<String> list =
        // DateTimeUtil.getStartTimeAndEndTimeBetweenMonths("201403", "201403",
        // "yyyyMM");
        // for (String li : list)
        // {
        // System.out.println("==================" + li);
        // }
        System.out.println(testString);
        System.out.println("==========" + DateTimeUtil.getStartTimeAndEndTimeNumbers("201405", "201408", "yyyyMM"));

    }

    /***
     *
     * @param date
     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatDateByPattern(Date date, String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /***
     * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(Date date){
        String dateFormat = "ss mm HH * * ?";//格式化cron 每天某个时刻执行
        return formatDateByPattern(date, dateFormat);
//        return "*/1 * * * * ?";
    }

    public static Date hhmmss2Date(String hhmmss){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date=null;
        try {
            date = sdf.parse(hhmmss);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
