package com.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.HappyHouseException;
import com.happyhouse.model.dao.NoticeDao;
import com.happyhouse.model.dao.NoticeDaoImpl;
import com.happyhouse.model.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	
	public NoticeServiceImpl() {
		noticeDao = new NoticeDaoImpl();
	}

	@Override
	public boolean writeNotice(NoticeDto noticeDto) throws Exception {
		if(noticeDto.getSubject() == null || noticeDto.getContent() == null) {
			throw new Exception();
		}
		return noticeDao.writeNotice(noticeDto)==1;
	}

	@Override
	public List<NoticeDto> listNotice() throws Exception {
		return noticeDao.listNotice();
	}
	@Override
	public NoticeDto getNotice(int noticeno) throws Exception {
		return noticeDao.getNotice(noticeno);
	}

	@Override
	public boolean modifyNotice(NoticeDto noticeDto) throws Exception {
		return noticeDao.modifyNotice(noticeDto)==1;
	}

	@Override
	public boolean deleteNotice(int noticeno) throws Exception {
		return noticeDao.deleteNotice(noticeno)==1;
	}

	@Override
	public NoticeDto search(int noticeno) throws Exception {
		try {
			NoticeDto noticeDto = noticeDao.search(noticeno);
			if(noticeDto==null)
			{
				throw new HappyHouseException("해당 공지 사항이 존재하지 않습니다.");
			}
			return noticeDto;
		} catch (SQLException e) {
			throw new HappyHouseException("주택 정보 조회 중 요류 발생");
		}
	}

}
