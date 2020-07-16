package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.model.TUser;
import com.aaa.gpm.vo.TokenVo;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 16:08
 * @Description: TODO
 */
@Service
public class LoginService extends BaseService<TUser> {
    public TokenVo doLogin(TUser user) {
        TokenVo tokenVo = new TokenVo();
        TUser user1 = new TUser();
        // 1.判断User是否为null
        if(null != user) {
            user1.setUsername(user.getUsername());
            TUser user2 = super.selectOne(user1);
            // 2.判断user2是否为null
            if(null == user2) {
                tokenVo.setIfSuccess(false).setType(1);
                return tokenVo;
            } else {
                // 用户名OK，查询密码
                user1.setPassword(user.getPassword());
                TUser user3 = super.selectOne(user1);
                // 3.判断user3是否为null
                if(null == user3) {
                    tokenVo.setIfSuccess(false).setType(2);
                    return tokenVo;
                } else {
                    // 登录成功
                    /**
                     *
                     * !!!!!!mybatis是无法检测连接符的，他会把连接符进行转译(\\-)
                     * 需要把连接符替换掉
                     *
                     *
                     */
                    String token = UUID.randomUUID().toString().replaceAll("-","");
                    user3.setToken(token);
                    Integer updateResult = super.update(user3);
                    if(updateResult > 0) {
                        tokenVo.setIfSuccess(true).setToken(token);
                    } else {
                        tokenVo.setIfSuccess(false).setType(4);
                        return tokenVo;
                    }
                }
            }
        } else {
            tokenVo.setIfSuccess(false).setType(4);
            return tokenVo;
        }
        return tokenVo;
    }
}
