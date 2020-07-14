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
public class TCheckPerson {
    private Long id;

    private String name;

    private String unitName;

    private String duty;

    private String phone;

    private Date createTime;

    private Date modifyTime;

    private String memo;
}