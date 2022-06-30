package utils;

import org.testng.annotations.DataProvider;

public class CODutils {
	@DataProvider(name = "CreateShipCOD")
	public String[][] getdata(){
		String[][] exceldata1 = ReadexcelCOD.getExceldata();
		return exceldata1;

}
	
}
