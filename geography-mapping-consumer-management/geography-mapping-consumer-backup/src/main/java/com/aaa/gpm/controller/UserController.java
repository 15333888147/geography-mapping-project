package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.SpringcloudGpmService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    public ResultData userList(@RequestBody HashMap map){
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
    public ResultData delUserAlls(@RequestParam("ids") List<Long> ids){
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
    public ResponseEntity<byte[]> exportUserExcel(){
        ResponseEntity<byte[]> result = null;
        Response response = springcloudGpmService.exportUserExcel();
        Response.Body body = response.body();
        try (InputStream inputStream = body.asInputStream()) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[10240];
            while (true) {
                int len = inputStream.read(buf);
                if (len < 0) {
                    break;
                }
                bos.write(buf, 0, len);
            }
            byte[] b = bos.toByteArray();
            HttpHeaders heads = new HttpHeaders();
            heads.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=用户信息.xls");
            heads.add(HttpHeaders.CONTENT_TYPE, "application/vnd.ms-excel;charset=utf-8");
            heads.add(HttpHeaders.CONNECTION, "close");
            result = new ResponseEntity<>(b, heads, HttpStatus.OK);
        } catch (IOException e) {

        }
        return result;
    }
}
