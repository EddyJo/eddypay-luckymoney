package com.eddypay.luckypay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eddypay.luckypay.mapper.CommonMapper;
import com.eddypay.luckypay.service.CommonService;

@Service
public class CommonSerivceImpl implements CommonService {

	@Autowired
	private CommonMapper commonMapper;

	@Override
	public String getDate() {
		
		return commonMapper.getDate();
	}
	
}
