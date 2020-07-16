package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TResultCommit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: gcy
 * @DateTime: 2020/7/14 17:01
 * @Description: TODO
 */
public interface CommitMapper extends Mapper<TResultCommit> {

    TResultCommit selectCommitByProjectName(String name);
}
