package edu.sejong.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
      

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartVO {
	private String product="사이다";
	private int count;
}
