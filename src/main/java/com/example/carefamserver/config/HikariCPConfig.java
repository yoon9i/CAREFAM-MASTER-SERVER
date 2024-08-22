package com.example.carefamserver.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCPConfig {
    private static final String DB_URL = "jdbc:mariadb://localhost:33063";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DB_URL);
        config.setUsername(DB_USER);
        config.setPassword(DB_PASSWORD);

        return new HikariDataSource(config);
    }
}
