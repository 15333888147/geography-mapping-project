package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TDept;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/20
 * 部门管理
 */
@RestController
public class DeptController extends BaseController {

    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:18
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TDept>
     * Description:
     *      查询所有的一级部门以及其下面的子部门
    */
    @GetMapping("/deptList")
    public ResultData<TDept> deptList(){
        return springcloudGpmService.deptList();
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:18
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      添加部门信息
    */
    @PostMapping("/addDept")
    public ResultData addDept(@RequestParam Map map){
        return springcloudGpmService.addDept(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:19
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除部门信息
    */
    @PostMapping("/deleteDept")
    public ResultData deleteDept(@RequestParam Map map){
        return springcloudGpmService.deleteDept(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:19
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除部门信息
    */
    @PostMapping("/delDeptAlls")
    public ResultData delDeptAlls(@RequestParam List<Long> ids){
        return springcloudGpmService.delDeptAlls(ids);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:20
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改部门信息
    */
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestParam Map map){
        return springcloudGpmService.updateDept(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:21
     * @Params: []
     * @Return void
     * Description:
     *      部门Excel导出
    */
    @GetMapping("/exportDeptExcel")
    public void exportDeptExcel(){
        springcloudGpmService.exportDeptExcel();
    }
}
