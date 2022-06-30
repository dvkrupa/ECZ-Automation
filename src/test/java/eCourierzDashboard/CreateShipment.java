package eCourierzDashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateShipment {
	@Test
	public void myShipment() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://qa.ecourierz.com/beta/user/dashboard");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("devops@ecourierz.com");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//mat-icon[@role='img'])[3]")).click();
		//WebElement shipmentAfter  = driver.findElement(By.xpath("//input[@placeholder='From Date']"));
		//shipmentAfter.clear();
		//shipmentAfter.sendKeys("4/1/2022");
		//driver.findElement(By.xpath("//span[text()='MAR 2022']")).click();
		//WebElement shipmentAfter = driver.findElement(By.xpath("//div[@class='mat-form-field-infix']"));
		//shipmentAfter.clear();
		driver.findElement(By.xpath("//div[@class='mat-select-arrow']")).click();
		driver.findElement(By.xpath("//mat-pseudo-checkbox[contains(@class,'mat-option-pseudo-checkbox mat-pseudo-checkbox')]")).click();
		driver.findElement(By.xpath("(//div[@class='mat-select-arrow'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='cdk-overlay-container']//div")).click();
		driver.findElement(By.xpath("(//mat-pseudo-checkbox[contains(@class,'mat-option-pseudo-checkbox mat-pseudo-checkbox')])[2]")).click();
				
			
			}


}
