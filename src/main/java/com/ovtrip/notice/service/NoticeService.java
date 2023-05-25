package com.ovtrip.notice.service;

import com.ovtrip.notice.model.dto.NoticeDto;

import java.util.List;

public interface NoticeService {
    public int writeArticle(NoticeDto noticeDto) throws Exception;
    public List<NoticeDto> listArticle() throws Exception;
    public NoticeDto getArticle(int articleno) throws Exception;
    public void updateHit(int articleno) throws Exception;
    public int modifyArticle(NoticeDto noticeDto) throws Exception;
    public int deleteArticle(int articleno) throws Exception;
}
