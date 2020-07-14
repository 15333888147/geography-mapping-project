package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.RoleMapper;
import com.aaa.gpm.model.TRole;
import com.aaa.gpm.model.TUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 添加角色信息
     * @param map
     * @return
     */
    public Integer addRole(Map map){
        /**
         * 先添加角色信息，然后在添加当前生成的角色id和menuId到"角色与菜单关联表"中
         */


        return 0;
    }

    public Integer updateRole(Map map){
        /**
         * 先修改角色表中的信息，然后删除"角色与菜单关联表"中当前角色id的所有数据，然后在添加当前角色ID的新的权限信息
         */
        return 0;
    }

}
