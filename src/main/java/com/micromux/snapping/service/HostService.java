package com.micromux.snapping.service;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.micromux.snapping.HostConfig;
import com.micromux.snapping.db.HostDao;
import com.micromux.snapping.model.Host;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Service endpoint to request information about the application. This includes the
 * version, last commit id and last time it was modified.
 */
@Path("/host")
public class HostService {

    @Inject
    protected HostDao hostDao;

    @GET
    @Produces("application/json")
    @Path("/list")
    @Timed
    public List<Host> getAllHostConfig() throws IOException {
        try {
            return hostDao.getAllHostConfig();
        } catch (SQLException sx) {
            throw new IOException("Unable to read host configurations", sx);
        }
    }

    @POST
    @Timed
    public void createHost(Host host) throws IOException {

        try {
            hostDao.create(host);
        } catch (SQLException sx) {
            throw new IOException("Unable to create host: " + host, sx);
        }
    }
}
