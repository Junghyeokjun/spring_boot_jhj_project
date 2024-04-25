package edu.sejong.ex.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.page.PageVO;
import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board")
public class RestBoardController {

	@Autowired
	BoardService boardService;

	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv) {
		log.info("list()..");
		
		mv.addObject("boards", boardService.getList());
		mv.setViewName("/board/list2");
		return mv;
	}
	
	@GetMapping("/list2")
	public ModelAndView list2(Criteria criteria,ModelAndView mv) {
		log.info("list2()..");
		
		mv.addObject("boards", boardService.getListWithPaging(criteria));
		
		int total=boardService.getTotal();
		
		mv.addObject("pageMaker",new PageVO(criteria,total) );
		mv.setViewName("/board/list2");
		
		return mv;
	}
	
	@GetMapping("/content_view")
	public ModelAndView contentView(ModelAndView mv,int bid) {
		log.info("contentView()..");
		mv.addObject("content", boardService.get(bid));
		mv.setViewName("/board/content_view");
		return mv;
	}
	
	@DeleteMapping("/{bid}")
	public int delete(@PathVariable int bid) {
		log.info("delete()..");
		int i=boardService.remove(bid);
		log.info(i+"행 삭제");
		return i;
	}
	
	@GetMapping("/write_view")
	public ModelAndView write_view(ModelAndView mv) {
		log.info("write_view()..");
		mv.setViewName("/board/write_view");
		return mv;
	}
	
	@PostMapping("/write")
	public ModelAndView write(ModelAndView mv,BoardVO boardVO) {
		log.info("write()..");
		log.info(boardService.writeBoard(boardVO)+"행 삽입");
		mv.setViewName("board/list2");
		return mv;
	}
	
	@PostMapping("/modify")
	public ModelAndView modify(ModelAndView mv, BoardVO boardVO) {
		log.info("modify()..");
		log.info(boardService.modifyBoard(boardVO)+"행 수정");
		mv.setViewName("/board/list2");
		return mv;
	}
	
	@GetMapping("/reply_view")
	public ModelAndView reply_view(BoardVO boardVO , ModelAndView mv) {
		log.info("reply_view()..");
		
		mv.addObject("reply_view",boardService.get(boardVO.getBid()));
		mv.setViewName("/board/reply_view");
		return mv;
	}
	
	@PostMapping("/reply")
	public ModelAndView reply(ModelAndView mv,BoardVO boardVO) {
		log.info("reply()..");
		boardService.writeReply(boardVO);
		mv.setViewName("redirect:/board/list2");
		return mv;
	}

}
