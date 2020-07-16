package com.aaa.gpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TDept implements Serializable {
    private Long deptId;

    private Long parentId;

    private String deptName;

    private Double orderNum;

    private Date createTime;

    private Date modifyTime;

    /**
     * 下级部门
     */
    private List<TDept> subDept;
}