package com.asb.example.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asb.example.model.OrderDiscount;
import com.asb.example.model.OrderRequest;

@Service
public class OrderDiscountService {

	@Autowired
	private KieContainer kieContainer;

	public OrderDiscount getDiscount(OrderRequest orderRequest) {
		OrderDiscount orderDiscount = new OrderDiscount();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("orderDiscount", orderDiscount);
		kieSession.insert(orderRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		return orderDiscount;
	}
}