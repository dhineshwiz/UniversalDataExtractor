package com.technovanza.ude.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;



public  class  Connections {
	private final static Logger LOGGER = Logger.getLogger(Connection.class.getName());

	public static Connection get_connection()
	{
	Connection connection = null;


	    try
	    {
	      // the sql server driver string
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	    	System.out.println("GOT the driver");

	      // the sql server url cloud server
	      //String url = "jdbc:sqlserver://172.0.4.7;DatabaseName=UDE";

	      // get the sql server database connection cloud server
	      //connection = DriverManager.getConnection(url,"sa", "password$1");

	    	String url = "jdbc:sqlserver://10.232.197.45;DatabaseName=Technovanza";

	    connection = DriverManager.getConnection(url,"sermigr_BO", "password-6");

	      // now do whatever you want to do with the connection
	      // ...

	    }
	    catch (ClassNotFoundException e1)
	    {
	      e1.printStackTrace();
	      LOGGER.info("driver not found");
	      System.exit(1);
	      LOGGER.info(e1.getMessage());
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.out.println("could not connect server");
	      LOGGER.info("could not connect server");
	      LOGGER.info(e.getMessage());

	    }


	return connection;

	}



}