package com.aaa.gpm.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "t_dept")
public class TDept implements Serializable {
    @Id
    @Column(name = "DEPT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Excel(name = "编号", width = 5, orderNum = "1")
    private Long deptId;

    @Column(name = "PARENT_ID")
    @Excel(name = "上级部门编号", width = 5, orderNum = "2")
    private Long parentId;

    @Column(name = "DEPT_NAME")
    @Excel(name = "部门名称", width = 20, orderNum = "3")
    private String deptName;

    @Column(name = "ORDER_NUM")
    @Excel(name = "排序", width = 5, orderNum = "4")
    private Double orderNum;

    @Column(name = "CREATE_TIME")
    @Excel(name = "创建时间", width = 35, orderNum = "5")
    private Date createTime;

    @Column(name = "MODIFY_TIME")
    @Excel(name = "修改时间", width = 35, orderNum = "6")
    private Date modifyTime;

    /**
     * 下级部门
     */
    private List<TDept> subDept;
}