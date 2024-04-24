package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.DeptSalgradeEmpVO;
import edu.sejong.ex.vo.EmpDeptVO;
import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.SalgradeEmpVO;

@Mapper
public interface CompanyMapper {
	EmpVO getEmp(String ename);
	List<EmpDeptVO> getEmpDept();
	List<DeptEmpVO> getDeptEmpList();
	List<SalgradeEmpVO> getSalgradeEmpList();
	List<DeptSalgradeEmpVO> getDeptSalgradeEmpList();
}
