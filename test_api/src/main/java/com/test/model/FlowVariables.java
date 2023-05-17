package com.test.model;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowVariables {
	
	private String index;
	
	private String id;

	private HttpServletRequest dataHttpRequest;
	
	private Map<String, Object> dataHeader;
	
	private Map<String, Object> dataParameter;
	
	private Map<String, Object> dataResponse;
	
	private Boolean valid;
}
