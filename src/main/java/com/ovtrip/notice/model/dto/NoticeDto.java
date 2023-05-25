package com.ovtrip.notice.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class NoticeDto {
    private int articleNo;
    private Long userId;
    private String userName;
    private String subject;
    private String content;
    private int hit;
    private String regTime;

    @Builder
    public NoticeDto(int articleNo, Long userId, String userName, String subject, String content, int hit, String regTime) {
        this.articleNo = articleNo;
        this.userId = userId;
        this.userName = userName;
        this.subject = subject;
        this.content = content;
        this.hit = hit;
        this.regTime = regTime;
    }
}
