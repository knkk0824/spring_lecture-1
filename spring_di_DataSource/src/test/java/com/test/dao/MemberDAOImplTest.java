package com.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/test/context/*-context.xml")
public class MemberDAOImplTest {

	@Autowired
	private MemberDAO memDao;
	
	@Test
	public void getMemberListTest()throws Exception{
		List<MemberVO> memberList=memDao.getMemberList();
		
		System.out.println(memberList);
	}
}










