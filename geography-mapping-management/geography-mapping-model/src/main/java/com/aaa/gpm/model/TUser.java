package com.aaa.gpm.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "t_user")
public class TUser implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Excel(name = "编号", width = 5, orderNum = "1")
    private Long id;

    @Column(name = "username")
    @Excel(name = "用户名", width = 45, orderNum = "2")
    private String username;

    private String password;

    @Column(name = "dept_id")
    @Excel(name = "部门编号", width = 5, orderNum = "3")
    private Long deptId;

    @Column(name = "email")
    @Excel(name = "邮箱", width = 20, orderNum = "4")
    private String email;

    @Column(name = "mobile")
    @Excel(name = "联系电话", width = 15, orderNum = "5")
    private String mobile;

    @Column(name = "mobile")
    @Excel(name = "状态", width = 10, replace = { "锁定_0", "有效_1"},orderNum = "6")
    private String status;

    @Column(name = "create_time")
    @Excel(name = "创建时间", width = 35, orderNum = "7")
    private String createTime;

    @Column(name = "modify_time")
    @Excel(name = "修改时间", width = 35, orderNum = "8")
    private String modifyTime;

    private String lastLoginTime;

    @Column(name = "ssex")
    @Excel(name = "性别", width = 10, replace = { "男_0", "女_1","保密_2" },orderNum = "9")
    private String ssex;

    private String description;

    private String avatar;

    private String type;

    private String token;

    private String deptName;
}