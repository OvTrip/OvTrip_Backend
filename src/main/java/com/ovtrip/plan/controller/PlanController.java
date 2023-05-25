package com.ovtrip.plan.controller;

import com.ovtrip.global.resolver.userinfo.UserInfo;
import com.ovtrip.global.resolver.userinfo.UserInfoDto;
import com.ovtrip.plan.model.dto.*;
import com.ovtrip.plan.model.vo.CourseVo;
import com.ovtrip.plan.model.vo.PlanUserVo;
import com.ovtrip.plan.model.vo.PlanVo;
import com.ovtrip.plan.service.PlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<?> getPlanByUser(@UserInfo UserInfoDto userInfoDto){
        List<PlanUserVo> planVos = planService.getPlanByUser(userInfoDto.getUserId());
        System.out.println(userInfoDto.getUserId());
        return ResponseEntity.ok(planVos);
    }

    @PostMapping
    @ApiOperation(value="Plan 생성", notes = "새로운 일정을 생성합니다.")
    public ResponseEntity<?> createPlan(@RequestBody PlanCreateDto planCreateDto, @UserInfo UserInfoDto userInfoDto){
        try {
            planCreateDto.setUserId(userInfoDto.getUserId());
            int planId = planService.createPlan(planCreateDto);
            return new ResponseEntity<>(planId, HttpStatus.OK);
        } catch (Exception e){
            return exceptionHandling(e);
        }
    }

    @PostMapping(value="/{planId}/course")
    @ApiOperation(value = "Course 생성", notes="날짜별 일정을 저장합니다.")
    public ResponseEntity<?> createCourse(@PathVariable Long planId, @RequestBody PlanDto planDto){
        try {
            System.out.println("됨");
            for (int i=0;i < planDto.getVisitList().size();i++){
                CourseCreateDto courseCreateDto = CourseCreateDto.builder()
                        .planId(planId)
                        .courseDate(planDto.getVisitList().get(i).getCourse_date())
                        .addressName(planDto.getVisitList().get(i).getAddress_name())
                        .roadAddressName(planDto.getVisitList().get(i).getRoad_address_name())
                        .placeName(planDto.getVisitList().get(i).getPlaceName())
                        .placeUrl(planDto.getVisitList().get(i).getPlace_url())
                        .latitude(planDto.getVisitList().get(i).getLatitude())
                        .longitude(planDto.getVisitList().get(i).getLongitude())
                        .build();
                planService.createCourse(courseCreateDto);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping(value = "/{planId}/course/{courseDate}")
    @ApiOperation(value="Course 조회", notes="날짜별 일정을 가져옵니다.")
    public ResponseEntity<?> getCourse(@PathVariable Long planId, @PathVariable String courseDate){
        try{
            CourseGetDto courseGetDto = new CourseGetDto();
            courseGetDto.setPlanId(planId);
            courseGetDto.setCourseDate(courseDate);
            List<CourseVo> courseVo = planService.getCourse(courseGetDto);
            return new ResponseEntity<>(courseVo, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @PostMapping("/title")
    public ResponseEntity<?> updatePlanTitle(@RequestBody PlanTitleDto planTitleDto){
        planService.updatePlanTitle(planTitleDto);
        return ResponseEntity.ok(planTitleDto.getPlanId());
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
