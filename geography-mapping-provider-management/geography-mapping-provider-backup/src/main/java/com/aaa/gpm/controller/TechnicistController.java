package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TTechnicist;
import com.aaa.gpm.service.TechnicistService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gcy
 * @DateTime: 2020/7/17 19:50
 * @Description: TODO
 */
@RestController
public class TechnicistController extends CommonController<TTechnicist> {
    @Autowired
    private TechnicistService technicistService;
    @Override
    public BaseService<TTechnicist> getBaseService() {
        return technicistService;
    }
    /**@DateTime: 2020/7/17 19:52
     * @Params: [pageNo, pageSize]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TTechnicist>
     * 描述：
     *      查询所有技术人员表
    */
    @GetMapping("/selectAllTechnicist")
    public ResultData<TTechnicist> selectAllTechnicist(Integer pageNo,Integer pageSize){
        PageInfo<TTechnicist> pageInfo = technicistService.selectListByPage(null, pageNo, pageSize);
        if (null != pageInfo && !"".equals(pageInfo)){
            return super.operationSuccess(pageInfo);
        }
        return super.operationFailed("系统异常，查询所有技术人员表失败");
    }
    /**@DateTime: 2020/7/17 20:02
     * @Params: [id]
     * @Return com.aaa.gpm.base.ResultData<com.aaa.gpm.model.TTechnicist>
     * 描述：
     *      根据id查询技术人员详细信息
    */
    @GetMapping("/selectTechnicistById")
    public ResultData<TTechnicist> selectTechnicistById(Long id){
        TTechnicist tTechnicist = new TTechnicist();
        tTechnicist.setId(id);
        TTechnicist selectOne = technicistService.selectOne(tTechnicist);
        if (null != selectOne && !"".equals(selectOne)){
            return super.operationSuccess(selectOne);
        }
        return super.operationFailed("查无此人");
    }

}
