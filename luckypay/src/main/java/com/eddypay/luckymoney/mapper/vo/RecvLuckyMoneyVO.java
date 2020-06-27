package com.eddypay.luckymoney.mapper.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecvLuckyMoneyVO {
	private long dividedLuckyAmt;
	private String resultCode;
	private String resultMsg;
}
