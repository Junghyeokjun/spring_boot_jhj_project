package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.CompanyMapper;
import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.DeptSalgradeEmpVO;
import edu.sejong.ex.vo.SalgradeEmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	CompanyMapper companyMapper;
	
	@Override
	public List<DeptEmpVO> getDeptEmpVOList() {
		log.info("getDeptEmpVOList()..");
		return companyMapper.getDeptEmpList();
	}

	@Override
	public List<SalgradeEmpVO> getSalgradeEmpVOList() {
		log.info("getSalgradeEmpVOList()..");
		return companyMapper.getSalgradeEmpList();
	}

	@Override
	public List<DeptSalgradeEmpVO> getDeptSalgradeEmVOList() {
		log.info("getDeptSalgradeEmVOList()..");
		return companyMapper.getDeptSalgradeEmpList();
	}

}
