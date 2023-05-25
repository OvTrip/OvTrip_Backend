package com.ovtrip.plan.model.mapper;

import com.ovtrip.plan.model.dto.CourseCreateDto;
import com.ovtrip.plan.model.dto.CourseGetDto;
import com.ovtrip.plan.model.dto.PlanCreateDto;
import com.ovtrip.plan.model.vo.CourseVo;
import com.ovtrip.plan.model.vo.PlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface PlanMapper {
    PlanVo getPlan(int planId) throws SQLException;
    void createPlan(PlanCreateDto planCreateDto) throws SQLException;
    List<CourseVo> getCourse(CourseGetDto courseGetDto) throws SQLException;
    void createCourse(CourseCreateDto courseCreateDto) throws  SQLException;
}
