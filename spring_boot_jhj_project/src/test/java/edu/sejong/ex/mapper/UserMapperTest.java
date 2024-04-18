package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.AuthVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Disabled
	@Test
	void testUserMapper() {
		assertNotNull(userMapper);
	}
	
	@Test
	void testGetUser() {
		UserVO user=userMapper.getUser("admin");
		System.out.println(user);
		for (AuthVO auth : user.getAuthList()) {
			System.out.println(auth);
		}
	}

}
