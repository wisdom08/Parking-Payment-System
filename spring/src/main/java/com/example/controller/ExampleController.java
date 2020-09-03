package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mapper.LogMapper;
import com.example.mapper.MemberMapper;
import com.example.mapper.PaymentMapper;

@Controller
public class ExampleController {

	@Autowired
	MemberMapper memberMapper;

	@Autowired
	PaymentMapper paymentMapper;

	@Autowired
	LogMapper logMapper;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String selectMembers() {
		memberMapper.selectMembers().stream().forEach(a -> System.out.println(a));

		return "hello";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String selectPayment() {
		paymentMapper.selectPayments().stream().forEach(a -> System.out.println(a));

		return "hello";
	}

	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public String selectLog() {
		logMapper.selectLog().stream().forEach(a -> System.out.println(a));

		return "hello";
	}
}
