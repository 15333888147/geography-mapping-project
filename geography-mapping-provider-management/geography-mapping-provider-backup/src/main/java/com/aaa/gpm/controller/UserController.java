package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.UserService;
import com.aaa.gpm.utils.MyExcelExportUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/8
 * 用户管理
 */
@RestController
@Slf4j
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
    @PostMapping("/userList")
    public ResultData<TUser> list(@RequestParam HashMap map){
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
    public ResultData addUser(@RequestParam Map map){
        return super.add(map);
    }

    /**
     * 删除用户信息
     * @param map
     * @return
     */
    @PostMapping("/deleteUser")
    public ResultData deleteUser(@RequestParam Map map){
        return super.delete(map);
    }

    /**
     * 批量删除用户信息
     * @param ids
     * @return
     */
    @PostMapping("/delUserAlls")
    public ResultData delUserAlls(@RequestBody List<Long> ids){
        Integer integer = userService.delUserAlls(ids);
        if (integer > 0) {
            return super.deleteSuccess();
        } else {
            return super.deleteFailed();
        }
    }

    /**
     * 修改用户信息[
     * @param map
     * @return
     */
    @PostMapping("/updateUser")
    public ResultData updateUser(@RequestParam Map map){
        return super.update(map);
    }

    /**
     * 导出用户信息Excel表格
     * @param response
     */
    @GetMapping("/exportUserExcel")
    public void exportUserExcel(HttpServletResponse response){
        List<TUser> users = userService.exportUserExcel();
        if (null != users && users.size() >0){
            MyExcelExportUtil.exportExcel(users,TUser.class,"用户信息","用户信息表",response);
        } else{
            log.error("用户管理中的导出数据出错！");
        }

    }
}

