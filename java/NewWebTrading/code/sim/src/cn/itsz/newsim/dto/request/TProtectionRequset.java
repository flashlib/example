package cn.itsz.newsim.dto.request;

import cn.itsz.newsim.dto.BaseDTO;

public class TProtectionRequset extends BaseDTO {
	private String loginId;
	private String password;
	private String transactionProtection;

	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTransactionProtection() {
		return transactionProtection;
	}
	public void setTransactionProtection(String transactionProtection) {
		this.transactionProtection = transactionProtection;
	}
}