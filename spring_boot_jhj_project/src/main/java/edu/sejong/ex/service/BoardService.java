package edu.sejong.ex.service;

import java.util.List;

import edu.sejong.ex.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList();
	BoardVO get(int bno);
	int remove(int bid);
	int writeBoard(BoardVO boardVO);
	int modifyBoard(BoardVO boardVO);
	void writeReply(BoardVO boardVO);
	void addHit(BoardVO boardVO);
}
