package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TAudit;
import com.aaa.gpm.model.TMappingProject;
import com.aaa.gpm.service.ProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: gcy
 * @DateTime: 2020/7/14 15:07
 * @Description: TODO
 */
@RestController
public class ProjectController extends CommonController<TMappingProject> {
    @Autowired
    private ProjectService projectService;

    @Override
    public BaseService<TMappingProject> getBaseService() {
        return projectService;
    }

    /**@DateTime: 2020/7/14 16:57
    * @Params: [tMappingProject, pageNo, pageSize]
    * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMappingProject>
    * 描述：查询所有项目
    */
    @GetMapping("/allProjects")
    public ResultData<TMappingProject> allProjects(Integer pageNo,Integer pageSize){
        PageInfo pageInfo = projectService.allProjects(pageNo, pageSize);
        if (null!=pageInfo && !"".equals(pageInfo)){
            return super.operationSuccess(pageInfo);
        }
        return super.operationFailed();
    }
    @PostMapping("/selectProjectByName")
    public ResultData<TMappingProject> selectProjectByName(String name){
        TMappingProject project = projectService.selectProjectByName(name);
        if (null != project && !"".equals(project)){
            return super.operationSuccess(project);
        }
        return super.operationFailed();
    }
}
