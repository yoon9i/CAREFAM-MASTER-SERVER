package com.example.carefamserver.repository;

import org.json.JSONObject;

public class ApiResponse {
    private String name;
    private String category1;
    private String category2;
    private String category3;
    private String city;
    private String siGunGu;
    private String eupMyeonDong;
    private String li;
    private String bungi;
    private String roadName;
    private String buildingNumber;
    private String latitude;
    private String longitude;
    private Integer postalCode;
    private String roadAddress;
    private String jibunAddress;
    private String phoneNumber;
    private String website;
    private String closedDays;
    private String operatingHours;
    private String parkingAvailability;
    private String admissionFeeInfo;
    private String petAccommodationInfo;
    private String petExclusiveInfo;
    private String permissibleAnimalSize;
    private String petRestrictionInfo;
    private String indoorFacilityAvailability;
    private String outdoorFacilityAvailability;
    private String basicInfoDescription;
    private String additionalDogFee;
    private String lastUpdatedDate;


    public  ApiResponse(JSONObject json) {
        this.name = json.optString("시설명");
        this.category1 =  json.optString("카테고리1");
        this.category2 =  json.optString("카테고리2");
        this.category3 =  json.optString("카테고리3");
        this.city =  json.optString("시도 명칭");
        this.siGunGu =  json.optString("시군구 명칭");
        this.eupMyeonDong =  json.optString("법정읍면동명칭");
        this.li =  json.optString("리 명칭");
        this.bungi =  json.optString("번지");
        this.roadName =  json.optString("도로명 이름");
        this.buildingNumber =  json.optString("건물 번호");
        this.latitude =  json.optString("위도");
        this.longitude =  json.optString("경도");
        this.postalCode =  json.optInt("우편번호");
        this.roadAddress =  json.optString("도로명주소");
        this.jibunAddress =  json.optString("지번주소");
        this.phoneNumber =  json.optString("전화번호");
        this.website =  json.optString("홈페이지");
        this.closedDays =  json.optString("휴무일");
        this.operatingHours =  json.optString("운영시간");
        this.parkingAvailability =  json.optString("주차 가능여부");
        this.admissionFeeInfo =  json.optString("입장(이용료)가격 정보");
        this.petAccommodationInfo =  json.optString("반려동물 동반 가능정보");
        this.petExclusiveInfo =  json.optString("반려동물 전용 정보");
        this.permissibleAnimalSize =  json.optString("입장 가능 동물 크기");
        this.petRestrictionInfo =  json.optString("반려동물 제한사항");
        this.indoorFacilityAvailability =  json.optString("장소(실내) 여부");
        this.outdoorFacilityAvailability =  json.optString("장소(실외)여부");
        this.basicInfoDescription =  json.optString("기본 정보_장소설명");
        this.additionalDogFee =  json.optString("애견 동반 추가 요금");
        this.lastUpdatedDate =  json.optString("최종작성일");
    }

    // Constructors, getters, and setters

