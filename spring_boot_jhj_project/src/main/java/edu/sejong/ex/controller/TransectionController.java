package edu.sejong.ex.controller;

import javax.websocket.server.PathParam;

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
	public void Transaction(@PathVariable("num") int num,Model model) {
		log.info("Transaction()..============="+num);
		if(num==1) {
			transectionTestService.transectionTest1();
		}
	}
	

}
