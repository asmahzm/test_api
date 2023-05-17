package com.test.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.FlowVariables;
import com.test.repositories.CustomersRepository;
import com.test.repositories.OrdersRepository;

@Service
public class InputData {

	@Autowired
	CustomersRepository custRepo;
	
	@Autowired
	OrdersRepository ordRepo;
	
	public Map<String, Object> inputData (FlowVariables flowVars) {
		
		try {
			Map<String, Object> payload = flowVars.getDataParameter();
			
			String index = flowVars.getIndex();
			
			Map<String, Object> response = new HashMap<String,Object>();
			
			int statusInsert = 0;
			if (index.equals("customer")) {
				statusInsert = custRepo.insertDataCustomer(payload.get("id").toString(), payload.get("name").toString(), 
						payload.get("email").toString(), payload.get("phone").toString());
			} else {
				statusInsert = ordRepo.insertDataOrder(payload.get("id").toString(), payload.get("customer_id").toString(), 
						payload.get("total_price").toString(), payload.get("create_at").toString());
			}
			
			response.put("status", statusInsert);
			return response;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
