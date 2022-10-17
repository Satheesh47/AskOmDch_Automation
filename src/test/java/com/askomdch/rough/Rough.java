package com.askomdch.rough;

import com.askomdch.utilities.Constants;
import com.askomdch.utilities.ExcelUtility;

public class Rough {
	
	
	public static void main(String[] args) {
		
		ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "MyFirstTestCase");
		System.out.println(Constants.EXCEL_FILE);
		Object[][] testData = ExcelUtility.getTestData("guestCheckoutUsing_DirectBankTransfer");
		System.out.println(testData[0][7]);
		

	}

}
