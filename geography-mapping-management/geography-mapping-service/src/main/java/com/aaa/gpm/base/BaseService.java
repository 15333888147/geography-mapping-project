package com.aaa.gpm.base;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: zj
 * @Date: 2020/7/8
 *
 * 通用service
 */
public abstract class BaseService<T> {

    @Autowired
    private Mapper<T> mapper;

    protected Mapper getMapper() {
        return mapper;
    }

    public ResultData insertDta(T t) {
        int insert = mapper.insert(t);
        if(insert > 0){
            return new ResultData().setCode("300").setMsg("数据插入成功");
        }
        return null;
    }

}
