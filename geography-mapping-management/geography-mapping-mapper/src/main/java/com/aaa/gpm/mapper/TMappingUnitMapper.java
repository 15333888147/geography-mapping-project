package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TMappingUnit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface TMappingUnitMapper extends Mapper<TMappingUnit> {

    List<TMappingUnit> selectUnitByName(String name);

    Long updateScore(@Param("score_plus") Integer score_plus,@Param("score_subtract") Integer score_subtract, @Param("id") Long id);

    Integer registAudit(Long id);

    /**
     * @author zj
     * @DateTime: 2020/7/18 15:19
     * @Params: [hashMap]
     * @Return java.util.List<com.aaa.gpm.model.TMappingUnit>
     * Description:
     *      单位随机抽查
    */
    List<TMappingUnit> unitRandom(HashMap hashMap);


}