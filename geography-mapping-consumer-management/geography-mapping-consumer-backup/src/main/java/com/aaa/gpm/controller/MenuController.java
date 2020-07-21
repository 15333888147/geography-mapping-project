package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TMenu;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/13
 * 菜单管理
 */
@RestController
public class MenuController extends BaseController {

    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    /**
     * @author zj
     * @DateTime: 2020/7/20 9:49
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMenu>
     * Description:
     *      查询当前用户下所有的菜单信息
    */
   @GetMapping("/allMenu")
    public ResultData allMenu(){
        return springcloudGpmService.allMenu();
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:07
     * @Params: []
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TMenu>
     * Description:
     *      查询所有的一级菜单以及其对应子菜单
    *//*
    @GetMapping("/allMenus")
    public ResultData<TMenu> allMenus(){
        return springcloudGpmService.allMenus();
    }

    *//**
     * @author zj
     * @DateTime: 2020/7/20 10:08
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      添加菜单或按钮
    *//*
    @PostMapping("/insertMenu")
    public ResultData insertMenu(@RequestParam Map map){
        return springcloudGpmService.insertMenu(map);
    }

    *//**
     * @author zj
     * @DateTime: 2020/7/20 10:08
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改菜单或按钮
    *//*
    @PostMapping("/updateMenu")
    public ResultData updateMenu(@RequestParam Map map){
        return springcloudGpmService.updateMenu(map);
    }

    *//**
     * @author zj
     * @DateTime: 2020/7/20 10:09
     * @Params: [menuId]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除菜单或按钮
    *//*
    @PostMapping("/deleteMenu")
    public ResultData deleteMenu(@RequestParam Long menuId){
        return springcloudGpmService.deleteMenu(menuId);
    }

    *//**
     * @author zj
     * @DateTime: 2020/7/20 10:10
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除菜单信息
    *//*
    @PostMapping("/delMenuAlls")
    public ResultData delMenuAlls(@RequestParam List<Long> ids){
        return springcloudGpmService.delMenuAlls(ids);
    }

    *//**
     * @author zj
     * @DateTime: 2020/7/20 10:11
     * @Params: [response]
     * @Return void
     * Description:
     *    导出菜单信息Excel表格
    *//*
    @GetMapping("/exportMenuExcel")
    public void exportMenuExcel(HttpServletResponse response){
        springcloudGpmService.exportMenuExcel();
    }*/
}
