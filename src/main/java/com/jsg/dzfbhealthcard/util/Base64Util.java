package com.jsg.dzfbhealthcard.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Base64Util {

    /**
     * BASE64解密
     * 接受与返回都已对象形式，避免fastjson转换的时候产生转义字符，导致转换失败
     * @param o
     * @return
     * @throws Exception
     */
    public static Object decryptBASE64(Object o) {
        Map result = new HashMap();
        try {
            Map<String, Object> map = JSONObject.parseObject(JSON.toJSONString(o), Map.class);
            byte[] bt;
            for(String key : map.keySet()){
                Object obj = map.get(key);
                if(obj instanceof Map){
                    result.put(key,decryptBASE64(obj));
                }else if(obj instanceof List){
                    List jsonList = new ArrayList();
                    List<Object> list = (List<Object>)obj;
                    for(int i=0;i<list.size();i++){
                        jsonList.add(decryptBASE64(list.get(i)));
                    }
                    result.put(key,jsonList);
                }else{
                    bt = (new BASE64Decoder()).decodeBuffer(obj.toString());
                    result.put(key,new String(bt,"gbk"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return result;
    }

    /**
     * BASE64加密
     *
     * @param o
     * @return
     * @throws Exception
     */
    public static Object encryptBASE64(Object o) {
        Map result = new HashMap();
        try{
            Map<String, Object> map = JSONObject.parseObject(JSON.toJSONString(o), Map.class);
            byte[] bt = null;
            for(String key:map.keySet()){
                Object obj = map.get(key);
                if(obj instanceof Map){
                    result.put(key,encryptBASE64(obj));
                }else if(obj instanceof List){
                    List resultList = new ArrayList();
                    List<Object> list = (List<Object>)obj;
                    for(int i=0;i<list.size();i++){
                        resultList.add(encryptBASE64(list.get(i)));
                    }
                    result.put(key,resultList);
                }else{
                    bt = map.get(key).toString().getBytes("gbk");
                    result.put(key,new BASE64Encoder().encodeBuffer(bt).trim());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
        return result;
    }
}
