package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TAudit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AuditMapper extends Mapper<TAudit> {

    List<TAudit> selectAuditByProjectId(@Param("id") Long id, @Param("type") Integer type);

    List<TAudit> selectAuditByUnitId(@Param("id") Long id);
}