package com.technovanza.ude.util;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;


import com.technovanza.ude.model.Excell_rows;



public class excell_downloading extends AbstractXlsxView {
	private final static Logger LOGGER = Logger.getLogger(excell_downloading.class.getName());
	@Override
	protected void buildExcelDocument(Map model, Workbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//Sheet sheet = workbook.createSheet("sheet 1");

		System.out.println("inside excell writing");
		LOGGER.info("inside excell writing");

		 Row row;

		@SuppressWarnings("unchecked")
		List<Excell_rows> excell_sheets	= (List<Excell_rows>) model.get("final_list");
		 Sheet spreadsheet = workbook.createSheet("Data Extract");
		int rowid = 0;

		for(Excell_rows excel_row:excell_sheets)
		{
			row = spreadsheet.createRow(rowid++);
			int cellid = 0;
			for(String cell:excel_row.getRows())
		     {


				Cell cell1 = row.createCell(cellid++);
		   		 cell1.setCellValue(cell);


					}


		}







		//@SuppressWarnings("unchecked")
       // XSSFWorkbook workbook_fromdb = new XSSFWorkbook();

        //Sheet spreadsheet = workbook.createSheet("sample");
        //Create row object
        //Row row;
        //int rowid = 0;

        //row = spreadsheet.createRow(rowid++);

        //List<String> lt = new ArrayList<String>();


       // lt.add("sa");
       // lt.add("sa");
       // lt.add("sa");
       // lt.add("sa");
       // lt.add("sa");
       // lt.add("sa");



   	// for(String header :lt)
   	// {
   		 //Cell cell = row.createCell(cellid++);
   		// cell.setCellValue(header);


   	 //}


    }







}