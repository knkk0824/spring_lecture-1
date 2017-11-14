package com.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dto.MemberVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/test/context/*-context.xml")
public class MemberServiceImplTest {
	
	@Autowired
	private MemberService service;
	
	@Test
	public void getMemberListTest()throws Exception{
		List<MemberVO> memberList=service.getMemberList();
		System.out.println(memberList);
	}
	
}








