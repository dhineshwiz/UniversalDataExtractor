package com.technovanza.ude.model;

public class Application {

	private String application_name;
	private String email;
	private String User_Id;

	private Integer Application_Id;





	public Integer getApplication_Id() {
		return Application_Id;
	}
	public void setApplication_Id(Integer application_Id) {
		Application_Id = application_Id;
	}
	public String getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}
	public String getApplication_name() {
		return application_name;
	}
	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
