package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TResource;
import com.aaa.gpm.model.TSpecialPost;
import com.aaa.gpm.model.TTechnicist;
import com.aaa.gpm.service.ResourceService;
import com.aaa.gpm.service.SpecialPostService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: gcy
 * @DateTime: 2020/7/17 20:48
 * @Description: TODO
 */
@RestController
public class TSpecialPostController extends CommonController<TSpecialPost> {
    @Autowired
    private SpecialPostService specialPostService;
    @Autowired
    private ResourceService resourceService;
    @Override
    public BaseService<TSpecialPost> getBaseService() {
        return null;
    }
    /**@DateTime: 2020/7/17 20:52
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TSpecialPost>
     * 描述：
     *      查询所有特殊岗位人员
    */
    @GetMapping("/selectAllSpecialPost")
    public ResultData<TSpecialPost> selectAllSpecialPost(Integer pageNo,Integer pageSize){
        PageInfo<TSpecialPost> pageInfo = specialPostService.selectListByPage(null, pageNo, pageSize);
        if (pageInfo != null && !"".equals(pageInfo)){
            return super.operationSuccess(pageInfo);
        }
        return super.operationFailed("系统异常，查询失败");
    }
    /**@DateTime: 2020/7/17 20:56
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData<java.util.Map>
     * 描述：
     *       根据id查询特殊岗位人员
    */
    @GetMapping("/selectSpecialPostById")
    public ResultData<Map> selectSpecialPostById(Long id){
        Map map = new HashMap();
        TSpecialPost tSpecialPost = new TSpecialPost();
        tSpecialPost.setId(id);
        TSpecialPost tSpecialPost1 = specialPostService.selectOne(tSpecialPost);
        TResource tResource = new TResource();
        tResource.setRefBizId(id);
        List<TResource> tResources = resourceService.selectList(tResource);
        if (null != tSpecialPost1 && !"".equals(tSpecialPost1) && null != tResources && !"".equals(tResources)){
            map.put("tEquipment",tSpecialPost1);
            map.put("tResource",tResources);
            return super.operationSuccess(map);
        }
        return super.operationFailed("查无此特殊岗位人员");
    }
    /**@DateTime: 2020/7/20 10:25
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TSpecialPost>
     * 描述：
     *      修改特殊岗位人员信息
     */
    @PostMapping("/updateSpecialPost")
    public ResultData<TSpecialPost> updateSpecialPost(@RequestBody Map map){
        return super.update(map);
    }
    /**@DateTime: 2020/7/20 10:25
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TSpecialPost>
     * 描述：
     *      增加特殊岗位人员信息
     */
    @PostMapping("/addSpecialPost")
    public ResultData<TSpecialPost> addSpecialPost(@RequestBody Map map){
        return super.add(map);
    }
    /**@DateTime: 2020/7/20 10:26
     * @Params: [map]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TSpecialPost>
     * 描述：
     *      删除特殊岗位人员信息
     */
    @PostMapping("/deleteSpecialPost")
    public ResultData<TSpecialPost> deleteSpecialPost(@RequestBody Map map){
        return super.delete(map);
    }
}
