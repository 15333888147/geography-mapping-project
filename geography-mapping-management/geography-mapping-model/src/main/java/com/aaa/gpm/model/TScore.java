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
public class TScore {
    private Long id;

    private Integer scorePlus;

    private Integer scoreSubtract;

    private Integer score;

    private Long unitId;

    private String reason;

    private Date createTime;

    private Date modifyTime;
}