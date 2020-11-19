package com.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.model.dao.MemberDao;
import com.happyhouse.model.dto.member.MemberDto;
import com.happyhouse.model.dto.member.MyInterestArea;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
   private MemberDao memberDao;
	

//    public MemberServiceImpl() {
//        memberDao = new MemberDaoImpl();
//    }

    @Override
    public boolean join(MemberDto dto) {
    	memberDao.join(dto);
        return memberDao.insertInterestArea(dto.getMemberId())==1;
    }

    @Override
    public boolean login(MemberDto dto) {
        if (dto.getMemberId() == null || dto.getMemberPswd() == null) {
        	throw new IllegalArgumentException();
        }
        else{
        	if(memberDao.login(dto).length()!= 0) {
        		return false;
        	}
        	return true;
        }
        
        
    }

    @Override
    public boolean updateMember(MemberDto dto) {
        return memberDao.updateMember(dto)==1;
    }

    @Override
    public MemberDto findPswd(MemberDto dto) {
        return memberDao.findPassword(dto);
    }

    @Override
    public boolean delete(String memberid) {
    	memberDao.deleteInterestArea(memberid);
        return memberDao.delete(memberid)==1;
    }

    @Override
	public MyInterestArea getInterestArea(String memberid) {
		return memberDao.getInterestArea(memberid);
	}

	@Override
	public boolean updateInterestArea(MyInterestArea myInterestArea) {
		return memberDao.updateInterestArea(myInterestArea)==1;
	}

	@Override
	public List<MemberDto> findAll() {
		return memberDao.findAll();
	}

    @Override
    public int updatePassword(String id, String password) {
       return memberDao.updatePassword(id, password);
    }

    @Override
	public MemberDto detailMember(String memberid) {
		return memberDao.selectMemberByMemberid(memberid);
	}


}
