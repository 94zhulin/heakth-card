package com.jsg.dzfbhealthcard.util;

import com.jsg.dzfbhealthcard.model.AESEncodeType;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 类描述
 * @since 2019/11/5 11:31
 */
public class AESCommonUtils {
    /** 日志记录 */
    private static Logger logger = LogManager.getLogger(AESCommonUtils.class);

    /**
     * Aes加密 <br>
     *
     * @param content
     *            加解密字节组
     * @param key
     *            加密密钥
     * @throws Exception
     * @author pengyunbo
     * @return String 加密后16进制字符串
     * @Creating_Time 2018年12月10日 下午7:40:51
     */
    public static String encryptECB128(String data, String key) throws Exception {
        if (StringUtils.isBlank(data) || StringUtils.isBlank(key))
            return null;
        byte[] content = data.getBytes(AESEncodeType.CHARSET);
        logger.debug("加密密钥" + key);
        Cipher cipher = initCipher(key, Cipher.ENCRYPT_MODE);
        byte[] encrypt = cipher.doFinal(content);
        // String encodeBase64String = Base64.encodeBase64String(encrypt);
        // logger.debug("加密Base64：" + encodeBase64String.length());
        // logger.debug("加密Base64：" + encodeBase64String);
        String parseByte2HexStr = StringXUtils.parseByte2HexStr(encrypt);
        return parseByte2HexStr;
    }

    /**
     * AES解密 <br>
     *
     * @param data
     *            待解密字节组
     * @param key
     *            解密密钥
     * @throws Exception
     * @author pengyunbo
     * @return String 解密后原文
     * @Creating_Time 2018年12月10日 下午7:41:03
     */
    public static String decryptECB128(String data, String key) throws Exception {
        if (StringUtils.isBlank(data) || StringUtils.isBlank(key))
            return null;
        byte[] encrypt = StringXUtils.parseHexStr2Byte(data);
        logger.debug("解密密钥" + key);
        Cipher cipher = initCipher(key, Cipher.DECRYPT_MODE);
        byte[] decrypt = cipher.doFinal(encrypt);
        return new String(decrypt, AESEncodeType.CHARSET);
    }

    private static Cipher initCipher(String key, int mode)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(AESEncodeType.AES_ECB_PKCS5Padding);
        cipher.init(mode, new SecretKeySpec(key.getBytes("utf-8"), AESEncodeType.AES_DEFAULT));
        return cipher;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("1.======>" + decryptECB128("2AC7B11B5E73B1B48A274F909D596CFB1F1128B68B7C7383F10227CAA19D04608579722C3F563BDC1E65651781CB15A4","D7A081E7FD4C10BE"));
        System.out.println("2.======>" + AESUtil.decrypt("2AC7B11B5E73B1B48A274F909D596CFB1F1128B68B7C7383F10227CAA19D04608579722C3F563BDC1E65651781CB15A4","D7A081E7FD4C10BE"));
    }
}