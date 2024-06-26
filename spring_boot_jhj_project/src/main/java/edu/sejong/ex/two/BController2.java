package edu.sejong.ex.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.page.PageVO;

/*
1. interface는 필요가 없음 
2. sqlSession에서 제공하는 함수(selectList,selectOne)를 이용함
3. 쿼리구현을 위한 XML이 필요. 
해당 XML의 namespace는  개발자가가 정함
 */
@Controller
@RequestMapping("/two")
public class BController2 {
	
	@Autowired
	private BService2 bserveice2;
	
	@RequestMapping("/list")
	public String list(Model model)throws Exception {
		System.out.println("list()");
		model.addAttribute("boards",bserveice2.selectBoardList());
		
		return "/board/list";
	}	
	
	@RequestMapping("/list2")
	public String list2(Model model,Criteria cri)throws Exception {
		System.out.println("list2()");
		model.addAttribute("boards",bserveice2.selectBoardPagingList(cri));
		model.addAttribute("pageMaker",new PageVO(cri, bserveice2.getTotal()));
		
		return "/board/list2";
	}
	
}
