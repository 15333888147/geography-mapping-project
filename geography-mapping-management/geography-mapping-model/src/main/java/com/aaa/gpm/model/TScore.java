package com.aaa.gpm.model;

import java.util.Date;

public class TScore {
    private Long id;

    private Integer scorePlus;

    private Integer scoreSubtract;

    private Integer score;

    private Long unitId;

    private String reason;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScorePlus() {
        return scorePlus;
    }

    public void setScorePlus(Integer scorePlus) {
        this.scorePlus = scorePlus;
    }

    public Integer getScoreSubtract() {
        return scoreSubtract;
    }

    public void setScoreSubtract(Integer scoreSubtract) {
        this.scoreSubtract = scoreSubtract;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}