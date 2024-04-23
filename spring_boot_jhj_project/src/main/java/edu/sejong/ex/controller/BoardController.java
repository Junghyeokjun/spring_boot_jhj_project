package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.page.PageVO;
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
		
//		model.addAttribute("boards", boardService.getList());
		return "redirect:/board/list2";
	}
	
	@GetMapping("/list2")
	public String list2(Criteria criteria,Model model) {
		log.info("list2()..");
		
		model.addAttribute("boards", boardService.getListWithPaging(criteria));
		
		int total=boardService.getTotal();
		
		model.addAttribute("pageMaker",new PageVO(criteria,total) );
		
		return "/board/list2";
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
		return "redirect:/board/list2";
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
		return "redirect:/board/list2";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO) {
		log.info("modify()..");
		log.info(boardService.modifyBoard(boardVO)+"행 수정");
		return "redirect:/board/list2";
	}
	
	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO , Model model) {
		log.info("reply_view()..");
		
		model.addAttribute("reply_view",boardService.get(boardVO.getBid()));
		return "/board/reply_view";
	}
	
	@PostMapping("/reply")
	public String reply(BoardVO boardVO) {
		log.info("reply()..");
		boardService.writeReply(boardVO);
		return "redirect:/board/list2";
	}
	
	@GetMapping("/hit")
	public String hit(BoardVO boardVO) {
		log.info("hit()..");
		boardService.addHit(boardVO);
		return "redirect:/board/content_view?bid="+boardVO.getBid();
	}
}
