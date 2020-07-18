package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TResource;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 22:03
 * @Description: TODO
 */
public interface ResourceMapper extends Mapper<TResource> {

    TResource selectByRefBizId(Long id);

    List<TResource> selectResource(Long id);

}
