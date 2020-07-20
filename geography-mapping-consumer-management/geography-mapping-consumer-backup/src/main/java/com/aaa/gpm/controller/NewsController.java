package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/20
 * 公告栏
 */
@RestController
public class NewsController extends BaseController {

    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:50
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TUser>
     * Description:
     *      分页查询公告栏信息
    */
    @PostMapping("/newsList")
    public ResultData<TUser> newsList(@RequestParam HashMap map){
        return springcloudGpmService.newsList(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:50
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      新增一条公告栏信息
    */
    @PostMapping("/addNews")
    public ResultData addNews(@RequestParam Map map){
        return springcloudGpmService.addNews(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:51
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      删除一条公告栏信息
    */
    @PostMapping("/delNews")
    public ResultData delNews(@RequestParam Map map){
        return springcloudGpmService.delNews(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:51
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      批量删除公告栏信息
    */
    @PostMapping("/delNewsAlls")
    public ResultData delNewsAlls(@RequestBody List<Long> id){
        return springcloudGpmService.delNewsAlls(id);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:52
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      修改一条公告栏信息
    */
    @PostMapping("/updateNews")
    public ResultData updateNews(@RequestParam Map map){
        return springcloudGpmService.updateNews(map);
    }
}
