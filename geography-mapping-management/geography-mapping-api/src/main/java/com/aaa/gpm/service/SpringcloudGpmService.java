package com.aaa.gpm.service;

import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/13
 */
@FeignClient(value = "gpm-interface")
public interface SpringcloudGpmService {
    /**@DateTime: 2020/7/15 15:07
    * @Params: [tuser]
    * @Return com.aaa.gpm.base.ResultData
    * 描述：
     *      执行登陆操作
    */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody TUser tuser);
    /**@DateTime: 2020/7/15 15:09
    * @Params: [tloginLog]
    * @Return java.lang.Integer
    * 描述：
     *      添加日志
    */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody TLoginLog tloginLog);

    @GetMapping("/firstMenu")
    List<TMenu> firstMenu(@RequestParam("id") Long id);

    /*@PostMapping("/allProjects")
    PageInfo<TMappingProject> allProjects(@RequestParam Integer pageNo,@RequestParam Integer pageSize);*/

/*    @GetMapping("/allCommit")
    PageInfo<TResultCommit> allCommit(Integer pageNo, Integer pageSize);

    @GetMapping("/selectProjectByName")
    List<TMappingProject> selectProjectByName(String name);

    @GetMapping("/selectCommitByName")
    TResultCommit selectCommitByName(String name);*/

}
