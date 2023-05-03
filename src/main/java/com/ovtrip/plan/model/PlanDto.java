package com.ovtrip.plan.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanDto {
    private int planId;
    private int userId;
    String startDate;
    String endDate;
    String region;
    String planTitle;
}
