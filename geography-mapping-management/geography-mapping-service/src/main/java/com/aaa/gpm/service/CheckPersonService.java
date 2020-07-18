package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.CheckPersonMapper;
import com.aaa.gpm.model.TCheckPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/18
 */
@Service
public class CheckPersonService extends BaseService<TCheckPerson> {

    @Autowired
    private CheckPersonMapper checkPersonMapper;

    /**
     * @author zj
     * @DateTime: 2020/7/18 15:30
     * @Params: [hashMap]
     * @Return java.util.List<com.aaa.gpm.model.TCheckPerson>
     * Description:
     *      人员随机抽查
    */
    public List<TCheckPerson> personRandom(HashMap hashMap){
        List<TCheckPerson> tCheckPeople = checkPersonMapper.personRandom(hashMap);
        if (null != tCheckPeople && tCheckPeople.size()>0){
            return tCheckPeople;
        }
        return null;
    }

}
