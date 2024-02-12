package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {
  @Test
  public void sampleAlert() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
//	  driver.findElement(By.xpath("(//button[contains(text(),'Click me!')])[1]")).click();
//	  Alert alert = driver.switchTo().alert();
//	  Assert.assertEquals(alert.getText(), "I am an alert box!");
//	  alert.accept();
//	  
//	  //Example for cancel
//	  driver.findElement(By.xpath("(//button[contains(text(),'Click me!')])[2]")).click();
//	  Alert confirm = driver.switchTo().alert();
//	  Assert.assertEquals(confirm.getText(), "Press a button!");
//	  Thread.sleep(10000);
//	  confirm.dismiss();
	  
	  //prompt alert
	  driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();
	  Alert prompt = driver.switchTo().alert();
	  System.out.println("Alert text: "+prompt.getText());
	  prompt.sendKeys("Hello Worlds");
	  prompt.accept();
	  
	  
	  
	  
  }
}
