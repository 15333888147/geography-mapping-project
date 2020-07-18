package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/17
 * 数据统计
 */
@RestController
public class StatsController extends BaseController {

    @Autowired
    private StatsService statsService;

    /**
     * @author zj
     * @DateTime: 2020/7/17 14:50
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      项目类型测绘统计，2未完成，3已完成
    */
    @GetMapping("/mappingStats")
    public ResultData mappingStats(){
        List<Map> mappingStats = statsService.mappingStats();
        if (null != mappingStats && mappingStats.size() > 0){
            return super.operationSuccess(mappingStats);
        }
        return super.operationFailed();
    }

    /**
     * @author zj
     * @DateTime: 2020/7/17 14:53
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      单位资质统计
    */
    @GetMapping("/unitStats")
    public ResultData unitStats(){
        List<Map> unitStats = statsService.unitStats();
        if (null != unitStats && unitStats.size() > 0){
            return super.operationSuccess(unitStats);
        }
        return super.operationFailed();
    }

    /**
     * @author zj
     * @DateTime: 2020/7/17 14:53
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      单位信息统计
    */
    @GetMapping("/unitInfoStats")
    public ResultData unitInfoStats(){
        List<Map> unitInfoStats = statsService.unitInfoStats();
        if (null != unitInfoStats && unitInfoStats.size() > 0){
            return super.operationSuccess(unitInfoStats);
        }
        return super.operationFailed();
    }

    /**
     * @author zj
     * @DateTime: 2020/7/17 14:54
     * @Params: [userId]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      公司概览
    */
    @GetMapping("/companyOverview")
    public ResultData companyOverview(Long userId){
        List<List<Map>> companyOverview = statsService.companyOverview(userId);
        if (null != companyOverview && companyOverview.size() > 0){
            return super.operationSuccess(companyOverview);
        }
        return super.operationFailed();
    }

    /**
     * @author zj
     * @DateTime: 2020/7/18 13:57
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员设备汇总统计
    */
    @GetMapping("/personnelStats")
    public ResultData personnelStats(){
        List<List<Map>> list = statsService.personnelStats();
        if (null != list && list.size() > 0){
            return super.operationSuccess(list);
        }
        return super.operationFailed();
    }

}
