package cn.itsz.newsim.view.form;

/**
 * $Id: OrderDetailForm.java,v 1.1 2011/03/04 09:47:34 zxfan Exp $
 * @Project:portal.head
 * @File:OrderDetailForm.java
 * @Description:
 * @Author:Cimenon Saint
 * @Date:2007-5-21
 */
public class OrderDetailForm extends BaseForm {

	private static final long serialVersionUID = 7562478557427987719L;
	private String accountId;
	private String mcsOrderId;
	private String orderId;// mtss order id
	private String hasHisories;// 是否需要交易记录

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getHasHisories() {
		return hasHisories;
	}
	public void setHasHisories(String hasHisories) {
		this.hasHisories = hasHisories;
	}
	public String getMcsOrderId() {
		return mcsOrderId;
	}
	public void setMcsOrderId(String mcsOrderId) {
		this.mcsOrderId = mcsOrderId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
