package PackageSwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC7_TopMenuAbout {

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
public void topMenu() {
	
	WebElement topmenu = driver.findElement(By.id("react-burger-menu-btn"));
	topmenu.click();
	
//	WebElement about= driver.findElement(By.xpath("//a[@id='about_sidebar_link']"));
//	about.click();
//	
	
	// explicit wait - to wait for the compose button to be click-able
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("about_sidebar_link")));
	// click on the compose button as soon as the "compose" button is visible
	driver.findElement(By.id("about_sidebar_link")).click();
	
	driver.navigate().back();
	String title = driver.getTitle();
	
	
	String expectedtitle ="Swag Labs";
	
	Assert.assertEquals(title,expectedtitle);
	System.out.println("Expected title is:" +expectedtitle);
	System.out.println("Actual title is:"+ title);
	
	
}

@AfterTest
public void close() {
	driver.close();
}

}
