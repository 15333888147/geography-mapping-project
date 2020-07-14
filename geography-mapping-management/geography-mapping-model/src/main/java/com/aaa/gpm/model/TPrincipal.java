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
public class TPrincipal {
    private Long id;

    private String type;

    private String name;

    private String idType;

    private String idNumber;

    private Integer age;

    private Integer sex;

    private Integer workYear;

    private String duty;

    private String title;

    private Integer mappingYear;

    private String major;

    private Long userId;

    private Date createTime;

    private Date modifyTime;
}