package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVO;
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
	
	@Test
	void testRead() {
		log.info(boardMapper.read(1).toString());
	}
}
