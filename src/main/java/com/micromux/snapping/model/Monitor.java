package com.micromux.snapping.model;

import java.util.Date;

/**
 * Describe a host monitor configuration. This includes the host identifier along with what is being monitored.
 */
public class Monitor {

    private String hostId;
    private MonitorType monitorType;
    private Date checkTime;
    private MonitorStatus monitorStatus;

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public MonitorType getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(MonitorType monitorType) {
        this.monitorType = monitorType;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public MonitorStatus getMonitorStatus() {
        return monitorStatus;
    }

    public void setMonitorStatus(MonitorStatus monitorStatus) {
        this.monitorStatus = monitorStatus;
    }

}
