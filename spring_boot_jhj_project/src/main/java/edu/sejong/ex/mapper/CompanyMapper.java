package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.EmpDeptVO;

@Mapper
public interface CompanyMapper {
	List<EmpDeptVO> getEmpDept();
}
