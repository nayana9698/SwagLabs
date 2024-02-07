package PackageSwagLabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC10_ProductVisibleInCart {
	
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
	public void addProductToCart() {
		WebElement product = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		product.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement cart =driver.findElement(By.id("shopping_cart_container"));
		cart.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_4_title_link")));
		
		WebElement productName = driver.findElement(By.id("item_4_title_link"));
		System.out.println(productName.getText()+" is addedd to cart");
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}



}
