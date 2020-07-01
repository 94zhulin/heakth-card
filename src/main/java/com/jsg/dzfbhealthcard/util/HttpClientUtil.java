package com.jsg.dzfbhealthcard.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Map;

/**
 * http工具
 */
public class HttpClientUtil
{
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static String doGet(String url, Map<String, String> param) {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        String resultString = "";

        CloseableHttpResponse response = null;
        try{
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(60000).setConnectionRequestTimeout(60000)
                    .setSocketTimeout(60000).build();
            httpGet.setConfig(requestConfig);

            // 执行请求
            response = httpClient.execute(httpGet);
            // 判断返回状态是否为200
//            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
//            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String doPost(String url, Object param) {
//        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(60000).setConnectionRequestTimeout(60000)
                    .setSocketTimeout(60000).build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Content-type", "application/json; charset=utf-8");
            // 创建参数列表
            if (param != null) {
                // 直接传json字符串
                StringEntity entity = new StringEntity(JSONObject.toJSONString(param));
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(response != null){
                    response.close();
                }
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resultString;
    }

}
