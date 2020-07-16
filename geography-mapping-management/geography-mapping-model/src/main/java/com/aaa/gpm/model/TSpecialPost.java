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
public class TSpecialPost implements Serializable {
    private Long id;

    private String name;

    private String idNumber;

    private Integer sex;

    private Integer age;

    private Integer workYear;

    private String school;

    private String major;

    private String educationBackground;

    private String degree;

    private String specialPost;

    private Long userId;

    private Date createTime;

    private Date modifyTime;
}