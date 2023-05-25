package com.ovtrip.plan.model.mapper;

import com.ovtrip.plan.model.dto.PlanCreateDto;
import com.ovtrip.plan.model.vo.PlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

@Mapper
public interface PlanMapper {
    PlanVo getPlan(int planId) throws SQLException;
    void createPlan(PlanCreateDto planCreateDto) throws SQLException;

}
