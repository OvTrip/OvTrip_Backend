package com.ovtrip.plan.service;

import com.ovtrip.plan.model.PlanDto;
import com.ovtrip.plan.model.mapper.PlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{

    PlanMapper planMapper;

    @Override
    public PlanDto getPlan(int planId) throws Exception {
        return planMapper.getPlan(planId);
    }

    @Override
    public void createPlan(PlanDto planDto) throws Exception {

    }

    @Override
    public void updatePlan(PlanDto planDto) throws Exception {

    }

    @Override
    public void deletePlan(int planId) throws Exception {

    }
}
