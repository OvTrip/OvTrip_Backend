package com.ovtrip.plan.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanDto {

    @JsonProperty("visitlist")
    private List<CourseDto> visitList;

    @Getter
    @Setter
    @Builder
    public static class CourseDto {
        private String course_date;
        private String place_name;
        private String place_url;
        private String address_name;
        private String road_address_name;
        private String latitude;
        private String longitude;
    }
}
