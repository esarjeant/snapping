package com.micromux.snapping.service;

import com.codahale.metrics.annotation.Timed;
import com.micromux.snapping.ApplicationConfig;
import com.micromux.snapping.model.About;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Service endpoint to request information about the application. This includes the
 * version, last commit id and last time it was modified.
 */
@Path("/about")
public class AboutService {

    @GET
    @Produces("application/json")
    @Timed
    public About get() throws IOException {
        return ApplicationConfig.getAbout();
    }
}
