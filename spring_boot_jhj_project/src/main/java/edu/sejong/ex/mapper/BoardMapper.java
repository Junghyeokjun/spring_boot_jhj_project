package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getList();
	BoardVO read(int bno);
	int delete(int bid);
	int insertBoard(BoardVO boardVO);
	int updateBoard(BoardVO boardVO);
	void updateShape(BoardVO boardVO);
	void insertReply(BoardVO boardVO);
	void upHit(BoardVO boardVO);
}
