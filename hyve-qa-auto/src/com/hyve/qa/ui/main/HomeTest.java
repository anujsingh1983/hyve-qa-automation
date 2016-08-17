package com.hyve.qa.ui.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeTest {

	public String hyvecare = "https://www.hyve.buzz/hyve-care";
	public String hyvehome = "https://www.hyve.buzz/";
	public String hyvelogin = "https://www.hyve.buzz/login";
	public WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setup() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(hyvehome);
	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		String expectedTital = "Hyve - Android Smartphones";
		String actualTital = driver.getTitle();
		Assert.assertEquals(actualTital, expectedTital);

	}

	@Test(priority = 2)
	public void testLogin() {

		// driver.get(hyvelogin);
		driver.findElement(By.xpath("//div[2]/div[1]/div/div/div/div/div[3]/div/div/div[1]/a[2]")).click();
		driver.findElement(By.id("UserEmail")).clear();
		driver.findElement(By.id("UserEmail")).sendKeys("anuj.singh@hyve.buzz");
		driver.findElement(By.id("UserPassword")).clear();
		driver.findElement(By.id("UserPassword")).sendKeys("1234567");
		driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/div[2]/div/div/form/div[3]/button")).submit();

		String expected = "Anuj";
		String actualtext = driver.findElement(By.className("username_name")).getText();
		// Thread.sleep(3000);
		Assert.assertEquals(actualtext, expected);

	}

	// TODO: Correct below test method.
	/*
	 * @Test public void Hyve_Care() throws AWTException, InterruptedException{
	 * driver.get(hyvecare);
	 * driver.findElement(By.xpath("//div[3]/div[3]/div/ul/li[2]/a")).click();
	 * //Enter Values in Text Field
	 * driver.findElement(By.id("BugName")).sendKeys("Anuj Singh");
	 * driver.findElement(By.id("BugEmail")).sendKeys("anuj@gmail.com");
	 * //Select Device from Drop down. Select drpproductid= new Select
	 * (driver.findElement(By.name("data[Bug][product_id]")));
	 * drpproductid.selectByVisibleText("Buzz BU01"); //Select Product Category
	 * from Drop down. Select drpproductcat= new Select
	 * (driver.findElement(By.name("data[Bug][product_category]")));
	 * drpproductcat.selectByVisibleText("Software");
	 * driver.findElement(By.id("BugDescription")).
	 * sendKeys("Hello this is for testing");
	 * driver.findElement(By.id("BugBuildNumber")).sendKeys("A001");
	 * driver.findElement(By.id("BugHowOffen")).sendKeys("Daily");
	 * driver.findElement(By.id("BugHasOccured")).sendKeys("No"); WebElement
	 * Bugroot= driver.findElement(By.xpath(
	 * "//div[3]/div[3]/div/div[2]/div/div/div/div/form/div[2]/div[9]/div[1]/label"
	 * )); Bugroot.click(); // click the "Attachment" button
	 * driver.findElement(By.name("data[Bug][attachment]")).click();
	 * StringSelection ss = new
	 * StringSelection("C:\\Users\\Anuj Singh\\Desktop\\aa.txt");
	 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	 * 
	 * //imitate mouse events like ENTER, CTRL+C, CTRL+V Robot robot = new
	 * Robot(); robot.keyPress(KeyEvent.VK_ENTER);
	 * robot.keyRelease(KeyEvent.VK_ENTER); robot.keyPress(KeyEvent.VK_CONTROL);
	 * robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_V);
	 * robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_ENTER);
	 * robot.keyRelease(KeyEvent.VK_ENTER); Thread.sleep(3000);
	 * driver.findElement(By.xpath(
	 * "//div[3]/div[3]/div/div[2]/div/div/div/div/form/div[2]/div[11]/button"))
	 * .submit();
	 * 
	 * }
	 */

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}
