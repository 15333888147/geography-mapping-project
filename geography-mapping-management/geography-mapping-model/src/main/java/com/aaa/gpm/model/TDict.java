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
@Table(name = "t_dict")
public class TDict implements Serializable {
    @Id
    @Column(name = "DICT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Excel(name = "编号", width = 5, orderNum = "1")
    private Long dictId;

    @Column(name = "KEYY")
    @Excel(name = "键", width = 5, orderNum = "2")
    private Long keyy;

    @Column(name = "VALUEE")
    @Excel(name = "值", width = 15, orderNum = "3")
    private String valuee;

    @Column(name = "FIELD_NAME")
    @Excel(name = "字段名称", width = 15, orderNum = "4")
    private String fieldName;

    @Column(name = "TABLE_NAME")
    @Excel(name = "表名", width = 15, orderNum = "5")
    private String tableName;
}