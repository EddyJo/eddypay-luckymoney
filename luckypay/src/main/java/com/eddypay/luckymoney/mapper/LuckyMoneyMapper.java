package com.eddypay.luckymoney.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.eddypay.luckymoney.mapper.vo.DividedLuckyMoneyVO;
import com.eddypay.luckymoney.mapper.vo.ReqLuckyMoneyVO;

@Mapper
public interface LuckyMoneyMapper {
	
	
	public Integer getSeqOfLuckyMoneySeq(ReqLuckyMoneyVO reqLuckyMoneyVO);
	public void insertLuckyMoneyInfo(ReqLuckyMoneyVO reqLuckyMoneyVO);
	public void insertDividedLuckyMoneyInfo(DividedLuckyMoneyVO dividedLuckyMoneyVO);
	
	public ReqLuckyMoneyVO getLuckyMoneyInfo(ReqLuckyMoneyVO reqLuckyMoneyVO);
	public DividedLuckyMoneyVO getDividedLuckyMoneyInfo(ReqLuckyMoneyVO reqLuckyMoneyVO);
	public void updateDividedLuckyMoneyInfo(DividedLuckyMoneyVO dividedLuckyMoneyVO);
	
}
