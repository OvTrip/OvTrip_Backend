package com.ovtrip.plan.model.vo;

import lombok.*;

@Getter
@AllArgsConstructor     //Create Full Parameter Constructor
public class CourseVo {
    private final int courseId;
    private final String courseDate;
    private final String startTime;
    private final String endTime;
    private final String placeName;
    private final String placeUrl;
    private final String addressName;     //지번 주소 -> default
    private final String roadAddressName; //도로명 주소 -> 지번주소 없을 시 도로명 주소
    private final String latitude;
    private final String longitude;

}
