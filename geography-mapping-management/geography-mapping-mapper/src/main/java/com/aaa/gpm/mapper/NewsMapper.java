package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TDict;
import com.aaa.gpm.model.TNews;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wxq on 2020/7/17
 */
public interface NewsMapper extends Mapper<TNews> {

    /**
     * 分页查询公告信息
     * @param hashMap
     * @return
     */
    List<TNews> selectNewsAlls(HashMap hashMap);

}
