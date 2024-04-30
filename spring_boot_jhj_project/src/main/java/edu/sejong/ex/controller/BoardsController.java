package edu.sejong.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardsController {

	@Autowired
	BoardService boardService;

	@GetMapping("/list")
	public BoardVO list() {
		log.info("list()..");
		BoardVO vo=boardService.get(2054);
		return vo;
	}
	@GetMapping("/list2")
	public List<BoardVO> list2(Criteria criteria,Model model) {
		log.info("list2()..");
		
		List<BoardVO> list= boardService.getListWithPaging(criteria);
		
		return list;
	}
}
