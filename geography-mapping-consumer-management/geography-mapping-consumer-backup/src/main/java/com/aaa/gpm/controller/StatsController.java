package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zj
 * @Date: 2020/7/20
 * 数据统计
 */
@RestController
public class StatsController extends BaseController {

    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:45
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      项目类型测绘统计，2未完成，3已完成
    */
    @GetMapping("/mappingStats")
    public ResultData mappingStats(){
        return springcloudGpmService.mappingStats();
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:45
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      单位资质统计
    */
    @GetMapping("/unitStats")
    public ResultData unitStats(){
        return springcloudGpmService.unitStats();
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:45
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      单位信息统计
    */
    @GetMapping("/unitInfoStats")
    public ResultData unitInfoStats(){
        return springcloudGpmService.unitInfoStats();
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:46
     * @Params: [userId]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      公司概览
    */
    @GetMapping("/companyOverview")
    public ResultData companyOverview(@RequestParam Long userId){
        return springcloudGpmService.companyOverview(userId);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:47
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员设备汇总统计
    */
    @GetMapping("/personnelStats")
    public ResultData personnelStats(){
        return springcloudGpmService.personnelStats();
    }
}
