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
 * @DateTime: 2020/7/21 15:55
 * @Description: TODO
 */
@RestController
public class ResourceController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:56
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      通过id查询资源
    */
    @GetMapping("/selectResource")
    public ResultData selectResource(@RequestParam Long id){
        return springcloudGpmService.selectResource(id);
    }
}
