package com.ovtrip.plan.service;

import com.ovtrip.plan.model.dto.PlanCreateDto;
import com.ovtrip.plan.model.vo.PlanVo;
import com.ovtrip.plan.model.mapper.PlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{

    private final PlanMapper planMapper;

    @Override
    public PlanVo getPlan(int planId) throws Exception {
        return planMapper.getPlan(planId);
    }

    @Override
    public int createPlan(PlanCreateDto planCreateDto) throws Exception {
        planMapper.createPlan(planCreateDto);
        return planCreateDto.getPlanId();
    }

    @Override
    public void updatePlan(PlanVo planDto) throws Exception {

    }

    @Override
    public void deletePlan(int planId) throws Exception {

    }
}
