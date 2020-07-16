package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TDict;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.DictService;
import com.github.pagehelper.PageInfo;
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
 * @Date: 2020/7/14
 */
@RestController
public class DictController extends CommonController<TDict> {

    @Autowired
    private DictService dictService;

    @Override
    public BaseService<TDict> getBaseService() {
        return dictService;
    }

    /**
     * 分页查询字典信息
     * @param map
     * @return
     */
    @PostMapping("/dictList")
    public ResultData<TUser> list(@RequestParam HashMap map){
        PageInfo pageInfo = dictService.selectAlls(map);
        if (null != pageInfo || !("").equals(pageInfo)){
            return super.operationSuccess(pageInfo);
        } else {
            return super.operationFailed("查询失败");
        }
    }

    /**
     * 字典新增一条信息
     * @param map
     * @return
     */
    @PostMapping("/addDict")
    public ResultData addDict(@RequestParam Map map){
        return super.add(map);
    }

    /**
     * 字典删除一条信息
     * @param map
     * @return
     */
    @PostMapping("/delDict")
    public ResultData delDict(@RequestParam Map map){
        return super.delete(map);
    }

    /**
     * 批量删除部门信息
     * @param ids
     * @return
     */
    @PostMapping("/delDictAlls")
    public ResultData delDictAlls(@RequestBody List<Long> ids){
        Integer integer = dictService.delDictAlls(ids);
        if (integer > 0) {
            return super.deleteSuccess();
        } else {
            return super.deleteFailed();
        }
    }

    /**
     * 字典修改一条信息
     * @param map
     * @return
     */
    @PostMapping("/updateDict")
    public ResultData updateDict(@RequestParam Map map){
        return super.update(map);
    }

}
