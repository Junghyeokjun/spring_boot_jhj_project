package edu.sejong.ex.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		log.info("login()..");
		return "/login/login";
	}
	
	@GetMapping("/loginInfo")
	public String loginInfo(Authentication authentication,Principal principal) {
		
		//1. 로그인 정보를 체크 하는 첫번째 방법 - Principal principal 객체를 갖고 오는 방법
		if(principal!=null) {
			System.out.println("타입정보 : "+principal.getClass());
			System.out.println("ID정보 : "+principal.getName());
		}
		//2. 로그인 정보를 체크 하는 두번째 방법 - Authentication authentication 객체를 갖고 오는 방법
		if(authentication!=null) {
			System.out.println("타입정보 : "+authentication.getClass());
			
			UserDetails user =(UserDetails)authentication.getPrincipal();
			System.out.println("패스워드:"+user.getPassword());
			System.out.println("아이디:"+user.getUsername());
			System.out.println("권한들:"+user.getAuthorities());
		
			WebAuthenticationDetails web=
					(WebAuthenticationDetails) authentication.getDetails();
			System.out.println("세션ID : "+web.getSessionId());
			System.out.println("접속ID : "+web.getRemoteAddress());
		}
		//3. 로그인 정보를 체크 하는 세번째 방법 - SpringContextHolder를 다이렉트로 갖고 오는 방법
		
		UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user!=null) {
			System.out.println("패스워드:"+user.getPassword());
			System.out.println("아이디:"+user.getUsername());
			System.out.println("권한들:"+user.getAuthorities());
		}
		
		return "/loginInfo";
	}	
	
}
