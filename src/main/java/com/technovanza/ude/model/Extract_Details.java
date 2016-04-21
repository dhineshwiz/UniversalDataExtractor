package com.technovanza.ude.model;

import java.util.List;

public class Extract_Details {

private Integer extract_id;

private Integer extract_dtls_id;
private Integer category_id;



private String param_name;

private String param_value;

private String alias_name;

private String param_datatype;

private String template_datatype;



private String group;


private Boolean mandotary_indc;

private Boolean input_required;

private Boolean inactive_indicator;

public List<Multiple_details> getMultiple_details() {
	return multiple_details;
}

public void setMultiple_details(List<Multiple_details> multiple_details) {
	this.multiple_details = multiple_details;
}

private String user_id;

private List<Multiple_details>  multiple_details;

public Integer getExtract_id() {
	return extract_id;
}

public void setExtract_id(Integer extract_id) {
	this.extract_id = extract_id;
}

public Integer getExtract_dtls_id() {
	return extract_dtls_id;
}

public void setExtract_dtls_id(Integer extract_dtls_id) {
	this.extract_dtls_id = extract_dtls_id;
}

public String getParam_name() {
	return param_name;
}

public void setParam_name(String param_name) {
	this.param_name = param_name;
}

public String getParam_value() {
	return param_value;
}

public void setParam_value(String param_value) {
	this.param_value = param_value;
}

public String getAlias_name() {
	return alias_name;
}

public void setAlias_name(String alias_name) {
	this.alias_name = alias_name;
}

public String getParam_datatype() {
	return param_datatype;
}

public void setParam_datatype(String param_datatype) {
	this.param_datatype = param_datatype;
}

public String getGroup() {
	return group;
}

public void setGroup(String group) {
	this.group = group;
}

public Boolean getMandotary_indc() {
	return mandotary_indc;
}

public void setMandotary_indc(Boolean mandotary_indc) {
	this.mandotary_indc = mandotary_indc;
}

public Boolean getInput_required() {
	return input_required;
}

public void setInput_required(Boolean input_required) {
	this.input_required = input_required;
}

public Boolean getInactive_indicator() {
	return inactive_indicator;
}

public void setInactive_indicator(Boolean inactive_indicator) {
	this.inactive_indicator = inactive_indicator;
}

public String getUser_id() {
	return user_id;
}

public void setUser_id(String user_id) {
	this.user_id = user_id;
}

public Integer getCategory_id() {
	return category_id;
}

public void setCategory_id(Integer category_id) {
	this.category_id = category_id;
}
public String getTemplate_datatype() {
	return template_datatype;
}

public void setTemplate_datatype(String template_datatype) {
	this.template_datatype = template_datatype;
}



}
