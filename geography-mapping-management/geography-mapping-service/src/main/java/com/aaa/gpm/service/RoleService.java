package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.RoleMapper;
import com.aaa.gpm.model.RoleMenu;
import com.aaa.gpm.model.RoleMenuId;
import com.aaa.gpm.model.TRole;
import com.aaa.gpm.model.TUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/14
 * 角色管理
 */
@Service
public class RoleService extends BaseService<TRole> {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 分页查询所有角色
     * @param hashMap
     * @return
     */
    public PageInfo selectAlls(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNo")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo page = new PageInfo(roleMapper.selectAlls(hashMap));
        if (null != page && !"".equals(page)){
            return page;
        }
        return null;
    }

    /**
     * 添加角色以及对应权限信息
     * @param roleMenuId
     * @return
     */
    public Boolean addRole(RoleMenuId roleMenuId){
        /**
         * 先添加角色信息，然后在添加当前生成的角色id和menuId到"角色与菜单关联表"中，
         * 无论添加还是修改都需要用到多个menuId和当前role，所以创建一个实体类包含他们两个
         */
        roleMenuId.getRole().setCreateTime(new Date());
        //添加角色信息
        Integer add = super.add(roleMenuId.getRole());
        //如果大于0添加成功
        if (add > 0){
            //如果为空，只是添加一个角色
            if (null == roleMenuId.getMenuId() || "".equals(roleMenuId.getMenuId())){
                return true;
            } else {
                int res = 0;
                for (Long menuId:roleMenuId.getMenuId()) {
                    //添加到"角色与菜单关联表"
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setMenuId(menuId);
                    roleMenu.setRoleId(roleMenuId.getRole().getRoleId());
                    res = roleMapper.addRoleMenu(roleMenu);
                }
                if (res > 0){
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    /**
     * 修改角色以及对应权限信息
     * @param roleMenuId
     * @return
     */
    public Boolean updateRole(RoleMenuId roleMenuId){
        int rq = 0;
        /**
         * 先修改角色表中的信息，然后查询"角色与菜单关联表"中是否有权限信息，如果有就先删除在添加，如果没有就直接添加权限信息
         */
        roleMenuId.getRole().setModifyTime(new Date());
        //修改角色信息
        Integer update = super.update(roleMenuId.getRole());
        //如果大于0修改成功
        if (update > 0){
            //如果为空，只是修改当前角色信息
            if (null == roleMenuId.getMenuId() || "".equals(roleMenuId.getMenuId())){
                return true;
            } else {
                //查询当前角色的权限信息
                List<RoleMenu> roleMenus = roleMapper.selectByRoleId(roleMenuId.getRole().getRoleId());
                if (roleMenus.size() > 0){
                    //删除"角色与菜单关联表"中当前roleId
                    int res = roleMapper.delRoleMenu(roleMenuId.getRole().getRoleId());
                    if (res > 0){
                        for (Long menuId:roleMenuId.getMenuId()) {
                            //添加到"角色与菜单关联表"
                            RoleMenu roleMenu = new RoleMenu();
                            roleMenu.setMenuId(menuId);
                            roleMenu.setRoleId(roleMenuId.getRole().getRoleId());
                            rq = roleMapper.addRoleMenu(roleMenu);
                        }
                        if (rq > 0){
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    for (Long menuId:roleMenuId.getMenuId()) {
                        //添加到"角色与菜单关联表"
                        RoleMenu roleMenu = new RoleMenu();
                        roleMenu.setMenuId(menuId);
                        roleMenu.setRoleId(roleMenuId.getRole().getRoleId());
                        rq = roleMapper.addRoleMenu(roleMenu);
                    }
                    if (rq > 0){
                        return true;
                    } else {
                        return false;
                    }
                }
            }


        }
        return false;
    }

    /**
     * 删除角色以及对应权限信息
     * @param roleId
     * @return
     */
    public Boolean delRole(Long roleId){
        TRole tRole = new TRole();
        //删除当前角色
        tRole.setRoleId(roleId);
        Integer delete = super.delete(tRole);
        if (delete > 0){
            //查询当前角色是否拥有权限
            List<RoleMenu> roleMenus = roleMapper.selectByRoleId(roleId);
            if (roleMenus.size() > 0){
                //删除当前角色的所有权限信息
                int res = roleMapper.delRoleMenu(roleId);
                if (res > 0){
                    return true;
                } else {
                    return false;
                }
            }else {
                return true;
            }
        } else {
            return false;
        }
    }

}
