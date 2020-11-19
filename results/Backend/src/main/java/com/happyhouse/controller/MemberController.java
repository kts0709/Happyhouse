package com.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happyhouse.model.dto.member.PasswordDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.happyhouse.model.dto.member.MemberDto;
import com.happyhouse.model.service.MemberService;
import com.mysql.cj.Session;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/member")
public class MemberController /*extends HttpServlet*/ {

//	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "mfail";
	
	@Autowired
	MemberService memberService;

//	회원가입
	@ApiOperation(value = "새로운 가입 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/join")
	public ResponseEntity<String> join(@RequestBody MemberDto memberDto) {
		logger.debug("joinMember - 호출");
		if (memberService.join(memberDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	
	
//	회원 정보 수정
	@ApiOperation(value = "memberid에 해당하는 회원 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{memberid}")
	public ResponseEntity<String> updateMember(@RequestBody MemberDto memberDto) {
		logger.debug("updateMember - 호출");
		logger.debug("" + memberDto);
		
		if (memberService.updateMember(memberDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	
//	회원정보 삭제
	@ApiOperation(value = "memberid에 해당하는 회원 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{memberid}")
	public ResponseEntity<String> deleteMember(@PathVariable String memberid) {
		logger.debug("deleteMember - 호출");
		System.out.println("memberdelete");
		if (memberService.delete(memberid)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
//	회원 리스트 조회
	@ApiOperation(value = "모든 회원 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<MemberDto>> retrieveMember() throws Exception {
		logger.debug("retrieveMember - 호출");
		return new ResponseEntity<List<MemberDto>>(memberService.findAll(), HttpStatus.OK);
	}
	
	
//	회원 정보 보기
	@ApiOperation(value = "memberid에 해당하는 회원의 정보를 반환한다.", response = MemberDto.class)    
	@GetMapping("{memberid}")
	public ResponseEntity<MemberDto> detailMember(@PathVariable String memberid) {
		logger.debug("detailMember - 호출");
		System.out.println("memberdetail");
		return new ResponseEntity<MemberDto>(memberService.detailMember(memberid), HttpStatus.OK);
	}
	
//	회원 비밀번호 찾기
	@ApiOperation(value = "회원의 비밀번호를 반환한다.", response = MemberDto.class)    
	@GetMapping("{memberid}/{membername}/{memberphone}")
	public ResponseEntity<MemberDto> findPasswordMember(@PathVariable String memberid, @PathVariable String membername,@PathVariable String memberphone) {
		logger.debug("findPasswordMember - 호출");
		MemberDto dto = new MemberDto();
		dto.setMemberId(memberid);
		dto.setMemberName(membername);
		dto.setMemberPhone(memberphone);
		return new ResponseEntity<MemberDto>(memberService.findPswd(dto), HttpStatus.OK);
	}
	
	
//	로그인
	@ApiOperation(value = "로그인.", response = String.class)    
	@PostMapping("/login")
	public ResponseEntity<String> loginMember(@RequestBody MemberDto memberDto,HttpServletRequest request, HttpServletResponse response) {
		logger.debug("loginMember - 호출");
		Session session;
		System.out.println(memberDto.getMemberId()+" "+memberDto.getMemberPswd());
		if (memberService.login(memberDto)) {
			request.getSession().setAttribute("memberId", memberDto.getMemberId());
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	
//	로그아웃
	@ApiOperation(value = "로그아웃.", response = MemberDto.class)    
	@PostMapping("/logout")
	public ResponseEntity<String> logoutMember(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("logoutMember - 호출");
		request.getSession().removeAttribute("memberId");
		System.out.println("로그아웃");
		return new ResponseEntity<String>("로그아웃 성공", HttpStatus.OK);
	}

	@PutMapping("/updatepswd")
	public ResponseEntity<String> updatePassword(@RequestBody PasswordDto password) {
		memberService.updatePassword(password.getId(), password.getPassword());
		return new ResponseEntity<>("비밀번호 변경" , HttpStatus.OK);
	}
}