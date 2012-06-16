package com.wallony.object;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

@Table(name="JA_PAYMENT_RESULT")
@javax.persistence.Entity
@AccessType("field")
public class PaymentResult extends Entity{
	
	@Column(name = "payment_result")
	private boolean paymentResult=false;
	
	@Column(name = "trnx_id")
	private String trnxId;
	
	@Column(name = "auth_code")
	private String authCode;
	
	@Column(name = "bank_account")
	private String bankAccount;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "installment")
	private int installment;
	
	@Column(name = "canceled")
	private boolean canceled=false;
	
	@Column(name = "refund")
	private boolean refund=false;
	
	@Column(name = "ip")
	private String ip;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="products")
	private String products;
}
