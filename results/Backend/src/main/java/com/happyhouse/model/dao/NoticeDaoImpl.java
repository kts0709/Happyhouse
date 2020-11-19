package com.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happyhouse.model.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	
	@Autowired
	SqlSession session;
	
	@Override
	public int writeNotice(NoticeDto noticeDto) throws SQLException {		
		return session.insert("com.happyhouse.model.dao.NoticeDao.write",noticeDto);
	}
	
	@Override
	public int modifyNotice(NoticeDto noticeDto) throws SQLException {
		return session.update("com.happyhouse.model.dao.NoticeDao.modify", noticeDto);
	}

	@Override
	public int deleteNotice(int noticeno) throws SQLException {
		return session.delete("com.happyhouse.model.dao.NoticeDao.delete",noticeno);
	}

	@Override
	public NoticeDto search(int noticeno) throws SQLException {
		return session.selectOne("com.happyhouse.model.dao.NoticeDao.search",noticeno);
	}
	
	
	@Override
	public NoticeDto getNotice(int noticeno) throws SQLException {
		return session.selectOne("com.happyhouse.model.dao.NoticeDao.getNotice",noticeno);
	}

	@Override
	public List<NoticeDto> listNotice() throws SQLException {
		return session.selectList("com.happyhouse.model.dao.NoticeDao.listNotice");	
	}

}
