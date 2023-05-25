package com.ovtrip.plan.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor      //Create Defalut Constructor
@AllArgsConstructor     //Create Full Parameter Constructor
public class PlanCreateDto {
    private int planId;
    private String userId;
    private String startDate;
    private String endDate;
    private String region;
}
