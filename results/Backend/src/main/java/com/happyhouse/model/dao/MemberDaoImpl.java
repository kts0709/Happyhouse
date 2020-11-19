package com.happyhouse.model.dao;

import java.util.List;

import com.happyhouse.model.dto.member.PasswordDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happyhouse.model.dto.member.MemberDto;
import com.happyhouse.model.dto.member.MyInterestArea;

@Repository
public class MemberDaoImpl implements MemberDao {

	
	@Autowired
	SqlSession SqlSession;
	
    @Override
    public int join(MemberDto dto) {
       return SqlSession.insert("com.happyhouse.model.dao.MemberDao.insert",dto);
    }

    @Override
    public String login(MemberDto dto) {
    	return SqlSession.selectOne("com.happyhouse.model.dao.MemberDao.login", dto);
    }

    @Override
    public int updateMember(MemberDto dto) {
    	return SqlSession.update("com.happyhouse.model.dao.MemberDao.update",dto);
    }

    @Override
    public MemberDto findPassword(MemberDto dto) {
    	return SqlSession.selectOne("com.happyhouse.model.dao.MemberDao.findpswd",dto);
    }

    @Override
    public int delete(String memberid) {
    	 return SqlSession.delete("com.happyhouse.model.dao.MemberDao.delete",memberid);
    }

    @Override
    public int insertInterestArea(String memberid) {
    	return SqlSession.insert("com.happyhouse.model.dao.MemberDao.insertArea",memberid);

    }
 
    @Override
    public int deleteInterestArea(String memberid) {
    	return SqlSession.delete("com.happyhouse.model.dao.MemberDao.deleteArea",memberid);

    }

    @Override
    public MyInterestArea getInterestArea(String memberid) {
    	return SqlSession.selectOne("com.happyhouse.model.dao.MemberDao.selectArea",memberid);

    }

    @Override
    public int updateInterestArea(MyInterestArea myInterestArea) {
    	return SqlSession.update("com.happyhouse.model.dao.MemberDao.updateArea",myInterestArea);

    }

    @Override
    public int updatePassword(String id, String password) {
        return SqlSession.update("com.happyhouse.model.dao.MemberDao.updatePassword", new PasswordDto(id, password));
    }

    @Override
	public List<MemberDto> findAll() {
		return SqlSession.selectList("com.happyhouse.model.dao.MemberDao.selectAll");

	}

	@Override
	public MemberDto selectMemberByMemberid(String memberid) {
		return SqlSession.selectOne("com.happyhouse.model.dao.MemberDao.detailMember",memberid);
	}
}
