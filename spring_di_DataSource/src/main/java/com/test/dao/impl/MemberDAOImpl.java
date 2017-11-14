package com.test.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.test.dao.MemberDAO;
import com.test.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {	
	
	private BasicDataSource dataSource;
	public void setDataSource(BasicDataSource dataSource){
		this.dataSource=dataSource;
	}
	
	@Override
	public List<MemberVO> getMemberList() throws SQLException{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<MemberVO> memberList=new ArrayList<MemberVO>();
		
		con=dataSource.getConnection();
		String sql="select * from member";
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		
		while(rs.next()){
			MemberVO mem=new MemberVO();
			mem.setMem_email(rs.getString("mem_email"));
			mem.setMem_id(rs.getString("mem_id"));
			mem.setMem_name(rs.getString("mem_name"));
			mem.setMem_pwd(rs.getString("mem_pwd"));
			mem.setMem_role(rs.getString("mem_role"));
			
			memberList.add(mem);
		}
		
		return memberList;
	}

}






