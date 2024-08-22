package com.example.carefamserver.services;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;

@Service
public class CreateService {

    private final DataSource dataSource;

    public CreateService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


//    public Connection getConnection() throws SQLException {
//        HikariDataSource dataSource = null;
//        if (dataSource == null) {
//            HikariConfig config = new HikariConfig();
//            config.setJdbcUrl(DB_URL);
//            config.setUsername(DB_USER);
//            config.setPassword(DB_PASSWORD);
//
//            dataSource = new HikariDataSource(config);
//        }
//
//        return dataSource.getConnection();
//    }

    public void createSchema() {
        String sql = "CREATE SCHEMA IF NOT EXISTS `carefam`";

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

    public void dropSchema() {
        String sql = "DROP SCHEMA IF EXISTS `carefam`";

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

    public void createTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS `carefam`.`mainData` (" +
//                "시설명            TEXT   NULL,\n" +
//                "카테고리1          TEXT   NULL,\n" +
//                "카테고리2          TEXT   NULL,\n" +
//                "카테고리3          TEXT   NULL,\n" +
//                "`시도 명칭`        TEXT   NULL,\n" +
//                "`시군구 명칭`       TEXT   NULL,\n" +
//                "법정읍면동명칭        TEXT   NULL,\n" +
//                "`리 명칭`         TEXT   NULL,\n" +
//                "번지             TEXT   NULL,\n" +
//                "`도로명 이름`       TEXT   NULL,\n" +
//                "`건물 번호`        TEXT   NULL,\n" +
//                "위도             DOUBLE NULL,\n" +
//                "경도             DOUBLE NULL,\n" +
//                "우편번호           INT    NULL,\n" +
//                "도로명주소          TEXT   NULL,\n" +
//                "지번주소           TEXT   NULL,\n" +
//                "전화번호           TEXT   NULL,\n" +
//                "홈페이지           TEXT   NULL,\n" +
//                "휴무일            TEXT   NULL,\n" +
//                "운영시간           TEXT   NULL,\n" +
//                "`주차 가능여부`      TEXT   NULL,\n" +
//                "`입장(이용료)가격 정보` TEXT   NULL,\n" +
//                "`반려동물 동반 가능정보` TEXT   NULL,\n" +
//                "`반려동물 전용 정보`   TEXT   NULL,\n" +
//                "`입장 가능 동물 크기`  TEXT   NULL,\n" +
//                "`반려동물 제한사항`    TEXT   NULL,\n" +
//                "`장소(실내) 여부`    TEXT   NULL,\n" +
//                "`장소(실외)여부`     TEXT   NULL,\n" +
//                "`기본 정보_장소설명`   TEXT   NULL,\n" +
//                "`애견 동반 추가 요금`  TEXT   NULL,\n" +
//                "최종작성일          TEXT   NULL" +
//                ")";
        String sql = "CREATE TABLE IF NOT EXISTS `carefam`.`mainData` (" +
                "`name` TEXT NULL,\n" +
                "`category1` TEXT NULL,\n" +
                "`category2` TEXT NULL,\n" +
                "`category3` TEXT NULL,\n" +
                "`city` TEXT NULL,\n" +
                "`siGunGu` TEXT NULL,\n" +
                "`eupMyeonDong` TEXT NULL,\n" +
                "`li` TEXT NULL,\n" +
                "`bungi` TEXT NULL,\n" +
                "`roadName` TEXT NULL,\n" +
                "`buildingNumber` TEXT NULL,\n" +
                "`latitude` DOUBLE NULL,\n" +
                "`longitude` DOUBLE NULL,\n" +
                "`postalCode` INT NULL,\n" +
                "`roadAddress` TEXT NULL,\n" +
                "`jibunAddress` TEXT NULL,\n" +
                "`phoneNumber` TEXT NULL,\n" +
                "`website` TEXT NULL,\n" +
                "`closedDays` TEXT NULL,\n" +
                "`operatingHours` TEXT NULL,\n" +
                "`parkingAvailability` TEXT NULL,\n" +
                "`admissionFeeInfo` TEXT NULL,\n" +
                "`petAccommodationInfo` TEXT NULL,\n" +
                "`petExclusiveInfo` TEXT NULL,\n" +
                "`permissibleAnimalSize` TEXT NULL,\n" +
                "`petRestrictionInfo` TEXT NULL,\n" +
                "`indoorFacilityAvailability` TEXT NULL,\n" +
                "`outdoorFacilityAvailability` TEXT NULL,\n" +
                "`basicInfoDescription` TEXT NULL,\n" +
                "`additionalDogFee` TEXT NULL,\n" +
                "`lastUpdatedDate` TEXT NULL" +
                ")";

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
