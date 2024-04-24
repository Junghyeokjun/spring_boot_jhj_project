package edu.sejong.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.CompanyMapper;
import edu.sejong.ex.mapper.UserMapper;
import edu.sejong.ex.vo.CartVO;
import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.UserDetailsVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper UserMapper;

	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By UserVO member:" + username);
		UserVO user = UserMapper.getUser(username);
		
		EmpVO emp = companyMapper.getEmp("KING");
		CartVO cart=new CartVO();
		log.warn("queried by UserVO mapper:" + user);

		return user == null ? null : new UserDetailsVO(user,emp,cart);
	}

}
