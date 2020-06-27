package com.eddypay.luckymoney.service;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;


import org.junit.jupiter.api.Test;
import com.eddypay.luckymoney.mapper.vo.ReqLuckyMoneyVO;
import com.eddypay.luckymoney.service.impl.LuckyMoneyServiceImpl;

public class LuckyMoneyServiceTest {
	
	
	LuckyMoneyServiceImpl service = new LuckyMoneyServiceImpl();
	
	
	@Test
	public void divideLuckyAmt() {
		try {
			int targetCnt = 4;
			long amt = 1000L;
			
			ReqLuckyMoneyVO req = ReqLuckyMoneyVO.builder()
									.luckyMoneyAmt(amt)
									.luckyMoneyTargetCnt(targetCnt)
									.build();
			
			Long[] arr = service.divideLuckyAmt(req);
			System.out.println(Arrays.asList(arr));
			long sum = 0;
			for(Long randomAmt : Arrays.asList(arr)) {
				sum += randomAmt;
			}
			assertEquals(amt, sum);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setReqDtTmTest() {
		try {
			int targetCnt = 4;
			long amt = 1000L;
			String userId = "1234";
			String roomId = "R1234";
			
			ReqLuckyMoneyVO req = ReqLuckyMoneyVO.builder()
					.userId(userId)
					.roomId(roomId)
					.luckyMoneyAmt(amt)
					.luckyMoneyTargetCnt(targetCnt)
					.build();
			
			service.setReqDtTm(req);
			
			System.out.println(req);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void saveLuckyMoneyInfoTest() {
		try {
			int targetCnt = 4;
			long amt = 1000L;
			String userId = "1234";
			String roomId = "R1234";
			
			ReqLuckyMoneyVO req = ReqLuckyMoneyVO.builder()
					.userId(userId)
					.roomId(roomId)
					.luckyMoneyAmt(amt)
					.luckyMoneyTargetCnt(targetCnt)
					.build();
			
			service.setReqDtTm(req);
			
			service.saveLuckyMoneyInfo(req);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
/**
	@Test
	public void generateLuckyMoneyTest() {
		
		int targetCnt = 4;
		long amt = 1000L;
		String userId = "1234";
		String roomId = "R1234";
		
		ReqLuckyMoneyVO req = ReqLuckyMoneyVO.builder()
				.userId(userId)
				.roomId(roomId)
				.luckyMoneyAmt(amt)
				.luckyMoneyTargetCnt(targetCnt)
				.build();
		System.out.println("---");
		
		String token = service.generateLuckyMoney(req);
		System.out.println(token);
		assertEquals("tok", token);
		
	}
	**/
		
	
}
