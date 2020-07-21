package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.model.TLoginLog;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gcy
 * @DateTime: 2020/7/21 15:35
 * @Description: TODO
 */
@RestController
public class LoginLogController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:36
     * @Params: [tloginLog]
     * @Return java.lang.Integer
     * 描述：
     *      添加登陆日志
    */
    @PostMapping("/addLoginLog")
    public Integer addLoginLog(@RequestBody TLoginLog tloginLog) {
        return springcloudGpmService.addLoginLog(tloginLog);
    }
}
