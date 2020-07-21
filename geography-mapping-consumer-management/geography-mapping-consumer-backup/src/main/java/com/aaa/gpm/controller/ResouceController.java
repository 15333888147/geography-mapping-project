package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gcy
 * @DateTime: 2020/7/21 15:45
 * @Description: TODO
 */
@RestController
public class ResouceController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:54
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      通过id查询项目、汇交成果以及资源
    */
    @GetMapping("/selectProjectCommitResouceById")
    public ResultData selectProjectCommitResouceById(Long id){
        return springcloudGpmService.selectProjectCommitResouceById(id);
    }
}
