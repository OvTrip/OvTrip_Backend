package com.ovtrip.notice.service;

import com.ovtrip.notice.model.dto.NoticeDto;
import com.ovtrip.notice.model.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper noticeMapper;

    @Override
    public int writeArticle(NoticeDto noticeDto) throws Exception {
        return noticeMapper.writeArticle(noticeDto);
    }

    @Override
    public List<NoticeDto> listArticle() throws Exception {
        return noticeMapper.listArticle();
    }

    @Override
    public NoticeDto getArticle(int articleno) throws Exception {
        return noticeMapper.getArticle(articleno);
    }

    @Override
    public void updateHit(int articleno) throws Exception {
        noticeMapper.updateHit(articleno);
    }

    @Override
    public int modifyArticle(NoticeDto noticeDto) throws Exception {
        return noticeMapper.modifyArticle(noticeDto);
    }

    @Override
    public int deleteArticle(int articleno) throws Exception {
        return noticeMapper.deleteArticle(articleno);
    }
}
