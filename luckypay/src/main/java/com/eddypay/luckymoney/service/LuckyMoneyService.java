package com.eddypay.luckymoney.service;


import org.springframework.stereotype.Service;

import com.eddypay.luckymoney.mapper.vo.MyLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.RecvLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.ReqLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.ResLuckyMoneyVO;



public interface LuckyMoneyService {
	
	
	public ResLuckyMoneyVO generateLuckyMoney(ReqLuckyMoneyVO reqLuckyMoneyVO);
	public RecvLuckyMoneyVO recevieLuckyMoney(ReqLuckyMoneyVO reqLuckyMoneyVO);
	public MyLuckyMoneyVO getLuckyMoneyInfo(ReqLuckyMoneyVO reqLuckyMoneyVO);
}
