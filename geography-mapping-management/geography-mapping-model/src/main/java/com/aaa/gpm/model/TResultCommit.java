package com.aaa.gpm.model;

import java.util.Date;

public class TResultCommit {
    private Long id;

    private String plottingScale;

    private String newFigure;

    private String oldFigure;

    private String figure;

    private String mediumType;

    private Date resultDate;

    private String dataFormat;

    private String name;

    private Date createDate;

    private Integer heightDatum;

    private String memo;

    private Long refId;

    private String meridian;

    private String coordinate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlottingScale() {
        return plottingScale;
    }

    public void setPlottingScale(String plottingScale) {
        this.plottingScale = plottingScale == null ? null : plottingScale.trim();
    }

    public String getNewFigure() {
        return newFigure;
    }

    public void setNewFigure(String newFigure) {
        this.newFigure = newFigure == null ? null : newFigure.trim();
    }

    public String getOldFigure() {
        return oldFigure;
    }

    public void setOldFigure(String oldFigure) {
        this.oldFigure = oldFigure == null ? null : oldFigure.trim();
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure == null ? null : figure.trim();
    }

    public String getMediumType() {
        return mediumType;
    }

    public void setMediumType(String mediumType) {
        this.mediumType = mediumType == null ? null : mediumType.trim();
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat == null ? null : dataFormat.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getHeightDatum() {
        return heightDatum;
    }

    public void setHeightDatum(Integer heightDatum) {
        this.heightDatum = heightDatum;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }

    public String getMeridian() {
        return meridian;
    }

    public void setMeridian(String meridian) {
        this.meridian = meridian == null ? null : meridian.trim();
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }
}