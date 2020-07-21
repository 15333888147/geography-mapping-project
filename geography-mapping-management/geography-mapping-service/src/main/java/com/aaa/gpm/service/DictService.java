package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.DictMapper;
import com.aaa.gpm.model.TDept;
import com.aaa.gpm.model.TDict;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;

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
    public PageInfo selectAlls(@RequestBody HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNo")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo page = new PageInfo(dictMapper.selectAlls(hashMap));
        if (null != page && !"".equals(page)){
            return page;
        }
        return null;
    }

    /**
     * 批量删除字典信息
     * @param ids
     * @return
     */
    public Integer delDictAlls(@RequestBody List<Long> ids){
        Example example = Example.builder(TDict.class).where(Sqls.custom().andIn("dictId",ids)).build();
        return dictMapper.deleteByExample(example);
    }

    /**
     * 导出字典信息Excel表格
     * @return
     */
    public List<TDict> exportDictExcel(){
        List<TDict> dicts = dictMapper.selectAll();
        if (null != dicts && dicts.size() >0){
            return dicts;
        }
        return null;
    }

}
