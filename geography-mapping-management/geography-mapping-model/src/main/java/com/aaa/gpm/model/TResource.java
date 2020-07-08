package com.aaa.gpm.model;

import java.util.Date;

public class TResource {
    private Long id;

    private String name;

    private Long size;

    private String path;

    private String type;

    private String extName;

    private String refBizType;

    private Long refBizId;

    private Date createTime;

    private Date modifyTime;

    private String memo;

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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName == null ? null : extName.trim();
    }

    public String getRefBizType() {
        return refBizType;
    }

    public void setRefBizType(String refBizType) {
        this.refBizType = refBizType == null ? null : refBizType.trim();
    }

    public Long getRefBizId() {
        return refBizId;
    }

    public void setRefBizId(Long refBizId) {
        this.refBizId = refBizId;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}