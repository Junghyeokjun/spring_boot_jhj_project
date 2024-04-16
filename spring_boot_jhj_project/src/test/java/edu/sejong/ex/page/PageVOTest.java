package edu.sejong.ex.page;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PageVOTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Disabled
	@Test
	void testPageVO() {
		assertNotNull(boardMapper);
	}
	
	@Test
	void testPaging() {
		Criteria cri = new Criteria();
		assertNotNull(cri);
		
		List<BoardVO> boards= boardMapper.getListWithPaging(cri);
		
		for (BoardVO board : boards) {
			System.out.println(board);
		}
		
		cri.setPageNum(3);
		cri.setAmount(10);
		
		boards= boardMapper.getListWithPaging(cri);
		
		for (BoardVO board : boards) {
			System.out.println(board);
		}
	}

	
}
