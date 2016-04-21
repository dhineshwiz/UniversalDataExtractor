package com.technovanza.ude.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.technovanza.ude.model.Excell_rows;
import com.technovanza.ude.model.Excell_sheets;

public class File_writing {


	private final static Logger LOGGER = Logger.getLogger(File_writing.class.getName());

public List<Excell_rows>  Excelfilewriting(ResultSet rs,String Extract_name,List<String> headers)
{

	 XSSFWorkbook workbook = new XSSFWorkbook();
     //Create a blank sheet
     XSSFSheet spreadsheet = workbook.createSheet(Extract_name);
     //Create row object
     XSSFRow row;
     int rowid = 0;

     row = spreadsheet.createRow(rowid++);
	 int cellid = 0;
	 Excell_rows excell_rows_obj = new Excell_rows();

	 List<String> row_excell = new ArrayList<String>();

	 List<Excell_rows> sheet_excell = new ArrayList<Excell_rows>();

	 for(String header :headers)
	 {
		 Cell cell = row.createCell(cellid++);
		 cell.setCellValue(header);

		 row_excell.add(header);




	 }

	 excell_rows_obj.setRows(row_excell);

	 sheet_excell.add(excell_rows_obj);


     try {
		while(rs.next())
		 {

			 row = spreadsheet.createRow(rowid++);

			 cellid = 0;
			 row_excell = new ArrayList<String>();

			 excell_rows_obj= new Excell_rows();
			 int counter=1;

			 for(String header :headers)
			 {
				 System.out.println("The coloumn heading is:"+header);

				 LOGGER.info("The coloumn heading is:"+header);

				 System.out.println(rs.getString(counter));
				 LOGGER.info(rs.getString(counter));

				 //row_excell.add(rs.getString(header));

				 row_excell.add(rs.getString(counter));


				 Cell cell = row.createCell(cellid++);
				// cell.setCellValue(rs.getString(header));

				 cell.setCellValue(rs.getString(counter));
				 counter++;


			 }

			 excell_rows_obj.setRows(row_excell);

			 sheet_excell.add(excell_rows_obj);






		}

		/*FileOutputStream out;

		out = new FileOutputStream(
			      new File("C:/Lazy_coders/Excell_files_generated/"+Extract_name+".xlsx"));


				workbook.write(out);


				out.close();*/







	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		 LOGGER.info(e.getMessage());
	}





     return sheet_excell;
}


}
