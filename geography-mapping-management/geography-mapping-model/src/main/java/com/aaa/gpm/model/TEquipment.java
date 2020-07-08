package com.aaa.gpm.model;

import java.util.Date;

public class TEquipment {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId == null ? null : productionId.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    public String getCheckDepartment() {
        return checkDepartment;
    }

    public void setCheckDepartment(String checkDepartment) {
        this.checkDepartment = checkDepartment == null ? null : checkDepartment.trim();
    }

    public String getCheckCertificateId() {
        return checkCertificateId;
    }

    public void setCheckCertificateId(String checkCertificateId) {
        this.checkCertificateId = checkCertificateId == null ? null : checkCertificateId.trim();
    }

    public String getIdentified() {
        return identified;
    }

    public void setIdentified(String identified) {
        this.identified = identified == null ? null : identified.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}