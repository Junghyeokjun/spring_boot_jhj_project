package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList();
	BoardVO get(int bno);
}
