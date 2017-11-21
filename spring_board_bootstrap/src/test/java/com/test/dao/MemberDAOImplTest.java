package com.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.MemberDAO;
import com.spring.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager", 
						  defaultRollback=false)
@Transactional
public class MemberDAOImplTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	@Test
	@Rollback
	public void testMemberDAOMethod()throws Exception{
		MemberVO member=
		new MemberVO("userid1","userpw1","username1","email1",
				new Date(),new Date());
		
		System.out.println("insert : "+memberDAO.insertMember(member));
		System.out.println("selectMember : "+
						memberDAO.selectMemberById(member.getUserid()));
		member=	new MemberVO("userid1","userpw2","username2","email2",
						new Date(),new Date());
		System.out.println("update : "+memberDAO.updateMember(member));
		System.out.println("selectMember : "+
						memberDAO.selectMemberById(member.getUserid()));
		System.out.println("delete : "+
						memberDAO.deleteMember(member.getUserid()));
		System.out.println("selectMember : "+
						memberDAO.selectMemberById(member.getUserid()));
		
	}
}





