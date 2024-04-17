package edu.sejong.ex.two;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;

@Service
public class BService2 {
	
	@Autowired
	private SqlSessionTemplate sqlSession; //마이바티스
	
	public List<BoardVO> selectBoardList() throws Exception{

		return sqlSession.selectList("board.selectBoardList");
		
	}	
	
	public List<BoardVO> selectBoardPagingList(Criteria cri) throws Exception{

		return sqlSession.selectList("board.selectBoardPagingList",cri);
		
	}
	
	public int getTotal() throws Exception{

		return sqlSession.selectOne("board.getTotal");
		
	}
	
}
