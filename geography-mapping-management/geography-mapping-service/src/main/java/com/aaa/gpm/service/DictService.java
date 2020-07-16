package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.DictMapper;
import com.aaa.gpm.model.TDict;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author: zj
 * @Date: 2020/7/14
 */
@Service
public class DictService extends BaseService<TDict> {

    @Autowired
    private DictMapper dictMapper;

    /**
     * 分页查询字典信息
     * @param hashMap
     * @return
     */
    public PageInfo selectAlls(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNo")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo page = new PageInfo(dictMapper.selectAlls(hashMap));
        if (null != page && !"".equals(page)){
            return page;
        }
        return null;
    }

}
