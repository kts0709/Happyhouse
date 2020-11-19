package com.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.happyhouse.model.dto.NoticeDto;


public interface NoticeDao {

	public int writeNotice(NoticeDto noticeDto) throws SQLException;
	public List<NoticeDto> listNotice() throws SQLException;
	public NoticeDto getNotice(int noticeno) throws SQLException;
	public int modifyNotice(NoticeDto noticeDto) throws SQLException;
	public int deleteNotice(int noticeno) throws SQLException;
	public NoticeDto search(int noticeno) throws SQLException;
}
