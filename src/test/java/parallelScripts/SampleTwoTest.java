package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTwoTest {
	WebDriver driver;
	  @Test
	  public void testOne() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test 1 in sample 2 " +id);
	  }
	  @Test
	  public void testTwo() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test 2 in sample 2 " +id);
	  }
	  @Test
	  public void testThree() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test 3 in sample 2 " +id);
	  }
	  @Test
	  public void testFour() {
		  driver = new ChromeDriver();
		  long id = Thread.currentThread().getId();
		  System.out.println("Test 4 in sample 2 " +id);
	  }
}
