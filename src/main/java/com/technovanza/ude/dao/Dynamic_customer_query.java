package com.technovanza.ude.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.technovanza.ude.model.ConnectionDtls;
import com.technovanza.ude.model.Customer_output_type_matching;
import com.technovanza.ude.model.Excell_rows;
import com.technovanza.ude.model.Extract;
import com.technovanza.ude.model.Extract_Output_Details1;
import com.technovanza.ude.model.Multiple_details;
import com.technovanza.ude.util.File_writing;

public class Dynamic_customer_query {

	private final static Logger LOGGER = Logger.getLogger(Dynamic_customer_query.class.getName());

	public List<Excell_rows> fetch_customer_extract(Extract ext,Map<String,Customer_output_type_matching> customer_values,String Query)
	{


		Connection connection = null;
	    try
	    {
	      ConnectionDtls connection_obj = new ConnectionDtls();

	      Integer connection_id;


	      connection_id=ext.getConnection_id();

	      ConnectionDao connectiondaoobj = new ConnectionDao();

	      connection_obj=connectiondaoobj.getConnectiondetailsid(connection_id);

	      String url = null;

	      System.out.println("con type"+connection_obj.getConnection_type()+"samp");

	      LOGGER.info("con type"+connection_obj.getConnection_type()+"samp");



	    	if(connection_obj.getConnection_type().equals("Sql Server"))
	    	{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
System.out.println("inside sql query "+connection_obj.getServer_ip() +connection_obj.getDb_name());

LOGGER.info("inside sql query "+connection_obj.getServer_ip() +connection_obj.getDb_name());


	      url = "jdbc:sqlserver://"+connection_obj.getServer_ip()+";DatabaseName="+connection_obj.getDb_name();

	    	}

	    	else if(connection_obj.getConnection_type().equals("Oracle"))
	    	{

	    		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

	    		//Class.forName("org.postgresql.Driver").newInstance();

	    		//connection = DriverManager.getConnection(

	    		System.out.println("inside sql query "+connection_obj.getServer_ip() +connection_obj.getDb_name());
	    		LOGGER.info("inside sql query "+connection_obj.getServer_ip() +connection_obj.getDb_name());

	  	      url = "jdbc:oracle:thin:@"+connection_obj.getServer_ip()+":1521"+":"+connection_obj.getDb_name();

	  	    //url = "jdbc:oracle:thin:@"+connection_obj.getServer_ip()+":1521"+":"+"XE";
//url="jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = "+connection_obj.getServer_ip()+")(PORT = "+connection_obj.getPort_number()+"))   (SID = "+connection_obj.getDb_name()+") )";


	    	}

	    	/*else if(connection_obj.getConnection_type().equals("My Sql"))
	    	{

	    		Class.forName("oracle.jdbc.driver.OracleDriver");
	    		System.out.println("inside sql query "+connection_obj.getServer_ip() +connection_obj.getDb_name());


	  	      url = "jdbc:sqlserver://"+connection_obj.getServer_ip()+";DatabaseName="+connection_obj.getDb_name();

	    	}*/


	      connection = DriverManager.getConnection(url,connection_obj.getUser_name(),connection_obj.getPassword());

	      PreparedStatement preparedstatemnt_string;


	      preparedstatemnt_string=connection.prepareStatement(Query);

	      List<String> keys=new ArrayList(customer_values.keySet());

	      Collections.sort(keys);

	      int counter=1;

	      for(String key: keys)
	      {

if((customer_values.get(key).getType()=="String")&&(!((customer_values.get(key).getString().trim().isEmpty())||(customer_values.get(key).getString().trim()==null))))
{

	preparedstatemnt_string.setString(counter,customer_values.get(key).getString());

	counter++;


}


if((customer_values.get(key).getType()=="Integer")&&(!(customer_values.get(key).getInteger()==0)))
{

	preparedstatemnt_string.setInt(counter,customer_values.get(key).getInteger());

	counter++;


}


if((customer_values.get(key).getType()=="Date")&&(!(customer_values.get(key).getDate()==null)))
{

	java.util.Date utilDate = customer_values.get(key).getDate();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	preparedstatemnt_string.setDate(counter,sqlDate);

	System.out.println("SQL date"+sqlDate);
	counter++;


}

if((customer_values.get(key).getType()=="multiCheckbox")&&(!(customer_values.get(key).getMulticheckbox().isEmpty())))
{
	//List<Integer> List_key = new ArrayList<Integer>();

	List<Multiple_details> multidet = (customer_values.get(key).getMulticheckbox());

	//String appended_string = new String();

	for(Multiple_details mut :multidet)
	{

		//List_key.add(mut.getKey());

		//appended_string=appended_string.concat(appended_string.valueOf(mut.getKey()));

		//appended_string=appended_string.concat(",");

		preparedstatemnt_string.setInt(counter,mut.getKey());

		counter++;

	}

	//appended_string=appended_string.substring(0, appended_string.length()-1);

	//System.out.println(appended_string+ "   appeded string");





	//Array array = connection.createArrayOf("bigint",List_key.toArray());



	//preparedstatemnt_string.setArray(counter, array);


	//counter++;


}



	      }

	      ResultSet rs=preparedstatemnt_string.executeQuery();

	      int kk=1;

	    //  while(rs.next())
	      //{

	      //System.out.println("The result of query execution is "+rs.getString(kk));

	      //kk++;
	      //}




	      File_writing filewrite = new File_writing();

	      List<Extract_Output_Details1> ext_out=ext.getExtract_output_details1();
	      List<String> headears = new ArrayList<String>();

	      for(Extract_Output_Details1 ext_out_det:ext_out)
	      {
	    	  //rs.next();

	    	 //System.out.println("The output Allias name is "+ext_out_det.getOutput_alias_name() +"   "+ rs.getString(1));

	    	  headears.add(ext_out_det.getOutput_alias_name());






	      }






	      List<Excell_rows> workbook=filewrite.Excelfilewriting(rs, ext.getExtract_name(), headears);

	      // now do whatever you want to do with the connection
	      // ...
	      return workbook;

	    }
	    catch (ClassNotFoundException e1)
	    {
	      e1.printStackTrace();
	      LOGGER.info(e1.getMessage());
	      System.exit(1);

	      return null;

	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      LOGGER.info(e.getMessage());
	      System.exit(2);

	      return null;
	    } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info(e.getMessage());
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.info(e.getMessage());
			return null;
		}






	}


}
