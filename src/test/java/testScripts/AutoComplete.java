package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoComplete {
  @Test
  public void sampleAutoComplete() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://jqueryui.com/autocomplete/");
      WebElement frame1 = driver.findElement(By.cssSelector(".demo-frame"));
      driver.switchTo().frame(frame1);
      WebElement inTag = driver.findElement(By.cssSelector("#tags"));
      inTag.sendKeys("as");
    
	  WebElement select = driver.findElement(By.cssSelector("ul.ui-menu.ui-widget.ui-widget-content.ui-autocomplete.ui-front li div#ui-id-44"));
	  select.click();
  }
}
