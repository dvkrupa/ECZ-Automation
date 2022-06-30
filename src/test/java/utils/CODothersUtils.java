package utils;

import org.testng.annotations.DataProvider;

public class CODothersUtils {
	@DataProvider(name = "cod_others")
	public String[][] getdata(){
		String[][] exceldata3 = ReadExcelCODothers.getExceldata();
		return exceldata3;

}
}