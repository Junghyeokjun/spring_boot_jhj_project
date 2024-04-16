package edu.sejong.ex.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PageVO {
	private int startPage;//화면에 보여지는 페이지 시작번호
	private int endPage;//화면에 보여지는 끝번호
	
	private boolean prev,next; //이전과 다음으로 이동가능한 링크 표시
	private int total; //전체 게시판 글 수
	private Criteria criteria;
	
	public PageVO(Criteria criteria, int total) {
		this.criteria=criteria;
		this.total=total;

		this.endPage=(int)(Math.ceil(criteria.getPageNum()/10.0))*10;
		this.startPage=this.endPage-9;
		
		//endPage 재계산
		int realEnd=(int)(Math.ceil((total*1.0)/criteria.getAmount()));
		this.endPage=Math.min(endPage, realEnd);
		//시작번호가 1보다 크면 true
		this.prev=this.startPage>1;
		//끝번호가 realEnd보다 작으면 true
		this.next=this.endPage<realEnd;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder=
				UriComponentsBuilder.newInstance().queryParam("pageNum", page)
				.queryParam("amount", criteria.getAmount())
				.build();
		
		return uriComponentsBuilder.toUriString();
	}
}
