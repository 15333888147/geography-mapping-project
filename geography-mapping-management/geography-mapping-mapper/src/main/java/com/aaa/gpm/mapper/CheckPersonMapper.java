package com.aaa.gpm.mapper;

import com.aaa.gpm.model.TCheckPerson;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/18
 */
public interface CheckPersonMapper extends Mapper<TCheckPerson> {
    /**
     * @author zj
     * @DateTime: 2020/7/18 15:26
     * @Params: [hashMap]
     * @Return java.util.List<com.aaa.gpm.model.TCheckPerson>
     * Description:
     *      人员随机抽查
    */
    List<TCheckPerson> personRandom(HashMap hashMap);
}
