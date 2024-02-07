package PackageSwagLabs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC19_CheckOutInfoExcel {
	
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
		
		WebElement product = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		product.click();
				
		WebElement cart =driver.findElement(By.id("shopping_cart_container"));
		cart.click();
		
		
		WebElement checkout = driver.findElement(By.id("checkout"));
		checkout.click();
		
}

@Test
public void excelReading() throws IOException, InterruptedException {
	
	
	
	//Location of the file
			File file_path = new File("D://New folder//CheckoutInfo.xlsx");
			
			//Object for opening the file in read mode
			FileInputStream filestream1 = new FileInputStream(file_path);
			
			//Object for accessing workbook
			XSSFWorkbook w_book = new XSSFWorkbook(filestream1);
			
			
			//Object for accessing the sheet
			XSSFSheet sheet1=w_book.getSheet("data");
			System.out.println(sheet1.getLastRowNum());
			
			
//			System.out.println(sheet1.getRow(1).getCell(0).getStringCellValue());
//			System.out.println(sheet1.getRow(1).getCell(1).getStringCellValue());
			
			
			for(int i=1; i<=sheet1.getLastRowNum();i++) {
				
				String firstname= sheet1.getRow(i).getCell(0).getStringCellValue();
				String lastname= sheet1.getRow(i).getCell(1).getStringCellValue();
				String zipcode = sheet1.getRow(i).getCell(2).getStringCellValue();
				
				Thread.sleep(4000);	
				
				driver.findElement(By.id("first-name")).sendKeys(firstname);
				Thread.sleep(2000);
				driver.findElement(By.id("last-name")).sendKeys(lastname);
				Thread.sleep(2000);
				driver.findElement(By.id("postal-code")).sendKeys(zipcode);
				Thread.sleep(2000);
				
				driver.findElement(By.id("continue")).click();
				Thread.sleep(2000);
				
				String title = driver.getTitle();
				String expectedtitle ="Swag Labs";
				
				Assert.assertEquals(title,expectedtitle);
				System.out.println("Expected title is:" +expectedtitle);
				System.out.println("Actual title is:"+ title);
				
	
			
}
			FileOutputStream f_output = new FileOutputStream(file_path);
			w_book.write(f_output);
			w_book.close();
			f_output.close();
			filestream1.close();

}


}
