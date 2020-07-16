package com.aaa.gpm.controller;

import com.aaa.gpm.model.TMappingProject;
import com.aaa.gpm.service.SpringcloudGpmService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gcy
 * @DateTime: 2020/7/14 14:48
 * @Description: TODO
 */
@RestController
public class ProjectController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@DateTime: 2020/7/14 17:00
    * @Params: [pageNo, pageSize]
    * @Return com.github.pagehelper.PageInfo<com.aaa.gpm.model.TMappingProject>
    * 描述： 所有项目信息
    */
    @PostMapping("/allProjects")
    public PageInfo<TMappingProject> allProjects(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        return springcloudGpmService.allProjects(pageNo,pageSize);
    }


}
