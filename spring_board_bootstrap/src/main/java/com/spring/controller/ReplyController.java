package com.spring.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.ReplyVO;
import com.spring.service.ReplyService;


// url: /replies
// /replies/all/{bno} GET방식 : bno번 게시글의 댓글 목록
// /replies/{rno} PUT,PATCH 방식 : rno 댓글의 수정
// /replies/{rno} DELETE 방식 : rno 댓글의 삭제
// /replies POST방식 : 댓글 입력
// /replies/{bno}/{page} GET방식 : 페이징 처리된 댓글 목록

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO reply){
		
		ResponseEntity<String> entity=null;
		
		try {
			replyService.addReply(reply);
			entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}












