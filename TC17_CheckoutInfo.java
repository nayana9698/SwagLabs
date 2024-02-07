package PackageSwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC17_CheckoutInfo {
	
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
	public void checkOutInfo() {
		WebElement product = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		product.click();
				
		WebElement cart =driver.findElement(By.id("shopping_cart_container"));
		cart.click();
		
		
		WebElement checkout = driver.findElement(By.id("checkout"));
		checkout.click();
		
		WebElement checkoutInfo = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]"));
		System.out.println(checkoutInfo.getText()+ " is displayed");
		
//		WebElement firstname = driver.findElement(By.id("first-name"));
//		System.out.println(firstname.getText());
//		
//		WebElement lastname = driver.findElement(By.id("last-name"));
//		System.out.println(lastname.getText());
//		
//		WebElement zipcode = driver.findElement(By.id("postal-code"));
//		System.out.println(zipcode.getText());
		
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}



}
