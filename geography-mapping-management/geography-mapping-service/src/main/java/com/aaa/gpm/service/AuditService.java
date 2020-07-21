package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.AuditMapper;
import com.aaa.gpm.mapper.ProjectMapper;
import com.aaa.gpm.mapper.ResourceMapper;
import com.aaa.gpm.mapper.TMappingUnitMapper;
import com.aaa.gpm.model.TAudit;
import com.aaa.gpm.model.TMappingProject;
import com.aaa.gpm.model.TResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 20:10
 * @Description: TODO
 */
@Service
public class AuditService extends BaseService<TAudit> {
    @Autowired
    private AuditMapper auditMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private TMappingUnitMapper tMappingUnitMapper;
    /**@DateTime: 2020/7/15 19:45
     * @Params: [id]
     * @Return java.util.List<com.aaa.gpm.model.TAudit>
     * 描述：
     *      根据项目id查询审核记录
     */
    public List<TAudit> selectAuditByProjectId(@RequestParam("id") Long id,@RequestParam("type") String type){
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
    /**@DateTime: 2020/7/16 9:49
     * @Params: [id]
     * @Return com.aaa.gpm.vo.ProjectResourceVo
     * 描述：
     *      审核项目显示的数据
     */
    public Map showAduitProject(@RequestParam("id") Long id){
        Map map = new HashMap();
        TMappingProject tMappingProject = new TMappingProject();
        tMappingProject.setId(id);
        TMappingProject tMappingProject1 = projectMapper.selectById(id);
        TResource tResource = new TResource();
        tResource.setRefBizId(id);
        TResource tResource1 = resourceMapper.selectByRefBizId(id);
        if (tMappingProject1 != null && !tMappingProject1.equals("") && tResource1 != null && !tResource1.equals("")){
            map.put("project",tMappingProject1);
            map.put("resource",tResource1);
            return map;
        }
        return null;
    }

    /**@DateTime: 2020/7/16 16:30
    * @Params: [id]
    * @Return java.util.List<com.aaa.gpm.model.TAudit>
    * 描述：
     *      根据单位id查询审核记录
    */
    public List<TAudit> selectAuditByUnitId(@RequestParam("id") Long id){
        List<TAudit> tAudits = auditMapper.selectAuditByUnitId(id);
        return tAudits;
    }
    /**@DateTime: 2020/7/17 14:52
     * @Params: [tAudit]
     * @Return java.lang.Integer
     * 描述：
     *      添加审核记录
    */
    public Integer addAudit(TAudit tAudit){
        return super.add(tAudit);
    }

    /*public void Audit(Map map){
        if (map.get("name").equals("单位信息审核")){ //单位信息审核
            TMappingUnit tMappingUnit = new TMappingUnit();
            if (map.get("audit_status").equals("0")){
                Long id = Long.parseLong((String) map.get("id"));
                tMappingUnitMapper.
            }
        }
    }*/
}
