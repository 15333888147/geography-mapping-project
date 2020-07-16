package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.LoginService;
import com.aaa.gpm.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.gpm.status.LoginStatus.*;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 16:19
 * @Description: TODO
 */
@RestController
public class LoginController extends CommonController {
    @Autowired
    private LoginService loginService;
    @Override
    public BaseService getBaseService() {
        return loginService;
    }

    @PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody TUser user) {
        TokenVo tokenVo = loginService.doLogin(user);
        if(tokenVo.getIfSuccess()) {
            return super.loginSuccess(tokenVo.getToken());
        } else if(tokenVo.getType() == 1) {
            return super.loginFailed(USER_NOT_EXIST.getMsg());
        } else if(tokenVo.getType() == 2) {
            return super.loginFailed(PASSWORD_WRONG.getMsg());
        } else {
            return super.loginFailed(SYSTEM_EXCEPTION.getMsg());
        }
    }
}
