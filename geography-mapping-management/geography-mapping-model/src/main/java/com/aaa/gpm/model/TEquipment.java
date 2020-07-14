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
public class TEquipment implements Serializable {
    private Long id;

    private String name;

    private String brand;

    private String productionId;

    private Integer number;

    private Date checkDate;

    private Date effectiveDate;

    private String invoiceCode;

    private String checkDepartment;

    private String checkCertificateId;

    private String identified;

    private Long userId;

    private Date createTime;

    private Date modifyTime;
}