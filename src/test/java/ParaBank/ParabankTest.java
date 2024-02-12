package ParaBank;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ParabankTest {
	   
	   
	   public void openAccount()
	   {
		    WebDriver driver = new ChromeDriver();		
			driver.manage().window().maximize();
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			driver.findElement(By.name("username")).sendKeys("User11");
			driver.findElement(By.name("password")).sendKeys("1234");
			driver.findElement(By.cssSelector("input.button")).click();
			driver.findElement(By.xpath("//a[text() = 'Open New Account']")).click();
	
			Select singSel = new Select(driver.findElement(By.id("type")));
			singSel.selectByIndex(1);
		    driver.findElement(By.className("button")).click();
//			WebElement displays = driver.findElement(By.xpath("//p[text() = 'Congratulations, your account is now open.']"));
//			
//			if(displays.isDisplayed()) {
//			System.out.println("The account is Created");
//			}
//	
	   }
}
