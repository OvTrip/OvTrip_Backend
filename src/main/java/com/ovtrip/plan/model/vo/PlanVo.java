package com.ovtrip.plan.model.vo;

import lombok.*;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor     //Create Full Parameter Constructor
@Builder
@NoArgsConstructor
public class PlanVo {
    private int planId;
    private String planTitle;
    private String region;
    private String startDate;
    private String endDate;
    private List<CourseVo> courseList;
    private List<ParticipantsVo> participantList;
}
