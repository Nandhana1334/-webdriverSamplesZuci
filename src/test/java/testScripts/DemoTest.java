package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DemoTest {
  @Test
  public void automationTest() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/automation-practice-form");
	  WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
	  firstName.sendKeys("Nandhana");
	  WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
	  lastName.sendKeys("Sri");
	  driver.findElement(By.id("userEmail")).sendKeys("nan@gmail.com");
	  WebElement gender = driver.findElement(By.xpath("(//label[@class=\"custom-control-label\"])[1]"));
	  gender.click();
//	  JavascriptExecutor js=(JavascriptExecutor)driver;
//	  WebElement date=(WebElement)js.executeScript("return document.getElementById('dateOfBirthInput').value='01 Mar 2024'");
//	  date.click();
	  WebElement dob = driver.findElement(By.id("userNumber"));
	  dob.sendKeys("4563289110");
//	  WebElement sub = driver.findElement(By.className("subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3"));
//	  sub.sendKeys("hi");
	  
	  WebElement sub = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
	  sub.sendKeys("hi");
	 // driver.findElement(By.xpath("//div[contains(text(),'Hindi')]")).click();
//	  subj.click();
	  driver.findElement(By.id("react-select-2-option-0")).click();
	  //Select date = new Select(driver.findElement(By.id("react-datepicker__year-select")));
//	  Select yr = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
//	  yr.selectByValue("2024");
//	  driver.switchTo().frame("googlefcPresent");
//	  Select yr = new Select(driver.findElement(By.cssSelector(".react-datepicker__month-select")));
//	  yr.selectByValue("2024");
//	  Select month = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
//	  month.selectByValue("February");
	  //driver.switchTo().defaultContent();
	 // WebElement date = driver.findElement(By.cssSelector("div[class$='08']"));
	  
	  WebElement imgUpload= driver.findElement(By.cssSelector("input#uploadPicture"));
	  String strPath = System.getProperty("user.dir")
				+"//1706687005835.png";
	  imgUpload.sendKeys(strPath);
	  WebElement addr = driver.findElement(By.id("currentAddress"));
	  addr.sendKeys("Hello");
	  
	  WebElement hobbie1= driver.findElement(By.xpath("(//label[@class='custom-control-label'])[4]"));
	  if(!hobbie1.isSelected())
	  {
		  hobbie1.click();
	  }
	  
	  
//	  WebElement state = driver.findElement(By.xpath("(//div[@class=' css-1uccc91-singleValue'])[1]"));
//	  state.click();
//	  WebElement city = driver.findElement(By.xpath("(//div[@class=' css-1uccc91-singleValue'])[2]"));
//	  city.click();
	  //Select singleSel = new Select(driver.findElement(By.id("react-select-3-input")));
//	  WebElement state = driver.findElement(By.id("react-select-3-input"));
//	  state.click();
	  
	  WebElement state = driver.findElement(By.id("react-select-3-input"));

	  state.sendKeys("R");
	  driver.findElement(By.id("react-select-3-option-2")).click();
//	  WebElement selState = driver.findElement(By.cssSelector(".css-12jo7m5.subjects-auto-complete__multi-value__label"));
//	  selState.click();
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
