package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TMappingUnit;
import com.aaa.gpm.model.TResource;
import com.aaa.gpm.service.ResourceService;
import com.aaa.gpm.service.ScoreService;
import com.aaa.gpm.service.UnitService;
import com.aaa.gpm.utils.FileNameUtils;
import com.aaa.gpm.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.gpm.staticproperties.TimeForatProperties.TIME_FORMAT;

/**
 * @Author: gcy
 * @DateTime: 2020/7/16 14:52
 * @Description: TODO
 */
@RestController
public class UnitController extends CommonController<TMappingUnit> {
    @Autowired
    private UnitService unitService;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ResourceService resouceService;
    @Override
    public BaseService<TMappingUnit> getBaseService() {
        return unitService;
    }
    /**@DateTime: 2020/7/16 14:55
    * @Params: [tMappingUnit, pageNo, pageSize]
    * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMappingUnit>
    * 描述：
     *      查询所有单位
    */
    @GetMapping("/allUnit")
    public ResultData<TMappingUnit> allUnit(TMappingUnit tMappingUnit,Integer pageNo,Integer pageSize){
        PageInfo<TMappingUnit> allUnit = unitService.allUnit(tMappingUnit, pageNo, pageSize);
        if (null != allUnit && !"".equals(allUnit)){
            return super.operationSuccess(allUnit);
        }
        return super.operationFailed("查询所有单位失败");
    }
    /**@DateTime: 2020/7/18 10:57
     * @Params: [pageNo, pageSize, name]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMappingUnit>
     * 描述：
     *      通过单位名称查询单位信息
    */
    @GetMapping("/selectUnitByName")
    public ResultData<TMappingUnit> selectUnitByName(Integer pageNo, Integer pageSize, String name){
        PageInfo<TMappingUnit> tMappingUnitPageInfo = unitService.selectUnitByName(pageNo, pageSize,name);
        if (tMappingUnitPageInfo != null && !"".equals(tMappingUnitPageInfo)){
            return super.operationSuccess(tMappingUnitPageInfo);
        }
        return super.operationFailed();
    }
    /**@DateTime: 2020/7/16 19:40
    * @Params: [map]
    * @Return com.aaa.gpm.base.ResultData
    * 描述：
     *      企业用户注册
    */
    @PostMapping("/registUnit")
    public ResultData registUnit(@RequestParam Map map){
        return super.add(map);
    }
    /**@DateTime: 2020/7/17 9:02
     * @Params: [score_plus, score_subtract, id]
     * @Return com.aaa.gpm.base.ResultData<java.lang.Long>
     * 描述：
     *      单位加减分
     *      增加分值表
     *      增加资源表
    */
    @PostMapping("/updateScore")
    public ResultData<Long> updateScore(Long id, Integer score_plus, Integer score_subtract, Integer score, Long unit_id, String reason, Date create_time, Date modify_time,String name){
        Long aLong = unitService.updateScore(score_plus, score_subtract, unit_id);
        if (aLong != null && aLong>0){
            Integer integer = scoreService.addScore(id, score_plus, score_subtract, score, unit_id, reason, create_time, modify_time);
            if (integer != null && integer > 0) {
                TResource tResource = new TResource();
                tResource.setRefBizId(unit_id);
                tResource.setCreateTime(new Date()).setId(FileNameUtils.getFileName()).setName(name).setPath(FileNameUtils.getFileName()+""+name.substring(name.lastIndexOf(".")));
                Integer add = resouceService.add(tResource);
                if (add != null && add > 0) {
                    return super.operationSuccess("所有操作均完成");
                }
                return super.operationFailed("增加资源表失败");
            }
            return super.operationFailed("增加分值表失败");
        }
        return super.operationFailed("修改单位分值失败");
    }
    /**@DateTime: 2020/7/17 10:46
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData<java.lang.Integer>
     * 描述：
     *      注册审核
    */
    @PostMapping("/registAudit")
    public ResultData<Integer> registAudit(Long id){
        Integer integer = unitService.registAudit(id);
        if (integer != null && integer > 0) {
            return super.operationSuccess(integer);
        }
        return super.operationFailed("系统异常，注册审核失败");
    }
    /**@DateTime: 2020/7/17 10:52
     * @Params: [blackWhite]
     * @Return com.aaa.gpm.base.ResultData<java.util.List<com.aaa.gpm.model.TMappingUnit>>
     * 描述：
     *      黑白名单
    */
    @GetMapping("/blackWhite")
    public ResultData<List<TMappingUnit>> blackWhite(String blackWhite,Integer pageNo,Integer pageSize){
        TMappingUnit tMappingUnit = new TMappingUnit();
        Map map = new HashMap();
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        if (blackWhite.equals("黑名单")){
            tMappingUnit.setUnitStatus(2);
            map.put("t",tMappingUnit);
            return super.selectListByPage(map);
        }if (blackWhite.equals("白名单")){
            tMappingUnit.setUnitStatus(1);
            map.put("t",tMappingUnit);
            return super.selectListByPage(map);
        }
        return super.operationFailed("系统异常，查询失败");
    }
}
