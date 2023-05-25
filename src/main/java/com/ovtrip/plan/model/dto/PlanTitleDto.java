package com.ovtrip.plan.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanTitleDto {
    private Long planId;
    private String title;

    @Builder
    public PlanTitleDto(Long planId, String title) {
        this.planId = planId;
        this.title = title;
    }
}
