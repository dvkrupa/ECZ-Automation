package ecourierz;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.MPSprepaidUtils;
import utils.ReadExcelMPSprepaid;



public class MPSparcelPrepaid extends MPSprepaidUtils {
	/*public static ExtentReports extent;
	ExtentHtmlReporter reporter;
	public static ExtentTest test;*/
	public static WebDriver driver;
	/*@BeforeSuite
	public void setup() {
		//set up the physical report path
		reporter = new ExtentHtmlReporter("./reports/result.html");
		//Create an object for extent reports
		extent = new ExtentReports();
		//To retain the history
		reporter.setAppendExisting(true);
		//Attach the data with physical file
		extent.attachReporter(reporter);
	}*/
	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
}
	@Test(dataProvider = "MPS Prepaid")
	public void ecourierzLogin(String url,String uName,String pwd,String rName,String addR1,String addR2,String addR3,String rPincode,String rEmail,String rMobNum,String parcel,String length,String Width,String height,String wt,String value,String length1,String width1,String height1,String weight1,String value1,String custref,String invnum) throws Exception {
		//try {
		//test = extent.createTest("CreateShipment","Login with positive credentials");
		
		
		 driver.get(url);
		 //test.pass("Navigated to ecourierz.com");
		 driver.findElement(By.xpath("//input[@title='Please enter your Username / Email']")).sendKeys(uName);
		 //test.pass("Entered Username successfully..");
		 driver.findElement(By.xpath("//input[@title='Please enter your Password']")).sendKeys(pwd);
		 //test.pass("Entered Password successfully..");
		 driver.findElement(By.xpath("//button[contains(@class,'btn btn-lg')]")).click();
		Assert.assertTrue(true, "HomePage");
		System.out.println("HomePage is displayed..");
		driver.findElement(By.xpath("(//mat-icon[@role='img'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='mat-select-arrow']")).click();
		driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]")).click();
		
		/*String Defaultadd = DefaulAdd.getAttribute("Value");
		System.out.println("Default address is ::" + Defaultadd);
		driver.findElement(By.xpath("//mat-icon[text()='add']")).click();
		WebElement name = driver.findElement(By.xpath("//*[@id=\"pickup\"]/app-pickup/div[1]/div[2]/div[1]/div/div/div/div[2]/p[1]"));
		String Name = name.getText();
		int S_Name = Name.indexOf(':');
		int s_Name = Name.length();
		String s_name = Name.substring(S_Name+1, s_Name);
		System.out.println("Name is ::" +s_name);
		WebElement Cname = driver.findElement(By.xpath("(//p[@class='ng-star-inserted'])[2]"));
		String cName = Cname.getText();
		int C_NAME = cName.indexOf(':');
		int c_Name = cName.length();
		String c_name = cName.substring(C_NAME+1, c_Name);
		System.out.println("Company Name is ::" +c_name);
		WebElement Caddress = driver.findElement(By.xpath("//*[@id=\"pickup\"]/app-pickup/div[1]/div[2]/div[1]/div/div/div/div[2]/p[3]"));
		String cAddress = Caddress.getText();
		int c_Address = cAddress.indexOf(':');
		int C_Address = cAddress.length();
		String Address = cAddress.substring(c_Address+1, C_Address);
		System.out.println("address is ::" +Address);*/
		
		WebElement nameR = driver.findElement(By.id("mat-input-0"));
		nameR .sendKeys(rName);
		
		WebElement addr1 = driver.findElement(By.id("mat-input-1"));
		addr1.sendKeys(addR1);
		
		WebElement addr2 = driver.findElement(By.id("mat-input-2"));
		addr2.sendKeys(addR2);
		
		WebElement addr3 = driver.findElement(By.id("mat-input-3"));
		addr3.sendKeys(addR3);
		
		WebElement Rpincode = driver.findElement(By.id("mat-input-11"));
		Rpincode.sendKeys(rPincode);
		
		WebElement Remail = driver.findElement(By.id("mat-input-6"));
		Remail.sendKeys(rEmail);
		
		WebElement Rmobnum = driver.findElement(By.id("mat-input-7"));
		Rmobnum.sendKeys(rMobNum);
		
		WebElement paRcel = driver.findElement(By.id("mat-input-8"));
		paRcel.sendKeys(parcel);
		
		driver.findElement(By.xpath("(//div[@class='mat-checkbox-inner-container'])[2]")).click();
		
		WebElement Length = driver.findElement(By.id("mat-input-12"));
		Length.sendKeys(length);
		
		WebElement width = driver.findElement(By.id("mat-input-13"));
		width.sendKeys(Width);
		
		WebElement Height = driver.findElement(By.id("mat-input-14"));
		Height.sendKeys(height);
		
		WebElement weight = driver.findElement(By.id("mat-input-15"));
		weight.sendKeys(wt);
		
		WebElement valUE = driver.findElement(By.id("mat-input-16"));
		valUE.sendKeys(value);
		
		driver.findElement(By.xpath("(//mat-icon[text()='add'])[2]")).click();
		
		WebElement Length1 = driver.findElement(By.xpath("(//input[@formcontrolname='length'])[2]"));
		Length1.clear();
		Length1.sendKeys(length1);
		
		WebElement Width1 = driver.findElement(By.xpath("(//input[@formcontrolname='width'])[2]"));
		Width1.clear();
		Width1.sendKeys(width1);
		
		WebElement Height1 = driver.findElement(By.xpath("(//input[@formcontrolname='height'])[2]"));
		Height1.clear();
		Height1.sendKeys(height1);
		
		WebElement Weight1 = driver.findElement(By.xpath("(//input[@formcontrolname='weight'])[2]"));
		Weight1.clear();
		Weight1.sendKeys(weight1);
		
		WebElement Value1 = driver.findElement(By.xpath("(//input[@formcontrolname='value'])[2]"));
		Value1.clear();
		Value1.sendKeys(value1);
		
		WebElement Custref = driver.findElement(By.xpath("//input[@formcontrolname='customer_reference']"));
		Custref.sendKeys(custref);
		
		WebElement Invnum = driver.findElement(By.xpath("//input[@formcontrolname='invoice_number']"));
		Invnum.sendKeys(invnum);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//button[text()=' Create Shipment ']")).click();
		
		/**
		 * To get the label and read data from it & validate with excel data
		 */

		driver.findElement(By.xpath("(//mat-icon[contains(@class,'mat-icon notranslate')])[3]")).click();
		driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/button[1]/span[1]")).click();
		ArrayList<String> excelData =ReadExcelMPSprepaid.getExcelList();
		ArrayList<String> labelData = new ArrayList<String>();
		
		WebElement labelinvoice = driver.findElement(By.xpath("//b[contains(text(),'Invoice Number')][1]/following-sibling::b"));
		String Label_Invoice = labelinvoice.getText();
		System.out.println("Label Invoice Num is ::" +Label_Invoice);

		WebElement content = driver.findElement(By.xpath("//b[contains(text(),'Contents')][1]/following-sibling::b"));
		String ConTenT = content.getText();
		System.out.println("Contents is ::" +ConTenT);
		
		WebElement receiverName = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/b[1]"));
		String Receiver_Name = receiverName.getText();
		int Receiver = Receiver_Name.indexOf(' ');
		String receiver_Name = Receiver_Name.substring(Receiver,Receiver_Name.length());
		System.out.println("ReceiverName Is ::" + receiver_Name);
		

		WebElement receiverEmail = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/b[2]"));
		String Receiver_Email = receiverEmail.getText();
		int receiver = Receiver_Email.indexOf(' ');
		String receiver_Email = Receiver_Email.substring(receiver, Receiver_Email.length());
		System.out.println("Receiver Email Is ::" + receiver_Email);

		WebElement receiverNumber = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/b[3]"));
		String Receiver_Number = receiverNumber.getText();
		int receiveR = Receiver_Number.indexOf(' ');
		String receiver_number = Receiver_Number.substring(receiveR , Receiver_Number.length());
		System.out.println("Receiver Number Is ::" + receiver_number);

		WebElement addressline1 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/b[1]"));
		String Address_Line1 = addressline1.getText();
		System.out.println("Address Line 1 Is ::" + Address_Line1);

		WebElement addressline2 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/b[2]"));
		String Address_Line2 = addressline2.getText();
		System.out.println("Address Line 2 Is ::" + Address_Line2);

		WebElement addressline3 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/b[3]"));
		String Address_Line3 = addressline3.getText();
		System.out.println("Address Line 3 Is ::" + Address_Line3);

		WebElement pincode = driver.findElement(By.cssSelector("html>body>app-root>app-shipment>div>div>app-listing>div>div>div>div:nth-of-type(2)>div>div>table>tbody>tr:nth-of-type(2)>td>div>div>div:nth-of-type(2)>div>table>tbody>tr>td:nth-of-type(2)>div>b:nth-of-type(5)"));
		String Pincode = pincode.getText();
		System.out.println("Pincode Is ::" + Pincode);

		WebElement Dimension = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[2]s"));
		String dimension = Dimension.getText();
		String[] split = dimension.split("x");
		String LabelLength = split[0];
		String LabelWidth = split[1];
		String LabelHeight = split[2];
		int height2 = LabelHeight.length()-3;
		String height_1 = LabelHeight.substring(0, height2);
		System.out.println("length is:: "+LabelLength);
		System.out.println("width is:: "+LabelWidth);
		System.out.println("height is:: "+height_1);
		
		WebElement weight11 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[3]"));
		String WEIGHT = weight11.getText();
		String labelweight1 = WEIGHT.substring(0, WEIGHT.length()-3);
		System.out.println("Weight Is ::"+ labelweight1 );
		
		WebElement value4 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[4]"));
		String VALUE = value4.getText();
		int colonIndex4 = VALUE.indexOf('.');
		String RsValue = VALUE.substring(0, colonIndex4);
		String rsvalue1 = VALUE.substring(2, colonIndex4);
		System.out.println("Value Is ::"+ rsvalue1);

		
		WebElement dimension1 = driver.findElement(By.xpath("/html/body/app-root/app-shipment/div/div/app-listing/div/div/div/div[2]/div/div/table/tbody/tr[2]/td/div/div/div[3]/div/table/tbody/tr[2]/td[2]"));
		String Dimension1 = dimension1.getText();
		String[] Split = Dimension1.split("x");
		String Label_Length1 = split[0];
		String Label_Width1 = split[1];
		String LabelHeight1 = split[2];
		int height3 = LabelHeight1.length()-3;
		String height_2 = LabelHeight1.substring(0,height3);
		System.out.println("length1 is:: "+Label_Length1);
		System.out.println("width1 is:: "+Label_Width1);
		System.out.println("height1 is:: "+height_2);
		
		WebElement weight2 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[3]"));
		String WEIGHT1 = weight2.getText();
		String labelweight = WEIGHT1.substring(0, WEIGHT.length()-3);
		System.out.println("Weight Is ::"+ labelweight );

		WebElement value2 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[4]"));
		String VALUE1 = value2.getText();
		int colonIndex41 = VALUE1.indexOf('.');
		String RsValue1 = VALUE1.substring(0, colonIndex41);
		String rsvalue = VALUE1.substring(2, colonIndex41);
		System.out.println("Value Is ::"+ rsvalue);

		WebElement Cusref = driver.findElement(By.xpath("//td[contains(@class,'mat-cell cdk-column-customer_reference')]"));
		String CusRef  = Cusref.getText();
		System.out.println("CusReference Is ::"+ CusRef);
		
		labelData.add(receiver_Name.trim());
		labelData.add(Address_Line1);
		labelData.add(Address_Line2);
		labelData.add(Address_Line3);
		labelData.add(Pincode);
		labelData.add(receiver_Email.toUpperCase().trim());
		labelData.add(receiver_number.trim());
		labelData.add(ConTenT);
		labelData.add(LabelLength);
		labelData.add(LabelWidth);
		labelData.add(height1);
		labelData.add(labelweight1);
		labelData.add(rsvalue1);
		labelData.add(Label_Length1);
		labelData.add(Label_Width1);
		labelData.add(height_2);
		labelData.add(labelweight);
		labelData.add(rsvalue);
		labelData.add(CusRef.toUpperCase());
		labelData.add(Label_Invoice);
		System.out.println("LabelList: "+labelData);
		Assert.assertEquals(labelData,excelData);
		System.out.println("Data Is Validated");
	}
}
        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

		
		
		
		
		
		
		
		
		
				

