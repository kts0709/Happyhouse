package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.dto.NoticeDto;

public interface NoticeService {
	public boolean writeNotice(NoticeDto noticeDto) throws Exception;
	public List<NoticeDto> listNotice() throws Exception;
	public NoticeDto getNotice(int noticeno) throws Exception;
	public boolean modifyNotice(NoticeDto noticeDto) throws Exception;
	public boolean deleteNotice(int noticeno) throws Exception;
	public NoticeDto search(int noticeno) throws Exception;
}
