package utils;

import org.testng.annotations.DataProvider;

public class CreateShipUtils {
	@DataProvider(name = "createShipment")
	public String[][] getdata(){
		//String writeExcelData=ReadExcelCreateShipment.WriteExcelCreateShipment();
		String[][] exceldata1 = ReadExcelCreateShipment.getExceldata();
		return exceldata1;
	}

}
