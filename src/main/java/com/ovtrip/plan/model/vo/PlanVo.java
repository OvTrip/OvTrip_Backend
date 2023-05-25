package com.ovtrip.plan.model.vo;

import lombok.*;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor     //Create Full Parameter Constructor
public class PlanVo {
    private final int planId;
    private final String planTitle;
    private final String startDate;
    private final String endDate;
    private final String region;
    private final List<CourseVo> courseList;
    private final List<ParticipantsVo> participantList;
}
