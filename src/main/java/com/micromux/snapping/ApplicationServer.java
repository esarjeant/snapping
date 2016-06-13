package com.micromux.snapping;

import com.micromux.snapping.service.AboutService;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * Server application instance for Undertow. Use this to start / stop the servlet deployment for the endpoints
 * used to monitor.
 */
public class ApplicationServer extends Application<ApplicationServer.ApplicationConfiguration> {

    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().packages("com.micromux.snapping.service");
    }

    @Override
    public String getName() {
        return "snapping";
    }

    /**
     * Empty configuration, this reads from the application database.
     */
    public static class ApplicationConfiguration extends Configuration {}

}
