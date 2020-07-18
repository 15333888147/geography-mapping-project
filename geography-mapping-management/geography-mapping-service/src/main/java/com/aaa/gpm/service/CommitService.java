package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.CommitMapper;
import com.aaa.gpm.model.TResultCommit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gcy
 * @DateTime: 2020/7/14 17:03
 * @Description: TODO
 */
@Service
public class CommitService extends BaseService<TResultCommit> {
    @Autowired
    private CommitMapper commitMapper;
    /**@DateTime: 2020/7/15 22:19
    * @Params: [refid]
    * @Return java.util.List<com.aaa.gpm.model.TResultCommit>
    * 描述：
     *      根据refid查询汇交结果
    */
    public List<TResultCommit> selectByRefId(Long refid){
        TResultCommit tResultCommit = new TResultCommit();
        tResultCommit.setRefId(refid);
        List<TResultCommit> tResultCommits = super.selectList(tResultCommit);
        if (null != tResultCommits && tResultCommits.size()>0){
            return tResultCommits;
        }
        return null;
    }
    /**@DateTime: 2020/7/14 17:07
    * @Params: [tResultCommit, pageNo, pageSize]
    * @Return com.github.pagehelper.PageInfo<com.aaa.gpm.model.TResultCommit>
    * 描述： 所有汇交成果
    */
    public PageInfo<TResultCommit> allCommit(Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<TResultCommit> tResultCommits = commitMapper.selectAll();
        PageInfo pageInfo = new PageInfo(tResultCommits);
        if (null != pageInfo && !"".equals(pageInfo)){
            return pageInfo;
        }
        return null;
    }
    /**@DateTime: 2020/7/15 16:58
    * @Params: [name]
    * @Return com.aaa.gpm.model.TResultCommit
    * 描述：
     *      根据名字查询汇交成果
    */
    public TResultCommit selectCommitByProjectName(String name){
        TResultCommit tResultCommit = commitMapper.selectCommitByProjectName(name);
        if (null != tResultCommit && !"".equals(tResultCommit)){
            return tResultCommit;
        }
        return null;
    }
}
