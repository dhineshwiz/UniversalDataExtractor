package com.technovanza.ude.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Customer_Output {


	private String key;

	private String type;


    private String template;


	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Customer_Output_Template getTemplateOptions() {
		return templateOptions;
	}

	public void setTemplateOptions(Customer_Output_Template templateOptions) {
		this.templateOptions = templateOptions;
	}

	private Customer_Output_Template templateOptions;


}
