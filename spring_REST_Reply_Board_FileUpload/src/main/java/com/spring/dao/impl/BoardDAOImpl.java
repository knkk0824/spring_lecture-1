package com.spring.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.dao.BoardDAO;
import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;

public class BoardDAOImpl implements BoardDAO {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	private static final String NAMESPACE = "BoardMapper";

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		sqlSession.update(NAMESPACE + ".insertBoard", board);
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		sqlSession.update(NAMESPACE + ".updateBoard", board);
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		sqlSession.update(NAMESPACE + ".deleteBoard", bno);
	}

	@Override
	public List<BoardVO> selectBoardList() throws SQLException {
		List<BoardVO> boardList = sqlSession.selectList(NAMESPACE
				+ ".selectBoardList", null);
		return boardList;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		BoardVO board =(BoardVO)sqlSession.selectOne(NAMESPACE + ".selectBoardByBno",
				bno);
		return board;
	}

	@Override
	public List<BoardVO> selectBoardListCriteria(Criteria cri)
			throws SQLException {

		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<BoardVO> boardList = sqlSession.selectList(NAMESPACE
				+ ".selectBoardList", null, rowBounds);
		return boardList;
	}

	@Override
	public List<BoardVO> selectSearchList(SearchCriteria cri) {
		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<BoardVO> boardList = sqlSession.selectList(NAMESPACE
				+ ".selectSearchBoardList", cri, rowBounds);
		return boardList;
	}

	@Override
	public int selectSearchListCount(SearchCriteria cri) throws SQLException {
		int listCount=(Integer)sqlSession.selectOne(
				NAMESPACE+".selectSearchBoardCount",cri);
		return listCount;
	}
	
	@Override
	public void increaseViewCnt(int bno) throws SQLException{
		sqlSession.update(NAMESPACE+".increaseViewCnt",bno);
	}

	@Override
	public void insertAttach(String fullName) throws SQLException {
		sqlSession.update(NAMESPACE+".insertAttach",fullName);		
	}

	@Override
	public List<String> selectAttach(int bno) throws SQLException {
		List<String> files=sqlSession.selectList(NAMESPACE+".selectAttach",
				bno);
		return files;
	}	

	@Override
	public void deleteAttach(int bno) throws SQLException {
		sqlSession.update(NAMESPACE+".deleteAttach",bno);
	}

	@Override
	public void replaceAttach(String fullName, int bno) throws SQLException {
		Map<String,Object> paraMap=new HashMap<String,Object>();
		
		paraMap.put("fullName", fullName);
		paraMap.put("bno", bno);
		
		sqlSession.update(NAMESPACE+".replaceAttach",paraMap);		
	}
	

}









