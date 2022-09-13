package com.example.producer.model;

import java.io.Serializable;

public class customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String customerid;
	private String customername;
	
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
}
