package com.ovtrip.plan.model.vo;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor     //Create Full Parameter Constructor
@Builder
@NoArgsConstructor
public class PlanUserVo {
    private Long plan_id;
    private String plan_title;
    private String region;
    private String start_date;
    private String end_date;
}
