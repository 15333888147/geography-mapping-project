package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: gcy
 * @DateTime: 2020/7/21 15:56
 * @Description: TODO
 */
@RestController
public class TechnicistController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:58
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      分页查询所有技术人员
    */
    @GetMapping("/selectAllTechnicist")
    public ResultData selectAllTechnicist(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        return springcloudGpmService.selectAllTechnicist(pageNo,pageSize);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:58
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      根据id查询技术人员详细信息
    */
    @GetMapping("/selectTechnicistById")
    public ResultData selectTechnicistById(@RequestParam Long id){
        return springcloudGpmService.selectTechnicistById(id);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 15:59
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      修改技术人员信息
    */
    @PostMapping("/updateTechnicist")
    public ResultData updateTechnicist(@RequestBody Map map){
        return springcloudGpmService.updateTechnicist(map);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 16:00
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      增加技术人员信息
    */
    @PostMapping("/addTechnicist")
    public ResultData addTechnicist(@RequestBody Map map){
        return springcloudGpmService.addTechnicist(map);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 16:00
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *         删除技术人员信息
    */
    @PostMapping("/deleteTechnicist")
    public ResultData deleteTechnicist(@RequestBody Map map){
        return springcloudGpmService.deleteTechnicist(map);
    }
}
