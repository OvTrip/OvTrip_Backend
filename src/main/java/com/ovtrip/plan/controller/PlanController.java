package com.ovtrip.plan.controller;

import com.ovtrip.plan.model.PlanDto;
import com.ovtrip.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
@CrossOrigin
public class PlanController {

    private final PlanService planService;

    @GetMapping(value = "/view/{planid}")
    public ResponseEntity<?> planInfo(@PathVariable("planid") int planId){
        try {
            PlanDto planDto = planService.getPlan(planId);
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
