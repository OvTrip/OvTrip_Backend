package com.ovtrip.plan.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor      //Create Defalut Constructor
@AllArgsConstructor     //Create Full Parameter Constructor
@Builder
public class CourseCreateDto {
    private Long courseId;
    private Long planId;
    private String courseDate;
    private String placeName;
    private String placeUrl;
    private String addressName;
    private String roadAddressName;
    private String latitude;
    private String longitude;
}
