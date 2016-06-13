package com.micromux.snapping;

import com.micromux.snapping.model.About;

/**
 * Console application for SnapPing system monitor. This application allows a user
 * to monitor one or more hosts for either ICMP or a specific port number and TCPv4
 * protocol.
 */
public class Server {

    public static void main(String[] args) throws Exception {

        About about = ApplicationConfig.getAbout();
        System.out.println(String.format("%s %s Server (%s)", about.getName(), about.getVersion(), about.getCommitTime()));

        new ApplicationServer().run(args);
    }
}
