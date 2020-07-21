package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TAudit;
import com.aaa.gpm.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 20:11
 * @Description: TODO
 */
@RestController
public class AuditController extends CommonController<TAudit> {
    @Autowired
    private AuditService auditService;
    @Override
    public BaseService<TAudit> getBaseService() {
        return auditService;
    }

    @PostMapping("/selectAuditByProjectId")
    public ResultData selectAuditByProjectId(Long id, String type){
        List<TAudit> tAudits = auditService.selectAuditByProjectId(id,type);
        if (tAudits!=null && tAudits.size()>0){
            return super.operationSuccess(tAudits);
        }
        return super.operationFailed();
    }
    /**@DateTime: 2020/7/16 10:57
    * @Params: [id]
    * @Return com.aaa.gpm.base.ResultData<java.util.Map>
    * 描述：
     *      审核项目所显示的信息
    */
    @GetMapping("/showAduitProject")
    public ResultData showAduitProject(@RequestParam("id") Long id){
        Map map = auditService.showAduitProject(id);
        if (map != null && map.size()>0){
            return super.operationSuccess(map);
        }
        return super.operationFailed("数据未找到");
    }
    /**@DateTime: 2020/7/18 10:58
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData<java.util.List<com.aaa.gpm.model.TAudit>>
     * 描述：
     *      查询审核记录通过单位id
    */
    @GetMapping("/selectAuditByUnitId")
    public ResultData selectAuditByUnitId(Long id){
        List<TAudit> tAudits = auditService.selectAuditByUnitId(id);
        if (null != tAudits && tAudits.size()>0){
            return super.operationSuccess(tAudits);
        }
        return super.operationFailed();
    }
}
