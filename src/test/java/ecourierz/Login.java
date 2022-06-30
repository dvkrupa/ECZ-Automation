package ecourierz;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CreateShipUtils;
import utils.ReadExcelCreateShipment;


public class Login extends CreateShipUtils {
	public static ExtentReports extent;
	ExtentHtmlReporter reporter;
	public static ExtentTest test;
	public static WebDriver driver;
	@BeforeSuite
	public void setup() {
		//set up the physical report path
		reporter = new ExtentHtmlReporter("./reports/result.html");
		//Create an object for extent reports
		extent = new ExtentReports();
		//To retain the history
		reporter.setAppendExisting(true);
		//Attach the data with physical file
		extent.attachReporter(reporter);
	}
	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	//private int ;
	@Test(dataProvider = "createShipment")
	public void ecourierzLogin(String url,String uName,String pwd,String rName,String addR1,String addR2,String addR3,String rPincode,String rEmail,String rMobNum,String parcel,String length,String Width,String height,String wt,String value,String custRef,String invNum) throws Exception {
		try {
		test = extent.createTest("CreateShipment","Login with positive credentials");
		 driver.get(url);
		 test.pass("Navigated to ecourierz.com");
		 driver.findElement(By.xpath("//input[@title='Please enter your Username / Email']")).sendKeys(uName);
		 test.pass("Entered Username successfully..");
		 driver.findElement(By.xpath("//input[@title='Please enter your Password']")).sendKeys(pwd);
		 test.pass("Entered Password successfully..");
		 driver.findElement(By.xpath("//button[contains(@class,'btn btn-lg')]")).click();
		Assert.assertTrue(true, "HomePage");
		System.out.println("HomePage is displayed..");
		driver.findElement(By.xpath("(//mat-icon[@role='img'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='mat-select-arrow']")).click();
		driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]")).click();

		WebElement nameR = driver.findElement(By.id("mat-input-0"));
		nameR .sendKeys(rName);
		//String NameR = nameR.getAttribute("value");
		//Assert.assertEquals(NameR, rName);
		//System.out.println("rName is Validated");

		WebElement addr1 = driver.findElement(By.id("mat-input-1"));
		addr1.sendKeys(addR1);
		//String Addr1 = addr1.getAttribute("value");
		//Assert.assertEquals(Addr1, addR1);
		//System.out.println("Address R1 is Validated");

		WebElement addr2 = driver.findElement(By.id("mat-input-2"));
		addr2.sendKeys(addR2);
		//String Addr2 = addr2.getAttribute("value");
		//Assert.assertEquals(Addr2, addR2);
		//System.out.println("Address R2 is Validated");

		WebElement addr3 = driver.findElement(By.id("mat-input-3"));
		addr3.sendKeys(addR3);
		//String Addr3 = addr3.getAttribute("value");
		//Assert.assertEquals(Addr3, addR3);
		//System.out.println("Address R3 is Validated");

		WebElement Rpincode = driver.findElement(By.id("mat-input-11"));
		Rpincode.sendKeys(rPincode);
		//String RpinCode = Rpincode.getAttribute("value");
		//Assert.assertEquals(RpinCode, rPincode);
		//System.out.println("R pincode is Validated");

		WebElement Remail = driver.findElement(By.id("mat-input-6"));
		Remail.sendKeys(rEmail);
		//String ReMail =Remail .getAttribute("value");
		//Assert.assertEquals(ReMail, rEmail);
		//System.out.println("R Email is Validated");


		WebElement Rmobnum = driver.findElement(By.id("mat-input-7"));
		Rmobnum.sendKeys(rMobNum);
		//String RmobNum =Rmobnum .getAttribute("value");
		//Assert.assertEquals(RmobNum, rMobNum);
		//System.out.println("R MobNum is Validated");

		WebElement paRcel = driver.findElement(By.id("mat-input-8"));
		paRcel.sendKeys(parcel);
		//String ParCel =paRcel .getAttribute("value");
		//Assert.assertEquals(ParCel, parcel);
		//System.out.println("Parcel is Validated");

		driver.findElement(By.xpath("(//div[@class='mat-checkbox-inner-container'])[2]")).click();

		WebElement Length = driver.findElement(By.id("mat-input-12"));
		Length.sendKeys(length);
		//String LenGth =Length .getAttribute("value");
		//Assert.assertEquals(LenGth, length);
		//System.out.println("Length is Validated");


		WebElement width = driver.findElement(By.id("mat-input-13"));
		width.sendKeys(Width);
		//String widTH =width .getAttribute("value");
		//Assert.assertEquals(widTH, Width);
		//System.out.println("Width is Validated");



		WebElement Height = driver.findElement(By.id("mat-input-14"));
		Height.sendKeys(height);
		//String heigTH =Height.getAttribute("value");
		//Assert.assertEquals(heigTH, height);
		//System.out.println("Height is Validated");


		WebElement weight = driver.findElement(By.id("mat-input-15"));
		weight.sendKeys(wt);
		//String Weight =weight.getAttribute("value");
		//Assert.assertEquals(Weight, wt);
		//System.out.println("Weight is Validated");

		WebElement valUE = driver.findElement(By.id("mat-input-16"));
		valUE.sendKeys(value);
		//String Value =valUE.getAttribute("value");
		//Assert.assertEquals(Value, value);
		//System.out.println("Value is Validated");

		WebElement custref = driver.findElement(By.id("mat-input-9"));
		custref.sendKeys(custRef);
		//String CustRef =custref.getAttribute("value");
		//Assert.assertEquals(CustRef, custRef);
		//System.out.println("Coustomer Refference is Validated");

		WebElement invnum = driver.findElement(By.id("mat-input-10"));
		invnum.sendKeys(invNum);
		//String InVnum =invnum.getAttribute("value");
		//Assert.assertEquals(InVnum, invNum);
		//System.out.println("InVoice Number is Validated");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//button[text()=' Create Shipment '])[3]")).click();
		//driver.findElement(By.xpath("//button[text()=' Print Label ']")).click();

		/**
		 * To get the label and read data from it & validate with excel data
		 */

		driver.findElement(By.xpath("(//mat-icon[contains(@class,'mat-icon notranslate')])[3]")).click();
		driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/button[1]/span[1]")).click();
		ArrayList<String> excelData = ReadExcelCreateShipment.getExcelList();
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

		//WebElement dimensions = driver.findElement(By.cssSelector("html>body>app-root>app-shipment>div>div>app-listing>div>div>div>div:nth-of-type(2)>div>div>table>tbody>tr:nth-of-type(2)>td>div>div>div:nth-of-type(3)>div>table>tbody>tr>td:nth-of-type(2)"));
		//String DIMENSIONS = dimensions.getText();
		//System.out.println("Dimensions Is ::"+ DIMENSIONS);

		WebElement weight1 = driver.findElement(By.cssSelector("html>body>app-root>app-shipment>div>div>app-listing>div>div>div>div:nth-of-type(2)>div>div>table>tbody>tr:nth-of-type(2)>td>div>div>div:nth-of-type(3)>div>table>tbody>tr>td:nth-of-type(3)"));
		String WEIGHT = weight1.getText();
		String labelweight = WEIGHT.substring(0, WEIGHT.length()-3);
		System.out.println("Weight Is ::"+ labelweight );

		WebElement value1 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[4]"));
		String VALUE = value1.getText();
		int colonIndex4 = VALUE.indexOf('.');
		String RsValue = VALUE.substring(0, colonIndex4);
		String rsvalue = VALUE.substring(2, colonIndex4);
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
		labelData.add(labelweight);
		labelData.add(rsvalue);
		labelData.add(CusRef.toUpperCase().trim());
		labelData.add(Label_Invoice);
		Assert.assertEquals(labelData,excelData);
		System.out.println("Data Is Validated");
		test.info("All Data are validated successfully..");
	}catch(Exception e) {
		test.log(Status.FAIL, e.getMessage());
	}
}
@AfterTest
public void teardown() {
	driver.quit();
}
@AfterSuite
public void stopReports() {
	extent.flush();
}




	}




