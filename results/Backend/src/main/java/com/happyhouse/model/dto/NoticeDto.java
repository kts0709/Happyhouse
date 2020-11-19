package com.happyhouse.model.dto;

public class NoticeDto {

	private int noticeno;
	private String memberid;
	private String subject;
	private String content;
	private String regtime;




	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public int getNoticeno() {
		return noticeno;
	}

	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}

	@Override
	public String toString() {
		return "NoticeDto [noticeno=" + noticeno + ", memberid=" + memberid + ", subject=" + subject + ", content="
				+ content + ", regtime=" + regtime + "]";
	}
	

}
