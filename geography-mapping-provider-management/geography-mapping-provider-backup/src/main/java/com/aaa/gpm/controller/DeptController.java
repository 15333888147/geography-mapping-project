package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TDept;
import com.aaa.gpm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/14
 */
@RestController
public class DeptController extends CommonController<TDept> {

    @Autowired
    private DeptService deptService;

    @Override
    public BaseService<TDept> getBaseService() {
        return deptService;
    }

    /**
     * 查询所有的一级部门以及其下面的子部门
     * @return
     */
    @GetMapping("/deptList")
    public ResultData<TDept> deptList(){
        List<TDept> deptList = deptService.deptList();
        if (null != deptList && deptList.size() > 0){
            return super.operationSuccess(deptList);
        } else {
            return super.operationFailed("查询失败");
        }
    }


}
