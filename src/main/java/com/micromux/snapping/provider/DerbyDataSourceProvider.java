package com.micromux.snapping.provider;

import com.google.inject.Provider;
import com.google.inject.Singleton;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * Provider for the datasource connection. This is declared with Singleton scope inside the application,
 * there should only be one instance of this.
 */
@Singleton
public class DerbyDataSourceProvider implements Provider<DataSource> {

    @Override
    public DataSource get() {

        String homePath = System.getProperty("user.home");
        String url = String.format("jdbc:derby:%s/.snapping/db;create=true", homePath);

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(org.apache.derby.jdbc.EmbeddedDriver.class.getName());
        dataSource.setUrl(url);

        return dataSource;

    }
}
