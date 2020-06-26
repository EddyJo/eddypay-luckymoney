package com.eddypay.luckymoney.controller;

import org.springframework.web.bind.annotation.RestController;

import com.eddypay.luckymoney.service.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloWorldController {

	@Autowired
	CommonService commonService;
	
    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }
    
    @RequestMapping("/date")
    public String getDate() {
        return commonService.getDate();
    }
}
