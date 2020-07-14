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
public class TResource implements Serializable {
    private Long id;

    private String name;

    private Long size;

    private String path;

    private String type;

    private String extName;

    private String refBizType;

    private Long refBizId;

    private Date createTime;

    private Date modifyTime;

    private String memo;
}