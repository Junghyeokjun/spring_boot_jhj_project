package edu.sejong.ex.controller;

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
		
		model.addAttribute("depts", empService.getDeptEmpVOList());
		return "/board/empList";
	}
	
	@GetMapping("/salgrade")
	public String salgrade(Model model) {
		log.info("salgrade()..");
		
		model.addAttribute("salgerades", empService.getSalgradeEmpVOList());
		return "/board/salgrade";
	}
	
}
