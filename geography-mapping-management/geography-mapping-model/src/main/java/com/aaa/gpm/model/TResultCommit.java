package com.aaa.gpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TResultCommit implements Serializable {
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
}