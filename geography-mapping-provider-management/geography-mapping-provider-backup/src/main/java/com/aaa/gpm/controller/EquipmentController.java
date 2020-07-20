package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TEquipment;
import com.aaa.gpm.model.TResource;
import com.aaa.gpm.model.TSpecialPost;
import com.aaa.gpm.service.EquipmentService;
import com.aaa.gpm.service.ResourceService;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: gcy
 * @DateTime: 2020/7/17 20:05
 * @Description: TODO
 */
@RestController
public class EquipmentController extends CommonController<TEquipment> {
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private ResourceService resourceService;
    @Override
    public BaseService<TEquipment> getBaseService() {
        return equipmentService;
    }
    /**@DateTime: 2020/7/17 20:38
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TEquipment>
     * 描述：
     *      查询所有仪器
    */
    @GetMapping("/allEquipment")
    public ResultData<TEquipment> allEquipment(Integer pageNo,Integer pageSize){
        PageInfo<TEquipment> pageInfo = equipmentService.selectListByPage(null, pageNo, pageSize);
        if (null != pageInfo && !"".equals(pageInfo)){
            return super.operationSuccess(pageInfo);
        }
        return super.operationFailed("系统异常，查询失败");
    }
    /**@DateTime: 2020/7/17 20:42
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TEquipment>
     * 描述：
     *      根据id查询仪器
    */
    @GetMapping("/selectEquipmentById")
    public ResultData<Map> selectEquipmentById(Long id){
        Map map = new HashMap();
        TEquipment tEquipment = new TEquipment();
        tEquipment.setId(id);
        TEquipment tEquipment1 = equipmentService.selectOne(tEquipment);
        TResource tResource = new TResource();
        tResource.setRefBizId(id);
        List<TResource> tResources = resourceService.selectList(tResource);
        if (null != tEquipment1 && !"".equals(tEquipment1) && null != tResources && !"".equals(tResources)){
            map.put("tEquipment",tEquipment1);
            map.put("tResource",tResources);
            return super.operationSuccess(map);
        }
        return super.operationFailed("查无此仪器");
    }
    /**@DateTime: 2020/7/20 10:25
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TEquipment>
     * 描述：
     *      修改仪器信息
     */
    @PostMapping("/updateEquipment")
    public ResultData<TEquipment> updateSpecialPost(@RequestBody Map map){
        return super.update(map);
    }
    /**@DateTime: 2020/7/20 10:25
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TEquipment>
     * 描述：
     *      增加仪器信息
     */
    @PostMapping("/addEquipment")
    public ResultData<TEquipment> addSpecialPost(@RequestBody Map map){
        return super.add(map);
    }
    /**@DateTime: 2020/7/20 10:26
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TEquipment>
     * 描述：
     *      删除仪器信息
     */
    @PostMapping("/deleteEquipment")
    public ResultData<TEquipment> deleteSpecialPost(@RequestBody Map map){
        return super.delete(map);
    }
}
