package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TCheckPerson;
import com.aaa.gpm.service.SpringcloudGpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/20
 * 人员随机抽查
 */
@RestController
public class CheckPersonController extends BaseController {

    @Autowired
    private SpringcloudGpmService springcloudGpmService;

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:57
     * @Params: [hashMap]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TCheckPerson>
     * Description:
     *      人员随机抽查
    */
    @PostMapping("/personRandom")
    public ResultData personRandom(@RequestBody HashMap hashMap){
        return springcloudGpmService.personRandom(hashMap);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:57
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员添加
    */
    @PostMapping("/addPerson")
    public ResultData addPerson(@RequestParam Map map){
        return springcloudGpmService.addPerson(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:58
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员删除
    */
    @PostMapping("/delPerson")
    public ResultData delPerson(@RequestParam Map map){
        return springcloudGpmService.delPerson(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/20 10:58
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *     人员修改
    */
    @PostMapping("/updatePerson")
    public ResultData updatePerson(@RequestParam Map map){
        return springcloudGpmService.updatePerson(map);
    }

}
