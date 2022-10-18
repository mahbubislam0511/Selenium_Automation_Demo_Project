package com.mislbd.testautomation.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mislbd.testautomation.model.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.mislbd.testautomation.ExcelData;

public class SingleExcelUtils extends ExcelData{

	static XSSFWorkbook workbook;
	protected static int i;
	
	public static List<LoginModel> getLoginModels(){
		List<LoginModel> myLoginModels = new ArrayList<>();
		
		try {
			workbook = new XSSFWorkbook(singleExcelData);
			XSSFSheet login = workbook.getSheet("Login");
			for (i = 1; i < login.getPhysicalNumberOfRows(); i++) {
				LoginModel myLoginModel = new LoginModel();

				myLoginModel.setEmailAddress(login.getRow(i).getCell(0).getStringCellValue());
				myLoginModel.setPassword(login.getRow(i).getCell(1).getStringCellValue());

				myLoginModels.add(myLoginModel);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myLoginModels;	
	}

}
	



