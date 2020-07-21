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
 * @DateTime: 2020/7/21 15:27
 * @Description: TODO
 */
@RestController
public class CommitController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:29
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      查询所有的汇交成果
    */
    @GetMapping("/allCommit")
    public ResultData allCommit(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        return springcloudGpmService.allCommit(pageNo,pageSize);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:29
     * @Params: [name]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      根据名称查询项目汇交成果
    */
    @GetMapping("/selectCommitByProjectName")
    public ResultData selectCommitByProjectName(@RequestParam String name){
        return springcloudGpmService.selectCommitByProjectName(name);
    }
}
