package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TMappingUnit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TMappingUnitMapper extends Mapper<TMappingUnit> {

    List<TMappingUnit> selectUnitByName(String name);

    Long updateScore(@Param("score_plus") Integer score_plus,@Param("score_subtract") Integer score_subtract, @Param("id") Long id);

    Integer registAudit(Long id);

}