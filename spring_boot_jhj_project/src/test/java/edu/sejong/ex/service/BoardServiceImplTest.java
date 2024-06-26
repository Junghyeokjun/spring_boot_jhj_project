package edu.sejong.ex.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BoardServiceImplTest {

	@Autowired
	BoardService boardService;

	@Disabled
	@Test
	void testBoardMapper() {
		assertNotNull(boardService);
	}
	
	@Disabled
	@Test
	void testSelectList() {
		for (BoardVO boardVO : boardService.getList()) {
			log.info(boardVO.toString());
		}
	}
	@Disabled
	@Test
	void testRead() {
			log.info(boardService.get(1).toString());
	}
	@Disabled
	@Test
	void testWriteBoard() {
		BoardVO boardVO=new BoardVO(0,"1234","4567","7891",null,0,0,0,0);
		boardService.writeBoard(boardVO);
	}
	
	@Test
	void testModifyBoard() {
		BoardVO boardVO=new BoardVO(1,"test","테스트","test",null,0,0,0,0);
		log.info(boardService.modifyBoard(boardVO)+"행 수정");
	}
}
