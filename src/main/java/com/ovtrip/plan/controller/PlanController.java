package com.ovtrip.plan.controller;

import com.ovtrip.plan.model.vo.PlanVo;
import com.ovtrip.plan.service.PlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
@CrossOrigin
@Api(tags={"여행계획"})
public class PlanController {

    private final PlanService planService;

    @GetMapping(value = "/{planid}")
    @ApiOperation(value = "Plan 조회", notes = "해당 일정에 대한 상세 정보를 불러 옵니다.")
    public ResponseEntity<?> planInfo(@PathVariable("planid") int planId){
        try {
            PlanVo planDto = planService.getPlan(planId);
            if(planDto != null){
                return new ResponseEntity<>(planDto, HttpStatus.OK);
            } else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e){
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
