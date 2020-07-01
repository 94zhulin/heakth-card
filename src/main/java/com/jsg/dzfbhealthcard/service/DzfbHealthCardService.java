package com.jsg.dzfbhealthcard.service;

import com.jsg.dzfbhealthcard.model.InParm;
import com.jsg.dzfbhealthcard.model.OutParm;

/**
 * @author DEdison Z
 * @company 绵阳金盛高科技
 * @remark 类描述
 * @since 2019/8/29 17:10
 */
public interface DzfbHealthCardService {

    /**
     * 上传健康卡监测数据
     * @return
     */
    OutParm uploadUserCardData (InParm inParm);

    /**
     * 注册健康卡
     * @return
     */
    OutParm regquery(InParm inParm);


    /**
     * 查询健康卡
     * @return
     */
    OutParm query(InParm inParm);

    /**
     * 修改健康卡
     * @return
     */
    OutParm modify(InParm inParm);

    /**
     * 注销健康卡
     * @return
     */
    OutParm destroy(InParm inParm);

    /**
     * 申请二维码
     * @return
     */
    OutParm apply(InParm inParm);

    /**
     * 二维码扩展
     * @return
     */
    OutParm applyex(InParm inParm);

    /**
     * 二维码验证
     * @return
     */
    OutParm verify(InParm inParm);

    /**
     * 新增门诊项
     * @param inParm
     * @return
     */
    OutParm outpatientAdd(InParm inParm);

    /**
     * 新增住院项
     * @param inParm
     * @return
     */
    OutParm inpatientAdd(InParm inParm);

    /**
     * 查询院内是否注册健康卡
     * @param brid
     * @param yljgbm
     * @return
     */
    OutParm queryHealthCardByBrid(String brid,String yljgbm);

}
