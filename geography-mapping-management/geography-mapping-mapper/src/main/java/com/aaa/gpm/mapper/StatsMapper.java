package com.aaa.gpm.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/17
 * 数据统计
 */
@Repository
public interface StatsMapper {

    /**
     * @author zj
     * @DateTime: 2020/7/17 10:00
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      项目类型测绘统计，2未完成，3已完成
    */
    @Select("select count(1) 'procount',tmp.project_type 'protype',tmp.status 'prostatus' from t_mapping_project tmp GROUP BY project_type,status")
    List<Map> mappingStats();

    /**
     * @author zj
     * @DateTime: 2020/7/17 10:02
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      单位资质统计
     */
    @Select("select count(1) 'unitcount',tmu.qualification_level 'unitlevel' from t_mapping_unit tmu GROUP BY qualification_level")
    List<Map> unitStats();

    /**
     * @author zj
     * @DateTime: 2020/7/17 10:05
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      单位信息统计
    */
    @Select("select user_id,id,unit_name,register_address,oa,qualification_level,certificate_code,belong_industry,linkman fax_num,score from t_mapping_unit")
    List<Map> unitInfoStats();

    /**
     * @author zj
     * @DateTime: 2020/7/17 10:57
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      初，中，高级技术员统计
    */
    @Select("select count(1) 'mtcount',tt.major_type 'majorType' from t_technicist tt where tt.user_id=#{userId} GROUP BY tt.major_type")
    List<Map> technicianStats(Long userId);

    /** 
     * @author zj
     * @DateTime: 2020/7/17 10:58
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      特殊人员统计
    */
    @Select("select count(1) 'tspcount' from t_special_post tsp where user_id=#{userId} ")
    List<Map> specialStats(Long userId);
    
    /** 
     * @author zj
     * @DateTime: 2020/7/17 11:22
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      项目数量
    */
    @Select("select count(1) 'tmpcount' from t_mapping_project where user_id=#{userId}")
    List<Map> mappingCountStats(Long userId);

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:41
     * @Params: []
     * @Return java.util.Map
     * Description:
     *      甲级单位数量
    */
    @Select("select count(1) 'unitcount',tmu.qualification_level 'unitlevel' from t_mapping_unit tmu where qualification_level='甲级'")
    Map unitJCount();

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:41
     * @Params: []
     * @Return java.util.Map
     * Description:
     *      乙级单位数量
     */
    @Select("select count(1) 'unitcount',tmu.qualification_level 'unitlevel' from t_mapping_unit tmu where qualification_level='乙级'")
    Map unitYCount();

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:42
     * @Params: []
     * @Return java.util.Map
     * Description:
     *      丙级单位数量
    */
    @Select("select count(1) 'unitcount',tmu.qualification_level 'unitlevel' from t_mapping_unit tmu where qualification_level='丙级'")
    Map unitBCount();

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:43
     * @Params: []
     * @Return java.util.Map
     * Description:
     *      丁级单位数量
    */
    @Select("select count(1) 'unitcount',tmu.qualification_level 'unitlevel' from t_mapping_unit tmu where qualification_level='丁级'")
    Map unitDCount();

    /** 
     * @author zj
     * @DateTime: 2020/7/18 11:44
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      甲级初，中，高级技术员统计
    */
    @Select("select count(1) mtcount ,tt.major_type 'mttype',tmu.qualification_level tmulevel from t_technicist tt join t_mapping_unit tmu " +
            "on tt.user_id=tmu.user_id where tmu.qualification_level='甲级' GROUP BY tt.major_type")
    List<Map> technicianJCount();

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:45
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      乙级初，中，高级技术员统计
    */
    @Select("select count(1) mtcount ,tt.major_type 'mttype',tmu.qualification_level tmulevel from t_technicist tt join t_mapping_unit tmu " +
            "on tt.user_id=tmu.user_id where tmu.qualification_level='乙级' GROUP BY tt.major_type")
    List<Map> technicianYCount();

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:46
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      丙级初，中，高级技术员统计
    */
    @Select("select count(1) mtcount ,tt.major_type 'mttype',tmu.qualification_level tmulevel from t_technicist tt join t_mapping_unit tmu " +
            "on tt.user_id=tmu.user_id where tmu.qualification_level='丙级' GROUP BY tt.major_type")
    List<Map> technicianBCount();

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:46
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      丁级初，中，高级技术员统计
    */
    @Select("select count(1) mtcount ,tt.major_type 'mttype',tmu.qualification_level tmulevel from t_technicist tt join t_mapping_unit tmu " +
            "on tt.user_id=tmu.user_id where tmu.qualification_level='丁级' GROUP BY tt.major_type")
    List<Map> technicianDCount();

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:50
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      甲级仪器设备统计
    */
    @Select("select sum(teq.number) teqnumber,teq.name teqname,tmu.qualification_level tmulevel  from t_equipment teq join t_mapping_unit tmu " +
            "on teq.user_id=tmu.user_id where tmu.qualification_level='甲级' GROUP BY teq.name")
    List<Map> equipmentJCount();

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:51
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      乙级仪器设备统计
    */
    @Select("select sum(teq.number) teqnumber,teq.name teqname,tmu.qualification_level tmulevel  from t_equipment teq join t_mapping_unit tmu " +
            "on teq.user_id=tmu.user_id where tmu.qualification_level='乙级' GROUP BY teq.name")
    List<Map> equipmentYCount();

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:51
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      丙级仪器设备统计
    */
    @Select("select sum(teq.number) teqnumber,teq.name teqname,tmu.qualification_level tmulevel  from t_equipment teq join t_mapping_unit tmu " +
            "on teq.user_id=tmu.user_id where tmu.qualification_level='丙级' GROUP BY teq.name")
    List<Map> equipmentBCount();

    /**
     * @author zj
     * @DateTime: 2020/7/18 11:52
     * @Params: []
     * @Return java.util.List<java.util.Map>
     * Description:
     *      丁级仪器设备统计
    */
    @Select("select sum(teq.number) teqnumber,teq.name teqname,tmu.qualification_level tmulevel  from t_equipment teq join t_mapping_unit tmu " +
            "on teq.user_id=tmu.user_id where tmu.qualification_level='丁级' GROUP BY teq.name")
    List<Map> equipmentDCount();
}
