package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TCheckPerson;
import com.aaa.gpm.service.CheckPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/18
 */
@RestController
public class CheckPersonController extends CommonController<TCheckPerson> {

    @Autowired
    private CheckPersonService checkPersonService;

    @Override
    public BaseService<TCheckPerson> getBaseService() {
        return checkPersonService;
    }

    /**
     * @author zj
     * @DateTime: 2020/7/18 15:33
     * @Params: [hashMap]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TCheckPerson>
     * Description:
     *      人员随机抽查
    */
    @PostMapping("/personRandom")
    public ResultData personRandom(@RequestParam HashMap hashMap){
        List<TCheckPerson> tCheckPeople = checkPersonService.personRandom(hashMap);
        if (null != tCheckPeople && tCheckPeople.size()>0){
            return super.operationSuccess(tCheckPeople);
        }
        return super.operationFailed("系统异常，抽查失败");
    }

    /**
     * @author zj
     * @DateTime: 2020/7/18 15:35
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员添加
    */
    @PostMapping("/addPerson")
    public ResultData addPerson(@RequestParam Map map){
        return super.add(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/18 15:35
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员删除
    */
    @PostMapping("/delPerson")
    public ResultData delPerson(@RequestParam Map map){
        return super.delete(map);
    }

    /**
     * @author zj
     * @DateTime: 2020/7/18 15:36
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData
     * Description:
     *      人员修改
    */
    @PostMapping("/updatePerson")
    public ResultData updatePerson(@RequestParam Map map){
        return super.update(map);
    }
}
