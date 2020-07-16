package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TDept;
import com.aaa.gpm.model.TMenu;
import com.aaa.gpm.service.DeptService;
import com.aaa.gpm.utils.MyExcelExportUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/14
 * 部门管理
 */
@Slf4j
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

    /**
     * 添加部门信息
     * @param map
     * @return
     */
    @PostMapping("/addDept")
    public ResultData addDept(@RequestParam Map map){
        return super.add(map);
    }

    /**
     * 删除部门信息
     * @param map
     * @return
     */
    @PostMapping("/deleteDept")
    public ResultData deleteDept(@RequestParam Map map){
        return super.delete(map);
    }

    /**
     * 批量删除部门信息
     * @param ids
     * @return
     */
    @PostMapping("/delDeptAlls")
    public ResultData delDeptAlls(@RequestBody List<Long> ids){
        Integer integer = deptService.delDeptAlls(ids);
        if (integer > 0) {
            return super.deleteSuccess();
        } else {
            return super.deleteFailed();
        }
    }

    /**
     * 修改部门信息
     * @param map
     * @return
     */
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestParam Map map){
        return super.update(map);
    }

    /**
     * 导出部门信息Excel表格
     * @param response
     */
    @GetMapping("/exportDeptExcel")
    public void exportDeptExcel(HttpServletResponse response){
        List<TDept> menus = deptService.exportDeptExcel();
        if (null != menus && menus.size() >0){
            MyExcelExportUtil.exportExcel(menus,TDept.class,"部门信息","部门信息表",response);
        } else{
            log.error("部门管理中的导出数据出错！");
        }
    }
}
