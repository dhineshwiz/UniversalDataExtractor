package com.technovanza.ude.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.technovanza.ude.model.Category;

public class CategoryDao {

	private final static Logger LOGGER = Logger.getLogger(CategoryDao.class.getName());


public void insertCategory(Category Categoryobj )
 {
	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;

	String Insert_category_query="insert into Dbo.Catg([App_Id],[Inac_Indc],[Catg_Nme],[Row_Cre_Dt],[Row_Cre_Usr_Id],[Row_Upd_Dt],[Row_Upd_Usr_Id]) VALUES(?,?,?,GETDATE(),?,GETDATE(),?)";


	try {
		prepared_statement_object=connection_object.prepareStatement(Insert_category_query);

		prepared_statement_object.setInt(1,Categoryobj.getApplication_Id());
		prepared_statement_object.setBoolean(2,false);
		prepared_statement_object.setString(3,Categoryobj.getCategory_Name());
		prepared_statement_object.setString(4,Categoryobj.getUser_Id());
		prepared_statement_object.setString(5,Categoryobj.getUser_Id());

		prepared_statement_object.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		LOGGER.info(e.getMessage());
	}
}



public List<Category> getCaetory()
{




		Connection connection_object=Connections.get_connection();
		PreparedStatement statement_object = null;
		ResultSet Result_set_sites_info = null;
		Category cat_obj;


		String Get_category_query="Select [Catg_Id],[App_Id],[Catg_Nme],[Row_Cre_Usr_Id] from dbo.[Catg] ";


		try {
			statement_object=connection_object.prepareStatement(Get_category_query);

			Result_set_sites_info=statement_object.executeQuery();

			ArrayList<Category> catglst = new ArrayList<Category>();
			while(Result_set_sites_info.next())
			{


				cat_obj= new Category();

				cat_obj.setCategory_Id(Result_set_sites_info.getInt(1));

				cat_obj.setApplication_Id(Result_set_sites_info.getInt(2));

				cat_obj.setCategory_Name(Result_set_sites_info.getString(3));

				cat_obj.setUser_Id(Result_set_sites_info.getString(4));

				catglst.add(cat_obj);

			}
			return catglst;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info(e.getMessage());
			return null;
		}


	}

public List<Category> getCaetoryapp(Integer application_id)
{




		Connection connection_object=Connections.get_connection();
		PreparedStatement statement_object = null;
		ResultSet Result_set_sites_info = null;
		Category cat_obj;


		String Get_category_query="Select [Catg_Id],[App_Id],[Catg_Nme],[Row_Cre_Usr_Id] from dbo.[Catg] where [App_Id]=?";


		try {
			statement_object=connection_object.prepareStatement(Get_category_query);

			statement_object.setInt(1, application_id);

			Result_set_sites_info=statement_object.executeQuery();

			ArrayList<Category> catglst = new ArrayList<Category>();
			while(Result_set_sites_info.next())
			{


				cat_obj= new Category();

				cat_obj.setCategory_Id(Result_set_sites_info.getInt(1));

				cat_obj.setApplication_Id(Result_set_sites_info.getInt(2));

				cat_obj.setCategory_Name(Result_set_sites_info.getString(3));

				cat_obj.setUser_Id(Result_set_sites_info.getString(4));

				catglst.add(cat_obj);

			}
			return catglst;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info(e.getMessage());
			return null;
		}


	}






}





