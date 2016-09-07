package com.micromux.snapping;

import com.google.inject.AbstractModule;
import com.micromux.snapping.db.HostDao;
import com.micromux.snapping.provider.DerbyDataSourceProvider;

import javax.sql.DataSource;

/**
 * Bindings for injection.
 */
public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DataSource.class).toProvider(DerbyDataSourceProvider.class);
    }
}
