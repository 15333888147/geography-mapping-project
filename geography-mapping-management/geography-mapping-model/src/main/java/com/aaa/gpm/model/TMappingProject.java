package com.aaa.gpm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TMappingProject {
    private Long id;

    private String projectType;

    private String projectName;

    private Double projectAmount;

    private String projectLeader;

    private String startDate;

    private String endDate;

    private String completeTime;

    private String acceptanceDepartment;

    private String acceptanceReport;

    private String taskSource;

    private Double projectArea;

    private String scale;

    private String sheetNumber;

    private String awardsDepartment;

    private String prizeLevel;

    private String projectQualityApproval;

    private String winningTime;

    private String acceptanceTime;

    private String basicContent;

    private String creditStatus;

    private String submitStatus;

    private Long userId;

    private Integer schedule;

    private String createTime;

    private String modifyTime;

    private String memo;

    private Integer status;

    private Integer auditStatus;

    private Integer resultsStatus;

    private String meridian;

    private String coordinateSystem;

    private String managementLevel;

    private String fundingSource;

    private String entrustUnit;

    private String acceptUnit;

    private String mobilePhone;

    private String phone;

    private String address;

    private String centerPoint;

    private Integer synchronizationStatus;

    private String contractTime;

    private String coordinate;
}