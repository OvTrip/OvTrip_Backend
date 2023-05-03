package com.ovtrip.plan.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlanDto {
    private int planId;
    String planTitle;
    String startDate;
    String endDate;
    String region;
    List<CourseDto> courseList;
    List<ParticipantDto> participantList;
}
