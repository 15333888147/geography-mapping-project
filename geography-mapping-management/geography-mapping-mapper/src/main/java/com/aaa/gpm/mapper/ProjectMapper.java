package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TMappingProject;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @Author: gcy
 * @DateTime: 2020/7/14 15:01
 * @Description: TODO
 */
public interface ProjectMapper extends Mapper<TMappingProject> {

    List<TMappingProject> selectNotAduitPass();

    TMappingProject selectById(Long id);

}
