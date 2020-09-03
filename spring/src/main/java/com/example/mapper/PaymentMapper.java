package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.beans.PaymentBean;

public interface PaymentMapper {
	@Select("select * from payment")
	List<PaymentBean> selectPayments();
}
