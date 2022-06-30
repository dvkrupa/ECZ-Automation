package ecourierz;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CreateShipOthersUtils;
import utils.ReadExcelCreateShipOthers;


public class CreateShipOthers extends CreateShipOthersUtils {
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
	@Test(dataProvider = "createUtilsothers",dataProviderClass =CreateShipOthersUtils.class)
	public void createshipdoc(String url,String uName,String pwd,String sName,String cName,String ADD1,String ADD2,String ADD3,String sPincode,String sEmail,String sNum,String rName,String addR1,String addR2,String addR3,String rPincode,String rEmail,String rMobNum,String parcel,String length,String WIDTH,String height,String wEIGHT,String value,String CUSTREF,String INVNUM) throws Exception {
		try {
			test = extent.createTest("CreateShip-Others-Prepaid-Parcel-Commercial","Login with positive credentials");
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
			driver.findElement(By.xpath("(//span[@class='mat-option-text'])[3]")).click();

			WebElement senderName = driver.findElement(By.xpath("//input[contains(@class,'mat-input-element mat-form-field-autofill-control')]"));
			senderName.sendKeys(sName);

			WebElement sCompanyName = driver.findElement(By.xpath("(//input[contains(@class,'mat-input-element mat-form-field-autofill-control')])[2]"));
			sCompanyName.sendKeys(cName);

			WebElement Address1 = driver.findElement(By.xpath("(//input[contains(@class,'mat-input-element mat-form-field-autofill-control')])[3]"));
			Address1.sendKeys(ADD1);

			WebElement Address2 = driver.findElement(By.id("mat-input-21"));
			Address2.sendKeys(ADD2);

			WebElement Address3 = driver.findElement(By.id("mat-input-22"));
			Address3.sendKeys(ADD3);

			WebElement senderPincode = driver.findElement(By.id("mat-input-23"));
			senderPincode.sendKeys(sPincode);

			WebElement senderEmail = driver.findElement(By.id("mat-input-26"));
			senderEmail.sendKeys(sEmail);

			WebElement senderNum = driver.findElement(By.id("mat-input-27"));
			senderNum.sendKeys(sNum);

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
			width.sendKeys(WIDTH);

			WebElement Height = driver.findElement(By.id("mat-input-14"));
			Height.sendKeys(height);

			WebElement weight = driver.findElement(By.id("mat-input-15"));
			weight.sendKeys(wEIGHT);

			WebElement valUE = driver.findElement(By.id("mat-input-16"));
			valUE.sendKeys(value);

			WebElement Custref = driver.findElement(By.id("mat-input-9"));
			Custref.sendKeys(CUSTREF);

			WebElement invnum = driver.findElement(By.id("mat-input-10"));
			invnum.sendKeys(INVNUM);

			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.xpath("(//button[text()=' Create Shipment '])[3]")).click();

			/**
			 * To get the label and read data from it & validate with excel data
			 */

			driver.findElement(By.xpath("(//mat-icon[contains(@class,'mat-icon notranslate')])[3]")).click();
			driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/button[1]/span[1]")).click();
			ArrayList<String> excelData = ReadExcelCreateShipOthers.getExcelList();
			ArrayList<String> labelDataOthers = new ArrayList<String>();

			WebElement labelinvoice = driver.findElement(By.xpath("//b[contains(text(),'Invoice Number')][1]/following-sibling::b"));
			String Label_Invoice = labelinvoice.getText();
			System.out.println("Label Invoice Num is ::" +Label_Invoice);

			WebElement content = driver.findElement(By.xpath("//b[contains(text(),'Contents')][1]/following-sibling::b"));
			String ConTenT = content.getText();
			System.out.println("Contents is ::" +ConTenT);

			WebElement SenderName = driver.findElement(By.xpath("/html/body/app-root/app-shipment/div/div/app-listing/div/div/div/div[2]/div/div/table/tbody/tr[2]/td/div/div/div[2]/div/table/tbody/tr/td[1]/b[1]"));
			String Sender_Name = SenderName.getText();
			int Sender = Sender_Name.indexOf(' ');
			String sender_name = Sender_Name.substring(Sender, Sender_Name.length());
			System.out.println("Sender Name Is ::" +sender_name);

			WebElement SenderEmail = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/b[2]"));
			String Sender_email = SenderEmail.getText();
			int Senderemail = Sender_email.indexOf(' ');
			String senderemail = Sender_email.substring(Senderemail, Sender_email.length());
			System.out.println("Sender Email is ::" +senderemail);

			WebElement SenderNumber = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/b[3]"));
			String S_Number = SenderNumber.getText();
			int sendernumber = S_Number.indexOf(' ');
			String sNumber= S_Number.substring(sendernumber, S_Number.length());
			System.out.println("Sender Number Is ::" +sNumber);

			WebElement SenderComapany = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/b[1]"));
			String Sender_Comapany  = SenderComapany.getText();
			System.out.println("Sender Company is ::" +Sender_Comapany);

			WebElement Saddress1 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/b[2]"));
			String S_Address1 = Saddress1.getText();
			System.out.println("SenderAddress 1 is ::" +S_Address1);

			WebElement Saddress2 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/b[3]"));
			String S_Address2 = Saddress2.getText();
			System.out.println("SenderAddress 2 is ::" +S_Address2);

			WebElement Saddress3 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/b[4]"));
			String S_Address3 = Saddress3.getText();
			System.out.println("SenderAddress 3 is ::" +S_Address3);

			WebElement s_Pincode = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/b[7]"));
			String SenderPincode = s_Pincode.getText();
			System.out.println("Sender Pincode is ::"+SenderPincode);

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
			//int add1 = Address_Line1.indexOf(' ');
			//String Add1 = Address_Line1.substring(add1 , Address_Line1.length());
			System.out.println("Address Line 1 Is ::" + Address_Line1);

			WebElement addressline2 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/b[2]"));
			String Address_Line2 = addressline2.getText();
			//int add2 = Address_Line2.indexOf(' ');
			//String Add2 = Address_Line2.substring(add2 , Address_Line2.length());
			System.out.println("Address Line 2 Is ::" + Address_Line2);

			WebElement addressline3 = driver.findElement(By.xpath("html[1]/body[1]/app-root[1]/app-shipment[1]/div[1]/div[1]/app-listing[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/b[3]"));
			String Address_Line3 = addressline3.getText();
			//int add3 = Address_Line3.indexOf(' ');
			//String Add3 = Address_Line3.substring(add3 , Address_Line3.length());
			System.out.println("Address Line 3 Is ::" + Address_Line3);

			WebElement pincode = driver.findElement(By.cssSelector("html>body>app-root>app-shipment>div>div>app-listing>div>div>div>div:nth-of-type(2)>div>div>table>tbody>tr:nth-of-type(2)>td>div>div>div:nth-of-type(2)>div>table>tbody>tr>td:nth-of-type(2)>div>b:nth-of-type(5)"));
			String Pincode = pincode.getText();
			System.out.println("Pincode Is ::" + Pincode);

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

			labelDataOthers.add(sender_name.trim());
			labelDataOthers.add(Sender_Comapany);
			labelDataOthers.add(S_Address1);
			labelDataOthers.add(S_Address2);
			labelDataOthers.add(S_Address3);
			labelDataOthers.add(SenderPincode);
			labelDataOthers.add(senderemail.toUpperCase().trim());
			labelDataOthers.add(sNumber.trim());
			labelDataOthers.add(receiver_Name.trim());
			labelDataOthers.add(Address_Line1);
			labelDataOthers.add(Address_Line2);
			labelDataOthers.add(Address_Line3);
			labelDataOthers.add(Pincode);
			labelDataOthers.add(receiver_Email.toUpperCase().trim());
			labelDataOthers.add(receiver_number.trim());
			labelDataOthers.add(ConTenT);
			labelDataOthers.add(labelweight);
			labelDataOthers.add(rsvalue);
			labelDataOthers.add(CusRef.toUpperCase().trim());
			labelDataOthers.add(Label_Invoice);
			System.out.println("LabelData is :: "+labelDataOthers);
			Assert.assertEquals(labelDataOthers,excelData);
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

		


