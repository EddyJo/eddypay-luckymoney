package com.eddypay.luckymoney.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eddypay.luckymoney.mapper.vo.MyLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.RecvLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.ReqLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.ResLuckyMoneyVO;
import com.eddypay.luckymoney.service.LuckyMoneyService;

@RestController
@RequestMapping("/luckymoney")
public class LuckyMoneyController {
	
	
	private static final Logger log = LoggerFactory.getLogger(LuckyMoneyController.class);

	
	@Autowired
	LuckyMoneyService luckyMoneyService;
	
	@PostMapping("/")
	public ResLuckyMoneyVO generateLuckyMoney(@RequestHeader("X-USER-ID") String userId,
										@RequestHeader("X-ROOM-ID") String roomId, 
											@RequestBody ReqLuckyMoneyVO reqLuckyMoneyVO) {
		log.info("뿌리기 API 호출");
		reqLuckyMoneyVO.setRoomId(roomId);
		reqLuckyMoneyVO.setUserId(userId);
		log.info("뿌리기 Service 호출 시자 ");
		ResLuckyMoneyVO res = luckyMoneyService.generateLuckyMoney(reqLuckyMoneyVO);
		
		return res;
	}
	
	@PutMapping("/")
	public RecvLuckyMoneyVO receivceLuckyMoney(@RequestHeader("X-USER-ID") String userId,
										@RequestHeader("X-ROOM-ID") String roomId, 
											@RequestBody ReqLuckyMoneyVO reqLuckyMoneyVO) {
		
		reqLuckyMoneyVO.setRoomId(roomId);
		reqLuckyMoneyVO.setUserId(userId);
		
		return luckyMoneyService.recevieLuckyMoney(reqLuckyMoneyVO);
	}
	
	@GetMapping("/")
	public MyLuckyMoneyVO getLuckyMoneyInfo(@RequestHeader("X-USER-ID") String userId,
												@RequestHeader("X-ROOM-ID") String roomId, 
													@RequestBody ReqLuckyMoneyVO reqLuckyMoneyVO) {
		
		reqLuckyMoneyVO.setRoomId(roomId);
		reqLuckyMoneyVO.setUserId(userId);
		
		return luckyMoneyService.getLuckyMoneyInfo(reqLuckyMoneyVO);
	}
}
