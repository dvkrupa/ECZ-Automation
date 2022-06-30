package utils;

import org.testng.annotations.DataProvider;

public class CreateShipOthersDocumentUtils {
	@DataProvider(name = "Others-Document")
	public String[][] getdata(){
		String[][] exceldata1 = ReadExcelCreateOthersDocument.getExcelOthersDocdata();
		return exceldata1;
		
	
	


}
	
}
