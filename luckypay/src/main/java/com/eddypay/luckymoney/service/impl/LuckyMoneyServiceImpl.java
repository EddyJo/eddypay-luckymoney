package com.eddypay.luckymoney.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eddypay.luckymoney.mapper.LuckyMoneyMapper;
import com.eddypay.luckymoney.mapper.vo.DividedLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.MyLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.RecvLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.ReqLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.ResLuckyMoneyVO;
import com.eddypay.luckymoney.service.LuckyMoneyService;

@Service
public class LuckyMoneyServiceImpl implements LuckyMoneyService {
	
	
	private static final Logger log = LoggerFactory.getLogger(LuckyMoneyServiceImpl.class);

	@Autowired
	private LuckyMoneyMapper luckyMoneyMapper;
	
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@Override
	public ResLuckyMoneyVO generateLuckyMoney(ReqLuckyMoneyVO reqLuckyMoneyVO) {
		// TODO 
		log.info("뿌리기 생성 시작");
		setReqDtTm(reqLuckyMoneyVO);
		
		//1. 금액 분배
		log.info("금액 분배");
		Long[] arrayOfdividedLuckyAmt = divideLuckyAmt(reqLuckyMoneyVO);
		reqLuckyMoneyVO.setDividedAmts(arrayOfdividedLuckyAmt);
		
		//2. 토큰 생성
		log.info("토큰 생성");
		String token = generateToken(reqLuckyMoneyVO);
		reqLuckyMoneyVO.setToken(token);
		
		log.info("토큰 생성 완료 : ");
		
		//3. 저장 처리
		log.info("저장 처리");
		saveLuckyMoneyInfo(reqLuckyMoneyVO);
		
		ResLuckyMoneyVO res = ResLuckyMoneyVO.builder()
									.token(token)
								    .build();
		return res;
	}

	
	@Override
	public RecvLuckyMoneyVO recevieLuckyMoney(ReqLuckyMoneyVO reqLuckyMoneyVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyLuckyMoneyVO getLuckyMoneyInfo(ReqLuckyMoneyVO reqLuckyMoneyVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getTimeStr() {
		Date date = new Date();
		
		return sdf.format(date.getTime());
	}
	
	public void setReqDtTm(ReqLuckyMoneyVO reqLuckyMoneyVO) {
		String yyyyMMddHHmmss = getTimeStr();
		String yyyyMMdd = yyyyMMddHHmmss.substring(0, 8);
		String HHmmss = yyyyMMddHHmmss.substring(8, 14);
		reqLuckyMoneyVO.setRegDt(yyyyMMdd);
		reqLuckyMoneyVO.setRegTm(HHmmss);
	}
	
	public Long[] divideLuckyAmt(ReqLuckyMoneyVO reqLuckyMoneyVO) {
		int targetCnt = reqLuckyMoneyVO.getLuckyMoneyTargetCnt();
		long luckyAmt = reqLuckyMoneyVO.getLuckyMoneyAmt();
		
		Long[] arrayOfdividedLuckyAmt = new Long[targetCnt];
		Random random = new Random();
		
		for(int i=targetCnt;i>0;i--) {
			long randomAmt;
			if(i==1) {
				randomAmt = luckyAmt;
			} else {
				randomAmt = random.longs(1, luckyAmt-i).findFirst().getAsLong();
			}

			luckyAmt -= randomAmt;
			arrayOfdividedLuckyAmt[i-1] = randomAmt;
		}
		
		
		return arrayOfdividedLuckyAmt;
	}

	
	private String generateToken(ReqLuckyMoneyVO reqLuckyMoneyVO) {
		String token = genRandomToken();
		 
		while(!isNotDuplicateToken(reqLuckyMoneyVO)) {
			token = genRandomToken();
		}
		
		return token;
	}
	
	private String genRandomToken() {
		
		//랜덤문자열 생성
		return "tok";
	}
	
	private boolean isNotDuplicateToken(ReqLuckyMoneyVO reqLuckyMoneyVO) {
		
		//for문으로 순회 돌면서 10분동안 유효한 토큰값과 일치 하지 않으면 true;
		
		return true;
	}
	
	
	public int genSeq(ReqLuckyMoneyVO reqLuckyMoneyVO) {
		Integer seq = 0 ;
		try {
			seq = luckyMoneyMapper.getSeqOfLuckyMoneySeq(reqLuckyMoneyVO) + 1;
		} catch(Exception e) {
			log.error("Exception : {}", e);
		}
		
	
		return seq; 
	}
	
	public DividedLuckyMoneyVO convertIntoDividedLuckyMoney(ReqLuckyMoneyVO reqLuckyMoneyVO) {
		DividedLuckyMoneyVO dividedLuckyMoneyVO = DividedLuckyMoneyVO.builder()
																.seq(reqLuckyMoneyVO.getSeq())
																.userId(reqLuckyMoneyVO.getUserId())
																.roomId(reqLuckyMoneyVO.getRoomId())
																.regDt(reqLuckyMoneyVO.getRegDt())
																.regTm(reqLuckyMoneyVO.getRegTm())
																.recvYn("N")
															.build();
		
		return dividedLuckyMoneyVO;
	}
	
	
	public void saveLuckyMoneyInfo(ReqLuckyMoneyVO reqLuckyMoneyVO) {
		
		log.info("저장 시작");
		
		int seq = genSeq(reqLuckyMoneyVO);
		
		reqLuckyMoneyVO.setSeq(seq);
		
		luckyMoneyMapper.insertLuckyMoneyInfo(reqLuckyMoneyVO);
		
		DividedLuckyMoneyVO dividedLuckyMoneyVO = convertIntoDividedLuckyMoney(reqLuckyMoneyVO);
		
		Long[] dividedAmts = reqLuckyMoneyVO.getDividedAmts();
		
		
		for(int i=0;i<dividedAmts.length;i++) {
			dividedLuckyMoneyVO.setDividedLuckyMoney(dividedAmts[i]);
			luckyMoneyMapper.insertDividedLuckyMoneyInfo(dividedLuckyMoneyVO);
		}
	}
	
}
