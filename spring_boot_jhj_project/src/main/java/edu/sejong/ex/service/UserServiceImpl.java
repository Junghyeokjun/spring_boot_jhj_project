package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.CompanyMapper;
import edu.sejong.ex.mapper.UserMapper;
import edu.sejong.ex.vo.DeptSalgradeEmpVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	CompanyMapper companyMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<DeptSalgradeEmpVO> getDeptSalgradeEmVOList() {
		log.info("getDeptSalgradeEmVOList()..");
		return companyMapper.getDeptSalgradeEmpList();
	}

	@Override
	public void userSignUp(UserVO userVO) {
		log.info("userSignUp()..");
		int insertcount=userMapper.insertUser(userVO);
		userMapper.insertAuthorities(userVO);
		log.info(insertcount+"명 가입");

	}

}
