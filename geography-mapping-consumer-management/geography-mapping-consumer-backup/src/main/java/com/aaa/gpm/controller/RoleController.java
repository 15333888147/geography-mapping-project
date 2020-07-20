package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TRole;
import com.aaa.gpm.service.SpringcloudGpmService;
import com.aaa.gpm.vo.RoleMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/20
 * 角色管理
 */
@RestController
public class RoleController extends BaseController {

    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:12
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TRole>
     * Description:
     *      分页查询所有角色
    */
    @GetMapping("/roleList")
    public ResultData<TRole> roleList(@RequestParam HashMap map){
        return springcloudGpmService.roleList(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:13
     * @Params: [roleMenuVo]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      添加角色信息
    */
    @PostMapping("/addRole")
    public ResultData addRole(@RequestBody RoleMenuVo roleMenuVo){
        return springcloudGpmService.addRole(roleMenuVo);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:14
     * @Params: [roleId]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除角色信息
    */
    @PostMapping("/delRole")
    public ResultData delRole(@RequestParam Long roleId){
        return springcloudGpmService.delRole(roleId);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:14
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除角色信息
    */
    @PostMapping("/delRoleAlls")
    public ResultData delRoleAlls(@RequestBody List<Long> ids){
        return springcloudGpmService.delRoleAlls(ids);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:15
     * @Params: [roleMenuVo]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改角色信息
    */
    @PostMapping("/updateRole")
    public ResultData updateRole(@RequestParam RoleMenuVo roleMenuVo){
        return springcloudGpmService.updateRole(roleMenuVo);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:16
     * @Params: []
     * @Return void
     * Description:
     *      导出角色信息Excel表格
    */
    @GetMapping("/exportRoleExcel")
    public void exportRoleExcel(){
        springcloudGpmService.exportRoleExcel();
    }


}
