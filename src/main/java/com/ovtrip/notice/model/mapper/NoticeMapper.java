package com.ovtrip.notice.model.mapper;

import com.ovtrip.notice.model.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {
    public int writeArticle(NoticeDto noticeDto) throws SQLException;
    public List<NoticeDto> listArticle() throws SQLException;
    public NoticeDto getArticle(int articleno) throws SQLException;
    public void updateHit(int articleno) throws SQLException;
    public int modifyArticle(NoticeDto noticeDto) throws SQLException;
    public int deleteArticle(int articleno) throws SQLException;
}
