package com.ovtrip.plan.service;

import com.ovtrip.plan.model.vo.PlanVo;
public interface PlanService {
    PlanVo getPlan(int planId) throws Exception;
    void createPlan(PlanVo planDto) throws Exception;
    void updatePlan(PlanVo planDto) throws Exception;
    void deletePlan(int planId) throws Exception;
}
