package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.TMappingUnitMapper;
import com.aaa.gpm.model.TMappingUnit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
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
    public PageInfo<TMappingUnit> allUnit(TMappingUnit tMappingUnit,Integer pageNo,Integer pageSize){
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
    public PageInfo<TMappingUnit> selectUnitByName(Integer pageNo, Integer pageSize, String name){
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
    public Long updateScore( Integer score_plus, Integer score_subtract, Long unit_id){
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
    public Integer registAudit(Long id){
        Integer integer = tMappingUnitMapper.registAudit(id);
        if (integer != null && integer > 0){
            return integer;
        }
        return null;
    }
}
