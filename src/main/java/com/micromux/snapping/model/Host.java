package com.micromux.snapping.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Describe a Host in the monitoring service.
 */
public class Host {

    private String Id;
    private String ipAddress;
    private String description;
    private Date createDate = new Date();
    private Date modifyDate = new Date();

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonFormat()
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
