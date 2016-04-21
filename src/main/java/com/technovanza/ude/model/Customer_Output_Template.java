package com.technovanza.ude.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Customer_Output_Template {

	private String label;

	private String type;

	private String placeholder;

	private Boolean required;

	private String valueProp;

	private String labelProp;

	private List<Multiple_details> options;


	public String getValueProp() {
		return valueProp;
	}

	public void setValueProp(String valueProp) {
		this.valueProp = valueProp;
	}

	public String getLabelProp() {
		return labelProp;
	}

	public void setLabelProp(String labelProp) {
		this.labelProp = labelProp;
	}

	public List<Multiple_details> getOptions() {
		return options;
	}

	public void setOptions(List<Multiple_details> options) {
		this.options = options;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}



}
