package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TAudit;
import com.aaa.gpm.service.AuditService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResultData<List<TAudit>> selectAuditByProjectId(Long id, String type){
        List<TAudit> tAudits = auditService.selectAuditByProjectId(id,type);
        if (tAudits!=null && tAudits.size()>0){
            return super.operationSuccess(tAudits);
        }
        return super.operationFailed();
    }
}
