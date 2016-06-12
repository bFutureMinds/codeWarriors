/**
 * 
 *//*
package com.ws.dbconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

*//**
 * @author Chetan
 *
 *//*
public class ReadExcelDatabase {

	public static final String QUESTION_BANK_PATH = "E:\\hackthon\\code\\chatbot\\VirtualAgentEngine\\src\\QUESTION_BANK.xlsx";

	public String getAnswerForQuestion(String inputQuestion) throws IOException {

		InputStream inputStream = new FileInputStream(QUESTION_BANK_PATH);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		XSSFSheet sheet=wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();

		System.out.println(rows);
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();

			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
				if (cell != null && cell.getNumericCellValue() == 9999)
					break;
				if (cell.getColumnIndex() == 0)
					System.out.print(cell.getNumericCellValue()+" ");
				else if(cell.getColumnIndex() == 1)
					System.out.print(cell.getNumericCellValue()+" ");
				else if(cell.getColumnIndex() == 2)
					System.out.print(cell.getStringCellValue()+" ");
				else if(cell.getColumnIndex() == 3)
					System.out.print(cell.getStringCellValue()+" ");
				else if(cell.getColumnIndex() == 4)
					System.out.print(cell.getNumericCellValue()+" ");
				else if(cell.getColumnIndex() == 5)
					System.out.print(cell.getStringCellValue()+" ");
				else if(cell.getColumnIndex() == 6)
					System.out.print(cell.getStringCellValue()+" ");
				
			}
			System.out.println();
		}
		return null;
	
	}
}
*/