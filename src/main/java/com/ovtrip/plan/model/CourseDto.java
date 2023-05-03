package com.ovtrip.plan.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    private int courseId;
    private String courseDate;
    private String startTime;
    private String endTime;
    private String placeName;
    private String placeUrl;
    private String addressName;     //지번 주소 -> default
    private String roadAddressName; //도로명 주소 -> 지번주소 없을 시 도로명 주소
    private String latitude;
    private String longitude;

}
