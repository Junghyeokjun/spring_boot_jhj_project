package edu.sejong.ex;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity//스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
		
//		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		web.ignoring().antMatchers("/css/**","/js/**","/imgx/**","/lib/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//csrf설정 해제
		//초기 개발시만 권장
//		http.csrf().disable();
		/* 권한설정 */
	    http.authorizeRequests()
	    .antMatchers("/member/**").hasAnyRole("MEMBER") 
	    .antMatchers("/admin/**").hasAnyRole("ADMIN")
	    .antMatchers("/emp/list").hasAnyRole("ADMIN")
	    .antMatchers("/**").permitAll();   
	    http.formLogin();
	}	

	//테스트용 유저 만들기(인메모리 방식)
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("member").password("{noop}member").roles("USER")
		.and()
		.withUser("admin").password("{noop}admin").roles("ADMIN");

		
	}

	
	
}
