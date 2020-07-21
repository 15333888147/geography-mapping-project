package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gcy
 * @DateTime: 2020/7/21 15:20
 * @Description: TODO
 */
@RestController
public class AuditController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:23
     * @Params: [id, type]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      根据项目id查询审核记录
    */
    @PostMapping("/selectAuditByProjectId")
    public ResultData selectAuditByProjectId(@RequestParam("id") Long id, @RequestParam("type") String type){
        return springcloudGpmService.selectAuditByProjectId(id,type);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:24
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      审核项目所显示的信息
    */
    @GetMapping("/showAduitProject")
    public ResultData showAduitProject(@RequestParam Long id){
        return springcloudGpmService.showAduitProject(id);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:25
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      查询审核记录通过单位id
    */
    @GetMapping("/selectAuditByUnitId")
    public ResultData selectAuditByUnitId(@RequestParam Long id){
        return springcloudGpmService.selectAuditByUnitId(id);
    }
}
