package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.ResourceMapper;
import com.aaa.gpm.model.TResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<TResource> selectByRefBizId(Long refbizid){
        TResource tResource = new TResource();
        tResource.setRefBizId(refbizid);
        List<TResource> tResources = super.selectList(tResource);
        if (tResources != null && tResources.size()>0){
            return tResources;
        }
        return  null;
    }
}
