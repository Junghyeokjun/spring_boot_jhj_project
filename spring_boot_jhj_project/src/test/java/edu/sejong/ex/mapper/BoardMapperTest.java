package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.DeptVO;
import edu.sejong.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Disabled
	@Test
	void testBoardMapper() {
		assertNotNull(boardMapper);
	}

	@Disabled
	@Test
	void testSelectList() {
		for (BoardVO boardVO : boardMapper.getList()) {
			log.info("확인==================="+boardVO);
		}
	}
	@Disabled
	@Test
	void testSelectList2() {
		for (BoardVO boardVO : boardMapper.getList2()) {
			log.info("확인==================="+boardVO);
		}
	}
	@Disabled
	@Test
	void testRead() {
		log.info(boardMapper.read(1).toString());
	}
	@Disabled
	@Test
	void testInsertBoard() {
		BoardVO boardVO=new BoardVO(0,"1234","4567","7891",null,0,0,0,0);
		log.info(boardMapper.insertBoard(boardVO)+"행 삽입");
	}
	@Disabled
	@Test
	void testDelete() {
		log.info(boardMapper.delete(68)+"행 삭제");
	}
	@Disabled
	@Test
	void testUpdateBoard() {
		BoardVO boardVO=new BoardVO(1,"1234","4567","7891",null,0,0,0,0);
		log.info(boardMapper.updateBoard(boardVO)+"행 수정");
	}
	@Disabled
	@Test
	void testGetJoin() {
		List<EmpVO> emps=boardMapper.getJoinEmp();
		List<DeptVO> depts=boardMapper.getJoinDept();
		Map<DeptVO,EmpVO> join=new HashMap<DeptVO, EmpVO>();
		for(int i=0;i<depts.size();i++) {
			join.put(depts.get(i), emps.get(i));
		}
		Set<DeptVO> set= join.keySet();
		
		for (DeptVO deptVO : set) {
			log.info(deptVO.getDname()+join.get(deptVO).toString()+"");
		}
		
	}
	
}
