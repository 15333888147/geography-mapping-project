package com.aaa.gpm.controller;

import com.aaa.gpm.annotation.LoginAnnotation;
import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 16:02
 * @Description: TODO
 */
@RestController
public class LoginController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    @PostMapping("/doLogin")
    @LoginAnnotation(opeationType = "登录操作", opeationName = "管理员登录")
    public ResultData doLogin(TUser tuser) {
        return springcloudGpmService.doLogin(tuser);
    }
}
