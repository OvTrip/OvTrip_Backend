package com.ovtrip.plan.service;

import com.ovtrip.plan.model.dto.CourseCreateDto;
import com.ovtrip.plan.model.dto.CourseGetDto;
import com.ovtrip.plan.model.dto.PlanCreateDto;
import com.ovtrip.plan.model.dto.PlanTitleDto;
import com.ovtrip.plan.model.vo.CourseVo;
import com.ovtrip.plan.model.vo.PlanUserVo;
import com.ovtrip.plan.model.vo.PlanVo;
import com.ovtrip.plan.model.mapper.PlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void createCourse(CourseCreateDto courseCreateDto) throws Exception {
        planMapper.createCourse(courseCreateDto);
    }

    @Override
    public List<CourseVo> getCourse(CourseGetDto courseGetDto) throws Exception {
        return planMapper.getCourse(courseGetDto);
    }

    @Override
    public List<PlanUserVo> getPlanByUser(Long userId) {
        return planMapper.getPlanByUser(userId);
    }

    @Override
    public void updatePlanTitle(PlanTitleDto planTitleDto) {
        planMapper.updatePlanTitle(planTitleDto);
    }
}
