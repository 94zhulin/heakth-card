package com.jsg.dzfbhealthcard.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 作者：zhuLin
 * 日期：2020-06-19 19:25:25
 * 备注：对码
 */
@Component
public class DepUtil {

    /**
     * 0017 妇科          0020 孕产保健科    0021 儿科       0036 产科
     * 0056 儿童保健科    0063 门诊内科      0064 门诊儿科    0034 新生儿科
     * 科室对码
     * @return
     */
    public HashMap<String,String> depCode () {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("0017","5.01");			//妇科
        map.put("0018","5.01");			//中医妇科
        map.put("0021","7");			//儿科
        map.put("0033","50.16");		//急诊科
        map.put("0034","7.01");			//新生儿科
        map.put("0035","7");			//中医儿科
        map.put("0036","5.02");			//产科
        map.put("0056","9.04");			//儿童保健科
        map.put("0020","5.02");         //孕产保健科
        map.put("0041","9.04");			//儿童五官科
        map.put("0063","50.01");		//门诊内科
        map.put("0064","50.04");		//门诊儿科
        return map;
    }

}
