package com.test.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.FlowVariables;
import com.test.repositories.CustomersRepository;
import com.test.repositories.OrdersRepository;

@Service
public class DeleteDataById {

	@Autowired
	CustomersRepository custRepo;
	
	@Autowired
	OrdersRepository ordRepo;
	
	public Map<String, Object> deleteDataById (FlowVariables flowVars) {
		
		try {
			Map<String, Object> payload = flowVars.getDataParameter();
			
			String index = flowVars.getIndex();
			
			Map<String, Object> response = new HashMap<String,Object>();
			
			int statusDelete = 0;
			if (index.equals("customer")) {
				statusDelete = custRepo.deleteDataCustomer(payload.get("id").toString());
			} else {
				statusDelete = ordRepo.deleteDataOrder(payload.get("id").toString());
			}
			
			response.put("status", statusDelete);
			return response;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
