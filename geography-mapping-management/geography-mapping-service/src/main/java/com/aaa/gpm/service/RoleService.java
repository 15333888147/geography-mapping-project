package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.RoleMapper;
import com.aaa.gpm.model.RoleMenu;
import com.aaa.gpm.model.TMenu;
import com.aaa.gpm.model.TRole;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.vo.RoleMenuVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
     * @param roleMenuVo
     * @return
     */
    public Boolean addRole(RoleMenuVo roleMenuVo){
        /**
         * 先添加角色信息，然后在添加当前生成的角色id和menuId到"角色与菜单关联表"中，
         * 无论添加还是修改都需要用到多个menuId和当前role，所以创建一个实体类包含他们两个
         */
        roleMenuVo.getRole().setCreateTime(new Date());
        //添加角色信息
        Integer add = super.add(roleMenuVo.getRole());
        //如果大于0添加成功
        if (add > 0){
            //如果为空，只是添加一个角色
            if (null == roleMenuVo.getMenuId() || "".equals(roleMenuVo.getMenuId())){
                return true;
            } else {
                int res = 0;
                for (Long menuId:roleMenuVo.getMenuId()) {
                    //添加到"角色与菜单关联表"
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setMenuId(menuId);
                    roleMenu.setRoleId(roleMenuVo.getRole().getRoleId());
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
     * @param roleMenuVo
     * @return
     */
    public Boolean updateRole(RoleMenuVo roleMenuVo){
        int rq = 0;
        /**
         * 先修改角色表中的信息，然后查询"角色与菜单关联表"中是否有权限信息，如果有就先删除在添加，如果没有就直接添加权限信息
         */
        roleMenuVo.getRole().setModifyTime(new Date());
        //修改角色信息
        Integer update = super.update(roleMenuVo.getRole());
        //如果大于0修改成功
        if (update > 0){
            //如果为空，只是修改当前角色信息
            if (null == roleMenuVo.getMenuId() || "".equals(roleMenuVo.getMenuId())){
                return true;
            } else {
                //查询当前角色的权限信息
                List<RoleMenu> roleMenus = roleMapper.selectByRoleId(roleMenuVo.getRole().getRoleId());
                if (roleMenus.size() > 0){
                    //删除"角色与菜单关联表"中当前roleId
                    int res = roleMapper.delRoleMenu(roleMenuVo.getRole().getRoleId());
                    if (res > 0){
                        for (Long menuId:roleMenuVo.getMenuId()) {
                            //添加到"角色与菜单关联表"
                            RoleMenu roleMenu = new RoleMenu();
                            roleMenu.setMenuId(menuId);
                            roleMenu.setRoleId(roleMenuVo.getRole().getRoleId());
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
                    for (Long menuId:roleMenuVo.getMenuId()) {
                        //添加到"角色与菜单关联表"
                        RoleMenu roleMenu = new RoleMenu();
                        roleMenu.setMenuId(menuId);
                        roleMenu.setRoleId(roleMenuVo.getRole().getRoleId());
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

    /**
     * 批量删除菜单信息
     * @param ids
     * @return
     */
    public Boolean delRoleAlls(List<Long> ids){
        int rq = 0;
        Example example = Example.builder(TMenu.class).where(Sqls.custom().andIn("roleId",ids)).build();
        int res = roleMapper.deleteByExample(example);
        if (res > 0){
            //查询当前角色是否拥有权限
            for (Long id : ids){
                List<RoleMenu> roleMenus = roleMapper.selectByRoleId(id);
                if (roleMenus.size() > 0){
                    //删除当前角色的所有权限信息
                    rq = roleMapper.delRoleMenu(id);
                }else {
                    return true;
                }
            }
            if(rq > 0){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 导出角色信息Excel表格
     * @return
     */
    public List<TRole> exportRoleExcel(){
        List<TRole> tRoles = roleMapper.selectAll();
        if (null != tRoles && tRoles.size() >0){
            return tRoles;
        }
        return null;
    }
}
