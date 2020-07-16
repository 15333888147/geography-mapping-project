package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/8
 */
public interface UserMappper extends Mapper<TUser> {
    /**
     * 分页查询所有用户
     * @param hashMap
     * @return
     */
    List<TUser> selectAlls(HashMap hashMap);
}
