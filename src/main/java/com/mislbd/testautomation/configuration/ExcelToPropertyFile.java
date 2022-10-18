package com.mislbd.testautomation.configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ExcelToPropertyFile{
	public static void main(String[] args) {
		Properties properties = new Properties();
		OutputStream output = null ;
		
		try {
			output = new FileOutputStream("/excel_data.properties");
			
			properties.setProperty("title", "${excel_data.title}");
			properties.setProperty("subject", "${excel_data.subject}");
			properties.setProperty("author", "${excel_data.author}");
			properties.setProperty("manager", "${excel_data.manager}");
			properties.setProperty("company", "${excel_data.company}");
			properties.setProperty("category", "${excel_data.category}");
			properties.setProperty("keywords", "${excel_data.keywords}");
			properties.setProperty("comments", "${excel_data.comments}");
			properties.setProperty("base_link", "");
			
			properties.store(output, null);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	
}
