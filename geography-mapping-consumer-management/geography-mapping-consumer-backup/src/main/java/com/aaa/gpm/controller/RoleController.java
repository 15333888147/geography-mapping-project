package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TRole;
import com.aaa.gpm.service.SpringcloudGpmService;
import com.aaa.gpm.vo.RoleMenuVo;
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

/**
 * @Author: zj
 * @Date: 2020/7/20
 * 角色管理
 */
@RestController
public class RoleController extends BaseController {

    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:12
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TRole>
     * Description:
     *      分页查询所有角色
    */
    @PostMapping("/roleList")
    public ResultData roleList(@RequestBody HashMap map){
        return springcloudGpmService.roleList(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:13
     * @Params: [roleMenuVo]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      添加角色信息
    */
    @PostMapping("/addRole")
    public ResultData addRole(@RequestBody RoleMenuVo roleMenuVo){
        return springcloudGpmService.addRole(roleMenuVo);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:14
     * @Params: [roleId]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除角色信息
    */
    @PostMapping("/delRole")
    public ResultData delRole(@RequestParam("roleId") Long roleId){
        return springcloudGpmService.delRole(roleId);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:14
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除角色信息
    */
    @PostMapping("/delRoleAlls")
    public ResultData delRoleAlls(@RequestParam("ids") List<Long> ids){
        return springcloudGpmService.delRoleAlls(ids);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:15
     * @Params: [roleMenuVo]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改角色信息
    */
    @PostMapping("/updateRole")
    public ResultData updateRole(@RequestBody RoleMenuVo roleMenuVo){
        return springcloudGpmService.updateRole(roleMenuVo);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:16
     * @Params: []
     * @Return void
     * Description:
     *      导出角色信息Excel表格
    */
    @GetMapping("/exportRoleExcel")
    public ResponseEntity<byte[]> exportRoleExcel(){
        ResponseEntity<byte[]> result = null;
        Response response = springcloudGpmService.exportRoleExcel();
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
            heads.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=角色信息.xls");
            heads.add(HttpHeaders.CONTENT_TYPE, "application/vnd.ms-excel;charset=utf-8");
            heads.add(HttpHeaders.CONNECTION, "close");
            result = new ResponseEntity<>(b, heads, HttpStatus.OK);
        } catch (IOException e) {

        }
        return result;
    }

}
