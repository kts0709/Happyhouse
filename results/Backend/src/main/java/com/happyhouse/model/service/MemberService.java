package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.dto.QnA;
import com.happyhouse.model.dto.member.MemberDto;
import com.happyhouse.model.dto.member.MyInterestArea;

public interface MemberService {

    public boolean join(MemberDto dto);
    public boolean login(MemberDto dto);
    public boolean updateMember(MemberDto dto);
    public MemberDto findPswd(MemberDto dto);
    public boolean delete(String memberid);
    public MemberDto detailMember(String memberid);
    
    public MyInterestArea getInterestArea(String memberid);
    public boolean updateInterestArea(MyInterestArea myInterestArea);
    
    public List<MemberDto> findAll();

    public int updatePassword(String id, String password);
    
}
