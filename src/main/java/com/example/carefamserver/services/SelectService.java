package com.example.carefamserver.services;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;

@Service
public class SelectService {
    private final DataSource dataSource;

    public SelectService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void selectAll() {
        String sql = "SELECT * FROM `CAREFAM`.`mainData` LIMIT 10";

        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.execute(sql);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // 처리할 예외
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // 처리할 예외
                }
            }
        }
    }
}
