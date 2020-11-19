package com.happyhouse.model.dto.member;

public class MyInterestArea {
	private String memberid;
	private String dong1;
	private String dong2;
	private String dong3;
	
	public MyInterestArea() {
		// TODO Auto-generated constructor stub
	}
	
	public MyInterestArea(String memberid, String dong1, String dong2, String dong3) {
		super();
		this.memberid = memberid;
		this.dong1 = dong1;
		this.dong2 = dong2;
		this.dong3 = dong3;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getDong1() {
		return dong1;
	}

	public void setDong1(String dong1) {
		this.dong1 = dong1;
	}

	public String getDong2() {
		return dong2;
	}

	public void setDong2(String dong2) {
		this.dong2 = dong2;
	}

	public String getDong3() {
		return dong3;
	}

	public void setDong3(String dong3) {
		this.dong3 = dong3;
	}
	
	

}
