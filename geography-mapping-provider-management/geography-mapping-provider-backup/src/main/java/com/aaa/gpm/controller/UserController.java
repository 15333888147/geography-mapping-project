package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.mapper.UserMappper;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/8
 */
@RestController
public class UserController extends CommonController<TUser> {

    @Autowired
    private UserService userService;

    @Override
    public BaseService<TUser> getBaseService() {
        return userService;
    }

    /**
     * 分页查询所有用户
     * @param map
     * @return
     */
    @GetMapping("/userList")
    public ResultData<TUser> list(HashMap map){
        map.put("pageNo",1);
        map.put("pageSize",5);
        map.put("username","阳");
        map.put("deptId","");
        PageInfo pageInfo = userService.selectAlls(map);
        if (null != pageInfo || !("").equals(pageInfo)){
            return super.operationSuccess(pageInfo);
        } else {
            return super.operationFailed("查询失败");
        }
    }

    /**
     * 添加用户信息
     * @param map
     * @return
     */
    @PostMapping("/addUser")
    public ResultData addUser(Map map){
        return super.add(map);
    }

    /**
     * 删除用户信息
     * @param map
     * @return
     */
    @PostMapping("/deleteUser")
    public ResultData deleteUser(Map map){
        return super.delete(map);
    }

    /**
     * 修改用户信息[
     * @param map
     * @return
     */
    @PostMapping("/updateUser")
    public ResultData updateUser(Map map){
        return super.update(map);
    }

}
