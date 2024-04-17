package edu.sejong.ex.one;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.vo.BoardVO;

@Service
public class BService1 {
	
	@Autowired
//	private SqlSession sqlSession; //마이바티스
	private SqlSessionTemplate sqlSession; //마이바티스
	
	public List<BoardVO> selectBoardList() throws Exception{
		IBDao dao = sqlSession.getMapper(IBDao.class);
		return dao.listDao();
		
	}
}
