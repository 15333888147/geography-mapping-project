package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gcy
 * @DateTime: 2020/7/21 15:37
 * @Description: TODO
 */
@RestController
public class PrincipalController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:38
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      分页查询所有负责人
    */
    @GetMapping("/selectAllTPrincipal")
    public ResultData selectAllTPrincipal(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return springcloudGpmService.selectAllTPrincipal(pageNo,pageSize);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:39
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      根据id查询负责人表和资源表
    */
    @GetMapping("/selectPrincipalAndResource")
    public ResultData selectPrincipalAndResource(@RequestParam Long id){
        return springcloudGpmService.selectPrincipalAndResource(id);
    }
}
