package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TMenu;
import com.aaa.gpm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author: zj
 * @Date: 2020/7/13
 * 菜单管理
 */
@RestController
public class MenuController extends CommonController<TMenu> {

    @Autowired
    private MenuService menuService;

    @Override
    public BaseService<TMenu> getBaseService() {
        return menuService;
    }

    /**
     * 查询当前用户下所有的菜单信息
     * @return
     */
    @GetMapping("/allMenu")
    public ResultData<TMenu> allMenu(){
        List<TMenu> tMenus = menuService.allMenu(1L);
        if (null != tMenus || tMenus.size() != 0){
            return super.operationSuccess(tMenus);
        } else {
            return super.operationFailed("查询失败");
        }
    }

    /**
     * 查询所有的一级菜单以及其对应子菜单
     * @return
     */
    @GetMapping("/allMenus")
    public ResultData<TMenu> allMenus(){
        List<TMenu> tMenus = menuService.allMenus();
        if (null != tMenus || tMenus.size() != 0){
            return super.operationSuccess(tMenus);
        } else {
            return super.operationFailed("查询失败");
        }
    }

    /**
     * 添加菜单或按钮
     * @param map
     * @return
     */
    @PostMapping("/insertMenu")
    public ResultData insertMenu(@RequestParam Map map){
        map.put("parentId",0L);
        map.put("menuName","测试菜单");
        map.put("type","0");
        map.put("createTime",new Date());
        /*tMenu.setParentId(1L);
        tMenu.setMenuName("测试按钮");
        tMenu.setType("1");*/
        return super.add(map);
    }

    /**
     * 修改菜单或按钮
     * @param map
     * @return
     */
    @PostMapping("/updateMenu")
    public ResultData updateMenu(@RequestParam Map map){
        return super.update(map);
    }

    /**
     * 删除菜单或按钮
     * @param menuId
     * @return
     */
    @PostMapping("/deleteMenu")
    public ResultData deleteMenu(@RequestBody Long menuId){
        Integer res = menuService.delMenu(menuId);
        if (res > 0){
            return super.deleteSuccess();
        } else {
            return super.deleteFailed();
        }
    }
}
