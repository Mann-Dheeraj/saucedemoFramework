package com.mannautomation.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchDataFromExcelFile {

	public String[][] getCredentialsFromExcelFile(String filePath, int firstRow) throws IOException {

		FileInputStream file = new FileInputStream(filePath);

		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("LoginCredentials");
		int lastRow = sheet.getLastRowNum();
		int startingRow = 1;
		String[][] credentialsArray = new String[lastRow][3];
		int credentialsArrayRow = 0;
		for (startingRow = firstRow; startingRow <= lastRow; startingRow++) {
			Row row = sheet.getRow(startingRow);
			int credentialsArraycell = 0;
			int cell = 0;
			while (row.getCell(cell) != null) {
				credentialsArray[credentialsArrayRow][credentialsArraycell++] = row.getCell(cell++).toString();
			}
			credentialsArrayRow++;
		}
		return credentialsArray;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String credentialsFilePath = "E:\\myFrameWork\\saucedemoFramework\\TestData\\TestData.xlsx";
		FetchDataFromExcelFile fetchCredentials = new FetchDataFromExcelFile();
		String[][] loginCredentials = fetchCredentials.getCredentialsFromExcelFile(credentialsFilePath,1);

		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(loginCredentials[i][j] + "     ");
			}
			System.out.println();
		}
	}

}
