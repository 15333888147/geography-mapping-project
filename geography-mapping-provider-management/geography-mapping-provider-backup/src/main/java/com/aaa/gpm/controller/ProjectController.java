package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TAudit;
import com.aaa.gpm.model.TMappingProject;
import com.aaa.gpm.service.AuditService;
import com.aaa.gpm.service.ProjectService;
import com.aaa.gpm.utils.FileNameUtils;
import com.aaa.gpm.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: gcy
 * @DateTime: 2020/7/14 15:07
 * @Description: TODO
 */
@RestController
public class ProjectController extends CommonController<TMappingProject> {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private AuditService auditService;

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
    /**@DateTime: 2020/7/17 14:34
     * @Params: [name]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMappingProject>
     * 描述：
     *      通过名称查询项目
    */
    @PostMapping("/selectProjectByName")
    public ResultData<TMappingProject> selectProjectByName(String name){
        TMappingProject project = projectService.selectProjectByName(name);
        if (null != project && !"".equals(project)){
            return super.operationSuccess(project);
        }
        return super.operationFailed();
    }
    /**@DateTime: 2020/7/17 14:34
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMappingProject>
     * 描述：
     *      查询没有审核通过的项目
    */
    @GetMapping("/selectNotAduitPass")
    public ResultData<TMappingProject> selectNotAduitPass(){
        List<TMappingProject> tMappingProjects = projectService.selectNotAduitPass();
        if (tMappingProjects != null && tMappingProjects.size()>0){
           return super.operationSuccess(tMappingProjects);
        }
        return super.operationFailed("查询没有审核通过的项目失败");
    }
    /**@DateTime: 2020/7/17 15:30
     * @Params: [id, audit_status]
     * @Return com.aaa.gpm.base.ResultData<java.lang.Integer>
     * 描述：
     *      修改项目审核状态，并增加审核记录
    */
    @PostMapping("/updateProjectAuditById")
    public ResultData<Integer> updateProjectAuditById(Long id,Integer audit_status){
        TMappingProject tMappingProject = new TMappingProject();
        Map map = new HashMap();
        tMappingProject.setId(id);
        TMappingProject tMappingProject1 = projectService.selectById(id);
        if (tMappingProject1 != null && !tMappingProject1.equals("")){
            /**
             * acceptanceTime：项目的验收时间，即审核表中的提交时间
             * create_time：创建时间
             */
            String acceptanceTime = tMappingProject1.getAcceptanceTime();
            String create_time = tMappingProject1.getCreateTime();
            if (audit_status == 0){
                tMappingProject.setAuditStatus(0);
                map.put("tMappingProject",tMappingProject);
                ResultData update = super.update(map);
                if (update != null && !update.equals("")){
                    TAudit tAudit = new TAudit();
                    try {
                        tAudit.setId(FileNameUtils.getFileName()).setAuditTime(null).setRefId(id).setUserId(id).setStatus(0).setName("项目信息审核").setSubmitTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(acceptanceTime)).setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(create_time));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Integer addAudit = auditService.addAudit(tAudit);
                    if (addAudit != null && addAudit > 0) {
                        return super.operationSuccess(addAudit,"已将该项目审核状态修改为通过并增加了记录");
                    }
                    return super.operationSuccess(update,"已将该项目审核状态修改为通过,增加记录失败");
                }
                return super.operationFailed("系统异常，无法修改当前项目的审核状态");
            }if (audit_status == 1){
                tMappingProject.setAuditStatus(1);
                map.put("tMappingProject",tMappingProject);
                ResultData update = super.update(map);
                if (update == null || update.equals("")){
                    TAudit tAudit = new TAudit();
                    try {
                        tAudit.setId(FileNameUtils.getFileName()).setAuditTime(null).setRefId(id).setUserId(id).setStatus(1).setName("项目信息审核").setSubmitTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(acceptanceTime)).setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(create_time));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Integer addAudit = auditService.addAudit(tAudit);
                    if (addAudit != null && addAudit > 0) {
                        return super.operationSuccess(addAudit,"未通过审核并增加了记录");
                    }
                    return super.operationSuccess(update,"未通过审核,增加记录失败");
                }
                return super.operationFailed("系统异常，无法修改当前项目的审核状态");
            }
        }

        return super.operationFailed();
    }
    /**@DateTime: 2020/7/17 15:48
     * @Params: [id, results_status]
     * @Return com.aaa.gpm.base.ResultData<java.lang.Integer>
     * 描述：
     *      修改项目汇交成果信息审核状态，并增加审核记录
    */
    @PostMapping("/updateProjectResultById")
    public ResultData<Integer> updateProjectResultById(Long id,Integer results_status){
        TMappingProject tMappingProject = new TMappingProject();
        Map map = new HashMap();
        tMappingProject.setId(id);
        String acceptanceTime = tMappingProject.getAcceptanceTime();
        String createTime = tMappingProject.getCreateTime();
        if (results_status == 0){
            tMappingProject.setResultsStatus(0);
            map.put("tMappingProject",tMappingProject);
            ResultData update = super.update(map);
            if (update != null && !update.equals("")){
                TAudit tAudit = new TAudit();
                try {
                    tAudit.setId(FileNameUtils.getFileName()).setAuditTime(new Date()).setRefId(id).setUserId(id).setStatus(0).setName("汇交成果信息审核").setSubmitTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(acceptanceTime)).setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(createTime));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Integer addAudit = auditService.addAudit(tAudit);
                if (addAudit != null && addAudit > 0) {
                    return super.operationSuccess(addAudit,"已将该项目汇交成果信息审核状态修改为通过并增加了记录");
                }
                return super.operationSuccess(update,"已将该项目汇交成果信息审核状态修改为通过,增加记录失败");
            }
            return super.operationFailed("系统异常，无法修改当前项目的汇交成果信息状态");
        }if (results_status == 1){
            tMappingProject.setResultsStatus(1);
            map.put("tMappingProject",tMappingProject);
            ResultData update = super.update(map);
            if (update == null || update.equals("")){
                TAudit tAudit = new TAudit();
                try {
                    tAudit.setId(FileNameUtils.getFileName()).setAuditTime(new Date()).setRefId(id).setUserId(id).setStatus(1).setName("汇交成果信息审核").setSubmitTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(acceptanceTime)).setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(createTime));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Integer addAudit = auditService.addAudit(tAudit);
                if (addAudit != null && addAudit > 0) {
                    return super.operationSuccess(addAudit,"未通过汇交成果信息审核并增加了记录");
                }
                return super.operationSuccess(update,"未通过汇交成果信息审核,增加记录失败");
            }
            return super.operationFailed("系统异常，无法修改当前项目的汇交成果信息审核状态");
        }
        return super.operationFailed();
    }
}
