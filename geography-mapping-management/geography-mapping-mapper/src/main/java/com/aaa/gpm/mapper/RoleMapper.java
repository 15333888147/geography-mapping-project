package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TRole;
import com.aaa.gpm.model.TUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/14
 */
public interface RoleMapper extends Mapper<TRole> {
    /**
     * 分页查询所有角色
     * @param hashMap
     * @return
     */
    List<TRole> selectAlls(HashMap hashMap);
}
