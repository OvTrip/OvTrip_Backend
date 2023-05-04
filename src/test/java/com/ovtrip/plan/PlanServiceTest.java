package com.ovtrip.plan;

import com.ovtrip.plan.model.vo.PlanVo;
import com.ovtrip.plan.service.PlanService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlanServiceTest {
    @Autowired
    PlanService planService;

    @Test
    void 플랜조회() throws Exception {
        PlanVo planDto = planService.getPlan(1);
        Assertions.assertThat(planDto.getPlanTitle()).isEqualTo("서울 여행");
    }
}
