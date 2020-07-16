package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.AuditMapper;
import com.aaa.gpm.model.TAudit;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 20:10
 * @Description: TODO
 */
@Service
public class AuditService extends BaseService<TAudit> {
    @Autowired
    private AuditMapper auditMapper;
    /**@DateTime: 2020/7/15 19:45
     * @Params: [id]
     * @Return java.util.List<com.aaa.gpm.model.TAudit>
     * 描述：
     *      根据项目id查询审核记录
     */
    public List<TAudit> selectAuditByProjectId(Long id,String type){
        Integer typeNo = null;
        if (type.equals("项目信息")){
            typeNo = 2;
        }else if (type.equals("汇交成果信息")){
            typeNo = 4;
        }
        List<TAudit> tAudits = auditMapper.selectAuditByProjectId(id,typeNo);
        if (tAudits != null && tAudits.size()>0){
            return tAudits;
        }
        return null;
    }
}
