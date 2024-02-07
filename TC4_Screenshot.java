package PackageSwagLabs;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TC4_Screenshot {

	
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
	public void screenshot() throws IOException {
		
		//take screenshot
		
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		Files.copy(screenshot, new File("C:\\Users\\user\\Documents\\Nayana\\SauceLogin.png"));
		System.out.println("The screenshot is taken");
				
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}

}
