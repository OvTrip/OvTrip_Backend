package com.ovtrip.plan.model.vo;

import lombok.*;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor      //Create Defalut Constructor
@AllArgsConstructor     //Create Full Parameter Constructor
public class PlanVo {
    private int planId;
    String planTitle;
    String startDate;
    String endDate;
    String region;
    List<CourseVo> courseList;
    List<ParticipantsVo> participantList;
}
