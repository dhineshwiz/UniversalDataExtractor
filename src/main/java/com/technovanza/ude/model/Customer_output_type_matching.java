package com.technovanza.ude.model;

import java.util.Date;
import java.util.List;

public class Customer_output_type_matching {


	private String type;

	private String string;

	private Date date;

	private Integer integer;

	private List<Multiple_details> multicheckbox;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public List<Multiple_details> getMulticheckbox() {
		return multicheckbox;
	}

	public void setMulticheckbox(List<Multiple_details> multicheckbox) {
		this.multicheckbox = multicheckbox;
	}



}
