package com.ovtrip.notice.controller;

import com.ovtrip.global.resolver.userinfo.UserInfo;
import com.ovtrip.global.resolver.userinfo.UserInfoDto;
import com.ovtrip.notice.model.dto.NoticeDto;
import com.ovtrip.notice.service.NoticeService;
import com.ovtrip.user.model.dto.UserVO;
import com.ovtrip.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;
    private final UserService userService;

    @PostMapping("/notice")
    public ResponseEntity<?> writeArticle(@RequestBody NoticeDto noticeDto, @UserInfo UserInfoDto userInfoDto) throws Exception {
        UserVO userVO = userService.getUserById(userInfoDto.getUserId());
        noticeDto.setUserName(userVO.getUserNickname());
        noticeDto.setUserId(userVO.getUserId());
        if (noticeService.writeArticle(noticeDto)!=0) {
            return ResponseEntity.ok("공지 등록성공");
        }
        return ResponseEntity.badRequest().body("안됨..");
    }

    @GetMapping("/notice")
    public ResponseEntity<List<NoticeDto>> listArticle() throws Exception {
        List<NoticeDto> noticeDtos = noticeService.listArticle();
        return ResponseEntity.ok(noticeDtos);
    }

    @GetMapping("/notice/{articleno}")
    public ResponseEntity<?> getArticle(@PathVariable("articleno") int articleno) throws Exception {
        noticeService.updateHit(articleno);
        return ResponseEntity.ok(noticeService.getArticle(articleno));
    }

    @PutMapping("/notice")
    public ResponseEntity<?> modifyArticle(@RequestBody NoticeDto noticeDto) throws Exception {
        if (noticeService.modifyArticle(noticeDto)!=0){
            return ResponseEntity.ok("글 수정 성공");
        }
        return ResponseEntity.badRequest().body("글 수정 실패");
    }

    @DeleteMapping("/notice/{articleno}")
    public ResponseEntity<?> deleteArticle(@PathVariable("articleno") int articleno) throws Exception {
        if (noticeService.deleteArticle(articleno)!=0) {
            return ResponseEntity.ok("글 삭제 성공");
        }
        return ResponseEntity.badRequest().body("글 삭제 실패");
    }
}
