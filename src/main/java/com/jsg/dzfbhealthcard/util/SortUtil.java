package com.jsg.dzfbhealthcard.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 签名获取工具
 * @since 2019/8/29 11:33
 */
@Component
public class SortUtil {

    private static final Logger logger = LoggerFactory.getLogger(SortUtil.class);

    @Autowired
    private PropConf propConf;

    private static String MD5Key;

    private static String terminalcode;//组织机构代码

    @PostConstruct
    private void init() {
        this.MD5Key = propConf.getMD5Key();
        this.terminalcode = propConf.getTerminalcode();
    }

    /**
     * 生成签名
     * @param map
     * @return
     */
    public static String getSignString(Map<String,String> map) throws Exception {

        logger.info("===============================进入生成签名==============================");
        if(map == null || map.size() <= 0){
            throw new Exception("【生成签名失败】：参数为空！" );
        }
        //组织机构代码_科室代码

        List<Map.Entry<String, String>> infoIds = new ArrayList<>(map.entrySet());
        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return (o1.getKey()).compareTo(o2.getKey());
            }
        });
        logger.info("=====================按照ASCLL码排序完成，正在生成签名===================");
        // 构造签名键值对的格式
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> item : infoIds) {
            if (item.getKey() != null || item.getKey() != "") {
                String key = item.getKey();
                Object val = item.getValue();
                if (val != null && StringUtils.isNotEmpty(String.valueOf(val))) {
                    sb.append(key + "=" + val + "&");
                }
            }
        }
        sb.append("key=" + MD5Key);

        logger.info("【生成签名】：" + sb.toString());

        return sb.toString();
    }
}
