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
public class TAudit implements Serializable {
    private Long id;

    private String name;

    private Integer type;

    private Long userId;

    private Integer status;

    private Date submitTime;

    private Date auditTime;

    private String memo;

    private Long refId;

    private Date createTime;

}