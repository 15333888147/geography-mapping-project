package com.aaa.gpm.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "t_role")
public class TRole implements Serializable {
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Excel(name = "编号", width = 5, orderNum = "1")
    private Long roleId;

    @Column(name = "ROLE_NAME")
    @Excel(name = "角色名称", width = 25, orderNum = "2")
    private String roleName;

    @Column(name = "REMARK")
    @Excel(name = "角色描述", width = 35, orderNum = "3")
    private String remark;

    @Column(name = "CREATE_TIME")
    @Excel(name = "创建时间", width = 35, orderNum = "4")
    private Date createTime;

    @Column(name = "MODIFY_TIME")
    @Excel(name = "修改时间", width = 35, orderNum = "5")
    private Date modifyTime;
}