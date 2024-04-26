package edu.sejong.ex.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.AuthVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class AuthVOTest {

	@Test
	void testAuthVO() {
		AuthVO authVO = new AuthVO();
		assertNotNull(authVO);
	}

	@Test
	void testGetUserName() {
		AuthVO authVO = new AuthVO();
		assertNotNull(authVO);
		
		authVO.setUsername("홍길동");
		assertEquals("홍길동", authVO.getUsername());
		
	}
}
