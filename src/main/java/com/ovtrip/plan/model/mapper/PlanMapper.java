package com.ovtrip.plan.model.mapper;

import com.ovtrip.plan.model.PlanDto;

import java.sql.SQLException;

public interface PlanMapper {
    PlanDto getPlan(int planId) throws SQLException;
}
