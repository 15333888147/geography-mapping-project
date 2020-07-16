package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.MenuMapper;
import com.aaa.gpm.model.TMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/13
 * 菜单管理
 */
@Service
public class MenuService extends BaseService<TMenu> {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询当前用户下所有的菜单信息
     * @param id
     * @return
     */
    public List<TMenu> allMenu(Long id){
        List<TMenu> allMenu = new ArrayList<TMenu>();
        //获取当前用户的所有一级菜单
        List<TMenu> tMenus = menuMapper.selectFirstMenu(id);
        if (null != tMenus && tMenus.size() > 0){
            for (int i = 0; i < tMenus.size(); i++) {
                TMenu tMenu = tMenus.get(i);
                //通过当前用户的一级菜单的menuId获取对应的子菜单
                List<TMenu> menus = menuMapper.selectSecondMenu(tMenu.getMenuId());
                tMenu.setSubMenu(menus);
                allMenu.add(tMenu);
            }
        }
        return allMenu;
    }

    /**
     * 查询所有的一级菜单以及其对应子菜单
     * @return
     */
    public List<TMenu> allMenus(){
        TMenu tMenu = new TMenu();
        tMenu.setParentId(0L);
        List<TMenu> allMenu = new ArrayList();
        List<TMenu> tMenus = super.selectList(tMenu);
        if (null != tMenus && tMenus.size() > 0){
            for (int i = 0; i < tMenus.size(); i++) {
                TMenu menu = tMenus.get(i);
                //通过当前用户的一级菜单的menuId获取对应的子菜单
                List<TMenu> menus = menuMapper.selectSecondMenu(menu.getMenuId());
                menu.setSubMenu(menus);
                allMenu.add(menu);
            }
        }
        return allMenu;
    }

    /**
     * 删除当前的一级和二级菜单
     * @param menuId
     * @return
     */
    public Integer delMenu(Long menuId){
        //删除当前menuId菜单
        int res = menuMapper.deleteByPrimaryKey(menuId);
        //根据menuId删除其对应二级菜单，如果有就删除，如果没有就删除失败
        TMenu tMenu = new TMenu();
        tMenu.setParentId(menuId);
        menuMapper.delete(tMenu);
        return res;
    }

    /**
     * 批量删除菜单信息
     * @param ids
     * @return
     */
    public Integer delMenuAlls(List<Long> ids){
        Example example = Example.builder(TMenu.class).where(Sqls.custom().andIn("menuId",ids)).build();
        return menuMapper.deleteByExample(example);
    }
}
