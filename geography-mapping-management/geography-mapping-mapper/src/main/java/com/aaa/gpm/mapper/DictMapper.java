package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TDict;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/14
 */
public interface DictMapper extends Mapper<TDict> {

    /**
     * 分页查询字典信息
     * @param hashMap
     * @return
     */
    List<TDict> selectAlls(HashMap hashMap);

}
