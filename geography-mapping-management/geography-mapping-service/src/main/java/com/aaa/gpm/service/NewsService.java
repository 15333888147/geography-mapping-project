package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.DictMapper;
import com.aaa.gpm.mapper.NewsMapper;
import com.aaa.gpm.model.TDict;
import com.aaa.gpm.model.TNews;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxq on 2020/7/17
 */
@Service
public class NewsService extends BaseService<TNews> {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 分页查询公告信息
     * @param hashMap
     * @return
     */
    public PageInfo selectNewsAlls(@RequestBody HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNo")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo page = new PageInfo(newsMapper.selectNewsAlls(hashMap));
        if (null != page && !"".equals(page)){
            return page;
        }
        return null;
    }
    /**
     * 批量删除公告信息
     * @param id
     * @return
     */
    public Integer delNewsAlls(List<Long> id){
        Example example = Example.builder(TNews.class).where(Sqls.custom().andIn("id",id)).build();
        return newsMapper.deleteByExample(example);
    }


}