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
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "t_menu")
public class TMenu implements Serializable {
    @Id
    @Column(name = "MENU_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Excel(name = "编号", width = 5, orderNum = "1")
    private Long menuId;

    @Column(name = "PARENT_ID")
    @Excel(name = "上级菜单编号", width = 5, orderNum = "2")
    private Long parentId;

    @Column(name = "MENU_NAME")
    @Excel(name = "菜单名称", width = 20, orderNum = "3")
    private String menuName;

    @Column(name = "PATH")
    @Excel(name = "菜单路径", width = 30, orderNum = "4")
    private String path;

    private String component;

    private String perms;

    private String icon;

    private String type;

    private Double orderNum;

    @Column(name = "CREATE_TIME")
    @Excel(name = "创建时间", width = 35, orderNum = "5")
    private Date createTime;

    @Column(name = "MODIFY_TIME")
    @Excel(name = "修改时间", width = 35, orderNum = "6")
    private Date modifyTime;

    /**
     * 子菜单
     */
    private List<TMenu> subMenu;
}