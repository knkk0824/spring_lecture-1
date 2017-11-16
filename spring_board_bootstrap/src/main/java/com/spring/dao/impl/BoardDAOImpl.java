package com.spring.dao.impl;

import java.sql.SQLException;
import java.util.List;

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
		BoardVO board = sqlSession.selectOne(NAMESPACE + ".selectBoardByBno",
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
		int listCount=sqlSession.selectOne(
				NAMESPACE+".selectSearchBoardCount",cri);
		return listCount;
	}
	
	@Override
	public void increaseViewCnt(int bno) throws SQLException{
		sqlSession.update(NAMESPACE+".increaseViewCnt",bno);
	}
	

}









