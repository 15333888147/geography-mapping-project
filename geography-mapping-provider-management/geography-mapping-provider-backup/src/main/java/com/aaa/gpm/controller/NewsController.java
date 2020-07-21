package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TNews;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.service.NewsService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxq on 2020/7/17
 */
@RestController
@Slf4j
public class NewsController  extends CommonController<TNews> {
    @Autowired
    private NewsService newsService;

    @Override
    public BaseService<TNews> getBaseService() {
        return newsService;
    }

    /**
     * 分页查询公告栏信息
     * @param map
     * @return
     */
    @PostMapping("/newsList")
    public ResultData newsList(@RequestParam HashMap map){
        PageInfo pageInfo = newsService.selectNewsAlls(map);
        if (null != pageInfo || !("").equals(pageInfo)){
            return super.operationSuccess(pageInfo);
        } else {
            return super.operationFailed("查询失败");
        }
    }

    /**
     * 新增一条公告栏信息
     * @param map
     * @return
     */
    @PostMapping("/addNews")
    public ResultData addNews(@RequestParam Map map){
        return super.add(map);
    }

    /**
     * 删除一条公告栏信息
     * @param map
     * @return
     */
    @PostMapping("/delNews")
    public ResultData delNews(@RequestParam Map map){
        return super.delete(map);
    }

    /**
     * 批量删除公告栏信息
     * @param id
     * @return
     */
    @PostMapping("/delNewsAlls")
    public ResultData delNewsAlls(@RequestBody List<Long> id){
        Integer integer = newsService.delNewsAlls(id);
        if (integer > 0) {
            return super.deleteSuccess();
        } else {
            return super.deleteFailed();
        }
    }

    /**
     * 修改一条公告栏信息
     * @param map
     * @return
     */
    @PostMapping("/updateNews")
    public ResultData updateNews(@RequestParam Map map){
        return super.update(map);
    }

}
