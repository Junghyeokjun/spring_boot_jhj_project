package edu.sejong.ex.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransectionTestService {

	@Autowired
	BoardMapper mapper;

	@Transactional
	public void transectionTest1() {
		log.info("transectionTest1() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션1");
		boardVO.setBname("트랜잭션1");
		boardVO.setBtitle("트랜잭션1");
	
		mapper.insertBoard(boardVO);
		
		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션2");
		boardVO2.setBname("트랜잭션2");
		boardVO2.setBtitle("트랜잭션2");

		mapper.insertBoard(boardVO2);
		
	}
	
	public void transectionTest2() {
		log.info("transectionTest2() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션1");
		boardVO.setBname("트랜잭션1");
		boardVO.setBtitle("트랜잭션1");
	
		mapper.insertBoard(boardVO);
		
		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션2");
		boardVO2.setBname("트랜잭션2");
		boardVO2.setBtitle("트랜잭션2");

		//일부러 트랜잭션을 위한 테스트로 null값을 넣음
		boardVO2=null;
		mapper.insertBoard(boardVO2);
		
	}
	
	@Transactional
	public void transectionTest3() {
		log.info("transectionTest3() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션3");
		boardVO.setBname("트랜잭션3");
		boardVO.setBtitle("트랜잭션3");
	
		mapper.insertBoard(boardVO);
		
		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션3");
		boardVO2.setBname("트랜잭션3");
		boardVO2.setBtitle("트랜잭션3");

		//일부러 트랜잭션을 위한 테스트로 null값을 넣음
		boardVO2=null;
		mapper.insertBoard(boardVO2);
		
	}	
	
	@Transactional //롤백
	public void transectionTest4() {
		log.info("transectionTest4() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션4");
		boardVO.setBname("트랜잭션4");
		boardVO.setBtitle("트랜잭션4");
	
		mapper.insertBoard(boardVO);
		
		throw new RuntimeException("RuntimeException for rollback");
	}
	
	@Transactional //롤백 안됨
	public void transectionTest5() throws SQLException {
		log.info("transectionTest5() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션5");
		boardVO.setBname("트랜잭션5");
		boardVO.setBtitle("트랜잭션5");
	
		mapper.insertBoard(boardVO);
		
		throw new SQLException("RuntimeException for rollback");
	}
	
	//@Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
	// Exception예외로 롤백을 하려면 다음과 같이 지정하면됩니다. @Transactional(rollbackFor = Exception.class) 
	// 여러개의 예외를 지정할 수도 있습니다. @Transactional(rollbackFro = {RuntimeException.class, Exception.class})
	@Transactional(rollbackFor = Exception.class)
	public void transectionTest6() throws SQLException {
		log.info("transectionTest6() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션6");
		boardVO.setBname("트랜잭션6");
		boardVO.setBtitle("트랜잭션6");
	
		mapper.insertBoard(boardVO);
		
		throw new SQLException("RuntimeException for rollback");
	}
	
	@Transactional(rollbackFor = SQLException.class)
	public void transectionTest7() throws SQLException {
		log.info("transectionTest7() 테스트");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션7");
		boardVO.setBname("트랜잭션7");
		boardVO.setBtitle("트랜잭션7");
	
		mapper.insertBoard(boardVO);
		
		throw new SQLException("RuntimeException for rollback");
	}
}
