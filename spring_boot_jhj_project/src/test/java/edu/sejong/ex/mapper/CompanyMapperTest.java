package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.DeptSalgradeEmpVO;
import edu.sejong.ex.vo.EmpDeptVO;
import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.SalgradeEmpVO;
import edu.sejong.ex.vo.SalgradeVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
class CompanyMapperTest {

	@Autowired
	CompanyMapper companyMapper;
	
	@Test
	void testCompanyMapper() {
		assertNotNull(companyMapper);
	}
	@Disabled
	@Test
	void testGetEmpDept() {
		for (EmpDeptVO vo : companyMapper.getEmpDept()) {
			log.info("확인============"+vo);
			log.info("사원번호"+vo.getEmpno());
			log.info("사원이름"+vo.getEname());
			log.info("부서번호"+vo.getDeptno());
			log.info("부서이름"+vo.getDname());
		}
	}
	@Disabled
	@Test
	void testGetDeptEmpList() {
		for (DeptEmpVO vo : companyMapper.getDeptEmpList()) {
			System.out.println(vo);
			for (EmpVO emp : vo.getEmpList()) {
				System.out.println(emp);
			}

		}
	}
	
	@Test
	void testgetDeptSalgradeEmpList() {
		for (DeptSalgradeEmpVO vo : companyMapper.getDeptSalgradeEmpList()) {
			System.out.println(vo);
			for (SalgradeEmpVO sal : vo.getSalgradeEmpList()) {
				System.out.println(sal);
				
				for (EmpVO emp : sal.getEmpList()) {
					System.out.println(emp);
				}
			}

		}
	}

}
