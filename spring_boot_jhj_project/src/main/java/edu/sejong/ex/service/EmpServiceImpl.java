package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.CompanyMapper;
import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.SalgradeEmpVO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	CompanyMapper companyMapper;
	
	@Override
	public List<DeptEmpVO> getDeptEmpVOList() {
		return companyMapper.getDeptEmpList();
	}

	@Override
	public List<SalgradeEmpVO> getSalgradeEmpVOList() {
		return companyMapper.getSalgradeEmpList();
	}

}
