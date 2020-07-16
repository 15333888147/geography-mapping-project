package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.model.TLoginLog;
import com.aaa.gpm.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 16:23
 * @Description: TODO
 */
@RestController
public class LoginLogController extends CommonController {
    @Autowired
    private LoginLogService loginLogService;
    @Override
    public BaseService getBaseService() {
        return loginLogService;
    }

    @PostMapping("/addLoginLog")
    public Integer addLoginLog(@RequestBody TLoginLog tloginLog) {
        return getBaseService().add(tloginLog);
    }
}
