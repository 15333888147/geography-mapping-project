package com.aaa.gpm.base;

import java.util.Map;

/**
 * @Author: zj
 * @Date: 2020/7/8
 */
public abstract class CommonController<T> extends BaseController {

    public abstract  BaseService<T> getBaseService();

    public ResultData add(Map map) {
        return new ResultData();
    }

}
