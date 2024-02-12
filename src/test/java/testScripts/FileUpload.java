package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
  @Test
  public void upload() {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://blueimp.github.io/jQuery-File-Upload/");
	  WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
	  String strpath = System.getProperty("user.dir") + "//1706687005835.png";
	  addFile.sendKeys(strpath);
	  driver.findElement(By.cssSelector("button[class$=start]")).click();
	  
	  
  }
}
