package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: gcy
 * @DateTime: 2020/7/21 15:30
 * @Description: TODO
 */
@RestController
public class EquipmentController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:31
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      查询所有仪器
    */
    @GetMapping("/allEquipment")
    public ResultData allEquipment(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return springcloudGpmService.allEquipment(pageNo,pageSize);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:32
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      根据id查询仪器
    */
    @GetMapping("/selectEquipmentById")
    public ResultData selectEquipmentById(@RequestParam Long id){
        return springcloudGpmService.selectEquipmentById(id);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:33
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      修改仪器信息
    */
    @PostMapping("/updateEquipment")
    public ResultData updateSpecialPost(@RequestBody Map map){
        return springcloudGpmService.updateSpecialPost(map);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:33
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      增加仪器信息
    */
    @PostMapping("/addEquipment")
    public ResultData addSpecialPost(@RequestBody Map map){
        return springcloudGpmService.addSpecialPost(map);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:34
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      删除仪器信息
    */
    @PostMapping("/deleteEquipment")
    public ResultData deleteSpecialPost(@RequestBody Map map){
        return springcloudGpmService.deleteSpecialPost(map);
    }
}
