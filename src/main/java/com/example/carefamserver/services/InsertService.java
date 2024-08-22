package com.example.carefamserver.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class InsertService {

    private final DataSource dataSource;

    public InsertService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Async
    protected void insertDB2(JSONArray array, int iter, Connection connection) {
        JSONArray jsonArray = array.getJSONArray(iter);
        String sql = "INSERT INTO `carefam`.`mainData` (`name`, `category1`, `category2`, `category3`, `city`," +
                "`siGunGu`, `eupMyeonDong`, `li`, `bungi`, `roadName`," +
                "`buildingNumber`, `latitude`, `longitude`, `postalCode`, `roadAddress`," +
                "`jibunAddress`, `phoneNumber`, `website`, `closedDays`, `operatingHours`," +
                "`parkingAvailability`, `admissionFeeInfo`, `petAccommodationInfo`, `petExclusiveInfo`, `permissibleAnimalSize`," +
                "`petRestrictionInfo`, `indoorFacilityAvailability`, `outdoorFacilityAvailability`, `basicInfoDescription`, `additionalDogFee`," +
                "`lastUpdatedDate`)" +
                "VALUES (?,?,?,?,?," +
                "?,?,?,?,?," +
                "?,?,?,?,?," +
                "?,?,?,?,?," +
                "?,?,?,?,?," +
                "?,?,?,?,?," +
                "?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int batchSize = 7000; // 배치 크기 설정
            int count = 0;

            for (int k = 0; k < jsonArray.length(); k++) {
                JSONArray objects = jsonArray.getJSONArray(k);
                int j = 0;
                while (j < objects.length()) {
                    JSONObject object = objects.getJSONObject(j);

                    // 데이터 설정 코드 생략
                    String name = object.optString("시설명");
                    String category1 = object.optString("카테고리1");
                    String category2 = object.optString("카테고리2");
                    String category3 = object.getString("카테고리3");
                    String city = object.optString("시도 명칭");
                    String siGunGu = object.optString("시군구 명칭");
                    String eupMyeonDong = object.optString("법정읍면동명칭");
                    String li = object.optString("리 명칭");
                    String bungi = object.optString("번지");
                    String roadName = object.optString("도로명 이름");
                    String buildingNumber = object.optString("건물 번호");
                    Double latitude = object.optDouble("위도");
                    Double longitude = object.optDouble("경도");
                    int postalCode = object.optInt("우편번호");
                    String roadAddress = object.optString("도로명주소");
                    String jibunAddress = object.optString("지번주소");
                    String phoneNumber = object.optString("전화번호");
                    String website = object.optString("홈페이지");
                    String closedDays = object.optString("휴무일");
                    String operatingHours = object.optString("운영시간");
                    String parkingAvailability = object.optString("주차 가능여부");
                    String admissionFeeInfo = object.optString("입장(이용료)가격 정보");
                    String petAccommodationInfo = object.optString("반려동물 동반 가능정보");
                    String petExclusiveInfo = object.optString("반려동물 전용 정보");
                    String permissibleAnimalSize = object.optString("입장 가능 동물 크기");
                    String petRestrictionInfo = object.optString("반려동물 제한사항");
                    String indoorFacilityAvailability = object.optString("장소(실내) 여부");
                    String outdoorFacilityAvailability = object.optString("장소(실외)여부");
                    String basicInfoDescription = object.optString("기본 정보_장소설명");
                    String additionalDogFee = object.optString("애견 동반 추가 요금");
                    String lastUpdatedDate = object.optString("최종작성일");

                    statement.setString(1, name);
                    statement.setString(2, category1);
                    statement.setString(3, category2);
                    statement.setString(4, category3);
                    statement.setString(5, city);

                    statement.setString(6, siGunGu);
                    statement.setString(7, eupMyeonDong);
                    statement.setString(8, li);
                    statement.setString(9, bungi);
                    statement.setString(10, roadName);

                    statement.setString(11, buildingNumber);
                    statement.setDouble(12, latitude);
                    statement.setDouble(13, longitude);
                    statement.setInt(14, postalCode);
                    statement.setString(15, roadAddress);

                    statement.setString(16, jibunAddress);
                    statement.setString(17, phoneNumber);
                    statement.setString(18, website);
                    statement.setString(19, closedDays);
                    statement.setString(20, operatingHours);

                    statement.setString(21, parkingAvailability);
                    statement.setString(22, admissionFeeInfo);
                    statement.setString(23, petAccommodationInfo);
                    statement.setString(24, petExclusiveInfo);
                    statement.setString(25, permissibleAnimalSize);

                    statement.setString(26, petRestrictionInfo);
                    statement.setString(27, indoorFacilityAvailability);
                    statement.setString(28, outdoorFacilityAvailability);
                    statement.setString(29, basicInfoDescription);
                    statement.setString(30, additionalDogFee);

                    statement.setString(31, lastUpdatedDate);

                    //=================================================
                    // 나머지 데이터 설정 코드 생략

                    // 배치에 SQL 문 추가
                    statement.addBatch();

//                    // 배치 크기에 도달하면 실행
//                    if (++count % batchSize == 0) {
//                        statement.executeBatch();
//                    }

                    j++;
                }

                // 남은 SQL 문 실행
                statement.executeBatch();
                statement.clearBatch();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    protected void insertDB2(JSONArray array, int iter, Connection connection) {
//        JSONArray jsonArray = array.getJSONArray(iter);
//        for (int k = 0; k < jsonArray.length(); k++) {
//
//            JSONArray objects = jsonArray.getJSONArray(k);
//            int j = 0;
//            while (j < objects.length()) {
//                JSONObject object = objects.getJSONObject(j);
//
//                String name = object.optString("시설명");
//                String category1 = object.optString("카테고리1");
//                String category2 = object.optString("카테고리2");
//                String category3 = object.getString("카테고리3");
//                String city = object.optString("시도 명칭");
//                String siGunGu = object.optString("시군구 명칭");
//                String eupMyeonDong = object.optString("법정읍면동명칭");
//                String li = object.optString("리 명칭");
//                String bungi = object.optString("번지");
//                String roadName = object.optString("도로명 이름");
//                String buildingNumber = object.optString("건물 번호");
//                Double latitude = object.optDouble("위도");
//                Double longitude = object.optDouble("경도");
//                int postalCode = object.optInt("우편번호");
//                String roadAddress = object.optString("도로명주소");
//                String jibunAddress = object.optString("지번주소");
//                String phoneNumber = object.optString("전화번호");
//                String website = object.optString("홈페이지");
//                String closedDays = object.optString("휴무일");
//                String operatingHours = object.optString("운영시간");
//                String parkingAvailability = object.optString("주차 가능여부");
//                String admissionFeeInfo = object.optString("입장(이용료)가격 정보");
//                String petAccommodationInfo = object.optString("반려동물 동반 가능정보");
//                String petExclusiveInfo = object.optString("반려동물 전용 정보");
//                String permissibleAnimalSize = object.optString("입장 가능 동물 크기");
//                String petRestrictionInfo = object.optString("반려동물 제한사항");
//                String indoorFacilityAvailability = object.optString("장소(실내) 여부");
//                String outdoorFacilityAvailability = object.optString("장소(실외)여부");
//                String basicInfoDescription = object.optString("기본 정보_장소설명");
//                String additionalDogFee = object.optString("애견 동반 추가 요금");
//                String lastUpdatedDate = object.optString("최종작성일");
//
//                String sql = "INSERT INTO `carefam`.`mainData` (`name`, `category1`, `category2`, `category3`, `city`," +
//                        "`siGunGu`, `eupMyeonDong`, `li`, `bungi`, `roadName`," +
//                        "`buildingNumber`, `latitude`, `longitude`, `postalCode`, `roadAddress`," +
//                        "`jibunAddress`, `phoneNumber`, `website`, `closedDays`, `operatingHours`," +
//                        "`parkingAvailability`, `admissionFeeInfo`, `petAccommodationInfo`, `petExclusiveInfo`, `permissibleAnimalSize`," +
//                        "`petRestrictionInfo`, `indoorFacilityAvailability`, `outdoorFacilityAvailability`, `basicInfoDescription`, `additionalDogFee`," +
//                        "`lastUpdatedDate`)" +
//                        "VALUES (?,?,?,?,?," +
//                        "?,?,?,?,?," +
//                        "?,?,?,?,?," +
//                        "?,?,?,?,?," +
//                        "?,?,?,?,?," +
//                        "?,?,?,?,?," +
//                        "?)";
//
//
//                try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                    statement.setString(1, name);
//                    statement.setString(2, category1);
//                    statement.setString(3, category2);
//                    statement.setString(4, category3);
//                    statement.setString(5, city);
//
//                    statement.setString(6, siGunGu);
//                    statement.setString(7, eupMyeonDong);
//                    statement.setString(8, li);
//                    statement.setString(9, bungi);
//                    statement.setString(10, roadName);
//
//                    statement.setString(11, buildingNumber);
//                    statement.setDouble(12, latitude);
//                    statement.setDouble(13, longitude);
//                    statement.setInt(14, postalCode);
//                    statement.setString(15, roadAddress);
//
//                    statement.setString(16, jibunAddress);
//                    statement.setString(17, phoneNumber);
//                    statement.setString(18, website);
//                    statement.setString(19, closedDays);
//                    statement.setString(20, operatingHours);
//
//                    statement.setString(21, parkingAvailability);
//                    statement.setString(22, admissionFeeInfo);
//                    statement.setString(23, petAccommodationInfo);
//                    statement.setString(24, petExclusiveInfo);
//                    statement.setString(25, permissibleAnimalSize);
//
//                    statement.setString(26, petRestrictionInfo);
//                    statement.setString(27, indoorFacilityAvailability);
//                    statement.setString(28, outdoorFacilityAvailability);
//                    statement.setString(29, basicInfoDescription);
//                    statement.setString(30, additionalDogFee);
//
//                    statement.setString(31, lastUpdatedDate);
//
//                    statement.executeUpdate();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//
//                j++;
//            }
//
//        }
//    }

    @Async
    protected void insertDB(JSONArray array, int iter, Connection connection) {
        JSONArray jsonArray = array.getJSONArray(iter);
        String sql = "INSERT INTO `carefam`.`mainData` (`name`, `category1`, `category2`, `category3`, `city`," +
                "`siGunGu`, `eupMyeonDong`, `li`, `bungi`, `roadName`," +
                "`buildingNumber`, `latitude`, `longitude`, `postalCode`, `roadAddress`," +
                "`jibunAddress`, `phoneNumber`, `website`, `closedDays`, `operatingHours`," +
                "`parkingAvailability`, `admissionFeeInfo`, `petAccommodationInfo`, `petExclusiveInfo`, `permissibleAnimalSize`," +
                "`petRestrictionInfo`, `indoorFacilityAvailability`, `outdoorFacilityAvailability`, `basicInfoDescription`, `additionalDogFee`," +
                "`lastUpdatedDate`)" +
                "SELECT ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                "FROM dual " +
                "WHERE NOT EXISTS " +
                "(SELECT `name`, `roadAddress`, `lastUpdatedDate`" +
                "FROM `carefam`.`mainData`" +
                "WHERE `name`=? AND `category1`=? AND `category2`=? AND `category3`=? AND `city`=? AND" +
                "`siGunGu`=? AND `eupMyeonDong`=? AND `li`=? AND `bungi`=? AND `roadName`=? AND" +
                "`buildingNumber`=? AND `latitude`=? AND `longitude`=? AND `postalCode`=? AND `roadAddress`=? AND" +
                "`jibunAddress`=? AND `phoneNumber`=? AND `website`=? AND `closedDays`=? AND `operatingHours`=? AND" +
                "`parkingAvailability`=? AND `admissionFeeInfo`=? AND `petAccommodationInfo`=? AND `petExclusiveInfo`=? AND `permissibleAnimalSize`=? AND" +
                "`petRestrictionInfo`=? AND `indoorFacilityAvailability`=? AND `outdoorFacilityAvailability`=? AND `basicInfoDescription`=? AND `additionalDogFee`=? AND" +
                "`lastUpdatedDate`=?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int batchSize = 100; // 배치 크기 설정
            int count = 0;

            for (int k = 0; k < jsonArray.length(); k++) {
                JSONArray objects = jsonArray.getJSONArray(k);
                int j = 0;
                while (j < objects.length()) {
                    JSONObject object = objects.getJSONObject(j);

                    // 데이터 설정 코드 생략
                    String name = object.optString("시설명");
                    String category1 = object.optString("카테고리1");
                    String category2 = object.optString("카테고리2");
                    String category3 = object.getString("카테고리3");
                    String city = object.optString("시도 명칭");
                    String siGunGu = object.optString("시군구 명칭");
                    String eupMyeonDong = object.optString("법정읍면동명칭");
                    String li = object.optString("리 명칭");
                    String bungi = object.optString("번지");
                    String roadName = object.optString("도로명 이름");
                    String buildingNumber = object.optString("건물 번호");
                    Double latitude = object.optDouble("위도");
                    Double longitude = object.optDouble("경도");
                    int postalCode = object.optInt("우편번호");
                    String roadAddress = object.optString("도로명주소");
                    String jibunAddress = object.optString("지번주소");
                    String phoneNumber = object.optString("전화번호");
                    String website = object.optString("홈페이지");
                    String closedDays = object.optString("휴무일");
                    String operatingHours = object.optString("운영시간");
                    String parkingAvailability = object.optString("주차 가능여부");
                    String admissionFeeInfo = object.optString("입장(이용료)가격 정보");
                    String petAccommodationInfo = object.optString("반려동물 동반 가능정보");
                    String petExclusiveInfo = object.optString("반려동물 전용 정보");
                    String permissibleAnimalSize = object.optString("입장 가능 동물 크기");
                    String petRestrictionInfo = object.optString("반려동물 제한사항");
                    String indoorFacilityAvailability = object.optString("장소(실내) 여부");
                    String outdoorFacilityAvailability = object.optString("장소(실외)여부");
                    String basicInfoDescription = object.optString("기본 정보_장소설명");
                    String additionalDogFee = object.optString("애견 동반 추가 요금");
                    String lastUpdatedDate = object.optString("최종작성일");

                    statement.setString(1, name);
                    statement.setString(2, category1);
                    statement.setString(3, category2);
                    statement.setString(4, category3);
                    statement.setString(5, city);

                    statement.setString(6, siGunGu);
                    statement.setString(7, eupMyeonDong);
                    statement.setString(8, li);
                    statement.setString(9, bungi);
                    statement.setString(10, roadName);

                    statement.setString(11, buildingNumber);
                    statement.setDouble(12, latitude);
                    statement.setDouble(13, longitude);
                    statement.setInt(14, postalCode);
                    statement.setString(15, roadAddress);

                    statement.setString(16, jibunAddress);
                    statement.setString(17, phoneNumber);
                    statement.setString(18, website);
                    statement.setString(19, closedDays);
                    statement.setString(20, operatingHours);

                    statement.setString(21, parkingAvailability);
                    statement.setString(22, admissionFeeInfo);
                    statement.setString(23, petAccommodationInfo);
                    statement.setString(24, petExclusiveInfo);
                    statement.setString(25, permissibleAnimalSize);

                    statement.setString(26, petRestrictionInfo);
                    statement.setString(27, indoorFacilityAvailability);
                    statement.setString(28, outdoorFacilityAvailability);
                    statement.setString(29, basicInfoDescription);
                    statement.setString(30, additionalDogFee);

                    statement.setString(31, lastUpdatedDate);

                    //=================================================

                    statement.setString(32, name);
                    statement.setString(33, category1);
                    statement.setString(34, category2);
                    statement.setString(35, category3);
                    statement.setString(36, city);

                    statement.setString(37, siGunGu);
                    statement.setString(38, eupMyeonDong);
                    statement.setString(39, li);
                    statement.setString(40, bungi);
                    statement.setString(41, roadName);

                    statement.setString(42, buildingNumber);
                    statement.setDouble(43, latitude);
                    statement.setDouble(44, longitude);
                    statement.setInt(45, postalCode);
                    statement.setString(46, roadAddress);

                    statement.setString(47, jibunAddress);
                    statement.setString(48, phoneNumber);
                    statement.setString(49, website);
                    statement.setString(50, closedDays);
                    statement.setString(51, operatingHours);

                    statement.setString(52, parkingAvailability);
                    statement.setString(53, admissionFeeInfo);
                    statement.setString(54, petAccommodationInfo);
                    statement.setString(55, petExclusiveInfo);
                    statement.setString(56, permissibleAnimalSize);

                    statement.setString(57, petRestrictionInfo);
                    statement.setString(58, indoorFacilityAvailability);
                    statement.setString(59, outdoorFacilityAvailability);
                    statement.setString(60, basicInfoDescription);
                    statement.setString(61, additionalDogFee);

                    statement.setString(62, lastUpdatedDate);
                    // 나머지 데이터 설정 코드 생략

                    // 배치에 SQL 문 추가
                    statement.addBatch();

                    // 배치 크기에 도달하면 실행
                    if (++count % batchSize == 0) {
                        statement.executeBatch();
                    }

                    j++;
                }
            }

            // 남은 SQL 문 실행
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    protected void insertDB(JSONArray array, int iter, Connection connection) {
//        JSONArray jsonArray = array.getJSONArray(iter);
//        for (int k = 0; k < jsonArray.length(); k++) {
//
//            JSONArray objects = jsonArray.getJSONArray(k);
//            int j = 0;
//            while (j < objects.length()) {
//                JSONObject object = objects.getJSONObject(j);
//
//                String name = object.optString("시설명");
//                String category1 =  object.optString("카테고리1");
//                String category2 =  object.optString("카테고리2");
//                String category3 = object.getString("카테고리3");
//                String city =  object.optString("시도 명칭");
//                String siGunGu =  object.optString("시군구 명칭");
//                String eupMyeonDong =  object.optString("법정읍면동명칭");
//                String li =  object.optString("리 명칭");
//                String bungi =  object.optString("번지");
//                String roadName =  object.optString("도로명 이름");
//                String buildingNumber =  object.optString("건물 번호");
//                Double latitude =  object.optDouble("위도");
//                Double longitude =  object.optDouble("경도");
//                int postalCode =  object.optInt("우편번호");
//                String roadAddress =  object.optString("도로명주소");
//                String jibunAddress =  object.optString("지번주소");
//                String phoneNumber =  object.optString("전화번호");
//                String website =  object.optString("홈페이지");
//                String closedDays =  object.optString("휴무일");
//                String operatingHours =  object.optString("운영시간");
//                String parkingAvailability =  object.optString("주차 가능여부");
//                String admissionFeeInfo =  object.optString("입장(이용료)가격 정보");
//                String petAccommodationInfo =  object.optString("반려동물 동반 가능정보");
//                String petExclusiveInfo =  object.optString("반려동물 전용 정보");
//                String permissibleAnimalSize =  object.optString("입장 가능 동물 크기");
//                String petRestrictionInfo =  object.optString("반려동물 제한사항");
//                String indoorFacilityAvailability =  object.optString("장소(실내) 여부");
//                String outdoorFacilityAvailability =  object.optString("장소(실외)여부");
//                String basicInfoDescription =  object.optString("기본 정보_장소설명");
//                String additionalDogFee =  object.optString("애견 동반 추가 요금");
//                String lastUpdatedDate =  object.optString("최종작성일");
//
//                String sql = "INSERT INTO `carefam`.`mainData` (`name`, `category1`, `category2`, `category3`, `city`," +
//                        "`siGunGu`, `eupMyeonDong`, `li`, `bungi`, `roadName`," +
//                        "`buildingNumber`, `latitude`, `longitude`, `postalCode`, `roadAddress`," +
//                        "`jibunAddress`, `phoneNumber`, `website`, `closedDays`, `operatingHours`," +
//                        "`parkingAvailability`, `admissionFeeInfo`, `petAccommodationInfo`, `petExclusiveInfo`, `permissibleAnimalSize`," +
//                        "`petRestrictionInfo`, `indoorFacilityAvailability`, `outdoorFacilityAvailability`, `basicInfoDescription`, `additionalDogFee`," +
//                        "`lastUpdatedDate`)"+
//                        "SELECT ?,?,?,?,?," +
//                        "?,?,?,?,?," +
//                        "?,?,?,?,?," +
//                        "?,?,?,?,?," +
//                        "?,?,?,?,?," +
//                        "?,?,?,?,?," +
//                        "?" +
//                        "FROM dual " +
//                        "WHERE NOT EXISTS " +
//                        "(SELECT `name`, `roadAddress`, `lastUpdatedDate`" +
//                        "FROM `carefam`.`mainData`" +
//                        "WHERE `name`=? AND `category1`=? AND `category2`=? AND `category3`=? AND `city`=? AND" +
//                        "`siGunGu`=? AND `eupMyeonDong`=? AND `li`=? AND `bungi`=? AND `roadName`=? AND" +
//                        "`buildingNumber`=? AND `latitude`=? AND `longitude`=? AND `postalCode`=? AND `roadAddress`=? AND" +
//                        "`jibunAddress`=? AND `phoneNumber`=? AND `website`=? AND `closedDays`=? AND `operatingHours`=? AND" +
//                        "`parkingAvailability`=? AND `admissionFeeInfo`=? AND `petAccommodationInfo`=? AND `petExclusiveInfo`=? AND `permissibleAnimalSize`=? AND" +
//                        "`petRestrictionInfo`=? AND `indoorFacilityAvailability`=? AND `outdoorFacilityAvailability`=? AND `basicInfoDescription`=? AND `additionalDogFee`=? AND" +
//                        "`lastUpdatedDate`=?)";
//
//
//
//                try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                    statement.setString(1, name);
//                    statement.setString(2, category1);
//                    statement.setString(3, category2);
//                    statement.setString(4, category3);
//                    statement.setString(5, city);
//
//                    statement.setString(6, siGunGu);
//                    statement.setString(7, eupMyeonDong);
//                    statement.setString(8, li);
//                    statement.setString(9, bungi);
//                    statement.setString(10, roadName);
//
//                    statement.setString(11, buildingNumber);
//                    statement.setDouble(12, latitude);
//                    statement.setDouble(13, longitude);
//                    statement.setInt(14, postalCode);
//                    statement.setString(15, roadAddress);
//
//                    statement.setString(16, jibunAddress);
//                    statement.setString(17, phoneNumber);
//                    statement.setString(18, website);
//                    statement.setString(19, closedDays);
//                    statement.setString(20, operatingHours);
//
//                    statement.setString(21, parkingAvailability);
//                    statement.setString(22, admissionFeeInfo);
//                    statement.setString(23, petAccommodationInfo);
//                    statement.setString(24, petExclusiveInfo);
//                    statement.setString(25, permissibleAnimalSize);
//
//                    statement.setString(26, petRestrictionInfo);
//                    statement.setString(27, indoorFacilityAvailability);
//                    statement.setString(28, outdoorFacilityAvailability);
//                    statement.setString(29, basicInfoDescription);
//                    statement.setString(30, additionalDogFee);
//
//                    statement.setString(31, lastUpdatedDate);
//
//                    //=================================================
//
//                    statement.setString(32, name);
//                    statement.setString(33, category1);
//                    statement.setString(34, category2);
//                    statement.setString(35, category3);
//                    statement.setString(36, city);
//
//                    statement.setString(37, siGunGu);
//                    statement.setString(38, eupMyeonDong);
//                    statement.setString(39, li);
//                    statement.setString(40, bungi);
//                    statement.setString(41, roadName);
//
//                    statement.setString(42, buildingNumber);
//                    statement.setDouble(43, latitude);
//                    statement.setDouble(44, longitude);
//                    statement.setInt(45, postalCode);
//                    statement.setString(46, roadAddress);
//
//                    statement.setString(47, jibunAddress);
//                    statement.setString(48, phoneNumber);
//                    statement.setString(49, website);
//                    statement.setString(50, closedDays);
//                    statement.setString(51, operatingHours);
//
//                    statement.setString(52, parkingAvailability);
//                    statement.setString(53, admissionFeeInfo);
//                    statement.setString(54, petAccommodationInfo);
//                    statement.setString(55, petExclusiveInfo);
//                    statement.setString(56, permissibleAnimalSize);
//
//                    statement.setString(57, petRestrictionInfo);
//                    statement.setString(58, indoorFacilityAvailability);
//                    statement.setString(59, outdoorFacilityAvailability);
//                    statement.setString(60, basicInfoDescription);
//                    statement.setString(61, additionalDogFee);
//
//                    statement.setString(62, lastUpdatedDate);
//
//                    statement.executeUpdate();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//
//                j++;
//            }
//
//        }
//    }

    @Async
    public void saveDataToDB() throws IOException {
        JSONArray array = new JSONArray();
        for (int i = 1; i < 7; i++) {
            array.put(makeDataJsonArray(i));
        }

        Connection connection = null;
        try {
            connection = getConnection();
            for (int i = 0; i < 6; i++) {
                insertDB2(array, i, connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // 처리할 예외
                }
            }
        }

    }

    @Async
    public void saveDataToDB2() throws IOException {
        JSONArray array = new JSONArray();
        for (int i = 7; i < 13; i++) {
            array.put(makeDataJsonArray(i));
        }

        Connection connection = null;
        try {
            connection = getConnection();
            for (int i = 0; i < 6; i++) {
                insertDB2(array, i, connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // 처리할 예외
                }
            }
        }

//        Connection connection = null;
//        try {
//            connection = getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        for (int i = 0; i < 6; i++) {
//            insertDB2(array, i, connection);
//        }
    }

    @Async
    public void saveDataToDB3() throws IOException {
        JSONArray array = new JSONArray();
        for (int i = 13; i < 19; i++) {
            array.put(makeDataJsonArray(i));
        }

        Connection connection = null;
        try {
            connection = getConnection();
            for (int i = 0; i < 6; i++) {
                insertDB2(array, i, connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // 처리할 예외
                }
            }
        }

//        Connection connection = null;
//        try {
//            connection = getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        for (int i = 0; i < 6; i++) {
//            insertDB2(array, i, connection);
//        }
    }

    @Async
    public void saveDataToDB4() throws IOException {
        JSONArray array = new JSONArray();
        for (int i = 19; i < 25; i++) {
            array.put(makeDataJsonArray(i));
        }

        Connection connection = null;
        try {
            connection = getConnection();
            for (int i = 0; i < 6; i++) {
                insertDB2(array, i, connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // 처리할 예외
                }
            }
        }

//        Connection connection = null;
//        try {
//            connection = getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        for (int i = 0; i < 7; i++) {
//            insertDB2(array, i, connection);
//        }
    }

    @Async
    public void saveDataToDB5() throws IOException {
        JSONArray array = new JSONArray();
        for (int i = 0; i < 25; i++) {
            array.put(makeDataJsonArray(i));
        }

        Connection connection = null;
        try {
            connection = getConnection();
            for (int i = 0; i < 25; i++) {
                insertDB2(array, i, connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // 처리할 예외
                }
            }
        }

//        Connection connection = null;
//        try {
//            connection = getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        for (int i = 0; i < 25; i++) {
//            insertDB(array, i, connection);
//        }
    }

    public String makeApiLine(int page) throws IOException {
        URL url = new URL("https://api.odcloud.kr/api/15111389/v1/uddi:41944402-8249-4e45-9e9d-a52d0a7db1cc?" +
                "page=" + page +
                "&perPage=" + 1000 +
                "&serviceKey=YUXEkrLM8%2FqHVVd7JvSH%2Fh1YgYXuyR3dP0%2BXDQ6M5syv2c4YqUHYvEom%2BrgRtSpZLpFHbuldA6lGEmrba9kErg%3D%3D");

        URLConnection urlConnection = url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }

    public JSONArray makeDataJsonArray(int page) throws IOException {
        JSONArray dataArray = new JSONArray();

        String line = makeApiLine(page);
        JSONObject object = new JSONObject(line);
        dataArray.put(object.getJSONArray("data"));


        return dataArray;
    }


}
