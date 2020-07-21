package com.aaa.gpm.service;

import com.aaa.gpm.base.BaseService;
import com.aaa.gpm.mapper.ScoreMapper;
import com.aaa.gpm.model.TScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @Author: gcy
 * @DateTime: 2020/7/16 19:37
 * @Description: TODO
 */
@Service
public class ScoreService extends BaseService<TScore> {
    @Autowired
    private ScoreMapper scoreMapper;
    /**@DateTime: 2020/7/17 9:30
     * @Params: [id, score_plus, score_subtract, score, unit_id, reason, create_time, modify_time]
     * @Return java.lang.Integer
     * 描述：
     *      新增分值表
    */
    public Integer addScore(@RequestParam("id") Long id,@RequestParam("score_plus") Integer score_plus,@RequestParam("score_subtract") Integer score_subtract,@RequestParam("score") Integer score,@RequestParam("unit_id") Long unit_id,@RequestParam("reason") String reason,@RequestParam("create_time") Date create_time,@RequestParam("modify_time") Date modify_time){
        TScore tScore = new TScore();
        tScore.setId(id).setScorePlus(score_plus).setScoreSubtract(score_subtract).setScore(score).setUnitId(unit_id).setReason(reason).setCreateTime(create_time).setModifyTime(modify_time);
        if (tScore != null && !"".equals(tScore)){
            return super.add(tScore);
        }
        return null;
    }
}
