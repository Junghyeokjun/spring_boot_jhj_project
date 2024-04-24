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
@ToString
public class UserDetailsVO implements UserDetails{
	
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	//테스트
	private String email = "admin@admin.com";
	private EmpVO emp=null;
	private CartVO cart=null;
	
	public EmpVO getEmp() {
		return this.emp;
	}
	
	public CartVO getCart() {
		return this.cart;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	
	public UserDetailsVO(UserVO user) {
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setAuthorities(user);
	}
	
	public UserDetailsVO(UserVO user, EmpVO empVO) {
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setAuthorities(user);
		this.emp=empVO;
	}
	
	public UserDetailsVO(UserVO user, EmpVO empVO,CartVO cartVO) {
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setAuthorities(user);
		this.emp=empVO;
		this.cart=cartVO;
	}
	
	public void setAuthorities(UserVO user) {
		List<GrantedAuthority> authorietis = new ArrayList<GrantedAuthority>();
		
		for (AuthVO authVO : user.getAuthList()) {
			authorietis.add(new SimpleGrantedAuthority(authVO.getAuthority()));
		}
		this.authorities=authorietis;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
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
