package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.ResourceMapper;
import com.aaa.gpm.model.TResource;
import com.aaa.gpm.model.TScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 22:20
 * @Description: TODO
 */
@Service
public class ResourceService extends BaseService<TResource> {
    @Autowired
    private ResourceMapper resourceMapper;
    /**@DateTime: 2020/7/16 19:34
    * @Params: [refbizid]
    * @Return java.util.List<com.aaa.gpm.model.TResource>
    * 描述：
     *      通过refbizid查询资源
    */
    public List<TResource> selectByRefBizId(@RequestParam("refbizid") Long refbizid){
        TResource tResource = new TResource();
        tResource.setRefBizId(refbizid);
        List<TResource> tResources = super.selectList(tResource);
        if (tResources != null && tResources.size()>0){
            return tResources;
        }
        return  null;
    }
    /**@DateTime: 2020/7/17 8:41
     * @Params: [id]
     * @Return java.util.List<com.aaa.gpm.model.TResource>
     * 描述：
     *      查询资源
    */
    public List<TResource> selectResource(@RequestParam("id") Long id){
        List<TResource> tScores = resourceMapper.selectResource(id);
        if (tScores != null && tScores.size()>0){
            return tScores;
        }
        return null;
    }
}