    public ApiResponse(String name, String category1, String category2, String category3, String city, String siGunGu, String eupMyeonDong, String li, String bungi, String roadName, String buildingNumber, String latitude, String longitude, Integer postalCode, String roadAddress, String jibunAddress, String phoneNumber, String website, String closedDays, String operatingHours, String parkingAvailability, String admissionFeeInfo, String petAccommodationInfo, String petExclusiveInfo, String permissibleAnimalSize, String petRestrictionInfo, String indoorFacilityAvailability, String outdoorFacilityAvailability, String basicInfoDescription, String additionalDogFee, String lastUpdatedDate) {
        this.name = name;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.city = city;
        this.siGunGu = siGunGu;
        this.eupMyeonDong = eupMyeonDong;
        this.li = li;
        this.bungi = bungi;
        this.roadName = roadName;
        this.buildingNumber = buildingNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
        this.roadAddress = roadAddress;
        this.jibunAddress = jibunAddress;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.closedDays = closedDays;
        this.operatingHours = operatingHours;
        this.parkingAvailability = parkingAvailability;
        this.admissionFeeInfo = admissionFeeInfo;
        this.petAccommodationInfo = petAccommodationInfo;
        this.petExclusiveInfo = petExclusiveInfo;
        this.permissibleAnimalSize = permissibleAnimalSize;
        this.petRestrictionInfo = petRestrictionInfo;
        this.indoorFacilityAvailability = indoorFacilityAvailability;
        this.outdoorFacilityAvailability = outdoorFacilityAvailability;
        this.basicInfoDescription = basicInfoDescription;
        this.additionalDogFee = additionalDogFee;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getName() {
        return name;
    }

    public ApiResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory1() {
        return category1;
    }

    public ApiResponse setCategory1(String category1) {
        this.category1 = category1;
        return this;
    }

    public String getCategory2() {
        return category2;
    }

    public ApiResponse setCategory2(String category2) {
        this.category2 = category2;
        return this;
    }

    public String getCategory3() {
        return category3;
    }

    public ApiResponse setCategory3(String category3) {
        this.category3 = category3;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ApiResponse setCity(String city) {
        this.city = city;
        return this;
    }

    public String getSiGunGu() {
        return siGunGu;
    }

    public ApiResponse setSiGunGu(String siGunGu) {
        this.siGunGu = siGunGu;
        return this;
    }

    public String getEupMyeonDong() {
        return eupMyeonDong;
    }

    public ApiResponse setEupMyeonDong(String eupMyeonDong) {
        this.eupMyeonDong = eupMyeonDong;
        return this;
    }

    public String getLi() {
        return li;
    }

    public ApiResponse setLi(String li) {
        this.li = li;
        return this;
    }

    public String getBungi() {
        return bungi;
    }

    public ApiResponse setBungi(String bungi) {
        this.bungi = bungi;
        return this;
    }

    public String getRoadName() {
        return roadName;
    }

    public ApiResponse setRoadName(String roadName) {
        this.roadName = roadName;
        return this;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public ApiResponse setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public ApiResponse setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public ApiResponse setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public ApiResponse setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public ApiResponse setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
        return this;
    }

    public String getJibunAddress() {
        return jibunAddress;
    }

    public ApiResponse setJibunAddress(String jibunAddress) {
        this.jibunAddress = jibunAddress;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ApiResponse setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public ApiResponse setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getClosedDays() {
        return closedDays;
    }

    public ApiResponse setClosedDays(String closedDays) {
        this.closedDays = closedDays;
        return this;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public ApiResponse setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
        return this;
    }

    public String getParkingAvailability() {
        return parkingAvailability;
    }

    public ApiResponse setParkingAvailability(String parkingAvailability) {
        this.parkingAvailability = parkingAvailability;
        return this;
    }

    public String getAdmissionFeeInfo() {
        return admissionFeeInfo;
    }

    public ApiResponse setAdmissionFeeInfo(String admissionFeeInfo) {
        this.admissionFeeInfo = admissionFeeInfo;
        return this;
    }

    public String getPetAccommodationInfo() {
        return petAccommodationInfo;
    }

    public ApiResponse setPetAccommodationInfo(String petAccommodationInfo) {
        this.petAccommodationInfo = petAccommodationInfo;
        return this;
    }

    public String getPetExclusiveInfo() {
        return petExclusiveInfo;
    }

    public ApiResponse setPetExclusiveInfo(String petExclusiveInfo) {
        this.petExclusiveInfo = petExclusiveInfo;
        return this;
    }

    public String getPermissibleAnimalSize() {
        return permissibleAnimalSize;
    }

    public ApiResponse setPermissibleAnimalSize(String permissibleAnimalSize) {
        this.permissibleAnimalSize = permissibleAnimalSize;
        return this;
    }

    public String getPetRestrictionInfo() {
        return petRestrictionInfo;
    }

    public ApiResponse setPetRestrictionInfo(String petRestrictionInfo) {
        this.petRestrictionInfo = petRestrictionInfo;
        return this;
    }

    public String getIndoorFacilityAvailability() {
        return indoorFacilityAvailability;
    }

    public ApiResponse setIndoorFacilityAvailability(String indoorFacilityAvailability) {
        this.indoorFacilityAvailability = indoorFacilityAvailability;
        return this;
    }

    public String getOutdoorFacilityAvailability() {
        return outdoorFacilityAvailability;
    }

    public ApiResponse setOutdoorFacilityAvailability(String outdoorFacilityAvailability) {
        this.outdoorFacilityAvailability = outdoorFacilityAvailability;
        return this;
    }

    public String getBasicInfoDescription() {
        return basicInfoDescription;
    }

    public ApiResponse setBasicInfoDescription(String basicInfoDescription) {
        this.basicInfoDescription = basicInfoDescription;
        return this;
    }

    public String getAdditionalDogFee() {
        return additionalDogFee;
    }

    public ApiResponse setAdditionalDogFee(String additionalDogFee) {
        this.additionalDogFee = additionalDogFee;
        return this;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public ApiResponse setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
        return this;
    }
}
