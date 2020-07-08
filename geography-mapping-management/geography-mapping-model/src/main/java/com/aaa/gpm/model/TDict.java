package com.aaa.gpm.model;

public class TDict {
    private Long dictId;

    private Long keyy;

    private String valuee;

    private String fieldName;

    private String tableName;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public Long getKeyy() {
        return keyy;
    }

    public void setKeyy(Long keyy) {
        this.keyy = keyy;
    }

    public String getValuee() {
        return valuee;
    }

    public void setValuee(String valuee) {
        this.valuee = valuee == null ? null : valuee.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }
}