package com.eddypay.luckymoney.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.eddypay.luckymoney.mapper.vo.ReqLuckyMoneyVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(LuckyMoneyController.class)
public class LuckyMoneyControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	private String userId = "1234";
	private String roomId = "R1234";
	
	
	
	@Test
	public void TestGenerateLuckyMoney() throws Exception {
		
		
		ReqLuckyMoneyVO req = ReqLuckyMoneyVO.builder()
								.luckyMoneyAmt(10000)
								.luckyMoneyTargetCnt(3)
								.build();
		
		//when
		final ResultActions actions = mvc.perform(post("/luckymoney/")
				 									.header("X-USER-ID", userId)
				 									.header("X-ROOM-ID", roomId)
				 									.contentType(MediaType.APPLICATION_JSON)
				 									.content(objectMapper.writeValueAsString(req)))
											.andDo(print());
		
		
		//then
		actions
				.andExpect(status().isOk())
				.andExpect(content().string("뿌리기 API 응답 : USER-ID :1234 / ROOM-ID : R1234"));
		
	}
	
	

}
