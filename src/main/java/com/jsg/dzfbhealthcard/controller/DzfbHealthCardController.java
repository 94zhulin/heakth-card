package com.jsg.dzfbhealthcard.controller;

import com.jsg.dzfbhealthcard.model.InParm;
import com.jsg.dzfbhealthcard.model.OutParm;
import com.jsg.dzfbhealthcard.service.DzfbHealthCardService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 达州宣汉妇保电子健康卡
 * @since 2019/8/29 10:23
 * 向日葵：766095543       123123
 * tv：1512839835        949ivi
 * select *from gyb_brjbxx where sfzjhm is not null;
 */
@RestController
@Valid
@RequestMapping("healthCard")
public class DzfbHealthCardController {

    private static final Logger logger = LoggerFactory.getLogger(DzfbHealthCardController.class);

    @Autowired
    DzfbHealthCardService healthCardService;

    /**
     * 上传健康卡监测数据
     * @return
     */
    @RequestMapping("uploadUserCardData")
    public OutParm uploadUserCardData(@Valid @RequestBody InParm inParm) {
        OutParm outParm = new OutParm();
        try {
            outParm = healthCardService.uploadUserCardData(inParm);
        } catch (Exception e) {
            e.printStackTrace();
            outParm.setExcutionError("【上传健康卡监测数据错误】：" + e.getMessage());
            logger.info("【上传健康卡监测数据错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 查询注册电子健康卡
     * @param inParm
     * @return
     */
    @RequestMapping("register")
    public OutParm register(@Valid @RequestBody InParm inParm){
        OutParm outParm = new OutParm();
        try{
            outParm = healthCardService.regquery(inParm);
        }catch (Exception e){
            e.printStackTrace();
            outParm.setExcutionError("【注册健康卡错误】：" + e.getMessage());
            logger.info("【注册健康卡错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 修改
     * @param inParm
     * @return outParm
     */
    @RequestMapping("modify")
    public OutParm modify(@Valid @RequestBody InParm inParm){
        OutParm outParm = new OutParm();
        try{
            outParm = healthCardService.modify(inParm);
        }catch (Exception e){
            e.printStackTrace();
            outParm.setExcutionError("【修改健康卡信息错误】：" + e.getMessage());
            logger.info("【修改健康卡信息错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 注销
     * @param inParm
     * @return outParm
     */
    @RequestMapping("destroy")
    public OutParm destroy(@Valid @RequestBody InParm inParm){
        OutParm outParm = new OutParm();
        try{
            outParm = healthCardService.destroy(inParm);
        }catch (Exception e){
            e.printStackTrace();
            outParm.setExcutionError("【注销健康卡错误】：" + e.getMessage());
            logger.info("【注销健康卡错误】：" + e.getMessage());
        }
        return outParm;
    }


    /**
     * 查询电子健康卡
     * @param inParm
     * @return
     */
    @RequestMapping("query")
    public OutParm query(@Valid @RequestBody InParm inParm){
        OutParm outParm = new OutParm();
        try{
            outParm = healthCardService.query(inParm);
        }catch (Exception e){
            e.printStackTrace();
            outParm.setExcutionError("【查询健康卡错误】：" + e.getMessage());
            logger.info("【查询健康卡错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 二维码申请
     * @param in
     * @return
     */
    @RequestMapping("apply")
    public OutParm apply(@RequestParam("")String in){
        OutParm outParm = new OutParm();
        try{

        }catch (Exception e){
            e.printStackTrace();
            outParm.setExcutionError("【注销健康卡错误】：" + e.getMessage());
            logger.info("【注销健康卡错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 二维码扩展
     * @param in
     * @return
     */
    @RequestMapping("applyex")
    public OutParm applyex(@RequestParam("")String in){
        OutParm outParm = new OutParm();
        try{

        }catch (Exception e){
            e.printStackTrace();
            outParm.setExcutionError("");
            logger.info("");
        }
        return outParm;
    }

    /**
     * 二维码验证
     * @param in
     * @return
     */
    @RequestMapping("verify")
    public OutParm verify(@RequestParam("")String in){
        OutParm outParm = new OutParm();
        try{

        }catch (Exception e){
            e.printStackTrace();
            outParm.setExcutionError("");
            logger.info("");
        }
        return outParm;
    }

    /**
     * 新增门诊项
     * @param inParm
     * @return
     */
    @RequestMapping("outpatientAdd")
    public OutParm outpatientAdd(@Valid @RequestBody InParm inParm){
        OutParm outParm = new OutParm();
        try{
            outParm = healthCardService.outpatientAdd(inParm);
        }catch (Exception e){
            e.printStackTrace();
            outParm.setExcutionError("【新增门诊项错误】：" + e.getMessage());
            logger.info("【新增门诊项错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 新增住院项
     * @param inParm
     * @return
     */
    @RequestMapping("inpatientAdd")
    public OutParm inpatientAdd(@Valid @RequestBody InParm inParm){
        OutParm outParm = new OutParm();
        try{
            outParm = healthCardService.inpatientAdd(inParm);
        }catch (Exception e){
            e.printStackTrace();
            outParm.setExcutionError("【新增住院项错误】：" + e.getMessage());
            logger.info("【新增住院项错误】：" + e.getMessage());
        }
        return outParm;
    }

    /**
     * 查询院内是否注册健康卡
     * @param brid
     * @param yljgbm
     * @return
     */
    @RequestMapping("queryCardByBrid")
    public OutParm queryHealthCardByBrid(@Param("brid") String brid,@Param("yljgbm") String yljgbm){
        OutParm outParm = new OutParm();
        try{
            outParm = healthCardService.queryHealthCardByBrid(brid,yljgbm);
        }catch (Exception e){
            e.printStackTrace();
            outParm.setExcutionError("【查询院内是否注册健康卡错误】：" + e.getMessage());
            logger.info("【查询院内是否注册健康卡错误】：" + e.getMessage());
        }
        return outParm;
    }

}
