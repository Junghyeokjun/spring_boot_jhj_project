package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.DeptSalgradeEmpVO;
import edu.sejong.ex.vo.SalgradeEmpVO;

public interface EmpService {
	List<DeptEmpVO> getDeptEmpVOList();
	List<SalgradeEmpVO> getSalgradeEmpVOList();	
	List<DeptSalgradeEmpVO> getDeptSalgradeEmVOList();	
}
