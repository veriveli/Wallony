package com.wallony.object;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/**
 * 
 * @author v.coskun
 * 
 */

@Table(name="JA_SALE_PRODUCT")
@javax.persistence.Entity
@AccessType("field")
public class SaleProduct extends Entity implements Serializable {
	
	private static final long serialVersionUID = 207429472349171965L;

//	@Column(name = "customer_id", insertable = true, updatable = true)
//	private long customerId;
	
	@Column(name="product_type")
	private String productType;
	
	@Column(name="product_id")
	private long productId;
	
	@Column(name="web_user_id")
	private long webUserId;
	
	@Column(name="is_paid")
	private boolean isPaid;
	
	@Column(name="trx_id")
	private String trxId;
	
	@Column(name = "price")
	private float price;
	
	@Column(name="creation_date")
	private Date creationDate;
	
}
