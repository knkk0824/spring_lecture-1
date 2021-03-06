package com.spring.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Criteria;
import com.spring.domain.PageMaker;
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

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO reply) {
		
		System.out.println(reply);
		ResponseEntity<String> entity = null;
		try {
			replyService.addReply(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") int bno) {

		ResponseEntity<List<ReplyVO>> entity = null;

		try {
			entity = new ResponseEntity<List<ReplyVO>>(
					replyService.getReplyList(bno), HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/{rno}", method = { RequestMethod.PUT,
			RequestMethod.PATCH })
	public ResponseEntity<String> update(@PathVariable("rno") int rno,
			@RequestBody ReplyVO reply) {

		ResponseEntity<String> entity = null;

		try {
			reply.setRno(rno);
			replyService.modifyReply(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/{bno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(
			@PathVariable("bno") int bno, @PathVariable("page") int page) {

		ResponseEntity<Map<String, Object>> entity = null;

		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(5);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<ReplyVO> replyList = replyService.getReplyListPage(bno, cri);
			
			map.put("list",replyList);
			
			int replyCount=replyService.countReply(bno);
			pageMaker.setTotalCount(replyCount);
			
			map.put("pageMaker", pageMaker);
			
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		} catch (SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value="/{rno}",method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno")int rno){
		
		ResponseEntity<String> entity=null;
		
		try {
			replyService.removeReply(rno);
			entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
				
		return entity;
	}
}







