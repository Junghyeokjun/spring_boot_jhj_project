package edu.sejong.ex.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.TransectionTestService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/tx")
public class TransectionController {

	@Autowired
	TransectionTestService transectionTestService;
	
	@GetMapping("/{num}")
	public void Transaction(@PathVariable("num") int num,Model model) throws SQLException {
		log.info("Transaction()..============="+num);
		if(num==1) {
			transectionTestService.transectionTest1();
		}
		if(num==2) {
			transectionTestService.transectionTest2();
		}
		if(num==3) {
			transectionTestService.transectionTest3();
		}
		if(num==4) {
			transectionTestService.transectionTest4();
		}
		if(num==5) {
			transectionTestService.transectionTest5();
		}
		if(num==6) {
			transectionTestService.transectionTest6();
		}
		if(num==7) {
			transectionTestService.transectionTest7();
		}
	}
	

}
