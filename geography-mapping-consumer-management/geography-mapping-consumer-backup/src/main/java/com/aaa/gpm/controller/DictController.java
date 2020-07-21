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
 * 字典管理
 */
@RestController
public class DictController extends BaseController {

    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:26
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TUser>
     * Description:
     *      分页查询字典信息
    */
    @PostMapping("/dictList")
    public ResultData<TUser> dictList(@RequestBody HashMap map){
        return springcloudGpmService.dictList(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:27
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      字典新增一条信息
    */
    @PostMapping("/addDict")
    public ResultData addDict(@RequestParam Map map){
        return springcloudGpmService.addDict(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:27
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      字典删除一条信息
    */
    @PostMapping("/delDict")
    public ResultData delDict(@RequestParam Map map){
        return springcloudGpmService.delDict(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:28
     * @Params: [ids]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除字典信息
    */
    @PostMapping("/delDictAlls")
    public ResultData delDictAlls(@RequestParam("ids") List<Long> ids){
        return springcloudGpmService.delDictAlls(ids);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:29
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      字典修改一条信息
    */
    @PostMapping("/updateDict")
    public ResultData updateDict(@RequestParam Map map){
        return springcloudGpmService.updateDict(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:29
     * @Params: []
     * @Return void
     * Description:
     *      导出字典信息Excel表格
    */
    @GetMapping("/exportDictExcel")
    public ResponseEntity<byte[]> exportDictExcel(){
        ResponseEntity<byte[]> result = null;
        Response response = springcloudGpmService.exportDictExcel();
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
            heads.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=字典信息.xls");
            heads.add(HttpHeaders.CONTENT_TYPE, "application/vnd.ms-excel;charset=utf-8");
            heads.add(HttpHeaders.CONNECTION, "close");
            result = new ResponseEntity<>(b, heads, HttpStatus.OK);
        } catch (IOException e) {

        }
        return result;
    }

}
