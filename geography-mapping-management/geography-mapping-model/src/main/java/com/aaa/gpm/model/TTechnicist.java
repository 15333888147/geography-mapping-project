package com.aaa.gpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TTechnicist {
    private Long id;

    private String name;

    private String majorType;

    private String idType;

    private String idNumber;

    private Integer sex;

    private Integer age;

    private Integer workYear;

    private String duty;

    private String title;

    private String school;

    private Date graduationDate;

    private String degree;

    private String educationBackground;

    private String major;

    private String titleMajor;

    private Date startTime;

    private Date titleTime;

    private Date startContract;

    private Date endContract;

    private String post;

    private Integer mappingYear;

    private String specialPost;

    private String affirm;

    private Long userId;

    private Date createTime;

    private Date modifyTime;
}