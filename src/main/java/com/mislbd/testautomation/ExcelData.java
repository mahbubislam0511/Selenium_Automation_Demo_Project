package com.mislbd.testautomation;

import com.mislbd.testautomation.configuration.ExcelDataProperties;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelData {
	
	protected static String singleExcelData = System.getProperty("user.home")+new ExcelDataProperties("/excel_data.properties").getValue("cust_type_single_link");

	public String getExcelData() {
		return singleExcelData;
	}

	 public static boolean checkingEmptyCell(XSSFSheet xssfSheet, int row, int col){

		 return xssfSheet.getRow(row).getCell(col) != null
				 &&  xssfSheet.getRow(row).getCell(col).getStringCellValue() != null
				 && xssfSheet.getRow(row).getCell(col).getStringCellValue().isEmpty() == false;
	}

}
