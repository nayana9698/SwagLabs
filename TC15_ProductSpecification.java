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

public class TC15_ProductSpecification {
	
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
	public void productDescr() throws InterruptedException {
		WebElement product = driver.findElement(By.id("item_0_title_link"));
		product.click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]")));
		
		WebElement productName = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]"));
				
		
		WebElement frame1Heading= driver.findElement(By.className("inventory_details_price"));
		String frame1Text=frame1Heading.getText();
		System.out.println("Price of the product " +productName.getText() + " is : "+frame1Text);

		
		
		
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'A red')]")));
		
		WebElement productDescr1 = driver.findElement(By.xpath("//div[contains(text(),'A red')]"));
		
		String frame1Text1=productDescr1.getText();
		System.out.println("Description of the product is : " + frame1Text1);

		
	}

	@AfterTest
	public void close() {
		driver.close();
	}


}
