package ecourierz;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myshipment {
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
		driver.findElement(By.xpath("//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")).click();
		//m)
		driver.findElement(By.xpath("//mat-icon[text()='cloud_download']")).click();	
			}

}
