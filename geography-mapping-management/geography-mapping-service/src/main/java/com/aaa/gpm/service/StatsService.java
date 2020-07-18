package com.aaa.gpm.service;

import com.aaa.gpm.mapper.StatsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/17
 *      数据统计
 */
@Service
public class StatsService {

    @Autowired
    private StatsMapper statsMapper;

    /**
     * @author zj
     * @DateTime: 2020/7/17 14:38
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      项目类型测绘统计，2未完成，3已完成
    */
    public List<Map> mappingStats(){
        List<Map> mappingStats = statsMapper.mappingStats();
        if (null != mappingStats && mappingStats.size() > 0){
            return mappingStats;
        }
        return null;
    }

    /**
     * @author zj
     * @DateTime: 2020/7/17 14:41
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      单位资质统计
    */
    public List<Map> unitStats(){
        List<Map> unitStats = statsMapper.unitStats();
        if (null != unitStats && unitStats.size() > 0){
            return unitStats;
        }
        return null;
    }

    /**
     * @author zj
     * @DateTime: 2020/7/17 14:42
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *     单位信息统计
    */
    public List<Map> unitInfoStats(){
        List<Map> unitInfoStats = statsMapper.unitInfoStats();
        if (null != unitInfoStats && unitInfoStats.size() > 0){
            return unitInfoStats;
        }
        return null;
    }

    /**
     * @author zj
     * @DateTime: 2020/7/17 14:46
     * @Params: [userId]
     * @Return java.util.List<java.util.List<java.util.Map>>
     * Description:
     *      公司概览
    */
    public List<List<Map>> companyOverview(Long userId){
        List<List<Map>> list = new ArrayList<List<Map>>();
        List<Map> mapList = new ArrayList<Map>();
        List<Map> mapLists = new ArrayList<Map>();
        // 项目数量
        List<Map> mappingCountStats = statsMapper.mappingCountStats(userId);
        if (null == mappingCountStats && mappingCountStats.size() ==0){
            Map map = new HashMap();
            map.put("tmpcount",0);
        }
        // 初，中，高级技术员统计
        List<Map> technicianStats = statsMapper.technicianStats(userId);
        Boolean primaryMap = true;
        Boolean intermediateMap = true;
        Boolean seniorMap = true;
        for (Map map : technicianStats) {
            Map mapAllMt = new HashMap();
            if ("初级技术人员".equals(map.get("majorType"))){
                primaryMap = false;
                mapAllMt.put("mtcount",map.get("mtcount"));
                mapAllMt.put("majorType",map.get("majorType"));
                mapList.add(mapAllMt);
            }
            if ("中级技术人员".equals(map.get("majorType"))){
                intermediateMap = false;
                mapAllMt.put("mtcount",map.get("mtcount"));
                mapAllMt.put("majorType",map.get("majorType"));
                mapList.add(mapAllMt);
            }
            if ("高级技术人员".equals(map.get("majorType"))){
                seniorMap = false;
                mapAllMt.put("mtcount",map.get("mtcount"));
                mapAllMt.put("majorType",map.get("majorType"));
                mapList.add(mapAllMt);
            }
        }

        if(primaryMap){
            Map mapAllMt = new HashMap();
            mapAllMt.put("mtcount",0);
            mapAllMt.put("majorType","初级技术人员");
            mapList.add(mapAllMt);
        }
        if(intermediateMap){
            Map mapAllMt = new HashMap();
            mapAllMt.put("mtcount",0);
            mapAllMt.put("majorType","中级技术人员");
            mapList.add(mapAllMt);
        }
        if(seniorMap){
            Map mapAllMt = new HashMap();
            mapAllMt.put("mtcount",0);
            mapAllMt.put("majorType","高级技术人员");
            mapList.add(mapAllMt);
        }

        for (Map map : mapList) {
            if ("初级技术人员".equals(map.get("majorType"))){
                mapLists.add(map);
            }
        }
        for (Map map : mapList) {
            if ("中级技术人员".equals(map.get("majorType"))){
                mapLists.add(map);
            }
        }
        for (Map map : mapList) {
            if ("高级技术人员".equals(map.get("majorType"))){
                mapLists.add(map);
            }
        }
        // 特殊人员统计
        List<Map> specialStats = statsMapper.specialStats(userId);
        if (null == specialStats && specialStats.size() ==0){
            Map map2 = new HashMap();
            map2.put("tspcount",0);
        }
        list.add(mappingCountStats);
        list.add(mapLists);
        list.add(specialStats);
        if (list != null && list.size()>0) {
            return list;
        }
        return null;
    }

    /**
     * @author zj
     * @DateTime: 2020/7/18 13:37
     * @Params: []
     * @Return java.util.List<java.util.List<java.util.Map>>
     * Description:
     *      人员设备汇总统计
    */
    public List<List<Map>> personnelStats(){
        //总统计
        List<List<Map>> list = new ArrayList<List<Map>>();
        //甲级单位数量
        Map unitJCount = statsMapper.unitJCount();
        //甲级初，中，高级技术员统计
        List<Map> technicianJCount = statsMapper.technicianJCount();
        //甲级仪器设备统计
        List<Map> equipmentJCount = statsMapper.equipmentJCount();
        if (null == unitJCount){
            unitJCount.put("unitcount",0);
            unitJCount.put("unitlevel","甲级");
        }
        technicianJCount.add(unitJCount);
        for(Map mapTechnician : technicianJCount){
            equipmentJCount.add(mapTechnician);
        }
        //乙级单位数量
        Map unitYCount = statsMapper.unitYCount();
        //乙级初，中，高级技术员统计
        List<Map> technicianYCount = statsMapper.technicianYCount();
        //乙级仪器设备统计
        List<Map> equipmentYCount = statsMapper.equipmentYCount();
        if (null == unitYCount){
            unitYCount.put("unitcount",0);
            unitYCount.put("unitlevel","乙级");
        }
        technicianYCount.add(unitYCount);
        for(Map mapTechnician : technicianYCount){
            equipmentYCount.add(mapTechnician);
        }
        //丙级单位数量
        Map unitBCount = statsMapper.unitBCount();
        //丙级初，中，高级技术员统计
        List<Map> technicianBCount = statsMapper.technicianBCount();
        //丙级仪器设备统计
        List<Map> equipmentBCount = statsMapper.equipmentBCount();
        if (null == unitBCount){
            unitBCount.put("unitcount",0);
            unitBCount.put("unitlevel","丙级");
        }
        technicianBCount.add(unitBCount);
        for(Map mapTechnician : technicianBCount){
            equipmentBCount.add(mapTechnician);
        }
        //丁级单位数量
        Map unitDCount = statsMapper.unitDCount();
        //丁级初，中，高级技术员统计
        List<Map> technicianDCount = statsMapper.technicianDCount();
        //丁级仪器设备统计
        List<Map> equipmentDCount = statsMapper.equipmentDCount();
        if (null == unitDCount){
            unitDCount.put("unitcount",0);
            unitDCount.put("unitlevel","丁级");
        }
        technicianDCount.add(unitDCount);
        for(Map mapTechnician : technicianDCount){
            equipmentDCount.add(mapTechnician);
        }
        list.add(equipmentJCount);
        list.add(equipmentYCount);
        list.add(equipmentBCount);
        list.add(equipmentDCount);
        if (null != list && list.size() > 0){
            return list;
        }
        return null;
    }

}
