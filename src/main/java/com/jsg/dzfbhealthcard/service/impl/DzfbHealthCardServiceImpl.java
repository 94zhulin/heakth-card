package com.jsg.dzfbhealthcard.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jsg.dzfbhealthcard.dao.DzfbHealthCardDao;
import com.jsg.dzfbhealthcard.model.InParm;
import com.jsg.dzfbhealthcard.model.OutParm;
import com.jsg.dzfbhealthcard.model.RequestParamModel;
import com.jsg.dzfbhealthcard.model.ResultParamModel;
import com.jsg.dzfbhealthcard.service.DzfbHealthCardService;
import com.jsg.dzfbhealthcard.util.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 类描述
 * @since 2019/8/29 17:11
 */
@Service
public class DzfbHealthCardServiceImpl implements DzfbHealthCardService {

    private static final Logger logger = LoggerFactory.getLogger(DzfbHealthCardServiceImpl.class);

    @Autowired
    private PropConf propConf;

    @Autowired
    private DepUtil depUtil;

    @Autowired
    DzfbHealthCardDao dao;

    /**
     * 上传健康卡监测数据
     * @return
     */
    @Override
    public OutParm uploadUserCardData(InParm inParm) {
        OutParm outParm = new OutParm();
        try {
            RequestParamModel request = new RequestParamModel();     //公共请求参数对象
            request.setMethod("ehc.ehealthcode.usecarddate");       //设置接口方法
            Map<String,String> bizContent = new HashMap<String, String>();

            String depCode = depUtil.depCode().get(inParm.getKsbm());   //科室对码
            if ("".equals(depCode) || depCode == null || depCode == "null") {
                depCode = "-1";
            }
            String terminalCode = propConf.getTerminalcode() + depCode;  //机构_科室
            bizContent.put("terminalcode",terminalCode);                //机构_科室
            bizContent.put("ehealthCardId",inParm.getCardId());         //卡号
            bizContent.put("medstepcode",inParm.getMedstepcode());      //诊疗编号
            bizContent.put("channelcode","01");                         //（01，人工，02，自助机，99其他）
            logger.info("--诊疗编号---科室编码---------------------" + inParm.getMedstepcode() + "_" +  depCode);
            logger.info(inParm.getTerminalcode() + "---【上传健康卡监测数据入参】：" + inParm.getCardId() + "," + inParm.getMedstepcode());
            //签名
            String sign = SortUtil.getSignString(bizContent);
            if(StringUtils.isEmpty(sign)){
                outParm.setExcutionError("【上传健康卡监测数据失败】：生成签名失败！");
                logger.info("【上传健康卡监测数据失败】：生成签名失败！");
                return outParm;
            }
            AESUtil.removeNullValue(bizContent);
            //AES加密后设置入参
            request.setBizContent(AESUtil.encrypt(JSON.toJSONString(bizContent),propConf.getAESkey()));
            //设置签名
            request.setDigest(MD5Util.MD5Encode(sign,"utf-8"));
            logger.info("上传url地址"+ propConf.getScurl() + "【上传健康卡监测数据入参】：" + JSON.toJSONString(request));

            //请求接口
            String result = HttpClientUtil.doPost(propConf.getScurl() + "/dz_data/uploadData/upload" , request);
            if(StringUtils.isEmpty(result)) {
                outParm.setExcutionError("【上传健康卡监测数据失败】：健康卡接口返回为空！");
                logger.info("【上传健康卡监测数据失败】：接口返回为空！");
                return outParm;
            }

            logger.info("【上传健康卡监测数据出参】：" + result);
            ResultParamModel<String> resultMode = JSON.parseObject(result,ResultParamModel.class);
            if(!"10000".equals(resultMode.getCode())){ //{"code":10000,"message":"数据上传成功"}
                outParm.setExcutionError("【上传健康卡监测数据失败】：" + resultMode.getMessage());
                logger.info("【上传健康卡监测数据失败】：" + resultMode.getMessage());
                outParm.setOutResult(result);
                return outParm;
            }
            //解密
            String decBizContentStr = AESUtil.decrypt(request.getBizContent(),propConf.getAESkey());
            resultMode.setBizContent(decBizContentStr);
            outParm.setOutResult(JSON.toJSONString(resultMode));
            outParm.setExcutionSuccess("【上传健康卡监测数据】：成功！");
            logger.info("【上传健康卡监测数据解密后出参】：" + JSON.toJSONString(resultMode));
            logger.info("【上传健康卡监测数据】：成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传监测数据失败：" + e.getMessage());
            outParm.setExcutionError("上传监测数据失败：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 注册健康卡
     * @param inParm
     * @return
     */
    @Override
    public OutParm regquery(InParm inParm) {
        OutParm outParm = new OutParm();
        try{
            RequestParamModel request = new RequestParamModel();

            //接口方法
            request.setMethod("ehc.ehealthcard.regquery");
            logger.info("【注册健康卡入参】：" + inParm.getInJson());
            Map<String,String> bizContent = JSONObject.parseObject(inParm.getInJson(), Map.class);
            JSONObject inParmobject = JSONObject.parseObject(inParm.getInJson());
            logger.info("------->请求参数inParmobject：" + inParmobject.toJSONString());

            //外部注册时间
            bizContent.put("registerTime",request.getTimestamp());
            bizContent.put("appId",request.getAppId());
            //生成签名
            String sign =  SortUtil.getSignString(bizContent);
            if(StringUtils.isEmpty(sign)){
                outParm.setExcutionError("【注册健康卡失败】：生成签名失败！");
                logger.info("【注册健康卡失败】：生成签名失败！");
                return outParm;
            }
            AESUtil.removeNullValue(bizContent);
            //AES加密候设置参入参
            request.setBizContent(AESUtil.encrypt(JSON.toJSONString(bizContent),propConf.getAESkey()));
            //设置签名
            request.setDigest(MD5Util.MD5Encode(sign,"utf-8"));
            logger.info("【注册健康卡入参】：" + JSON.toJSONString(request));
            //请求健康卡接口
            String result = HttpClientUtil.doPost(propConf.getUrl() + "/virtual/user/create" , request);
            if(StringUtils.isEmpty(result)){
                outParm.setExcutionError("【注册健康卡失败】：健康卡接口返回为空！");
                logger.info("【注册健康卡失败】：健康卡接口返回为空！");
                return outParm;
            }
            logger.info("【健康卡注册出参】：" + result);
            ResultParamModel<String> resultMode = JSON.parseObject(result,ResultParamModel.class);
            if(!"200".equals(resultMode.getCode())){
                outParm.setExcutionError("【注册健康卡失败】：" + resultMode.getMessage());
                logger.info("【注册健康卡失败】：" + resultMode.getMessage());
                outParm.setOutResult(result);
                return outParm;
            }
            //解密返回的bizContent
            String decBizContentStr = AESUtil.decrypt(resultMode.getBizContent(),propConf.getAESkey());
            //重新放进返回的对象
            resultMode.setBizContent(decBizContentStr);
            //返回给前端
            outParm.setOutResult(JSON.toJSONString(resultMode));
            logger.info("【注册健康卡解密后出参】：" + JSON.toJSONString(resultMode));
            logger.info("【注册健康卡成功】：成功！");
            logger.info("【申请二维码扩展】：");

            Map<String,String> resultBiz = JSON.parseObject(resultMode.getBizContent(),Map.class);
            inParm.setCardId(resultBiz.get("ehealthCardId"));       //卡号
            this.uploadUserCardData(inParm);          //上传

            /*******************************申请二维码扩展********************************/
            Map<String,String> bizContentEx = new HashMap<>();
            bizContentEx.put("ehealthCardId",resultBiz.get("ehealthCardId"));
            bizContentEx.put("generateNo",new Date().getTime() + "");
            bizContentEx.put("generateTime",new Date().getTime() + "");
            bizContentEx.put("qrType","1");
            RequestParamModel requestEx = new RequestParamModel();

            requestEx.setMethod("ehc.ehealthcode.apply.ex");
            logger.info("【申请二维码扩展入参】：" + inParm.getInJson());
            //生成签名
            String signEx = SortUtil.getSignString(bizContentEx);
            if(StringUtils.isEmpty(signEx)){
                outParm.setExcutionError("【申请二维码扩展失败】：生成签名失败！");
                logger.info("【申请二维码扩展失败】：生成签名失败！");
                return outParm;
            }
            AESUtil.removeNullValue(bizContentEx);
            //AES加密候设置参入参
            requestEx.setBizContent(AESUtil.encrypt(JSON.toJSONString(bizContentEx),propConf.getAESkey()));
            //设置签名
            requestEx.setDigest(MD5Util.MD5Encode(signEx,"utf-8"));
            logger.info("【申请二维码扩展入参】：" + JSON.toJSONString(requestEx));
            //请求健康卡接口
            String resultEx = HttpClientUtil.doPost(propConf.getUrl() + "/quick/response/apply/ex" , requestEx);
            if(StringUtils.isEmpty(resultEx)){
                outParm.setExcutionError("【申请二维码扩展失败】：健康卡接口返回为空！");
                logger.info("【申请二维码扩展失败】：健康卡接口返回为空！");
                return outParm;
            }
            logger.info("【申请二维码扩展出参】：" + resultEx);
            ResultParamModel<String> resultModeEx = JSON.parseObject(resultEx,ResultParamModel.class);
            if(!"200".equals(resultModeEx.getCode())){
                outParm.setExcutionError("【申请二维码扩展失败】：" + resultModeEx.getMessage());
                logger.info("【申请二维码扩展失败】：" + resultModeEx.getMessage());
                outParm.setOutResult(resultEx);
                return outParm;
            }
            //解密返回的bizContent
            String decBizContentStrEx = AESUtil.decrypt(resultModeEx.getBizContent(),propConf.getAESkey());
            //重新放进返回的对象
            resultModeEx.setBizContent(decBizContentStrEx);
            //返回给前端
            outParm.setOutResult(JSON.toJSONString(resultModeEx));
            outParm.setExcutionSuccess("【注册健康卡成功】：成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.info("【注册健康卡错误】：" + e.getMessage());
            outParm.setExcutionError("注册健康卡错误：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 修改
     * @param inParm
     * @return
     */
    @Override
    public OutParm modify(InParm inParm) {
        OutParm outParm = new OutParm();
        try{
            RequestParamModel request = new RequestParamModel();
            //接口方法
            request.setMethod("ehc.ehealthcard.modify");
            logger.info("【修改健康卡信息入参】：" + inParm.getInJson());
            Map<String,String> bizContent = JSONObject.parseObject(inParm.getInJson(), Map.class);
            //外部注册时间
            bizContent.put("alterTime",request.getTimestamp());
            bizContent.put("appId",request.getAppId());
            String sign = SortUtil.getSignString(bizContent);
            if(StringUtils.isEmpty(sign)){
                outParm.setExcutionError("【修改健康卡信息失败】：生成签名失败！");
                logger.info("【修改健康卡信息失败】：生成签名失败！");
                return outParm;
            }
            AESUtil.removeNullValue(bizContent);
            //AES加密候设置参入参
            request.setBizContent(AESUtil.encrypt(JSON.toJSONString(bizContent),propConf.getAESkey()));
            //设置签名
            request.setDigest(MD5Util.MD5Encode(sign,"utf-8"));
            logger.info("【修改健康卡信息入参】：" + JSON.toJSONString(request));
            //请求健康卡接口
            String result = HttpClientUtil.doPost(propConf.getUrl() + "/virtual/user/update" , request);
            if(StringUtils.isEmpty(result)){
                outParm.setExcutionError("【修改健康卡信息失败】：健康卡接口返回为空！");
                logger.info("【修改健康卡信息失败】：健康卡接口返回为空！");
                return outParm;
            }
            logger.info("【修改健康卡信息出参】：" + result);
            ResultParamModel<String> resultMode = JSON.parseObject(result,ResultParamModel.class);
            if(!"200".equals(resultMode.getCode())){
                outParm.setExcutionError("【修改健康卡信息失败】：" + resultMode.getMessage());
                logger.info("【修改健康卡信息失败】：" + resultMode.getMessage());
                outParm.setOutResult(result);
                return outParm;
            }
            //解密返回的bizContent
            String decBizContentStr = AESUtil.decrypt(resultMode.getBizContent(),propConf.getAESkey());
            //重新放进返回的对象
            resultMode.setBizContent(decBizContentStr);
            //返回给前端
            outParm.setOutResult(JSON.toJSONString(resultMode));
            logger.info("【修改健康卡信息解密后出参】：" + JSON.toJSONString(resultMode));
            logger.info("【修改健康卡信息成功】：成功！");
            outParm.setExcutionSuccess("【修改健康卡信息成功】：成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.info("【修改健康卡信息错误】：" + e.getMessage());
            outParm.setExcutionError("【修改健康卡信息错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 注销
     * @param inParm
     * @return
     */
    @Override
    public OutParm destroy(InParm inParm) {
        OutParm outParm = new OutParm();
        try{
            RequestParamModel request = new RequestParamModel();
            //接口方法
            request.setMethod("ehc.ehealthcard.delete");
            logger.info("【注销健康卡信息入参】：" + inParm.getInJson());
            Map<String,String> bizContent = JSONObject.parseObject(inParm.getInJson(), Map.class);
            bizContent.put("appId",request.getAppId());
            String sign = SortUtil.getSignString(bizContent);
            if(StringUtils.isEmpty(sign)){
                outParm.setExcutionError("【注销健康卡信息失败】：生成签名失败！");
                logger.info("【注销健康卡信息失败】：生成签名失败！");
                return outParm;
            }
            AESUtil.removeNullValue(bizContent);
            //AES加密候设置参入参
            request.setBizContent(AESUtil.encrypt(JSON.toJSONString(bizContent),propConf.getAESkey()));
            //设置签名
            request.setDigest(MD5Util.MD5Encode(sign,"utf-8"));
            //请求健康卡接口
            String result = HttpClientUtil.doPost(propConf.getUrl() + "/virtual/user/write/off" , request);
            logger.info("【注销健康卡出参】：" + result);
            if(StringUtils.isEmpty(result)){
                outParm.setExcutionError("【注销健康卡信息失败】：健康卡接口返回为空！");
                logger.info("【注销健康卡信息失败】：健康卡接口返回为空！");
                return outParm;
            }
            ResultParamModel<String> resultMode = JSON.parseObject(result,ResultParamModel.class);
            if(!"200".equals(resultMode.getCode())){
                outParm.setExcutionError("【注销健康卡信息失败】：" + resultMode.getMessage());
                logger.info("【注销健康卡信息失败】：" + resultMode.getMessage());
                outParm.setOutResult(result);
                return outParm;
            }
            //解密返回的bizContent
            String decBizContentStr = AESUtil.decrypt(resultMode.getBizContent(),propConf.getAESkey());
            //重新放进返回的对象
            resultMode.setBizContent(decBizContentStr);
            //返回给前端
            outParm.setOutResult(JSON.toJSONString(resultMode));
            logger.info("【注销健康卡信息解密后出参】：" + JSON.toJSONString(resultMode));
            logger.info("【注销健康卡信息成功】：成功！");
            outParm.setExcutionSuccess("【注销健康卡信息成功】：成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.info("【注销健康卡信息错误】：" + e.getMessage());
            outParm.setExcutionError("【注销健康卡信息错误】：" + e.getMessage());
        }
        return outParm;
    }


    /**
     * 查询健康卡
     * @param inParm
     * @return
     */
    @Override
    public OutParm query(InParm inParm) {
        OutParm outParm = new OutParm();
        try{
            RequestParamModel request = new RequestParamModel();

            //接口方法
            request.setMethod("ehc.ehealthcard.regquery");
            logger.info("【查询健康卡信息入参】：" + inParm.getInJson());
            //准备签名参数
            Map<String,String> bizContent = JSONObject.parseObject(inParm.getInJson(), Map.class);
            bizContent.put("appId",request.getAppId());
            //获取签名
            String sign = SortUtil.getSignString(bizContent);
            if(StringUtils.isEmpty(sign)){
                outParm.setExcutionError("【查询健康卡信息失败】：生成签名失败！");
                logger.info("【查询健康卡信息失败】：生成签名失败！");
                return outParm;
            }
            AESUtil.removeNullValue(bizContent);
            //AES加密候设置参入参
            request.setBizContent(AESUtil.encrypt(JSON.toJSONString(bizContent),propConf.getAESkey()));
            //MD5加密签名
            String MD5Sign = MD5Util.MD5Encode(sign,"utf-8");
            logger.info("【MD5签名】：" + MD5Sign);
            request.setDigest(MD5Sign);
            //请求健康卡接口
            String result = HttpClientUtil.doPost(propConf.getUrl() + "/virtual/user/query" , request);
            if(StringUtils.isEmpty(result)){
                outParm.setExcutionError("【查询健康卡信息失败】：健康卡接口返回为空！");
                logger.info("【查询健康卡信息失败】：健康卡接口返回为空！");
                return outParm;
            }
            logger.info("【查询健康卡信息出参】：" + result);
            ResultParamModel<String> resultMode = JSON.parseObject(result,ResultParamModel.class);
            if(!"200".equals(resultMode.getCode())){
                outParm.setExcutionError("【查询健康卡信息失败】：" + resultMode.getMessage());
                logger.info("【查询健康卡信息失败】：" + resultMode.getMessage());
                outParm.setOutResult(result);
                return outParm;
            }
            //解密返回的bizContent
            String decBizContentStr = AESUtil.decrypt(resultMode.getBizContent(),propConf.getAESkey());
            Map<String,String> contentMap = JSON.parseObject(decBizContentStr,Map.class);

            //重新放进返回的对象
            resultMode.setBizContent(decBizContentStr);
            /*******************************申请二维码扩展********************************/
            Map<String,String> resultBiz = JSON.parseObject(resultMode.getBizContent(),Map.class);
            //解决手机注册无:xxxx等信息，这里申请一次二维码返回
            if(StringUtils.isNotEmpty(resultBiz.get("ehealthCardId")) && (resultBiz.get("ehealthCardId").length() <= 64 || resultBiz.get("ehealthCardId").indexOf(":") == -1)){
                Map<String,String> bizContentEx = new HashMap<>();
                bizContentEx.put("ehealthCardId",resultBiz.get("ehealthCardId"));
                bizContentEx.put("generateNo",new Date().getTime() + "");
                bizContentEx.put("generateTime",new Date().getTime() + "");
                bizContentEx.put("qrType","1");
                RequestParamModel requestEx = new RequestParamModel();
                requestEx.setMethod("ehc.ehealthcode.apply.ex");
                logger.info("【申请二维码扩展入参】：" + inParm.getInJson());
                //生成签名
                String signEx = SortUtil.getSignString(bizContentEx);
                if(StringUtils.isEmpty(signEx)){
                    outParm.setExcutionError("【申请二维码扩展失败】：生成签名失败！");
                    logger.info("【申请二维码扩展失败】：生成签名失败！");
                    return outParm;
                }
                AESUtil.removeNullValue(bizContentEx);
                //AES加密候设置参入参
                requestEx.setBizContent(AESUtil.encrypt(JSON.toJSONString(bizContentEx),propConf.getAESkey()));
                //设置签名
                requestEx.setDigest(MD5Util.MD5Encode(signEx,"utf-8"));
                logger.info("【申请二维码扩展入参】：" + JSON.toJSONString(requestEx));
                //请求健康卡接口
                String resultEx = HttpClientUtil.doPost(propConf.getUrl() + "/quick/response/apply/ex" , requestEx);
                if(StringUtils.isEmpty(resultEx)){
                    outParm.setExcutionError("【申请二维码扩展失败】：健康卡接口返回为空！");
                    logger.info("【申请二维码扩展失败】：健康卡接口返回为空！");
                    return outParm;
                }
                logger.info("【申请二维码扩展出参】：" + resultEx);
                ResultParamModel<String> resultModeEx = JSON.parseObject(resultEx,ResultParamModel.class);
                if(!"200".equals(resultModeEx.getCode())){
                    outParm.setExcutionError("【申请二维码扩展失败】：" + resultModeEx.getMessage());
                    logger.info("【申请二维码扩展失败】：" + resultModeEx.getMessage());
                    outParm.setOutResult(resultEx);
                    return outParm;
                }
                //解密返回的bizContent
                String decBizContentStrEx = AESUtil.decrypt(resultModeEx.getBizContent(),propConf.getAESkey());
                Map<String,String> contentExMap = JSON.parseObject(decBizContentStrEx,Map.class);
                contentMap.put("ehealthCode",contentExMap.get("ehealthCode"));
                resultMode.setBizContent(JSON.toJSONString(contentMap));
            }
            //返回给前端
            outParm.setOutResult(JSON.toJSONString(resultMode));
            logger.info("【查询健康卡信息解密后出参】：" + JSON.toJSONString(resultMode));
            logger.info("【查询健康卡信息成功】：成功！");
            outParm.setExcutionSuccess("【查询健康卡信息成功】：成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.info("【查询健康卡信息错误】：" + e.getMessage());
            outParm.setExcutionError("【查询健康卡信息错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 申请二维码
     * @param inParm
     * @return
     */
    @Override
    public OutParm apply(InParm inParm) {
        return null;
    }

    /**
     * 申请二维码扩展
     * @param inParm
     * @return
     */
    @Override
    public OutParm applyex(InParm inParm) {
        return null;
    }

    /**
     * 验证二维码
     * @param inParm
     * @return
     */
    @Override
    public OutParm verify(InParm inParm) {
        return null;
    }

    /**
     * 新增门诊项
     * @param inParm
     * @return
     */
    @Override
    public OutParm outpatientAdd(InParm inParm) {
        OutParm outParm = new OutParm();
        try{
            RequestParamModel request = new RequestParamModel();
            //接口方法
            request.setMethod("ehc.outpatient.add");
            logger.info("【新增门诊项入参】：" + inParm.getInJson());
            Map<String,String> bizContent = JSONObject.parseObject(inParm.getInJson(), Map.class);
            Map<String,String> signMap = new HashMap<>();
            //生成签名
            signMap.put("timestamp",request.getTimestamp());
            String sign =  SortUtil.getSignString(signMap);
            if(StringUtils.isEmpty(sign)){
                outParm.setExcutionError("【新增门诊项失败】：生成签名失败！");
                logger.info("【新增门诊项失败】：生成签名失败！");
                return outParm;
            }
            AESUtil.removeNullValue(bizContent);
            //AES加密候设置参入参
            request.setBizContent(AESUtil.encrypt("[" + JSON.toJSONString(bizContent) + "]",propConf.getAESkey()));
            //设置签名
            request.setDigest(MD5Util.MD5Encode(sign,"utf-8"));
            logger.info("【新增门诊项入参】：" + JSON.toJSONString(request));
            //请求健康卡接口
            String result = HttpClientUtil.doPost(propConf.getUrl() + "/outpatient/add" , request);
            if(StringUtils.isEmpty(result)){
                outParm.setExcutionError("【新增门诊项失败】：健康卡接口返回为空！");
                logger.info("【新增门诊项失败】：健康卡接口返回为空！");
                return outParm;
            }
            logger.info("【新增门诊项出参】：" + result);
            ResultParamModel<String> resultMode = JSON.parseObject(result,ResultParamModel.class);
            if(!"200".equals(resultMode.getCode())){
                outParm.setExcutionError("【新增门诊项失败】：" + resultMode.getMessage());
                logger.info("【新增门诊项失败】：" + resultMode.getMessage());
                outParm.setOutResult(result);
                return outParm;
            }
            //解密返回的bizContent
            String decBizContentStr = AESUtil.decrypt(resultMode.getBizContent(),propConf.getAESkey());
            //重新放进返回的对象
            resultMode.setBizContent(decBizContentStr);
            //返回给前端
            outParm.setOutResult(JSON.toJSONString(resultMode));
            logger.info("【新增门诊项解密后出参】：" + JSON.toJSONString(resultMode));
            logger.info("【新增门诊项成功】：成功！");
            outParm.setExcutionSuccess("【新增门诊项成功】：成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.info("【新增门诊项错误】：" + e.getMessage());
            outParm.setExcutionError("【新增门诊项错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 新增住院项
     * @param inParm
     * @return
     */
    @Override
    public OutParm inpatientAdd(InParm inParm) {
        OutParm outParm = new OutParm();
        try{
            RequestParamModel request = new RequestParamModel();
            //接口方法
            request.setMethod("ehc.inpatient.add");
            logger.info("【新增住院项入参】：" + inParm.getInJson());
            Map<String,String> bizContent = JSONObject.parseObject(inParm.getInJson(), Map.class);
            Map<String,String> signMap = new HashMap<>();
            //生成签名
            signMap.put("timestamp",request.getTimestamp());
            //生成签名
            String sign =  SortUtil.getSignString(signMap);
            if(StringUtils.isEmpty(sign)){
                outParm.setExcutionError("【新增住院项失败】：生成签名失败！");
                logger.info("【新增住院项失败】：生成签名失败！");
                return outParm;
            }
            AESUtil.removeNullValue(bizContent);
            //AES加密候设置参入参
            request.setBizContent(AESUtil.encrypt("[" + JSON.toJSONString(bizContent) + "]",propConf.getAESkey()));
            //设置签名
            request.setDigest(MD5Util.MD5Encode(sign,"utf-8"));
            logger.info("【新增住院项入参】：" + JSON.toJSONString(request));
            //请求健康卡接口
            String result = HttpClientUtil.doPost(propConf.getUrl() + "/inpatient/add" , request);
            if(StringUtils.isEmpty(result)){
                outParm.setExcutionError("【新增住院项失败】：健康卡接口返回为空！");
                logger.info("【新增住院项失败】：健康卡接口返回为空！");
                return outParm;
            }
            logger.info("【新增住院项出参】：" + result);
            ResultParamModel<String> resultMode = JSON.parseObject(result,ResultParamModel.class);
            if(!"200".equals(resultMode.getCode())){
                outParm.setExcutionError("【新增住院项失败】：" + resultMode.getMessage());
                logger.info("【新增住院项失败】：" + resultMode.getMessage());
                outParm.setOutResult(result);
                return outParm;
            }
            //解密返回的bizContent
            String decBizContentStr = AESUtil.decrypt(resultMode.getBizContent(),propConf.getAESkey());
            //重新放进返回的对象
            resultMode.setBizContent(decBizContentStr);
            //返回给前端
            outParm.setOutResult(JSON.toJSONString(resultMode));
            logger.info("【新增住院项解密后出参】：" + JSON.toJSONString(resultMode));
            logger.info("【新增住院项成功】：成功！");
            outParm.setExcutionSuccess("【新增住院项成功】：成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.info("【新增住院项错误】：" + e.getMessage());
            outParm.setExcutionError("【新增住院项错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 查询院内是否注册健康卡
     * @param brid
     * @param yljgbm
     * @return
     */
    @Override
    public OutParm queryHealthCardByBrid(String brid, String yljgbm) {
        OutParm outParm = new OutParm();
        try{
            Map<String,Object> ylkxx = dao.queryHealthCardByBrid(brid,yljgbm);
            if(ylkxx == null || ylkxx.size() <= 0){
                outParm.setExcutionError("【查询院内是否注册健康卡失败】：无相关信息！");
                return outParm;
            }
            outParm.setOutResult(JSON.toJSONString(ylkxx));
            outParm.setExcutionSuccess("【查询院内是否注册健康卡成功】：成功！");
        }catch (Exception e){
            e.printStackTrace();
            logger.info("【查询院内是否注册健康卡错误】：" + e.getMessage());
            outParm.setExcutionError("【查询院内是否注册健康卡错误】：" + e.getMessage());
        }
        return outParm;
    }
}