package com.ovtrip.plan.service;

import com.ovtrip.plan.model.PlanDto;
public interface PlanService {
    PlanDto getPlan(int planId) throws Exception;
    void createPlan(PlanDto planDto) throws Exception;
    void updatePlan(PlanDto planDto) throws Exception;
    void deletePlan(int planId) throws Exception;
}
