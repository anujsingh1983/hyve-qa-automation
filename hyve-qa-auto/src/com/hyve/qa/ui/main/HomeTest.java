package com.hyve.qa.ui.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hyve.utility.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class HomeTest {
	
	ExtentReports report;
	ExtentTest logger;
	public String hyvecare = "https://www.hyve.buzz/hyve-care-products";
	public String hyvehome = "https://www.hyve.buzz/";
	public String hyvelogin = "https://www.hyve.buzz/login";
	public WebDriver driver = new FirefoxDriver();

	/*@BeforeTest
	public void setup() throws Exception {
		
	}*/

	@Test(priority = 1)
	public void testHomePageTitle() {
		report = new ExtentReports("F:\\Automation\\git-codebase\\hyve-qa-automation\\hyve-qa-auto\\Report.html");
		logger = report.startTest("testHomePageTitle");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.log(LogStatus.INFO," Browser Started ");
		driver.get(hyvehome);
		logger.log(LogStatus.INFO," Browser up and Running ");
		String expectedTital = "Hyve - Android Smartphonesss";
		String actualTital = driver.getTitle();
		Assert.assertEquals(actualTital, expectedTital);
		logger.log(LogStatus.PASS," Title Verified ");

	}

    @Test(priority = 2)
	public void testLogin() {

		// driver.get(hyvelogin);
		driver.findElement(By.className("logout-header")).click();
		//xpath("//div[2]/div[1]/div/div/div/div/div[3]/div/div/div[1]/a[2]
		driver.findElement(By.id("UserEmail")).clear();
		driver.findElement(By.id("UserEmail")).sendKeys("anuj.singh@hyve.buzz");
		driver.findElement(By.id("UserPassword")).clear();
		driver.findElement(By.id("UserPassword")).sendKeys("1234567");
		driver.findElement(By.className("login-btn waves-effect waves-cyan btn-yellow btn-large")).submit();
		//driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/div[2]/div/div/form/div[3]/button")).submit();
		String expected = "Anuj";
		String actualtext = driver.findElement(By.className("username_name")).getText();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		Assert.assertEquals(actualtext, expected);

	}
	
	/*@Test(priority = 3)
	public void testCart() throws InterruptedException, ParseException{
		driver.findElement(By.xpath("//div[2]/div[1]/div/div/div[1]/div/div[2]/div/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//div[2]/div[1]/div/div/div[2]/div[1]/ul/li[11]/a")).click();
		
		String subtotal=driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/div[1]/div/div/form/table/tbody/tr/td[4]/div")).getText();
		System.out.println("subtotal = "+ subtotal);
		
		String saleprice=driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/div[1]/div/div/form/table/tbody/tr/td[3]/div")).getText();
		System.out.println("Sale Price = "+ saleprice);
		
		String quantity=driver.findElement(By.xpath("//*[contains(@name,'qty')]")).getAttribute("value");
		System.out.println("Quantity = "+ quantity);
		
	
	double isubtotal= Double.parseDouble(subtotal.replaceAll("[^0-9\\.]+", ""));
	//System.out.println("isubtotal is "+isubtotal);
	double isaleprice= Double.parseDouble(saleprice.replaceAll("[^0-9\\.]+", ""));
	//System.out.println("isaleprice is "+isaleprice);
		int iquantity=Integer.parseInt(quantity);
		double expectedsubtotal=(isaleprice*iquantity);
		System.out.println("Expected Subtotal is "+expectedsubtotal);
		Assert.assertEquals(isubtotal, expectedsubtotal);
		System.out.println("Great.. Subtotal is correct");
				
		Thread.sleep(3000);
	}*/

	/*@Test(priority = 3)

	public void Hyve_Care_Report_a_Bug() throws AWTException, InterruptedException {
		driver.get(hyvecare);
		driver.findElement(By.xpath("//div[2]/div[3]/div/div/div/div[2]/div[2]/a/div/div[1]/img")).click();;
		driver.findElement(By.xpath("//div[2]/div[3]/div/div/ul/li[2]/a")).click();
		// Enter Values in Text Field
		driver.findElement(By.id("BugName")).sendKeys("Anuj Singh");
		driver.findElement(By.id("BugEmail")).sendKeys("anuj@gmail.com");
		// Select Device from Drop down.
		Select drpproductid = new Select(driver.findElement(By.name("data[Bug][product_id]")));
		drpproductid.selectByVisibleText("Buzz BU01"); // Select Product Category from Drop down.
		Select drpproductcat = new Select(driver.findElement(By.name("data[Bug][product_category]")));
		drpproductcat.selectByVisibleText("Software");
		driver.findElement(By.id("BugDescription")).sendKeys("Hello this is for testing");
		driver.findElement(By.id("BugBuildNumber")).sendKeys("A001");
		driver.findElement(By.id("BugHowOffen")).sendKeys("Daily");
		driver.findElement(By.id("BugHasOccured")).sendKeys("No");
		WebElement Bugroot = driver.findElement(By.xpath("//div[2]/div[3]/div/div/div[2]/div/div/div/div/form/div[2]/div[9]/div[1]/label"));
		Bugroot.click(); // click the "Attachment" button
		driver.findElement(By.name("data[Bug][attachment]")).click();
		StringSelection ss = new StringSelection("C:\\Users\\Anuj Singh\\Desktop\\aa.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//div[2]/div[3]/div/div/div[2]/div/div/div/div/form/div[2]/div[11]/button")).submit();

	}*/

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshot_path= Utility.captureScreenshot(driver, result.getName());
			String image=logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL," Title Verification ", image);
		}
		report.endTest(logger);
		report.flush();
		driver.get("F:\\Automation\\git-codebase\\hyve-qa-automation\\hyve-qa-auto\\Report.html");
		//driver.quit();
	}

}
