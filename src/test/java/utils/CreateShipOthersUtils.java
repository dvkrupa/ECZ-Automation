package utils;

import org.testng.annotations.DataProvider;

public class CreateShipOthersUtils {
	@DataProvider(name = "createUtilsothers")
	public String[][] getdata() {
		String[][] exceldata4 = ReadExcelCreateShipOthers.getExceldata();
		return exceldata4;
	}







}
