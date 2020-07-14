package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
