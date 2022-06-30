package ecourierz;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CreateShipDocUtills;


public class CreateShipDocument extends CreateShipDocUtills{
	@Test(dataProvider = "CreateShip-Document")
	public void createshipdoc(String url,String uName,String pwd,String rName,String addR1,String addR2,String addR3,String rPincode,String rEmail,String rMobNum,String parcel,String length,String width,String height,String weight,String value,String custref,String invnum) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(uName);
		WebElement passWord = driver.findElement(By.name("password"));
		passWord.sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(true, "HomePage");
		System.out.println("HomePage is displayed..");
		driver.findElement(By.xpath("(//mat-icon[@role='img'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='mat-select-arrow']")).click();
		driver.findElement(By.xpath("(//span[@class='mat-option-text'])[1]")).click();

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

		driver.findElement(By.xpath("//div[@class='mat-checkbox-inner-container']")).click();

		WebElement Length = driver.findElement(By.xpath("//input[@formcontrolname='length']"));
		Length.clear();
		Length.sendKeys(length);

		WebElement Width = driver.findElement(By.xpath("//input[@formcontrolname='width']"));
		Width.clear();
		Width.sendKeys(width);

		WebElement Height = driver.findElement(By.xpath("//input[@formcontrolname='height']"));
		Height.clear();
		Height.sendKeys(height);

		WebElement Weight = driver.findElement(By.xpath("//input[@formcontrolname='weight']"));
		Weight.clear();
		Weight.sendKeys(weight);

		WebElement Value = driver.findElement(By.xpath("//input[@formcontrolname='value']"));
		Value.clear();
		Value.sendKeys(value);

		WebElement Custref = driver.findElement(By.xpath("//input[@formcontrolname='customer_reference']"));
		Custref.sendKeys(custref);

		WebElement Invnum = driver.findElement(By.xpath("//input[@formcontrolname='invoice_number']"));
		Invnum.sendKeys(invnum);

		driver.findElement(By.xpath("//button[text()=' Fetch Services']")).click();






	}
}
