package com.ovtrip.plan.model.mapper;

import com.ovtrip.plan.model.PlanDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface PlanMapper {
    PlanDto getPlan(int planId) throws SQLException;
}
