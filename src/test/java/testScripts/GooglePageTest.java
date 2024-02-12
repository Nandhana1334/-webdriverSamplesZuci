package testScripts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class GooglePageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// the webdriver object will check the browser version and download the corresponding driver
		//**WebDriver driver = new ChromeDriver();
		//the chromeoptions will download the chrome version and the driver to that version-chrome test
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("115");
		WebDriver driver = new ChromeDriver(options);
		
		
//		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		WebElement txtArea = driver.findElement(By.id("APjFqb"));
		txtArea.sendKeys("Java Tutorial");
		//txtArea.sendKeys(Keys.ENTER);
		
		
		

	}

}
