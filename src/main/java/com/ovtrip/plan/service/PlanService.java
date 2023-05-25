package com.ovtrip.plan.service;

import com.ovtrip.plan.model.dto.PlanCreateDto;
import com.ovtrip.plan.model.vo.PlanVo;
public interface PlanService {
    PlanVo getPlan(int planId) throws Exception;
    int createPlan(PlanCreateDto planCreateDto) throws Exception;
    void updatePlan(PlanVo planDto) throws Exception;
    void deletePlan(int planId) throws Exception;
}
