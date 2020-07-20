package com.aaa.gpm.service;

import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.*;
import com.aaa.gpm.vo.RoleMenuVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/13
 */
@FeignClient(value = "gpm-interface")
public interface SpringcloudGpmService {
    /**@DateTime: 2020/7/15 15:07
    * @Params: [tuser]
    * @Return com.aaa.gpm.base.ResultData
    * 描述：
     *      执行登陆操作
    */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody TUser tuser);
    /**@DateTime: 2020/7/15 15:09
    * @Params: [tloginLog]
    * @Return java.lang.Integer
    * 描述：
     *      添加日志
    */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody TLoginLog tloginLog);

    /** 
     * @author zj
     * @DateTime: 2020/7/20 8:43
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMenu>
     * Description:
     *      查询当前用户下所有的菜单信息
    */
    @GetMapping("/allMenu")
    ResultData<TMenu> allMenu();

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:45
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMenu>
     * Description:
     *      查询所有的一级菜单以及其对应子菜单
    */
    @GetMapping("/allMenus")
    ResultData<TMenu> allMenus();

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:47
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      添加菜单或按钮
    */
    @PostMapping("/insertMenu")
    ResultData insertMenu(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:47
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改菜单或按钮
    */
    @PostMapping("/updateMenu")
    ResultData updateMenu(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:48
     * @Params: [menuId]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除菜单或按钮
    */
    @PostMapping("/deleteMenu")
    ResultData deleteMenu(@RequestParam Long menuId);

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:48
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除菜单信息
    */
    @PostMapping("/delMenuAlls")
    ResultData delMenuAlls(@RequestParam List<Long> ids);

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:49
     * @Params: [response]
     * @Return void
     * Description:
     *      导出菜单信息Excel表格
    */
    @GetMapping("/exportMenuExcel")
    void exportMenuExcel();

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:50
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TRole>
     * Description:
     *      分页查询所有角色
    */
    @GetMapping("/roleList")
    ResultData<TRole> roleList(@RequestParam HashMap map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:50
     * @Params: [roleMenuVo]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      添加角色信息
    */
    @PostMapping("/addRole")
    ResultData addRole(@RequestBody RoleMenuVo roleMenuVo);

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:51
     * @Params: [roleId]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除角色信息
    */
    @PostMapping("/delRole")
    ResultData delRole(@RequestParam Long roleId);

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:51
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除角色信息
    */
    @PostMapping("/delRoleAlls")
    ResultData delRoleAlls(@RequestBody List<Long> ids);

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:52
     * @Params: [roleMenuVo]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改角色信息
    */
    @PostMapping("/updateRole")
    ResultData updateRole(@RequestParam RoleMenuVo roleMenuVo);

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:53
     * @Params: [response]
     * @Return void
     * Description:
     *      导出角色信息Excel表格
    */
    @GetMapping("/exportRoleExcel")
    void exportRoleExcel();

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:21
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TDept>
     * Description:
     *      查询所有的一级部门以及其下面的子部门
    */
    @GetMapping("/deptList")
    ResultData<TDept> deptList();

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:22
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      添加部门信息
    */
    @PostMapping("/addDept")
    ResultData addDept(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:22
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *    删除部门信息
    */
    @PostMapping("/deleteDept")
    ResultData deleteDept(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:22
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除部门信息
    */
    @PostMapping("/delDeptAlls")
    ResultData delDeptAlls(@RequestParam List<Long> ids);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:23
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改部门信息
    */
    @PostMapping("/updateDept")
    ResultData updateDept(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:23
     * @Params: [response]
     * @Return void
     * Description:
     *      部门Excel导出
    */
    @GetMapping("/exportDeptExcel")
    void exportDeptExcel();

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:24
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TUser>
     * Description:
     *      分页查询所有用户
    */
    @PostMapping("/userList")
    ResultData<TUser> userList(@RequestParam HashMap map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:24
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      添加用户信息
    */
    @PostMapping("/addUser")
    ResultData addUser(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:24
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除用户信息
    */
    @PostMapping("/deleteUser")
    ResultData deleteUser(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:25
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除用户信息
    */
    @PostMapping("/delUserAlls")
    ResultData delUserAlls(@RequestParam List<Long> ids);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:25
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改用户信息
    */
    @PostMapping("/updateUser")
    ResultData updateUser(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:26
     * @Params: [response]
     * @Return void
     * Description:
     *      导出用户信息Excel表格
    */
    @GetMapping("/exportUserExcel")
    void exportUserExcel();

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:27
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TUser>
     * Description:
     *      分页查询字典信息
    */
    @PostMapping("/dictList")
    ResultData<TUser> dictList(@RequestParam HashMap map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:27
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      字典新增一条信息
    */
    @PostMapping("/addDict")
    ResultData addDict(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:28
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      字典删除一条信息
    */
    @PostMapping("/delDict")
    ResultData delDict(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:29
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *     批量删除字典信息
    */
    @PostMapping("/delDictAlls")
    ResultData delDictAlls(@RequestParam List<Long> ids);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:30
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      字典修改一条信息
    */
    @PostMapping("/updateDict")
    ResultData updateDict(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:30
     * @Params: [response]
     * @Return void
     * Description:
     *      导出字典信息Excel表格
    */
    @GetMapping("/exportDictExcel")
    void exportDictExcel();

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:32
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      项目类型测绘统计，2未完成，3已完成
    */
    @GetMapping("/mappingStats")
    ResultData mappingStats();

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:33
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      单位资质统计
    */
    @GetMapping("/unitStats")
    ResultData unitStats();

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:33
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      单位信息统计
    */
    @GetMapping("/unitInfoStats")
    ResultData unitInfoStats();

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:33
     * @Params: [userId]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      公司概览
    */
    @GetMapping("/companyOverview")
    ResultData companyOverview(@RequestParam Long userId);

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:34
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员设备汇总统计
    */
    @GetMapping("/personnelStats")
    ResultData personnelStats();

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:47
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TUser>
     * Description:
     *      分页查询公告栏信息
    */
    @PostMapping("/newsList")
    ResultData<TUser> newsList(@RequestParam HashMap map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:47
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      新增一条公告栏信息
    */
    @PostMapping("/addNews")
    ResultData addNews(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:48
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除一条公告栏信息
    */
    @PostMapping("/delNews")
    ResultData delNews(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:48
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *     批量删除公告栏信息
    */
    @PostMapping("/delNewsAlls")
    ResultData delNewsAlls(@RequestBody List<Long> id);

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:48
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改一条公告栏信息
    */
    @PostMapping("/updateNews")
    ResultData updateNews(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:53
     * @Params: [hashMap]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      单位随机抽查
    */
    @PostMapping("/unitRandom")
    ResultData unitRandom(@RequestParam HashMap hashMap);

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:53
     * @Params: [hashMap]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TCheckPerson>
     * Description:
     *      人员随机抽查
    */
    @PostMapping("/personRandom")
    ResultData<TCheckPerson> personRandom(@RequestParam HashMap hashMap);

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:53
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员添加
    */
    @PostMapping("/addPerson")
    ResultData addPerson(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:54
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员删除
    */
    @PostMapping("/delPerson")
    ResultData delPerson(@RequestParam Map map);

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:54
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员修改
    */
    @PostMapping("/updatePerson")
    ResultData updatePerson(@RequestParam Map map);
}
