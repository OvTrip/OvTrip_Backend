package com.ovtrip.plan.service;

import com.ovtrip.plan.model.dto.CourseCreateDto;
import com.ovtrip.plan.model.dto.CourseGetDto;
import com.ovtrip.plan.model.dto.PlanCreateDto;
import com.ovtrip.plan.model.dto.PlanTitleDto;
import com.ovtrip.plan.model.vo.CourseVo;
import com.ovtrip.plan.model.vo.PlanUserVo;
import com.ovtrip.plan.model.vo.PlanVo;

import java.util.List;

public interface PlanService {
    PlanVo getPlan(int planId) throws Exception;
    int createPlan(PlanCreateDto planCreateDto) throws Exception;
    void updatePlan(PlanVo planDto) throws Exception;
    void deletePlan(int planId) throws Exception;

    void createCourse(CourseCreateDto courseCreateDto) throws  Exception;

    List<CourseVo> getCourse(CourseGetDto courseGetDto) throws Exception;

    List<PlanUserVo> getPlanByUser(Long userId);

    void updatePlanTitle(PlanTitleDto planTitleDto);

}
