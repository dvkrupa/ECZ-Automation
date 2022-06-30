package utils;

import org.testng.annotations.DataProvider;

public class CreateShipDocUtills {
	@DataProvider(name = "CreateShip-Document")
	public String[][] getdata(){
		String[][] exceldata1 = ReadExcelCreateDoc.getDocExceldata();
		return exceldata1;

}
}