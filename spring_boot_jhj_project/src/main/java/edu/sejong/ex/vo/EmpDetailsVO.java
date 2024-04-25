package edu.sejong.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter

public class EmpDetailsVO implements UserDetails{
	
	private EmpVO emp=null;
	
	public EmpDetailsVO(EmpVO emp) {
		this.setEmp(emp);
	} 
	public EmpVO getEmp() {
		return this.emp;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return String.valueOf(emp.getEmpno());
	}

	@Override
	public String getUsername() {
		return emp.getEname();
	}

	@Override
	public boolean isAccountNonExpired() {//계정만료여부
		return true; 
	}

	@Override
	public boolean isAccountNonLocked() {//계정잠금여부
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {//패스워드 만료여부
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {//계정 활성화 여부
		// TODO Auto-generated method stub
		return true;
	}
	
}
