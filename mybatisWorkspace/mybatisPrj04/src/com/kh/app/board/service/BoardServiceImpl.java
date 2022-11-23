package com.kh.app.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.dao.BoardDaoImpl;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.common.page.PageVo;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao dao = new BoardDaoImpl();

	@Override
	public int insertBoard(BoardVo vo) {
		//DB연결
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL 실행
		int result = dao.insertBoard(ss, vo);
		
		//트랜잭션 , 자원반납
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		ss.close();
		
		//결과리턴
		return result;
	}

	@Override
	public int increaseHit(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVo> selectBoardList(PageVo pv) {
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		List<BoardVo> voList = dao.selectBoardList(ss, pv);
		
		ss.close();
		
		return voList;
	}

	@Override
	public BoardVo selectBoardOne(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCnt() {
		//DB 연결
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL 실행
		int result = dao.selectCnt(ss);
		
		//트랜잭션 , 자원반납
		ss.close();
		
		//결과리턴
		return result;
	}

}//class




















