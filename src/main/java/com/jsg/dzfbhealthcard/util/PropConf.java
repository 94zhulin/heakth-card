package com.jsg.dzfbhealthcard.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 配置文件读取类
 */
@Component
@PropertySource(value = "classpath:application.yml",factory = YmlPropertiesLoaderFactory.class)
@ConfigurationProperties(prefix = "jsg.healthcard")
@Data
public class PropConf {

    /**
     * 接口地址
     */
    private String url;

    /**
     * 健康卡上传地址
     */
    private String scurl;

    /**
     * AES key
     */
    private String AESkey;


    /**
     * MD5 key
     */
    private String MD5Key;

    /**
     * 组织机构代码
     */
    private String terminalcode;
}
