
package com.eddypay.luckymoney.mapper.vo;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReqLuckyMoneyVO {
	private int seq;
	private String token;
	private String userId;
	private String roomId;
	private long luckyMoneyAmt;
	private int luckyMoneyTargetCnt;
	private String regDt;
	private String regTm;
	private Long[] dividedAmts;
	
}
