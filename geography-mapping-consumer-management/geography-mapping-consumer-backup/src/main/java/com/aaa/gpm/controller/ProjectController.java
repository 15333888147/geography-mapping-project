package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TMappingProject;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: gcy
 * @DateTime: 2020/7/14 14:48
 * @Description: TODO
 */
@RestController
public class ProjectController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:40
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      查询所有项目
    */
    @GetMapping("/allProjects")
    public ResultData allProjects(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return springcloudGpmService.allProjects(pageNo,pageSize);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:41
     * @Params: [name]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMappingProject>
     * 描述：
     *      通过名称查询项目
    */
    @PostMapping("/selectProjectByName")
    public ResultData<TMappingProject> selectProjectByName(@RequestParam String name){
        return springcloudGpmService.selectProjectByName(name);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:42
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMappingProject>
     * 描述：
     *      查询没有审核通过的项目
    */
    @GetMapping("/selectNotAduitPass")
    public ResultData<TMappingProject> selectNotAduitPass(){
        return springcloudGpmService.selectNotAduitPass();
    }
    /**@Author:gcy
     * @DateTime: 2020/7/21 15:42
     * @Params: [id, audit_status]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      修改项目审核状态，并增加审核记录
    */
    @PostMapping("/updateProjectAuditById")
    public ResultData updateProjectAuditById(@RequestParam("id") Long id,@RequestParam("audit_status") Integer audit_status){
        return springcloudGpmService.updateProjectAuditById(id,audit_status);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:43
     * @Params: [id, results_status]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      修改项目汇交成果信息审核状态，并增加审核记录
    */
    @PostMapping("/updateProjectResultById")
    public ResultData updateProjectResultById(@RequestParam("id") Long id,@RequestParam("results_status") Integer results_status){
        return springcloudGpmService.updateProjectResultById(id,results_status);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:44
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      添加项目,增加资源
    */
    @PostMapping("/addProject")
    public ResultData addProject(@RequestBody Map map){
        return springcloudGpmService.addProject(map);
    }
}
