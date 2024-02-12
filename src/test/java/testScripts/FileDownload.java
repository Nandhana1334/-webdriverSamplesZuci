package testScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FileDownload {
  @Test
  public void sample() throws InterruptedException {
//	  ChromeOptions options = new ChromeOptions();
//	  Map<String,Object> prefs = new HashMap<String,Object>();
//	  prefs.put("download.prompt_for_download", false);//for giving default download location instead of selecting the download location 
//	  options.setExperimentalOption("prefs", prefs);
//	  WebDriver driver = new ChromeDriver(options);
//	  driver.manage().window().maximize();
//	  driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");
//	  Thread.sleep(100);
//	  WebElement btnDownload = driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']"));
//	  btnDownload.click();
//	  Thread.sleep(1000);
//	  
	    ChromeOptions options=new ChromeOptions();
		 Map<String,Object> prefs=new HashMap<String,Object>();
		 prefs.put("download.prompt_for_download", false);
		 options.setExperimentalOption("prefs", prefs);
		 WebDriver driver=new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");
		 Thread.sleep(2000);
		 WebElement btnDownload=driver.findElement(By.xpath(".//a[text()='chromedriver_win32.zip']"));
		 btnDownload.click();
		 Thread.sleep(7000);
		
	  
	  
  }
}
