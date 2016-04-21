package com.technovanza.ude.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.technovanza.ude.model.Extract_Output_Details1;

public class ExtractOutputDtlsDao {

	private final static Logger LOGGER = Logger.getLogger(ExtractOutputDtlsDao.class.getName());

public void insertExtractoutputdtls(List<Extract_Output_Details1> extoutdetlstobj, Integer Extract_id)
{

	 Connection connection_object=Connections.get_connection();
	    PreparedStatement prepared_statement_object = null;

	    String insertextractquery = "insert into [dbo].[Extrct_Op_Dtls]([Extrct_id],[Op_Name],[Op_Alias_Name],[Inac_Indc],[Row_Cre_dt],[Row_Cre_Usr_Id],[Row_Upd_dt],[Row_Upd_Usr_id]) "
	    		+ "values(?,?,?,?,getDate(),?,getdate(),?)";

	    try {

	    	for(Extract_Output_Details1 extoutdetobj : extoutdetlstobj)
	    	{
	    	prepared_statement_object=connection_object.prepareStatement(insertextractquery);

	    	prepared_statement_object.setInt(1,Extract_id);

	    	prepared_statement_object.setString(2,extoutdetobj.getOutput_name());

	    	prepared_statement_object.setString(3,extoutdetobj.getOutput_alias_name());

	    	//prepared_statement_object.setBoolean(4,extoutdetobj.getMandotary_indc());

	    	prepared_statement_object.setBoolean(4,false);

	    	prepared_statement_object.setString(5,extoutdetobj.getUser_id());

	    	prepared_statement_object.setString(6,extoutdetobj.getUser_id());


	    	prepared_statement_object.executeUpdate();


	    	}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info(e.getMessage());
		}






}

public List<Extract_Output_Details1> getExtractoutputdtls(Integer Extract_Id)
{

try
{

	Connection connection_object=Connections.get_connection();
	PreparedStatement prepared_statement_object = null;

	String getExtractquery = "select [Extrct_Op_Dtls_Id],[Extrct_id],[Op_Name],[Op_Alias_Name],[Mandotary_Indc],[Row_Cre_Usr_Id] from [dbo].[Extrct_Op_Dtls] where [Extrct_id]=?";

	ResultSet Result_set_sites_info = null;

	prepared_statement_object=connection_object.prepareStatement(getExtractquery);

	prepared_statement_object.setInt(1,Extract_Id);

	Result_set_sites_info=prepared_statement_object.executeQuery();


	List<Extract_Output_Details1> extoutlst = new ArrayList<Extract_Output_Details1>();


	Extract_Output_Details1 extoutdtobj;

	while(Result_set_sites_info.next())
	{
		extoutdtobj= new Extract_Output_Details1();



		extoutdtobj.setExtract_output_dteails_id(Result_set_sites_info.getInt(1));

		extoutdtobj.setExtract_id(Result_set_sites_info.getInt(2));

		extoutdtobj.setOutput_name(Result_set_sites_info.getString(3));

		extoutdtobj.setOutput_alias_name(Result_set_sites_info.getString(4));

		extoutdtobj.setMandotary_indc(Result_set_sites_info.getBoolean(5));

		extoutdtobj.setUser_id(Result_set_sites_info.getString(6));


		extoutlst.add(extoutdtobj);


	}


return extoutlst;

}
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	LOGGER.info(e.getMessage());

return null;
}






}





}
