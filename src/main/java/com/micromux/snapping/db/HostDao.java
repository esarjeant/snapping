package com.micromux.snapping.db;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.micromux.snapping.model.Host;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Host data operations.
 */
@Singleton
public class HostDao {

    @Inject
    private DataSource dataSource;

    public List<Host> getAllHostConfig() throws SQLException {

        List<Host> hostConfigList = new LinkedList<>();

        try (Connection conn = dataSource.getConnection()) {

            PreparedStatement statement = conn.prepareStatement("select host_id, ip_addr, description, create_date, modify_date from APP.hosts");
            ResultSet rst = statement.executeQuery();

            while (rst.next()) {
                Host host = new Host();
                host.setId(rst.getString("host_id"));
                host.setIpAddress(rst.getString("ip_addr"));
                host.setDescription(rst.getString("description"));
                host.setCreateDate(rst.getTimestamp("create_date"));
                host.setModifyDate(rst.getTimestamp("modify_date"));

                hostConfigList.add(host);
            }
        }

        return hostConfigList;

    }

    public void create(Host host) throws SQLException {

        try (Connection conn = dataSource.getConnection()) {

            PreparedStatement statement = conn.prepareStatement("insert into APP.hosts(host_id, ip_addr, description, create_date, modify_date) values(?,?,?,?,?)");
            statement.setString(1, host.getId());
            statement.setString(2, host.getIpAddress());
            statement.setString(3, host.getDescription());
            statement.setTimestamp(4, new Timestamp(host.getCreateDate().getTime()));
            statement.setTimestamp(5, new Timestamp(host.getModifyDate().getTime()));

            statement.execute();

        }

    }
}
