//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : wmt
//  @ File Name : EnquiryPositionRequestModel.java
//  @ Date : 2008-3-6
//  @ Author : kyzou
//
//



package com.itsz.sht.common.model.request;

import com.itsz.sht.common.model.AbstractRequestModel;


public class EnquiryPositionRequestModel  extends AbstractRequestModel{
	private String accountId;
	private String defaultAccountId;
	private String allowTradeStatusFlag;
	private String marketCode;
	private int fromIdx;
	private int maxResults;

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getMarketCode() {
		return marketCode;
	}
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	public int getFromIdx() {
		return fromIdx;
	}
	public void setFromIdx(int fromIdx) {
		this.fromIdx = fromIdx;
	}
	public int getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	public String getDefaultAccountId() {
		return defaultAccountId;
	}
	public void setDefaultAccountId(String defaultAccountId) {
		this.defaultAccountId = defaultAccountId;
	}
	public String getAllowTradeStatusFlag() {
		return allowTradeStatusFlag;
	}
	public void setAllowTradeStatusFlag(String allowTradeStatusFlag) {
		this.allowTradeStatusFlag = allowTradeStatusFlag;
	}
}