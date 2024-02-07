package PackageSwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC9_ContinueShopping {
	
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
	public void continueShoppinginCart() throws InterruptedException {
		WebElement product = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		product.click();
				
		WebElement cart =driver.findElement(By.id("shopping_cart_container"));
		cart.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_4_title_link")));
		
		WebElement productName = driver.findElement(By.id("item_4_title_link"));
		System.out.println(productName.getText()+" is addedd to cart");
		
		Thread.sleep(2000);
		
		WebElement Continue = driver.findElement(By.id("continue-shopping"));
		Continue.click();
		
		System.out.println("Continuing Shopping");
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}



}
