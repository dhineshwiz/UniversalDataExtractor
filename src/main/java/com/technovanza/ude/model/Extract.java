package com.technovanza.ude.model;

import java.util.List;

public class Extract {

	private Integer extract_id;

	private Integer catg_id;

	private String extract_name;

	private String extract_description;

	private Integer connection_id;

	private Boolean preview_option;

	public Boolean getPreview_option() {
		return preview_option;
	}

	public void setPreview_option(Boolean preview_option) {
		this.preview_option = preview_option;
	}

	private String user_Id;

	private String query_skeleton;



	public String getQuery_skeleton() {
		return query_skeleton;
	}

	public void setQuery_skeleton(String query_skeleton) {
		this.query_skeleton = query_skeleton;
	}

	private List<Extract_Details> extract_details;

	private List<Extract_Output_Details1> extract_output_details1;

	public Integer getExtract_id() {
		return extract_id;
	}

	public void setExtract_id(Integer extract_id) {
		this.extract_id = extract_id;
	}

	public Integer getCatg_id() {
		return catg_id;
	}

	public void setCatg_id(Integer catg_id) {
		this.catg_id = catg_id;
	}

	public String getExtract_name() {
		return extract_name;
	}

	public void setExtract_name(String extract_name) {
		this.extract_name = extract_name;
	}

	public String getExtract_description() {
		return extract_description;
	}

	public void setExtract_description(String extract_description) {
		this.extract_description = extract_description;
	}

	public Integer getConnection_id() {
		return connection_id;
	}

	public void setConnection_id(Integer connection_id) {
		this.connection_id = connection_id;
	}



	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public List<Extract_Details> getExtract_details() {
		return extract_details;
	}

	public void setExtract_details(List<Extract_Details> extract_details) {
		this.extract_details = extract_details;
	}

	public List<Extract_Output_Details1> getExtract_output_details1() {
		return extract_output_details1;
	}

	public void setExtract_output_details1(
			List<Extract_Output_Details1> extract_output_details1) {
		this.extract_output_details1 = extract_output_details1;
	}




}
