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
public class TMappingUnit {
    private Long id;

    private Date createTime;

    private Date modifyTime;

    private String memo;

    private String unitName;

    private String registerAddress;

    private Date registerTime;

    private String oa;

    private String corporation;

    private String linkman;

    private String ownedDistrict;

    private Double registerFund;

    private String socialCreditCode;

    private String qualificationLevel;

    private String phone;

    private String contactWay;

    private String usedName;

    private String registerAddressLon;

    private String registerAddressLat;

    private String registerAddressPostcode;

    private String oaPostcode;

    private Double oaArea;

    private Date establishTime;

    private String mobilePhone;

    private String faxNum;

    private String email;

    private Integer surveyingNum;

    private Integer staffNum;

    private String unitNature;

    private String belongIndustry;

    private String certificateCode;

    private Date certificateSendDate;

    private String companyType;

    private String stockDetails;

    private String jointVenture;

    private Integer jointChP;

    private String jointRatifyCode;

    private String competentDepart;

    private String firstQualificationLevel;

    private Date firstQualificationDate;

    private String qualificationProcess;

    private String organizationCode;

    private String unitType;

    private Long userId;

    private Integer auditStatus;

    private String unitCode;

    private Integer unitStatus;

    private Integer synchronizationStatus;

    private Integer score;

    private String filingBusiness;

    private String businessScope;

    private String unitIntro;

    private String coordinate;
}