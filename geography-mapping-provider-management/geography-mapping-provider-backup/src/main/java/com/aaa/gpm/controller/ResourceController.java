package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TResource;
import com.aaa.gpm.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: gcy
 * @DateTime: 2020/7/17 8:42
 * @Description: TODO
 */
@RestController
public class ResourceController extends CommonController<TResource> {
    @Autowired
    private ResourceService resourceService;
    @Override
    public BaseService<TResource> getBaseService() {
        return resourceService;
    }
    @GetMapping("/selectResource")
    public ResultData<TResource> selectResource(Long id){
        List<TResource> tResources = resourceService.selectResource(id);
        if (tResources != null && tResources.size()>0){
            return super.operationSuccess(tResources);
        }
        return super.operationFailed("根据id查询资源失败");
    }
}
