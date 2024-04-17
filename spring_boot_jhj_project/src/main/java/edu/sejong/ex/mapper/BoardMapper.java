package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.DeptVO;
import edu.sejong.ex.vo.EmpVO;

@Mapper
public interface BoardMapper {
	
	@Select("select * from mvc_board2 order by bgroup desc, bstep asc")
	List<BoardVO> getList2();
	
	List<BoardVO> getList();
	BoardVO read(int bno);
	int delete(int bid);
	int insertBoard(BoardVO boardVO);
	int updateBoard(BoardVO boardVO);
	void upHit(BoardVO boardVO);
	
	//댓글 관련
	void updateShape(BoardVO boardVO);
	void insertReply(BoardVO boardVO);
	//페이징 관련
	List<BoardVO> getListWithPaging(Criteria cri);
	int getTotalCount();
	
	List<DeptVO> getJoinDept();
	List<EmpVO> getJoinEmp();

}
