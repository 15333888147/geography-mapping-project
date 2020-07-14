package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TRole;
import com.aaa.gpm.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/14
 */
@RestController
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
    @GetMapping("/roleList")
    public ResultData<TRole> roleList(HashMap map){
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
     * @param map
     * @return
     */
    @PostMapping("/addRole")
    public ResultData addRole(Map map){
        return null;
    }

    /**
     * 删除角色信息
     * @param map
     * @return
     */
    @PostMapping("/delRole")
    public ResultData delRole(Map map){
        return null;
    }

    /**
     * 修改角色信息
     * @param map
     * @return
     */
    @PostMapping("updateRole")
    public ResultData updateRole(Map map){
        return super.update(map);
    }

}
