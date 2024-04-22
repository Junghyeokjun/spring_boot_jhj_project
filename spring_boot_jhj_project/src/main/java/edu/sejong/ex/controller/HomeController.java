package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.sejong.ex.service.EmpService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	EmpService empService;

	@GetMapping("/")
	public String home() {
		log.info("home()..");
		return "home";
	}
	
}
