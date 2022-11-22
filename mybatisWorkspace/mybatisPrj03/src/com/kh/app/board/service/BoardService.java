package com.kh.app.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.common.page.PageVo;

public class BoardService {
	
	//게시글 작성 (찐)
	public int write(BoardVo vo) {
		
		//디비 연결
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL 실행
		BoardDao dao = new BoardDao();
		int result = dao.write(ss , vo);
		
		//트랜잭션 || 자원반납
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
		ss.close();
		
		//결과 리턴
		return result;
		
	}

	// 게시글 목록 조회
	public List<BoardVo> selectBoardList(Map<String, String> map, PageVo pv) {
		//디비 연결
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//SQL 실행
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.selectBoardList(ss , map , pv);
		
		//트랜잭션 || 자원반납
		ss.close();
		
		//결과리턴
		return list;
	}

	//게시글 갯수 조회
	public int selectCount() {
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		BoardDao dao = new BoardDao();
		int cnt = dao.selectCount(ss);
		
		ss.close();
		
		return cnt;
	}

}//class




























