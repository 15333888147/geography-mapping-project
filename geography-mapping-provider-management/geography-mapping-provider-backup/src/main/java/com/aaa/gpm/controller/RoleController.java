package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TRole;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.RoleService;
import com.aaa.gpm.utils.MyExcelExportUtil;
import com.aaa.gpm.vo.RoleMenuVo;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/14
 */
@RestController
@Slf4j
public class RoleController extends CommonController<TRole> {

    @Autowired
    private RoleService roleService;

    @Override
    public BaseService<TRole> getBaseService() {
        return roleService;
    }

    /**
     * 分页查询所有角色
     * @param map
     * @return
     */
    @PostMapping("/roleList")
    public ResultData roleList(@RequestBody HashMap map){
        map.put("pageNo",1);
        map.put("pageSize",5);
        PageInfo pageInfo = roleService.selectAlls(map);
        if (null != pageInfo || !("").equals(pageInfo)){
            return super.operationSuccess(pageInfo);
        } else {
            return super.operationFailed("查询失败");
        }
    }

    /**
     * 添加角色信息
     * @param roleMenuVo
     * @return
     */
    @PostMapping("/addRole")
    public ResultData addRole(@RequestBody RoleMenuVo roleMenuVo){
        Boolean aBoolean = roleService.addRole(roleMenuVo);
        if (aBoolean){
            return super.addSuccess();
        } else {
            return super.addFailed();
        }
    }

    /**
     * 删除角色信息
     * @param roleId
     * @return
     */
    @PostMapping("/delRole")
    public ResultData delRole(@RequestParam Long roleId){
        Boolean aBoolean = roleService.delRole(roleId);
        if (aBoolean){
            return super.deleteSuccess();
        } else {
            return super.deleteFailed();
        }
    }

    /**
     * 批量删除角色信息
     * @param ids
     * @return
     */
    @PostMapping("/delRoleAlls")
    public ResultData delRoleAlls(@RequestParam List<Long> ids){
        Boolean integer = roleService.delRoleAlls(ids);
        if (integer) {
            return super.deleteSuccess();
        } else {
            return super.deleteFailed();
        }
    }

    /**
     * 修改角色信息
     * @param roleMenuVo
     * @return
     */
    @PostMapping("/updateRole")
    public ResultData updateRole(@RequestBody RoleMenuVo roleMenuVo){
        Boolean aBoolean = roleService.updateRole(roleMenuVo);
        if (aBoolean){
            return super.updateSuccess();
        } else {
            return super.updateFailed();
        }
    }

    /**
     * 导出角色信息Excel表格
     * @param response
     */
    @GetMapping("/exportRoleExcel")
    public void exportRoleExcel(HttpServletResponse response){
        List<TRole> roles = roleService.exportRoleExcel();
        if (null != roles && roles.size() >0){
            MyExcelExportUtil.exportExcel(roles,TRole.class,"角色信息","角色信息表",response);
        } else{
            log.error("角色管理中的导出数据出错！");
        }

    }

}
