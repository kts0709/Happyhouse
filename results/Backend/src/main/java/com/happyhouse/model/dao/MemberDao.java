package com.happyhouse.model.dao;

import java.util.List;

import com.happyhouse.model.dto.QnA;
import com.happyhouse.model.dto.member.MemberDto;
import com.happyhouse.model.dto.member.MyInterestArea;

public interface MemberDao {

    public int join(MemberDto dto);
    public String login(MemberDto dto);
    public int updateMember(MemberDto dto);
    public MemberDto findPassword(MemberDto dto);
    public int delete(String memberid);
    public List<MemberDto> findAll();
    public MemberDto selectMemberByMemberid(String memberid); 
    
    
    public int insertInterestArea(String memberid);
    public int deleteInterestArea(String memberid);
    public MyInterestArea getInterestArea(String memberid);
    public int updateInterestArea(MyInterestArea myInterestArea); 

    public int updatePassword(String id, String password);
}
