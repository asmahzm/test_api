package com.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.FlowVariables;
import com.test.services.DeleteDataById;
import com.test.services.GetDataById;
import com.test.services.InputData;
import com.test.services.ListData;
import com.test.services.UpdateDataById;

@RestController
public class TestApiController {

	@Autowired
	ListData listData;
	
	@Autowired
	GetDataById getData;
	
	@Autowired
	InputData inputData;
	
	@Autowired
	UpdateDataById updateData;
	
	@Autowired
	DeleteDataById deleteData;
	
	//CUSTOMERS
	@GetMapping(path = "/customers")
	public List<Map<String, Object>> GetListDataCustomer (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestParam Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		flowVars.setDataHttpRequest(request);
		flowVars.setDataHeader(header);
		flowVars.setDataParameter(parameters);
		flowVars.setIndex("customer");
		
		List<Map<String, Object>> response = new ArrayList<Map<String,Object>>();
		response = listData.listData(flowVars);
		
		return response;
		
	}
	
	@GetMapping(path = "/customer/{id}")
	public Map<String, Object> GetDataCustomer (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @PathVariable String id) {
		
		FlowVariables flowVars = new FlowVariables();
		flowVars.setDataHttpRequest(request);
		flowVars.setDataHeader(header);
		flowVars.setId(id);
		flowVars.setIndex("customer");
		
		Map<String, Object> response = new HashMap<String, Object>();
		response = getData.getDataById(flowVars);
		
		return response;
		
	}
	
	@PostMapping(path = "/customer/input")
	public Map<String, Object> InputDataCustomer (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestBody Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		flowVars.setDataHttpRequest(request);
		flowVars.setDataHeader(header);
		flowVars.setDataParameter(parameters);
		flowVars.setIndex("customer");
		
		Map<String, Object> response = new HashMap<String, Object>();
		response = inputData.inputData(flowVars);
		
		return response;
		
	}
	
	@PostMapping(path = "/customer/update")
	public Map<String, Object> UpdateDataCustomer (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestBody Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		flowVars.setDataHttpRequest(request);
		flowVars.setDataHeader(header);
		flowVars.setDataParameter(parameters);
		flowVars.setIndex("customer");
		
		Map<String, Object> response = new HashMap<String, Object>();
		response = updateData.updateDataById(flowVars);
		
		return response;
		
	}
	
	@PostMapping(path = "/customer/delete")
	public Map<String, Object> DeleteDataCustomer (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestBody Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		flowVars.setDataHttpRequest(request);
		flowVars.setDataHeader(header);
		flowVars.setDataParameter(parameters);
		flowVars.setIndex("customer");
		
		Map<String, Object> response = new HashMap<String, Object>();
		response = deleteData.deleteDataById(flowVars);
		
		return response;
		
	}
	
	//ORDERS
	@GetMapping(path = "/orders")
	public List<Map<String, Object>> GetListDataOrder (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestParam Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		flowVars.setDataHttpRequest(request);
		flowVars.setDataHeader(header);
		flowVars.setDataParameter(parameters);
		flowVars.setIndex("order");
		
		List<Map<String, Object>> response = new ArrayList<Map<String,Object>>();
		response = listData.listData(flowVars);
		
		return response;
		
	}
	
	@GetMapping(path = "/order/{id}")
	public Map<String, Object> GetDataOrder (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @PathVariable String id) {
		
		FlowVariables flowVars = new FlowVariables();
		flowVars.setDataHttpRequest(request);
		flowVars.setDataHeader(header);
		flowVars.setId(id);
		flowVars.setIndex("order");
		
		Map<String, Object> response = new HashMap<String, Object>();
		response = getData.getDataById(flowVars);
		
		return response;
		
	}
	
	@PostMapping(path = "/order/input")
	public Map<String, Object> InputDataOrder (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestBody Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		flowVars.setDataHttpRequest(request);
		flowVars.setDataHeader(header);
		flowVars.setDataParameter(parameters);
		flowVars.setIndex("order");
		
		Map<String, Object> response = new HashMap<String, Object>();
		response = inputData.inputData(flowVars);
		
		return response;
		
	}
	
	@PostMapping(path = "/order/update")
	public Map<String, Object> UpdateDataOrder (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestBody Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		flowVars.setDataHttpRequest(request);
		flowVars.setDataHeader(header);
		flowVars.setDataParameter(parameters);
		flowVars.setIndex("order");
		
		Map<String, Object> response = new HashMap<String, Object>();
		response = updateData.updateDataById(flowVars);
		
		return response;
		
	}
	
	@PostMapping(path = "/order/delete")
	public Map<String, Object> DeleteDataOrder (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestBody Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		flowVars.setDataHttpRequest(request);
		flowVars.setDataHeader(header);
		flowVars.setDataParameter(parameters);
		flowVars.setIndex("order");
		
		Map<String, Object> response = new HashMap<String, Object>();
		response = deleteData.deleteDataById(flowVars);
		
		return response;
		
	}
}
