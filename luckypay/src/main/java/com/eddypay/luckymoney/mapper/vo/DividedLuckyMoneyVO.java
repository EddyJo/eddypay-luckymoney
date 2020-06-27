package com.eddypay.luckymoney.mapper.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DividedLuckyMoneyVO {
	private int seq;
	private String userId;
	private String roomId;
	private Long dividedLuckyMoney;
	private String regDt;
	private String regTm;
	private String recvDt;
	private String recvTm;
	private String recvYn;
	private String recvUserId;
}
