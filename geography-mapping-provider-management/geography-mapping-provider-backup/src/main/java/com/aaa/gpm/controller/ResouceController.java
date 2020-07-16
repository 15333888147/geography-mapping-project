package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.service.CommitService;
import com.aaa.gpm.service.ProjectService;
import com.aaa.gpm.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 22:24
 * @Description: TODO
 */
@RestController
public class ResouceController extends CommonController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private CommitService commitService;
    @Autowired
    private ResourceService resourceService;
    @Override
    public BaseService getBaseService() {
        return null;
    }
    @GetMapping("/selectProjectCommitResouceById")
    public ResultData selectProjectCommitResouceById(Long id){
        Map map = new HashMap();
        map.put("project",projectService.selectById(id));
        map.put("commit",commitService.selectByRefId(id));
        map.put("resouce",resourceService.selectByRefBizId(id));
        if (map != null && map.size()>0){
            return super.operationSuccess(map);
        }
        return operationFailed("查询项目、汇交成果以及资源失败");
    }
}
