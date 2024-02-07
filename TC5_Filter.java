package PackageSwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC5_Filter {
	
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
	public void filter() throws InterruptedException {
		
		
		Select filter = new Select(driver.findElement(By.className("product_sort_container")));
		Thread.sleep(2000);
		
		//select dropdown using value Z to A
		filter.selectByValue("za");
		Thread.sleep(2000);

		
		Select filter1 = new Select(driver.findElement(By.className("product_sort_container")));
		Thread.sleep(2000);
		
	
		//select dropdown using value Price low to high
		filter1.selectByValue("lohi");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}


}
