package com.jsg.dzfbhealthcard.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 类描述
 * @since 2019/8/28 11:16
 */
public class AESUtil {

    private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);

    private static final String KEY_AES = "AES";

    public static String encrypt(String src, String key) throws Exception {

        logger.info("【AES加密入参】：" + src + "，【key】：" + key);

        if (key == null || key.length() != 16) {
            logger.info("【AES加密失败】：【密钥】不满足条件！【key】：" + key);
            throw new Exception("【AES加密失败】：密钥不满足条件！");
        }
        logger.info("【AES加密】：正在加密！" );
        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(src.getBytes("utf-8"));
        String result = byte2hex(encrypted);
        if(StringUtils.isEmpty(result)){
            logger.info("【AES加密失败】：加密结果为空！【结果】：" + result);
            throw new Exception("【AES加密失败】：加密结果为空！【结果】：" + result);
        }
        logger.info("【AES加密成功出参】：" + result);
        return result;
    }



    public static String decrypt(String src, String key) throws Exception {

        logger.info("【AES解密入参】：" + src + "，【key】：" + key);

        if (key == null || key.length() != 16) {
            logger.info("【AES解密失败】：key不满足条件 ！【key】：" + key);
            throw new Exception("【AES解密失败】：key不满足条件");
        }
        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] encrypted1 = hex2byte(src);
        byte[] original = cipher.doFinal(encrypted1);
        String originalString = new String(original,"utf-8");
        if(StringUtils.isEmpty(originalString)){
            logger.info("【AES解密失败】：解密结果为空！【结果】：" + originalString);
            throw new Exception("【AES解密失败】：解密结果为空！【结果】：" + originalString);
        }
        logger.info("【AES解密成功出参】：" + originalString);
        return originalString;
    }

    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
                    16);
        }
        return b;
    }

    public static String byte2hex(byte[] b) {

        logger.info("【转换十六进制】");

        StringBuilder hs = new StringBuilder();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        logger.info("【转换十六进制出参】：" + hs.toString().toUpperCase());
        return hs.toString().toUpperCase();
    }


   public static void removeNullValue(Map<String,String> map){
       Set set = map.keySet();
       for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
           Object obj = (Object) iterator.next();
           Object value = (Object) map.get(obj);
           remove(value, iterator);
       }
   }

    private static void remove(Object obj, Iterator iterator) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (str == null || str.trim().isEmpty()) {
                iterator.remove();
            }
        } else if (obj instanceof Collection) {
            Collection col = (Collection) obj;
            if (col == null || col.isEmpty()) {
                iterator.remove();
            }

        } else if (obj instanceof Map) {
            Map temp = (Map) obj;
            if (temp == null || temp.isEmpty()) {
                iterator.remove();
            }

        } else if (obj instanceof Object[]) {
            Object[] array = (Object[]) obj;
            if (array == null || array.length <= 0) {
                iterator.remove();
            }
        } else {
            if (obj == null) {
                iterator.remove();
            }
        }
    }

}
