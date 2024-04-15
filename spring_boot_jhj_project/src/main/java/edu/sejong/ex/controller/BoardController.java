package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list()..");
		
		model.addAttribute("boards", boardService.getList());
		return "/board/list";
	}
	
	@GetMapping("/content_view")
	public String contentView(Model model,int bid) {
		log.info("contentView()..");
		model.addAttribute("content", boardService.get(bid));
		return "/board/content_view";
	}
	
	@GetMapping("/delete")
	public String delete(int bid) {
		log.info("delete()..");
		log.info(boardService.remove(bid)+"행 삭제");
		return "redirect:/board/list";
	}
	
	@GetMapping("/write_view")
	public String write_view() {
		log.info("write_view()..");
		return "/board/write_view";
	}
	
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		log.info("write()..");
		log.info(boardService.writeBoard(boardVO)+"행 삽입");
		return "redirect:/board/list";
	}
}
