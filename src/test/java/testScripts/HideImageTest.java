package testScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HideImageTest {
  @Test
  public void f() {
	  ChromeOptions options = new ChromeOptions();
	  //option1
	  options.addArguments("--blink-settings=imagesEnabled=false");
	  Map<String,Object> prefs = new HashMap<String,Object>();
	  //option2
	  prefs.put("profile.managed_default_content_settings.images", 2);
	  options.setExperimentalOption("prefs", prefs);
	  WebDriver driver = new ChromeDriver(options);
	  driver.get("https://demo.opencart.com/");
	  
	  
	  
  }
}
