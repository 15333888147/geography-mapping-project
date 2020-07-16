package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.UserService;
import com.aaa.gpm.utils.ExcelUtil;
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
        List<TUser> users = userService.selectAll();
        if (null != users && users.size() >0){
            //不为空，开始进行导出
            if (null != users && !users.isEmpty()){
                //list存放表格数据
                List<List<String>> excelData = new ArrayList<List<String>>();
                if(null != users){
                    //表格头
                    List<String> headList = new ArrayList<String>();
                    headList.add("用户ID");
                    headList.add("用户名");
                    headList.add("部门ID");
                    headList.add("部门名称");
                    headList.add("邮箱");
                    headList.add("联系电话");
                    headList.add("状态");
                    headList.add("创建时间");
                    headList.add("修改时间");
                    headList.add("最近访问时间");
                    headList.add("性别");
                    headList.add("描述");
                    headList.add("用户类型");
                    //把表头放入表格数据中
                    excelData.add(headList);
                    //遍历表格数据并放入excelData
                    for (TUser user : users) {
                        List<String> list = new ArrayList<String>();
                        list.add(String.valueOf(user.getId()));
                        list.add(String.valueOf(user.getUsername()));
                        list.add(String.valueOf(user.getDeptId()));
                        list.add(String.valueOf(user.getDeptName()));
                        list.add(String.valueOf(user.getEmail()));
                        list.add(String.valueOf(user.getMobile()));
                        if ("0".equals(user.getStatus())){
                            list.add("锁定");
                        }else if ("1".equals(user.getStatus())){
                            list.add("有效");
                        }
                        list.add(String.valueOf(user.getCreateTime()));
                        list.add(String.valueOf(user.getModifyTime()));
                        list.add(String.valueOf(user.getLastLoginTime()));
                        if ("0".equals(user.getSsex())){
                            list.add("男");
                        }else if ("1".equals(user.getSsex())){
                            list.add("女");
                        }else if ("2".equals(user.getSsex())){
                            list.add("保密");
                        }
                        list.add(String.valueOf(user.getDescription()));
                        if ("0".equals(user.getType())){
                            list.add("单位用户");
                        }else if ("1".equals(user.getType())){
                            list.add("审核用户");
                        }else if ("2".equals(user.getType())){
                            list.add("管理员");
                        }
                        //把数据放入excelData
                        excelData.add(list);
                    }
                }
                String sheetName = "用户信息";
                String fileName = "用户信息表";
                try {
                    ExcelUtil.exportExcel(response, excelData, sheetName, fileName, 12);
                } catch (IOException e) {
                    log.error("用户信息数据导出失败！");
                }

            }
        } else{
            log.error("用户管理中的导出数据出错！");
        }
    }
}
