package com.micromux.snapping;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.micromux.snapping.service.AboutService;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.sql.DriverManager;

/**
 * Server application instance for Undertow. Use this to start / stop the servlet deployment for the endpoints
 * used to monitor.
 */
public class ApplicationServer extends Application<ApplicationServer.ApplicationConfiguration> {

    private GuiceBundle<ApplicationConfiguration> guiceBundle;

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {

        // register GUICE
        guiceBundle = GuiceBundle.<ApplicationConfiguration>newBuilder()
                .addModule(new ServerModule())
                .enableAutoConfig("com.micromux.snapping.db")
                .setConfigClass(ApplicationConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);

    }

    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {

        // startup Derby database
        DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());

        // register JAX-RS service endpoints
        environment.jersey().packages("com.micromux.snapping.service");
        environment.getObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

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
