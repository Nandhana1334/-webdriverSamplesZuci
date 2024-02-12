package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.Utility;

public class SampleOneTest {
  
  
  
  WebDriver driver;
  ExtentReports extentReports;
  ExtentSparkReporter spark;
  ExtentTest extentTest;
  
  
  @BeforeTest
  public void setUpExtent()
  {
	  extentReports = new ExtentReports();
	  spark = new ExtentSparkReporter("test-output/SparkReport.html")
			  .viewConfigurer().viewOrder().as(new ViewName[]{
		  ViewName.DASHBOARD,ViewName.TEST,ViewName.AUTHOR,ViewName.DEVICE,ViewName.LOG
	  }).apply();
	  extentReports.attachReporter(spark);
  }
  
  
  @BeforeMethod
  public void setup()
  {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  
  
 // @Test(dependsOnMethods="scenario2")
  @Test()
  public void scenario1() {
//	  WebDriver driver = new ChromeDriver();
//	  Assert.assertEquals(driver.getTitle(), "Google Page");
//	  SoftAssert softAssert = new SoftAssert();
//	  softAssert.assertEquals(driver.getTitle(), "Google Page");
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  extentTest = extentReports.createTest("Java Search Test");
	  
	  driver.get("https://www.google.com/");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Java Tutorial");
	  srcBox.submit();
	  
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
//	  softAssert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
//	  softAssert.assertAll();
//	  
//	  
//	  driver.get("https://www.google.com/");//LAUNCH THE PAGE
//		SoftAssert softAssert=new SoftAssert();
//		softAssert.assertEquals(driver.getTitle(), "Google Page");
//		WebElement srcBox=driver.findElement(By.id("APjFqb"));//LOCATE THE ELEMENT
//		srcBox.sendKeys("Java tutorial");//ENTER VALUES
//		srcBox.submit();
//		softAssert.assertEquals(driver.getTitle(), "Java tutorial - Google Search");
//		softAssert.assertAll();//
  }
  @Test(retryAnalyzer = RetryAnalyzer.class)
  public void scenario2() {
	  //WebDriver driver = new ChromeDriver();
	  extentTest = extentReports.createTest("Selenium Search Test");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.google.com/");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Selenium Tutorial");
	  srcBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Selenium1 Tutorial - Google Search");
	  
	  
  }
  @Test
  public void scenario3() {
	 // WebDriver driver = new ChromeDriver();
	  extentTest = extentReports.createTest("Ansible Search Test");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.google.com/");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Ansible Tutorial");
	  srcBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Ansible Tutorial - Google Search");
	  
	  
  }
  @AfterMethod
  public void tearDown(ITestResult result)
  {
	  extentTest.assignAuthor("AutomationTester1").assignCategory("Regression").assignDevice(System.getProperty("os.name")).assignDevice("os.version");
	  if(ITestResult.FAILURE == result.getStatus())
	  {
		  extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		  String strPath = Utility.getScreenshotPath(driver);
		  extentTest.fail(MediaEntityBuilder.
				  createScreenCaptureFromPath
				  (strPath).build());
	  }
	  else if(ITestResult.SKIP == result.getStatus())
	  {
		  extentTest.log(Status.SKIP, result.getThrowable().getMessage());
	  }
	  driver.close();
  }
  
  @AfterTest
  public void finishExtent()
  {
	  extentReports.flush();
  }
  
}
