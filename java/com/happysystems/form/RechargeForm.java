package com.happysystems.form;

import org.apache.struts.action.ActionForm;

public class RechargeForm extends ActionForm	{
	private String msg;
	private String type = "";
	private String service;
	private String amount;
	private String response;
	private String operator;
	private String orderID;

	public String getMessage()	{
		return msg;
	}	

	public void setMessage(String msg)	{
		this.msg = msg;
	}
	
	public void setType(String type)	{
		this.type=type;
	}

	public String getType()	{
		return type;
	}


	public void setService(String service)	{
		this.service=service;
	}

	public String getService()	{
		return service;
	}


	public void setAmount(String amount)	{
		this.amount=amount;
	}

	public String getAmount()	{
		return amount;
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
	 * Get orderID.
	 *
	 * @return orderID as String.
	 */
	public String getOrderID()
	{
	    return orderID;
	}
	
	/**
	 * Set orderID.
	 *
	 * @param orderID the value to set.
	 */
	public void setOrderID(String orderID)
	{
	    this.orderID = orderID;
	}
}
