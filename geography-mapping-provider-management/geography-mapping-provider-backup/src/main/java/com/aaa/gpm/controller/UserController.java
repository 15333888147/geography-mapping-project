package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add")
    public ResultData add(TUser user) {
        return userService.insertDta(user);
    }

}
