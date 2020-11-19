package com.happyhouse.controller;

import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.model.dto.NoticeDto;
import com.happyhouse.model.dto.QnA;
import com.happyhouse.model.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/notice")
public class NoticeController /*extends HttpServlet*/ {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
//	private static final long serialVersionUID = 1L;
	
	@Autowired
	private NoticeService noticeService;
	
	@ApiOperation(value = "모든 공지사항 정보를 반환한다.", response = List.class)
	@GetMapping/*(value = "/list")*/
	public ResponseEntity<List<NoticeDto>> listNotice() throws Exception {
		logger.debug("ListNotice - 호출");
		return new ResponseEntity<List<NoticeDto>>(noticeService.listNotice(), HttpStatus.OK);
	}

	@ApiOperation(value = "공지사항 번호에 해당하는 공지사항의 정보를 반환한다.", response = NoticeDto.class)
	@GetMapping(value = "{noticeno}")
	public ResponseEntity<NoticeDto> detailNotice(@PathVariable int noticeno) throws Exception {
		logger.debug("detailNotice - 호출");
		return new ResponseEntity<NoticeDto>(noticeService.search(noticeno), HttpStatus.OK);
	}
	
	@ApiOperation(value = "새로운 공지사항을 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeNotice(@RequestBody NoticeDto noticeDto) throws Exception {
		logger.debug("writeNotice - 호출");
		if (noticeService.writeNotice(noticeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	
	
	
	@ApiOperation(value = "공지사항번호에 해당하는 공지사항의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{noticeno}")
	public ResponseEntity<String> updateNotice(@RequestBody NoticeDto noticeDto) throws Exception {
		logger.debug("updateNotice - 호출");
		logger.debug("" + noticeDto);
		if (noticeService.modifyNotice(noticeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}


	@ApiOperation(value = "공지사항번호에 해당하는 공지사항의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{noticeno}")
	public ResponseEntity<String> deleteNotice(@PathVariable int noticeno) throws Exception {
		logger.debug("deleteNotice - 호출");
		if (noticeService.deleteNotice(noticeno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	
//	@GetMapping(value = "/mvmodify")
//	public String mvmodify(HttpServletRequest request, HttpServletResponse response) {
//
//		int noticeno = Integer.parseInt(request.getParameter("noticeno"));
//		try {
//			NoticeDto noticeDto = noticeService.getNotice(noticeno);
//			request.setAttribute("notice", noticeDto);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "/notice/modify";
//	}
//
//	@GetMapping(value = "/mvwrite")
//	public String mvwrite(HttpServletRequest request, HttpServletResponse response) {
//		return "/notice/write";
//	}


}