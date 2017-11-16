package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "BoardMapper";

	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace + ".insertBoard", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".selectBoardByBno", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace + ".updateBoard", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".deleteBoard", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".selectBoardList");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {

		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return session.selectList(namespace + ".getPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();

		RowBounds rowBounds = new RowBounds(offset, limit);

		System.out.println("limit::"+rowBounds.getLimit()+", offset::"+rowBounds.getOffset());
		List<BoardVO> boardList=session.selectList(namespace + ".selectCriteria", null,rowBounds);
		
		System.out.println(boardList);
		return boardList;
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {

		return session.selectOne(namespace + ".selectCountPaging", cri);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		int offset = cri.getPageStart();
		int limit = cri.getPerPageNum();

		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return session.selectList(namespace + ".selectSearchBoardList", cri,rowBounds);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".selectSearchBoardCount", cri);
	}

}
