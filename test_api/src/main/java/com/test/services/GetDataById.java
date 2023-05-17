package com.test.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.FlowVariables;
import com.test.repositories.CustomersRepository;
import com.test.repositories.OrdersRepository;

@Service
public class GetDataById {

	@Autowired
	CustomersRepository custRepo;
	
	@Autowired
	OrdersRepository ordRepo;
	
	public Map<String, Object> getDataById (FlowVariables flowVars) {
		
		try {
			String id = flowVars.getId();
			
			String index = flowVars.getIndex();
			
			Map<String, Object> response = new HashMap<String,Object>();
			if (index.equals("customer")) {
				response = custRepo.getDataCustomerById(id);
			} else {
				response = ordRepo.getDataOrderById(id);
			}
			
			return response;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
