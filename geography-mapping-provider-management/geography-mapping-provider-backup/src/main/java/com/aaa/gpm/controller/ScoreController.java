package com.aaa.gpm.controller;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.base.CommonController;
import com.aaa.gpm.base.ResultData;
import com.aaa.gpm.model.TScore;
import com.aaa.gpm.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gcy
 * @DateTime: 2020/7/16 19:43
 * @Description: TODO
 */
@RestController
public class ScoreController extends CommonController<TScore> {
    @Autowired
    private ScoreService scoreService;
    @Override
    public BaseService getBaseService() {
        return scoreService;
    }
}
