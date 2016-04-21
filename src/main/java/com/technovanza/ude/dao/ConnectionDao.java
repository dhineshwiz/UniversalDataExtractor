package com.technovanza.ude.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.technovanza.ude.model.ConnectionDtls;

public class ConnectionDao {

	private final static Logger LOGGER = Logger.getLogger(ConnectionDao.class.getName());
public void insertConnectionDtls(ConnectionDtls condtl)
{

	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;
	String insrtconnectionDtls = "insert into [dbo].[Conn]([Conn_Type],[Driver_Nme],[Server_IP],[Port_Nbr],"


			+ "[Conn_Nme],[DB_Nme],[Usr_Nme],[Pwd],[Inac_Indc],[Row_Cre_Dt],[Row_Cre_Usr_Id],[Row_Upd_Dt],[Row_Upd_Usr_Id],[Catg_Id]) "

			+ "values(?,?,?,?,?,?,?,?,?,GETDATE(),?,GETDATE(),?,?)";


	try {
		prepared_statement_object=connection_object.prepareStatement(insrtconnectionDtls);


		prepared_statement_object.setString(1,condtl.getConnection_type());

		prepared_statement_object.setString(2,condtl.getDriver_name());

		//prepared_statement_object.setString(3,condtl.getDriver_name());

		prepared_statement_object.setString(3,condtl.getServer_ip());

		prepared_statement_object.setInt(4,condtl.getPort_number());

		prepared_statement_object.setString(5,condtl.getConnection_name());

		prepared_statement_object.setString(6,condtl.getDb_name());

		prepared_statement_object.setString(7,condtl.getUser_name());

		prepared_statement_object.setString(8,condtl.getPassword());

		prepared_statement_object.setBoolean(9,false);

		prepared_statement_object.setString(10,condtl.getUser_id());

		prepared_statement_object.setString(11,condtl.getUser_id());

		prepared_statement_object.setInt(12,condtl.getCategory_Id());





		prepared_statement_object.executeUpdate();

	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		LOGGER.info(e.getMessage());

	}


}









public List<ConnectionDtls> getConnectiondetailsctg(Integer Category_id)
{
	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;
	ResultSet Result_set_sites_info = null;
	String getconnectiondtlsqry= "select [Conn_Id],[Conn_Type],[Driver_Nme],[Server_IP],[Port_Nbr],[Conn_Nme],[DB_Nme],[Usr_Nme],[Pwd] from [dbo].[Conn] where [Catg_Id] = ?";
	ConnectionDtls con_dt_obj;


	try {
		prepared_statement_object=connection_object.prepareStatement(getconnectiondtlsqry);

		prepared_statement_object.setInt(1,Category_id);


		Result_set_sites_info=prepared_statement_object.executeQuery();

		ArrayList<ConnectionDtls> condtlslst = new ArrayList<ConnectionDtls>();
		while(Result_set_sites_info.next())
		{
			con_dt_obj = new ConnectionDtls();

			con_dt_obj.setConnection_id(Result_set_sites_info.getInt(1));
			con_dt_obj.setConnection_type(Result_set_sites_info.getString(2));
			con_dt_obj.setDriver_name(Result_set_sites_info.getString(3));
			con_dt_obj.setServer_ip(Result_set_sites_info.getString(4));
			con_dt_obj.setPort_number(Result_set_sites_info.getInt(5));
            con_dt_obj.setConnection_name(Result_set_sites_info.getString(6));
            con_dt_obj.setDb_name(Result_set_sites_info.getString(7));
            con_dt_obj.setUser_name(Result_set_sites_info.getString(8));
            con_dt_obj.setPassword(Result_set_sites_info.getString(9));



            condtlslst.add(con_dt_obj);

		}
		return condtlslst;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		LOGGER.info(e.getMessage());
		return null;
	}



}




public ConnectionDtls getConnectiondetailsid(Integer Connection_id)
{
	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;
	ResultSet Result_set_sites_info = null;
	String getconnectiondtlsqry= "select [Conn_Id],[Conn_Type],[Driver_Nme],[Server_IP],[Port_Nbr],[Conn_Nme],[DB_Nme],[Usr_Nme],[Pwd] from [dbo].[Conn] where [Conn_Id] = ?";
	ConnectionDtls con_dt_obj = new ConnectionDtls();


	try {
		prepared_statement_object=connection_object.prepareStatement(getconnectiondtlsqry);

		prepared_statement_object.setInt(1,Connection_id);


		Result_set_sites_info=prepared_statement_object.executeQuery();

		//ArrayList<ConnectionDtls> condtlslst = new ArrayList<ConnectionDtls>();
		while(Result_set_sites_info.next())
		{

			con_dt_obj.setConnection_id(Result_set_sites_info.getInt(1));
			con_dt_obj.setConnection_type(Result_set_sites_info.getString(2));
			con_dt_obj.setDriver_name(Result_set_sites_info.getString(3));
			con_dt_obj.setServer_ip(Result_set_sites_info.getString(4));
			con_dt_obj.setPort_number(Result_set_sites_info.getInt(5));
            con_dt_obj.setConnection_name(Result_set_sites_info.getString(6));
            con_dt_obj.setDb_name(Result_set_sites_info.getString(7));
            con_dt_obj.setUser_name(Result_set_sites_info.getString(8));
            con_dt_obj.setPassword(Result_set_sites_info.getString(9));



           // condtlslst.add(con_dt_obj);

		}
		return con_dt_obj;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		LOGGER.info(e.getMessage());
		return null;
	}



}





}
