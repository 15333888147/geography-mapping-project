package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/20
 * 用户管理
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:23
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TUser>
     * Description:
     *      分页查询所有用户
    */
    @PostMapping("/userList")
    public ResultData<TUser> userList(@RequestParam HashMap map){
        return springcloudGpmService.userList(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:23
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      添加用户信息
    */
    @PostMapping("/addUser")
    public ResultData addUser(@RequestParam Map map){
        return springcloudGpmService.addUser(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:23
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除用户信息
    */
    @PostMapping("/deleteUser")
    public ResultData deleteUser(@RequestParam Map map){
        return springcloudGpmService.deleteUser(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:24
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除用户信息
    */
    @PostMapping("/delUserAlls")
    public ResultData delUserAlls(@RequestParam List<Long> ids){
        return springcloudGpmService.delUserAlls(ids);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:24
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改用户信息
    */
    @PostMapping("/updateUser")
    public ResultData updateUser(@RequestParam Map map){
        return springcloudGpmService.updateUser(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:25
     * @Params: []
     * @Return void
     * Description:
     *      导出用户信息Excel表格
    */
    @GetMapping("/exportUserExcel")
    public void exportUserExcel(){
        springcloudGpmService.exportUserExcel();
    }
}
