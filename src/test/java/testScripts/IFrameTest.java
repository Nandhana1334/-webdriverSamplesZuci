package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class IFrameTest {
  @Test
  public void sampleTest() {
	  WebDriver driver = new ChromeDriver();
	  Actions actions = new Actions(driver);
	  driver.manage().window().maximize();
	  driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	  driver.switchTo().frame("frame1");
	  WebElement inpBox = driver.findElement(By.xpath("//input[@type='text']"));
	  inpBox.sendKeys("Hello World");
	  driver.switchTo().frame("frame3");
	  WebElement chckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
	  chckBox.click();
	  driver.switchTo().parentFrame();
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame("frame2");
	  
	  WebElement dropdown = driver.findElement(By.xpath("//select[@id='animals']"));

	  
	  Select singleSel = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
	  singleSel.selectByValue("big baby cat");
	  List<WebElement> items = singleSel.getAllSelectedOptions();
	  System.out.println("Items Selected: " +items.size());
	  for(WebElement e:items)
	  {
		  System.out.println("Selected Option is: "+e.getText());
	  }
	  

	  
	  
	  
  }
}
