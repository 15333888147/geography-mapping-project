package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.UserMapper;
import com.aaa.gpm.model.TMenu;
import com.aaa.gpm.model.TUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/8
 * 用户管理
 *
 */
@Service
public class UserService extends BaseService<TUser> {

    @Autowired
    private UserMapper userMappper;

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

    /**
     * 批量删除用户信息
     * @param ids
     * @return
     */
    public Integer delUserAlls(List<Long> ids){
        Example example = Example.builder(TMenu.class).where(Sqls.custom().andIn("id",ids)).build();
        return userMappper.deleteByExample(example);
    }

    /**
     * 导出用户信息Excel表格
     * @return
     */
    public List<TUser> selectAll(){
        List<TUser> tUsers = userMappper.selectAlls(null);
        if (null != tUsers && tUsers.size() >0){
            return tUsers;
        }
        return null;
    }
}
