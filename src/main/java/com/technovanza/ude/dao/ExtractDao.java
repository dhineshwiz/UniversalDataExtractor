package com.technovanza.ude.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.technovanza.ude.model.Extract;

public class ExtractDao {

	private final static Logger LOGGER = Logger.getLogger(ExtractDao.class.getName());

public Integer InsertExtract(Extract extractobj)
{

	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;

	PreparedStatement prepared_statement_object1 = null;

	ResultSet Result_set_sites_info = null;


	String insertExtractquery = "insert into dbo.Extrct([Catg_Id],[Extrct_Nme],[Extrct_Desc],[Inac_Indc],[Conn_Id],[Prvw_Optn],[Row_Cre_Dt],[Row_Cre_Usr_Id],[Row_Upd_Dt],[Row_Upd_Usr_Id],[Query]) values(?,?,?,?,?,?,GETDATE(),?,GETDATE(),?,?)";

	String getextractid = "select [Extrct_id] from dbo.Extrct where [Extrct_Nme] =? ";


	try {
		prepared_statement_object=connection_object.prepareStatement(insertExtractquery);

		prepared_statement_object.setInt(1,extractobj.getCatg_id());

		prepared_statement_object.setString(2,extractobj.getExtract_name());

		prepared_statement_object.setString(3,extractobj.getExtract_description());

		prepared_statement_object.setBoolean(4,false);

		prepared_statement_object.setInt(5,extractobj.getConnection_id());

		prepared_statement_object.setBoolean(6,true);

		prepared_statement_object.setString(7,extractobj.getUser_Id());

		prepared_statement_object.setString(8,extractobj.getUser_Id());
		prepared_statement_object.setString(9,extractobj.getQuery_skeleton());


		prepared_statement_object.executeUpdate();

		prepared_statement_object1=connection_object.prepareStatement(getextractid);


		prepared_statement_object1.setString(1,extractobj.getExtract_name());

		Result_set_sites_info=prepared_statement_object1.executeQuery();

		Result_set_sites_info.next();

		return Result_set_sites_info.getInt(1);

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		LOGGER.info(e.getMessage());
		return null;
	}

}


public List<Extract> getextract()
{
	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;

	String getExtractquery = "select [Extrct_id],[Catg_Id],[Extrct_Nme],[Extrct_Desc],[Conn_Id],[Prvw_Optn],[Row_Cre_Usr_Id],[Query] from [dbo].[Extrct]";

	ResultSet Result_set_sites_info = null;
	Extract Extobj;

	try
	{

		prepared_statement_object=connection_object.prepareStatement(getExtractquery);

		Result_set_sites_info=prepared_statement_object.executeQuery();

		ArrayList<Extract> Extlst = new ArrayList<Extract>();
		while(Result_set_sites_info.next())
		{

			Extobj = new Extract();

			Extobj.setExtract_id(Result_set_sites_info.getInt(1));

			Extobj.setCatg_id(Result_set_sites_info.getInt(2));

			Extobj.setExtract_name(Result_set_sites_info.getString(3));

			Extobj.setExtract_description(Result_set_sites_info.getString(4));

			Extobj.setConnection_id(Result_set_sites_info.getInt(5));


			Extobj.setPreview_option(Result_set_sites_info.getBoolean(6));

			Extobj.setUser_Id(Result_set_sites_info.getString(7));

			Extobj.setQuery_skeleton(Result_set_sites_info.getString(8));





			Extlst.add(Extobj);

		}

return Extlst;

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		LOGGER.info(e.getMessage());


	return null;
	}



}

public Extract getextract(Integer Extract_Id)
{
	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;

	String getExtractquery = "select [Extrct_id],[Catg_Id],[Extrct_Nme],[Extrct_Desc],[Conn_Id],[Prvw_Optn],[Row_Cre_Usr_Id],[Query] from [dbo].[Extrct] where [Extrct_id]=?";

	ResultSet Result_set_sites_info = null;
	Extract Extobj = null;

	try
	{

		prepared_statement_object=connection_object.prepareStatement(getExtractquery);
		prepared_statement_object.setInt(1,Extract_Id);

		Result_set_sites_info=prepared_statement_object.executeQuery();


		while(Result_set_sites_info.next())
		{
			Extobj = new Extract();

			Extobj.setExtract_id(Result_set_sites_info.getInt(1));

			Extobj.setCatg_id(Result_set_sites_info.getInt(2));

			Extobj.setExtract_name(Result_set_sites_info.getString(3));

			Extobj.setExtract_description(Result_set_sites_info.getString(4));

			Extobj.setConnection_id(Result_set_sites_info.getInt(5));


			Extobj.setPreview_option(Result_set_sites_info.getBoolean(6));

			Extobj.setUser_Id(Result_set_sites_info.getString(7));

			Extobj.setQuery_skeleton(Result_set_sites_info.getString(8));

			//System.out.println(Result_set_sites_info.getString(7));

		}

return Extobj;

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		LOGGER.info(e.getMessage());


	return null;
	}



}


public List<Extract> getextractbycategid(Integer Category_id)
{
	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;

	String getExtractquery = "select [Extrct_id],[Catg_Id],[Extrct_Nme],[Extrct_Desc],[Conn_Id],[Prvw_Optn],[Row_Cre_Usr_Id],[Query] from [dbo].[Extrct] where [Catg_Id]=?";

	ResultSet Result_set_sites_info = null;
	Extract Extobj;

	try
	{

		prepared_statement_object=connection_object.prepareStatement(getExtractquery);
		prepared_statement_object.setInt(1,Category_id);

		Result_set_sites_info=prepared_statement_object.executeQuery();

		ArrayList<Extract> Extlst = new ArrayList<Extract>();
		while(Result_set_sites_info.next())
		{

			Extobj = new Extract();

			Extobj.setExtract_id(Result_set_sites_info.getInt(1));

			Extobj.setCatg_id(Result_set_sites_info.getInt(2));

			Extobj.setExtract_name(Result_set_sites_info.getString(3));

			Extobj.setExtract_description(Result_set_sites_info.getString(4));

			Extobj.setConnection_id(Result_set_sites_info.getInt(5));


			Extobj.setPreview_option(Result_set_sites_info.getBoolean(6));

			Extobj.setUser_Id(Result_set_sites_info.getString(7));

			Extobj.setQuery_skeleton(Result_set_sites_info.getString(8));



			Extlst.add(Extobj);

		}

return Extlst;

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		LOGGER.info(e.getMessage());


	return null;
	}



}



public Extract getfullextract(String Extract_name)
{
	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;

	String getExtractquery = "select [Extrct_id],[Catg_Id],[Extrct_Nme],[Extrct_Desc],[Conn_Id],[Prvw_Optn],[Row_Cre_Usr_Id],[Query] from [dbo].[Extrct] where [Extrct_Nme]=?";

	ResultSet Result_set_sites_info = null;
	Extract Extobj = null;

	try
	{

		prepared_statement_object=connection_object.prepareStatement(getExtractquery);
		prepared_statement_object.setString(1,Extract_name);

		Result_set_sites_info=prepared_statement_object.executeQuery();

		while(Result_set_sites_info.next())
		{

			Extobj = new Extract();

			Extobj.setExtract_id(Result_set_sites_info.getInt(1));

			Extobj.setCatg_id(Result_set_sites_info.getInt(2));

			Extobj.setExtract_name(Result_set_sites_info.getString(3));

			Extobj.setExtract_description(Result_set_sites_info.getString(4));

			Extobj.setConnection_id(Result_set_sites_info.getInt(5));


			Extobj.setPreview_option(Result_set_sites_info.getBoolean(6));

			Extobj.setUser_Id(Result_set_sites_info.getString(7));

			Extobj.setQuery_skeleton(Result_set_sites_info.getString(8));
		}

return Extobj;

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		LOGGER.info(e.getMessage());


	return null;
	}



}









}
