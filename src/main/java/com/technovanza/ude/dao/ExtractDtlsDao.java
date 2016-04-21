package com.technovanza.ude.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.technovanza.ude.model.Extract_Details;
import com.technovanza.ude.model.Multiple_details;

public class ExtractDtlsDao {
	private final static Logger LOGGER = Logger.getLogger(ExtractDtlsDao.class.getName());

public void insertextractdtls(List<Extract_Details> extdlst, Integer Extract_id)
{
    Connection connection_object=Connections.get_connection();
    PreparedStatement prepared_statement_object = null;

    PreparedStatement prepared_statement_obj = null;
    //ResultSet Result_set_sites_info = null;

    String insertextractquery = "insert into [dbo].[Extrct_Dtls]([Extrct_id],[Param_Name],[Param_Val],[Alias_Name],[Param_Datatype],[Grp],"
    		+ "[Mand_Indc],[Input_Reqd],[Inac_Indc],[Row_Cre_dt],[Row_Cre_Usr_Id],[Row_Upd_dt],[Row_Upd_Usr_id],[Temp_Datatype])"
    		+ "values(?,?,?,?,?,?,?,?,?,GETDATE(),?,GETDATE(),?,?)";

    String extract_det_id = "select [Extrct_Dtls_Id] from [dbo].[Extrct_Dtls] where [Extrct_id]=? and [Param_Name]=?";

    String insert_Extract_flex_query ="insert into [dbo].[Extrct_Flex_Codn]([Extrct_Dtls_Id],[Codn_Name],[Codn_Val],[Inac_Indc]) values(?,?,?,?)";



    try {




        for(Extract_Details extdtlobj: extdlst)
        	{


        	 ResultSet Result_set_sites_info = null;
        	prepared_statement_object=connection_object.prepareStatement(insertextractquery);

        prepared_statement_object.setInt(1,Extract_id);

        prepared_statement_object.setString(2,extdtlobj.getParam_name());

        prepared_statement_object.setString(3,extdtlobj.getParam_value());

        prepared_statement_object.setString(4,extdtlobj.getAlias_name());

        prepared_statement_object.setString(5,extdtlobj.getParam_datatype());

        prepared_statement_object.setString(6,extdtlobj.getGroup());



        prepared_statement_object.setBoolean(7,((extdtlobj.getMandotary_indc()==null)?false:extdtlobj.getMandotary_indc()));



        prepared_statement_object.setBoolean(8,((extdtlobj.getInput_required()==null)?false:extdtlobj.getInput_required()));

        prepared_statement_object.setBoolean(9,false);

        prepared_statement_object.setString(10,extdtlobj.getUser_id());

        prepared_statement_object.setString(11,extdtlobj.getUser_id());

        prepared_statement_object.setString(12,extdtlobj.getTemplate_datatype());


        prepared_statement_object.executeUpdate();

        prepared_statement_obj=connection_object.prepareStatement(extract_det_id);

        prepared_statement_obj.setInt(1,Extract_id);

        prepared_statement_obj.setString(2,extdtlobj.getParam_name());

        Result_set_sites_info=prepared_statement_obj.executeQuery();

        Result_set_sites_info.next();
        PreparedStatement prepared_statement_object1= null;

        for(Multiple_details mut_det:extdtlobj.getMultiple_details())
        {

        	prepared_statement_object1=connection_object.prepareStatement(insert_Extract_flex_query);

        	prepared_statement_object1.setInt(1, Result_set_sites_info.getInt(1));


        	prepared_statement_object1.setString(2,String.valueOf(mut_det.getKey()));

        	prepared_statement_object1.setString(3,mut_det.getValue());

        	prepared_statement_object1.setBoolean(4,false);


        	prepared_statement_object1.executeUpdate();

        }




        	}
    }
    catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();

        LOGGER.info(e.getMessage());

    }

}

public List<Extract_Details> getExtractDetails(Integer Extract_Id)
{

	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;

	PreparedStatement prepared_statement_object1 = null;

	ResultSet Result_multi=null;

	String getExtractquery = "select [Extrct_id],[Extrct_Dtls_Id],[Param_Name],[Param_Val],[Alias_Name],[Param_Datatype],[Grp],[Mand_Indc],[Input_Reqd],[Row_Cre_Usr_Id],[Temp_Datatype] from [dbo].[Extrct_Dtls] where Extrct_id=?";

	String getmultiple_details= "select [Extrct_Dtls_Id],[Codn_Name],[Codn_Val]"
			+ " FROM [dbo].[Extrct_Flex_Codn] where Extrct_Dtls_Id=?";

	ResultSet Result_set_sites_info = null;

	 try {

		 prepared_statement_object=connection_object.prepareStatement(getExtractquery);

		 prepared_statement_object.setInt(1,Extract_Id);

		 Result_set_sites_info= prepared_statement_object.executeQuery();


		 Extract_Details extdtlobj;

		 List<Extract_Details> extdtlslst = new ArrayList<Extract_Details>();
		 while(Result_set_sites_info.next())
		 {

			 extdtlobj= new Extract_Details();


			 extdtlobj.setExtract_id(Result_set_sites_info.getInt(1));

			 extdtlobj.setExtract_dtls_id(Result_set_sites_info.getInt(2));

			 extdtlobj.setParam_name(Result_set_sites_info.getString(3));

			 extdtlobj.setParam_value(Result_set_sites_info.getString(4));

			 extdtlobj.setAlias_name(Result_set_sites_info.getString(5));


			 extdtlobj.setParam_datatype(Result_set_sites_info.getString(6));

			 extdtlobj.setGroup(Result_set_sites_info.getString(7));

			 extdtlobj.setMandotary_indc(Result_set_sites_info.getBoolean(8));

			 extdtlobj.setInput_required(Result_set_sites_info.getBoolean(9));

			 extdtlobj.setUser_id(Result_set_sites_info.getString(10));

			 extdtlobj.setTemplate_datatype(Result_set_sites_info.getString(11));

			 prepared_statement_object1=connection_object.prepareStatement(getmultiple_details);

			 prepared_statement_object1.setInt(1,extdtlobj.getExtract_dtls_id());

			 Result_multi= prepared_statement_object1.executeQuery();

			 Multiple_details mut_obj;

			 List<Multiple_details> lst_mut_obj = new ArrayList<Multiple_details>();

			 while(Result_multi.next())
			{

				 mut_obj = new Multiple_details();

				 mut_obj.setExtract_details_id(Result_multi.getInt(1));

				 mut_obj.setKey(Integer.parseInt(Result_multi.getString(2)));

				 mut_obj.setValue(Result_multi.getString(3));

				 lst_mut_obj.add(mut_obj);

			 }
			 extdtlobj.setMultiple_details(lst_mut_obj);

			 extdtlslst.add(extdtlobj);

		 }





return extdtlslst;

	 }
	 catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        LOGGER.info(e.getMessage());
	        return null;
	 }


}



}
