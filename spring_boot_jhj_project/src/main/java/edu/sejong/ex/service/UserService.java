package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.DeptSalgradeEmpVO;
import edu.sejong.ex.vo.UserVO;

public interface UserService {
	List<DeptSalgradeEmpVO> getDeptSalgradeEmVOList();	
	
	void userSignUp(UserVO userVO);	

}
