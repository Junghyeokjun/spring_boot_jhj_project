package edu.sejong.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.sejong.ex.security.CustomNoOpPasswordEncoder;
import edu.sejong.ex.security.CustomUserDetailsService;
import edu.sejong.ex.security.EmpUserDetailsService;

@Configuration
@EnableWebSecurity//스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private EmpUserDetailsService empUserDetailsService;
	
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
	    .antMatchers("/user/**").hasAnyRole("USER") 
	    .antMatchers("/admin/**").hasAnyRole("ADMIN")
	    .antMatchers("/emp/list").hasAnyRole("ADMIN")
	    .antMatchers("/board/list").hasAnyRole("ADMIN")
	    .antMatchers("/**").permitAll();
	    
	    http.formLogin()
	    .loginPage("/login")//loginpage()= 로그인을 진행할 페이지의 url
	    .usernameParameter("id")
	    .passwordParameter("pw")
	    .defaultSuccessUrl("/")
	    .permitAll();//모든유저가 로그인화면은 볼수 있다.
	}	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new CustomNoOpPasswordEncoder();
//		return new BCryptPasswordEncoder();
	}
	
	//테스트용 유저 만들기(인메모리 방식)
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.inMemoryAuthentication()
//		.withUser("member").password("{noop}member").roles("USER")
//		.and()
//		.withUser("admin").password("{noop}admin").roles("ADMIN");
		auth.userDetailsService(empUserDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	
}
