package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelCreateShipment {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("./Test-Data/ecourierz creatShip.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		sheet.createRow(0).createCell(0).setCellValue("url");
		sheet.getRow(0).createCell(1).setCellValue("email");
		sheet.getRow(0).createCell(2).setCellValue("Password");
		sheet.getRow(0).createCell(3).setCellValue(" Receiver Name");
		sheet.getRow(0).createCell(4).setCellValue("Address Line 1");
		sheet.getRow(0).createCell(5).setCellValue("Address Line 2");
		sheet.getRow(0).createCell(6).setCellValue("Address Line 3");
		sheet.getRow(0).createCell(7).setCellValue("Receiver Pincode");
		sheet.getRow(0).createCell(8).setCellValue("Receiver Email");
		sheet.getRow(0).createCell(9).setCellValue("Receiver Number");
		sheet.getRow(0).createCell(10).setCellValue("Parcel Content");
		sheet.getRow(0).createCell(11).setCellValue("Length");
		sheet.getRow(0).createCell(12).setCellValue("Width");
		sheet.getRow(0).createCell(13).setCellValue("Height");
		sheet.getRow(0).createCell(14).setCellValue("Weight ");
		sheet.getRow(0).createCell(15).setCellValue("Value");
		sheet.getRow(0).createCell(16).setCellValue("Customer Ref");
		sheet.getRow(0).createCell(17).setCellValue("Invoice Num");
		sheet.createRow(1).createCell(0).setCellValue("https://qa.ecourierz.com/beta/user/dashboard");
		sheet.getRow(1).createCell(1).setCellValue("devops@ecourierz.com");
		sheet.getRow(1).createCell(2).setCellValue("password");
		sheet.getRow(1).createCell(3).setCellValue("Ashwin");
		sheet.getRow(1).createCell(4).setCellValue("Address Line 1");
		sheet.getRow(1).createCell(5).setCellValue("Address Line 2");
		sheet.getRow(1).createCell(6).setCellValue("Address Line 3");
		sheet.getRow(1).createCell(7).setCellValue("560009");
		sheet.getRow(1).createCell(8).setCellValue("abcd@gmail.com");
		sheet.getRow(1).createCell(9).setCellValue("9999999999");
		sheet.getRow(1).createCell(10).setCellValue("laptop");
		sheet.getRow(1).createCell(11).setCellValue("2");
		sheet.getRow(1).createCell(12).setCellValue("5");
		sheet.getRow(1).createCell(13).setCellValue("10");
		sheet.getRow(1).createCell(14).setCellValue("1000");
		sheet.getRow(1).createCell(15).setCellValue("1");
		sheet.getRow(1).createCell(16).setCellValue("45685K");
		sheet.getRow(1).createCell(17).setCellValue("65478K");
		
try {
		FileOutputStream fos = new FileOutputStream("./Test-Data/ecourierz creatShip.xlsx");
		workbook.write(fos);
		fos.close();
		System.out.println("END OF WRITING DATA IN EXCEL");
}
catch(Exception e) {
	
		e.printStackTrace();
	
	}
	}















}
