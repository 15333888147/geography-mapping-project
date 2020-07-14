package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.UserMappper;
import com.aaa.gpm.model.TUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/8
 * 用户管理
 *
 */
@Service
public class UserService extends BaseService<TUser> {

    @Autowired
    private UserMappper userMappper;

    /**
     * 分页查询所有用户
     * @param hashMap
     * @return
     */
    public PageInfo selectAlls(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNo")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo page = new PageInfo(userMappper.selectAlls(hashMap));
        if (null != page && !"".equals(page)){
            return page;
        }
        return null;
    }


}
