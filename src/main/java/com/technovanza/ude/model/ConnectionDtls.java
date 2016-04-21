package com.technovanza.ude.model;

public class ConnectionDtls {

   private Integer connection_id;



	private String connection_name;

	private String connection_type;

	private String driver_name;

	private String server_ip;

	private Integer category_Id;



	public Integer getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(Integer category_Id) {
		this.category_Id = category_Id;
	}

	public Integer getPort_number() {
		return port_number;
	}

	public void setPort_number(Integer port_number) {
		this.port_number = port_number;
	}

	public String getServer_ip() {
		return server_ip;
	}

	public void setServer_ip(String server_ip) {
		this.server_ip = server_ip;
	}

	private Integer port_number;

	private String db_name;

	private String user_name;

	private String password;

	private String user_id;

	public Integer getConnection_id() {
		return connection_id;
	}

	public void setConnection_id(Integer connection_id) {
		this.connection_id = connection_id;
	}

	public String getConnection_name() {
		return connection_name;
	}

	public void setConnection_name(String connection_name) {
		this.connection_name = connection_name;
	}

	public String getConnection_type() {
		return connection_type;
	}

	public void setConnection_type(String connection_type) {
		this.connection_type = connection_type;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}





	public String getDb_name() {
		return db_name;
	}

	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}




}
