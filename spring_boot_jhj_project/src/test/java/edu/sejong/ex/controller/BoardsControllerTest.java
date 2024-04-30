package edu.sejong.ex.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class BoardsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/boards/list"))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andDo(print());	
	}
	
	@Test
	void testPaging() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/boards/list2?pageNum=2&amount=10"))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andDo(print());	
	}

}
