package com.test.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.FlowVariables;
import com.test.repositories.CustomersRepository;
import com.test.repositories.OrdersRepository;

@Service
public class UpdateDataById {

	@Autowired
	CustomersRepository custRepo;
	
	@Autowired
	OrdersRepository ordRepo;
	
	public Map<String, Object> updateDataById (FlowVariables flowVars) {
		
		try {
			Map<String, Object> payload = flowVars.getDataParameter();
			
			String index = flowVars.getIndex();
			
			Map<String, Object> response = new HashMap<String,Object>();
			
			int statusUpdate = 0;
			if (index.equals("customer")) {
				statusUpdate = custRepo.updateDataCustomer(payload.get("name").toString(), payload.get("email").toString(), 
						payload.get("phone").toString(), payload.get("id").toString());
			} else {
				statusUpdate = ordRepo.updateDataOrder(payload.get("customer_id").toString(), payload.get("total_price").toString(), 
						payload.get("create_at").toString(), payload.get("id").toString());
			}
			
			response.put("status", statusUpdate);
			return response;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
