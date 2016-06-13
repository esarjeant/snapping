package com.micromux.snapping;

import java.net.InetAddress;

/**
 * Individual host configuration for SnapPing. This includes the host name/IP address along
 * with protocol and/or port number for monitoring.
 */
public class HostConfig {

    private MonitorType monitorType;
    private Integer port;
    private InetAddress ipAddr;

    public HostConfig() { /* empty constructor */ }

    public HostConfig(MonitorType monitorType, Integer port, InetAddress ipAddr) {
        this.monitorType = monitorType;
        this.port = port;
        this.ipAddr = ipAddr;
    }

    public MonitorType getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(MonitorType monitorType) {
        this.monitorType = monitorType;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public InetAddress getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(InetAddress ipAddr) {
        this.ipAddr = ipAddr;
    }
}
