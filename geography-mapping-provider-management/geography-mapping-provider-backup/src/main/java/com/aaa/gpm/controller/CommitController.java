package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TResultCommit;
import com.aaa.gpm.service.CommitService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Author: gcy
 * @DateTime: 2020/7/14 17:09
 * @Description: TODO
 */
@RestController
public class CommitController extends CommonController<TResultCommit> {
    @Autowired
    private CommitService commitService;
    @Override
    public BaseService<TResultCommit> getBaseService() {
        return commitService;
    }
    /**@DateTime: 2020/7/17 15:31
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TResultCommit>
     * 描述：
     *      查询所有的汇交成果
    */
    @GetMapping("/allCommit")
    public ResultData<TResultCommit> allCommit(Integer pageNo, Integer pageSize){
        PageInfo pageInfo = commitService.allCommit(pageNo, pageSize);
        if (null!=pageInfo && !"".equals(pageInfo)){
            return super.operationSuccess(pageInfo);
        }
        return null;
    }
    /**@DateTime: 2020/7/17 15:31
     * @Params: [name]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TResultCommit>
     * 描述：
     *      根据名称查询项目汇交成果
    */
    @GetMapping("/selectCommitByProjectName")
    public ResultData<TResultCommit> selectCommitByProjectName(String name){
        TResultCommit tResultCommit = commitService.selectCommitByProjectName(name);
        if (null!=tResultCommit && !"".equals(tResultCommit)){
            return super.operationSuccess(tResultCommit);
        }
        return null;
    }
}
