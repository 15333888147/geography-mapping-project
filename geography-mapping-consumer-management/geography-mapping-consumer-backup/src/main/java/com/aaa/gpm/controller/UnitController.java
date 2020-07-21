package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: zj
 * @Date: 2020/7/20
 * 单位管理
 */
@RestController
public class UnitController extends BaseController {

    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:55
     * @Params: [hashMap]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      单位随机抽查
    */
    @PostMapping("/unitRandom")
    public ResultData unitRandom(@RequestBody HashMap hashMap){
        return springcloudGpmService.unitRandom(hashMap);
    }


}
