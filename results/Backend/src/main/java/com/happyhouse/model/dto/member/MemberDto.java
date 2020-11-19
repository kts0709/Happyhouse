package com.happyhouse.model.dto.member;

public class MemberDto {

//	private int memberNo;
	private String memberId;
	private String memberPswd;
	private String memberName;
	private int memberAge;
	private String memberPhone;

	public MemberDto() {
	}

//	public int getMemberNo() {
//		return memberNo;
//	}
//
//	public void setMemberNo(int memberNo) {
//		this.memberNo = memberNo;
//	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPswd() {
		return memberPswd;
	}

	public void setMemberPswd(String memberPswd) {
		this.memberPswd = memberPswd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
}
