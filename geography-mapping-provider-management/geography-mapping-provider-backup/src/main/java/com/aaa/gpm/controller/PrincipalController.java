package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TPrincipal;
import com.aaa.gpm.model.TResource;
import com.aaa.gpm.service.PrincipalService;
import com.aaa.gpm.service.ResourceService;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: gcy
 * @DateTime: 2020/7/17 19:18
 * @Description: TODO
 */
@RestController
public class PrincipalController extends CommonController<TPrincipal> {
    @Autowired
    private PrincipalService principalService;
    @Autowired
    private ResourceService resourceService;
    @Override
    public BaseService<TPrincipal> getBaseService() {
        return principalService;
    }
    /**@DateTime: 2020/7/17 19:39
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TPrincipal>
     * 描述：
     *      分页查询所有负责人
    */
    @GetMapping("/selectAllTPrincipal")
    public ResultData selectAllTPrincipal(Integer pageNo,Integer pageSize){
        PageInfo<TPrincipal> pageInfo = principalService.selectListByPage(null, pageNo, pageSize);
        if (null != pageInfo && !"".equals(pageInfo)){
            return super.operationSuccess(pageInfo);
        }
        return null;
    }
    /**@DateTime: 2020/7/17 19:22
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData<java.util.Map>
     * 描述：
     *      根据id查询负责人表和资源表
    */
    @GetMapping("/selectPrincipalAndResource")
    public ResultData selectPrincipalAndResource(Long id){
        Map map = new HashMap();
        TPrincipal tPrincipal = new TPrincipal();
        tPrincipal.setId(id);
        List<TPrincipal> tPrincipals = principalService.selectList(tPrincipal);
        TResource tResource = new TResource();
        tResource.setRefBizId(id);
        List<TResource> tResources = resourceService.selectList(tResource);
        if (tPrincipals != null && !tPrincipals.equals("") && tResources != null && !tResources.equals("")){
            map.put("tPrincipal",tPrincipals);
            map.put("tResource",tResources);
            return super.operationSuccess(map,"查询负责人表和资源表成功");
        }
        return super.operationFailed("系统异常，查询失败");
    }
}
