package com.itsz.sht.common.model.common.request;

import com.itsz.sht.common.model.common.AbstractRequestModel;



public class AccessSHKRequestModel extends AbstractRequestModel{

	private String productId;
	
	private String clientId;
	
	private String clientIp;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	
}
