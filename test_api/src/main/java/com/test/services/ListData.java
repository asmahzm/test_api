package com.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.FlowVariables;
import com.test.repositories.CustomersRepository;
import com.test.repositories.OrdersRepository;

@Service
public class ListData {

	@Autowired
	CustomersRepository custRepo;
	
	@Autowired
	OrdersRepository ordRepo;
	
	public List<Map<String, Object>> listData (FlowVariables flowVars) {
		
		try {
			Map<String, Object> payload = flowVars.getDataParameter();
			String index = flowVars.getIndex();
			
			List<Map<String, Object>> response = new ArrayList<Map<String,Object>>();
			if (index.equals("customer")) {
				response = custRepo.getAllDataCustomers();
			} else {
				response = ordRepo.getAllDataOrders();
			}
			
			return response;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
