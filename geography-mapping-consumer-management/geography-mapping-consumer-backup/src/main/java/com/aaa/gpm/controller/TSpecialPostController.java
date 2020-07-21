package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: gcy
 * @DateTime: 2020/7/21 16:01
 * @Description: TODO
 */
@RestController
public class TSpecialPostController extends BaseController {
    @Autowired
    private SpringcloudGpmService springcloudGpmService;
    /**@Author:gcy
     *@DateTime: 2020/7/21 16:02
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      查询所有特殊岗位人员
    */
    @GetMapping("/selectAllSpecialPost")
    public ResultData selectAllSpecialPost(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        return springcloudGpmService.selectAllSpecialPost(pageNo,pageSize);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 16:03
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      根据id查询特殊岗位人员
    */
    @GetMapping("/selectSpecialPostById")
    public ResultData selectSpecialPostById(@RequestParam Long id){
        return springcloudGpmService.selectSpecialPostById(id);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 16:03
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      修改特殊岗位人员信息
    */
    @PostMapping("/updateSpecialPost")
    public ResultData updateSpecialPost(@RequestBody Map map){
        return springcloudGpmService.updateSpecialPost(map);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 16:04
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *      增加特殊岗位人员信息
    */
    @PostMapping("/addSpecialPost")
    public ResultData addSpecialPost(@RequestBody Map map){
        return springcloudGpmService.addSpecialPost(map);
    }
    /**@Author:gcy
     *@DateTime: 2020/7/21 16:04
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * 描述：
     *         删除特殊岗位人员信息
    */
    @PostMapping("/deleteSpecialPost")
    public ResultData deleteSpecialPost(@RequestBody Map map){
        return springcloudGpmService.deleteSpecialPost(map);
    }
}
