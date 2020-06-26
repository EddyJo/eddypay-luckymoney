package com.eddypay.luckymoney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eddypay.luckymoney.mapper.CommonMapper;
import com.eddypay.luckymoney.service.CommonService;

@Service
public class CommonSerivceImpl implements CommonService {

	@Autowired
	private CommonMapper commonMapper;

	@Override
	public String getDate() {
		
		return commonMapper.getDate();
	}
	
}
