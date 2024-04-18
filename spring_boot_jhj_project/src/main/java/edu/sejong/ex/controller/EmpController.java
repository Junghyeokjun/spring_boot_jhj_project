package edu.sejong.ex.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.EmpService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	EmpService empService;

	@GetMapping("/list")
	public String list(Model model) {
		log.info("list()..");
		
		model.addAttribute("deptEmps", empService.getDeptEmpVOList());
		return "/emp/empList";
	}
	
	@GetMapping("/salgrade")
	public String salgrade(Model model) {
		log.info("salgrade()..");
		
		model.addAttribute("salgerades", empService.getSalgradeEmpVOList());
		return "/emp/salgrade";
	}	
	
	@GetMapping("/deptsalgrade")
	public String deptsalgrade(Model model) {
		log.info("deptsalgrade()..");
		
		model.addAttribute("deptsalgrade", empService.getDeptSalgradeEmVOList());
		return "/emp/deptsalgrade";
	}
	@GetMapping("/index")
	public String index(Model model) {
		log.info("index()..");
		model.addAttribute("rand",new Random());
		model.addAttribute("deptEmps", empService.getDeptEmpVOList());
		return "/emp/index";
	}
}
