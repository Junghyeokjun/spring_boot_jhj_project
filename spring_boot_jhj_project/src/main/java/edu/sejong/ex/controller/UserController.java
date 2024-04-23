package edu.sejong.ex.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.sejong.ex.service.UserService;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/index")
	public String index(Model model) {
		log.info("index()..");
		model.addAttribute("rand",new Random());
		model.addAttribute("DeptSalgradeEmp", userService.getDeptSalgradeEmVOList());
		return "/index";
	}
//	@GetMapping("/login")
//	public String login(Model model) {
//		log.info("login()..");
//
//		return "/login";
//	}
	@PostMapping("/signUp")
	public String signUp(UserVO userVO) {
		log.info("signUp()..");
		userService.userSignUp(userVO);
		return "redirect:/index";
	}
}
