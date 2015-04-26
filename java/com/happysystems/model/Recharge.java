package com.happysystems.model;

import java.sql.Timestamp;
import java.io.Serializable;

public class Recharge	implements Serializable	{
	private int id;
	private String operator;
	private long number;
	private double amount;
	private String response;
	private Timestamp created;
	private String orderId;
	
	public String getOrderId() {
		this.orderId = "NA";
		String [] split = response == null ? new String[]{} : response.split("\n");
		if(split.length > 1)	this.orderId = split[1].split(" ")[1];
		return this.orderId;
	}

	public void setOrderId()	{
		getOrderId();
	}

	/**
	 * Get id.
	 *
	 * @return id as int.
	 */
	public int getId()
	{
	    return id;
	}
	
	/**
	 * Set id.
	 *
	 * @param id the value to set.
	 */
	public void setId(int id)
	{
	    this.id = id;
	}
	
	/**
	 * Get operator.
	 *
	 * @return operator as String.
	 */
	public String getOperator()
	{
	    return operator;
	}
	
	/**
	 * Set operator.
	 *
	 * @param operator the value to set.
	 */
	public void setOperator(String operator)
	{
	    this.operator = operator;
	}
	
	/**
	 * Get number.
	 *
	 * @return number as int.
	 */
	public long getNumber()
	{
	    return number;
	}
	
	/**
	 * Set number.
	 *
	 * @param number the value to set.
	 */
	public void setNumber(long number)
	{
	    this.number = number;
	}
	
	/**
	 * Get amount.
	 *
	 * @return amount as double.
	 */
	public double getAmount()
	{
	    return amount;
	}
	
	/**
	 * Set amount.
	 *
	 * @param amount the value to set.
	 */
	public void setAmount(double amount)
	{
	    this.amount = amount;
	}
	
	/**
	 * Get response.
	 *
	 * @return response as String.
	 */
	public String getResponse()
	{
	    return response;
	}
	
	/**
	 * Set response.
	 *
	 * @param response the value to set.
	 */
	public void setResponse(String response)
	{
	    this.response = response;
	}
	
	/**
	 * Get created.
	 *
	 * @return created as Date.
	 */
	public Timestamp getCreated()
	{
	    return created;
	}
	
	/**
	 * Set created.
	 *
	 * @param created the value to set.
	 */
	public void setCreated(Timestamp created)
	{
	    this.created = created;
	}
}
