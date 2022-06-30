package utils;

import org.testng.annotations.DataProvider;

public class MPSprepaidUtils {
	@DataProvider(name = "MPS Prepaid")
	public String[][] getdata(){
		String[][] exceldata1 = ReadExcelMPSprepaid.getMPSExceldata();
		return exceldata1;
	}

}
