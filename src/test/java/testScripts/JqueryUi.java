package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JqueryUi {
  @Test
  public void uiTest() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
	  driver.manage().window().maximize();
	  WebElement d=driver.findElement(By.xpath("//li[@id='ui-id-3']//a[contains(text(),'Enabled')]"));
	  d.click();
	  //Thread.sleep(100);
	  // driver.findElement(By.xpath("//li[@id='ui-id-3']//a[contains(text(),'Enabled')] /../ul//li//a[contains(text(),'Downloads')]")).click();
	  //driver.findElement(By.xpath("//a[contains(text(),'Enabled')]/following-sibling::ul//a[contains(text(),'Downloads')]")).click();
	  //driver.findElement(By.cssSelector("li[id='ui-id-3'] ul li>a:nth-child(1)")).click();
	  
	  //d.click();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Enabled')]/following-sibling::ul//a[contains(text(),'Downloads')]")));
	 element.click();
	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	 WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Enabled')]//following-sibling::ul//a[contains(text(),'Downloads')]//following-sibling::ul//a[contains(text(),'PDF')]")));
	 element1.click();

	  }
}
