package com.ovtrip.plan.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor      //Create Defalut Constructor
@AllArgsConstructor     //Create Full Parameter Constructor
public class CourseCreateDto {
    private Long courseId;
    private Long planId;
    private String courseDate;
    private String startTime;
    private String endTime;
    private String placeName;
    private String placeUrl;
    private String addressName;
    private Long latitude;
    private Long longitude;
}
