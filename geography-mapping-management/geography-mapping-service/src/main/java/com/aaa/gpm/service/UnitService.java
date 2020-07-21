package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.TMappingUnitMapper;
import com.aaa.gpm.model.TMappingUnit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: gcy
 * @DateTime: 2020/7/16 14:45
 * @Description: TODO
 */
@Service
public class UnitService extends BaseService<TMappingUnit> {
    @Autowired
    private TMappingUnitMapper tMappingUnitMapper;

    /**@DateTime: 2020/7/16 14:51
    * @Params: [tMappingUnit, pageNo, pageSize]
    * @Return com.github.pagehelper.PageInfo<com.aaa.gpm.model.TMappingUnit>
    * 描述：
     *      查询所有单位
    */
    public PageInfo<TMappingUnit> allUnit(@RequestBody TMappingUnit tMappingUnit,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<TMappingUnit> tMappingUnitPageInfo = super.selectListByPage(tMappingUnit, pageNo, pageSize);
        if (null != tMappingUnitPageInfo && !"".equals(tMappingUnitPageInfo)){
            return tMappingUnitPageInfo;
        }
        return null;
    }
    /**@DateTime: 2020/7/16 15:08
    * @Params: [pageNo, pageSize, where, fields]
    * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMappingUnit>
    * 描述：
     *      条件查询
    */
    public PageInfo<TMappingUnit> selectUnitByName(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize,@RequestParam("name") String name){
        PageHelper.startPage(pageNo,pageSize);
        List<TMappingUnit> tMappingUnits = tMappingUnitMapper.selectUnitByName(name);
        if (tMappingUnits != null && tMappingUnits.size()>0){
            PageInfo<TMappingUnit> pageInfo = new PageInfo<TMappingUnit>(tMappingUnits);
            return pageInfo;
        }
        return null;
    }
    /**@DateTime: 2020/7/17 9:00
     * @Params: [score_plus, score_subtract, id]
     * @Return java.lang.Long
     * 描述：
     *      修改单位分值
     *      添加分值表
     *      添加资源表
    */
    public Long updateScore(@RequestParam("score_plus") Integer score_plus,@RequestParam("score_subtract") Integer score_subtract,@RequestParam("unit_id") Long unit_id){
        Long aLong = tMappingUnitMapper.updateScore(score_plus, score_subtract, unit_id);
        if (aLong != null && aLong>0){
            return aLong;
        }
        return null;
    }
    /**@DateTime: 2020/7/17 10:45
     * @Params: [id]
     * @Return java.lang.Integer
     * 描述：
     *      注册审核
    */
    public Integer registAudit(@RequestParam("id") Long id){
        Integer integer = tMappingUnitMapper.registAudit(id);
        if (integer != null && integer > 0){
            return integer;
        }
        return null;
    }

    /**
     * @author zj
     * @DateTime: 2020/7/18 15:21
     * @Params: [hashMap]
     * @Return java.util.List<com.aaa.gpm.model.TMappingUnit>
     * Description:
     *      单位随机抽查
    */
    public List<TMappingUnit> unitRandom(@RequestBody HashMap hashMap){
        List<TMappingUnit> tMappingUnits = tMappingUnitMapper.unitRandom(hashMap);
        if (null != tMappingUnits && tMappingUnits.size() > 0){
            return tMappingUnits;
        }
        return null;
    }
}
