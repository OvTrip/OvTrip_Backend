package com.ovtrip.plan.model.vo;

import lombok.*;

@Getter
@AllArgsConstructor     //Create Full Parameter Constructor
public class CourseVo {
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
