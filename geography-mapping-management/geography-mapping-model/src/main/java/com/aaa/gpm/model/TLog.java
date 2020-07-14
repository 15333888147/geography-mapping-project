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
public class TLog {
    private Long id;

    private String username;

    private Long time;

    private String ip;

    private Date createTime;

    private String location;

    private String operation;

    private String method;

    private String params;
}