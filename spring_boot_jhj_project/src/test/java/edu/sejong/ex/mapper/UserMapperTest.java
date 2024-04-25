package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.sejong.ex.vo.AuthVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder PasswordEncoder;
	
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
	@Disabled
	@Test
	void testGetUser() {
		UserVO user=userMapper.getUser("admin");
		System.out.println(user);
		for (AuthVO auth : user.getAuthList()) {
			System.out.println(auth);
		}
	}
	@Disabled
	@Test
	void testInsertUser() {
		UserVO user=new UserVO();
		user.setUsername("admin3");
		user.setPassword(new BCryptPasswordEncoder().encode("admin3"));
		user.setEnabled("1");
		List<AuthVO> list=new ArrayList<>();
		list.add(new AuthVO("admin3", "ROLE_ADMIN"));
		user.setAuthList(list);
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
	}	
	@Disabled
	@Test
	void testInsertAuthorities() {
		userMapper.insertAuthorities(new UserVO("say","111",null,null));
		UserVO user=userMapper.getUser("say");
		System.out.println(user);

	}
	@Disabled
	@Test
	void testMatcher1() {
		
		UserVO user=new UserVO();
		user.setUsername("user2");
		user.setPassword(PasswordEncoder.encode("user2"));
		user.setEnabled("1");
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
	}
	@Disabled
	@Test
	void testMatcher() {
		
		UserVO user=userMapper.getUser("admin2");
		boolean isMatch=PasswordEncoder.matches("admin2", user.getPassword());
		
		assertEquals(isMatch,true) ;
	}

	
}
