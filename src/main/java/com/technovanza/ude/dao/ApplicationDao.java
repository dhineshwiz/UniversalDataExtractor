package com.technovanza.ude.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.util.logging.Logger;

import com.technovanza.ude.model.Application;
import com.technovanza.ude.util.Generating_query;

public class ApplicationDao {

	private final static Logger LOGGER = Logger.getLogger(ApplicationDao.class.getName());


public void insertApplication(Application application)
{

	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;
String Insert_application_query="insert into dbo.App(App_Nme,"
		+ "Inac_Indc,"
		+ "Email_Dist_List,"
		+ "Row_Cre_Dt,"
		+ "Row_Cre_Usr_Id,"
		+ "Row_Upd_Dt,"
		+ "Row_Upd_Usr_Id) values(?,?,?,getdate(),?,getdate(),?)";





	try {
		prepared_statement_object=connection_object.prepareStatement(Insert_application_query);

		prepared_statement_object.setString(1,application.getApplication_name());
		prepared_statement_object.setBoolean(2,false);
		prepared_statement_object.setString(3,application.getEmail());
		prepared_statement_object.setString(4,application.getUser_Id());
		prepared_statement_object.setString(5,application.getUser_Id());






		prepared_statement_object.executeQuery();



	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		LOGGER.info(e.getMessage());
	}
}

public List<Application>  getallApplication()
{

	Connection connection_object=Connections.get_connection();
	PreparedStatement statement_object = null;
	ResultSet Result_set_sites_info = null;
	Application app_obj;


	String Get_application_query="Select App_Nme,Email_Dist_List,Row_Upd_Usr_Id,App_Id from dbo.App ";


	try {
		statement_object=connection_object.prepareStatement(Get_application_query);

		Result_set_sites_info=statement_object.executeQuery();

		ArrayList<Application> app = new ArrayList<Application>();
		while(Result_set_sites_info.next())
		{
			app_obj= new Application();


			app_obj.setApplication_name(Result_set_sites_info.getString(1));

		app_obj.setEmail(Result_set_sites_info.getString(2));

		app_obj.setUser_Id(Result_set_sites_info.getString(3));

		app_obj.setApplication_Id(Result_set_sites_info.getInt(4));

		app.add(app_obj);

		}
		return app;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		LOGGER.info(e.getMessage());
		return null;
	}


}


}
