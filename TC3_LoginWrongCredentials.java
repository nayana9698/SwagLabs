package PackageSwagLabs;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC3_LoginWrongCredentials {
	
	
WebDriver driver;
	
	@BeforeTest
	public void login() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
	
}
	
	@Test 
	public void testcase() {
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user123");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");	
		
		WebElement login = driver.findElement(By.id("login-button"));
		login.submit();
		
		// This will capture error message
		String actual_msg=driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")).getText();
		    
		// Store message in variable
		String expect="Epic sadface: Username and password do not match any user in this service";
		                
		// Verify error message
		Assert.assertEquals(actual_msg, expect);
		System.out.println(actual_msg);
	}
	@AfterTest
	public void close() {
		driver.close();
	}


}
