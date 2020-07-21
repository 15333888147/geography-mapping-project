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
    ResultData allMenu();

    /**
     * @author zj
     * @DateTime: 2020/7/20 8:45
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMenu>
     * Description:
     *      查询所有的一级菜单以及其对应子菜单
     *//*
    @GetMapping("/allMenus")
    ResultData<TMenu> allMenus();

    *//**
     * @author zj
     * @DateTime: 2020/7/20 8:47
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      添加菜单或按钮
     *//*
    @PostMapping("/insertMenu")
    ResultData insertMenu(@RequestParam Map map);

    *//**
     * @author zj
     * @DateTime: 2020/7/20 8:47
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改菜单或按钮
     *//*
    @PostMapping("/updateMenu")
    ResultData updateMenu(@RequestParam Map map);

    *//**
     * @author zj
     * @DateTime: 2020/7/20 8:48
     * @Params: [menuId]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除菜单或按钮
     *//*
    @PostMapping("/deleteMenu")
    ResultData deleteMenu(@RequestParam Long menuId);

    *//**
     * @author zj
     * @DateTime: 2020/7/20 8:48
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除菜单信息
     *//*
    @PostMapping("/delMenuAlls")
    ResultData delMenuAlls(@RequestParam List<Long> ids);

    *//**
     * @author zj
     * @DateTime: 2020/7/20 8:49
     * @Params: [response]
     * @Return void
     * Description:
     *      导出菜单信息Excel表格
     *//*
    @GetMapping("/exportMenuExcel")
    void exportMenuExcel();*/
}
