package PackageSwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC13_Facebook {
WebDriver driver;
	
	@BeforeTest
	public void login() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
	
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");	
		
		WebElement login = driver.findElement(By.id("login-button"));
		login.submit();
}

	@Test
	public void facebook() throws InterruptedException {
		
		//scroll down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement footerele = driver.findElement(By.xpath("//a[contains(text(),'Facebook')]"));
		
		js.executeScript("arguments[0].scrollIntoView();", footerele);
		
		Thread.sleep(2000);
		
		footerele.click();
		
		
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}


}
