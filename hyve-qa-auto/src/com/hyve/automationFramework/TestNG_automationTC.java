package com.hyve.automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.hyve.pageObjects.Home_Page;
import com.hyve.pageObjects.productHyve;
import com.hyve.utility.Constant;

import com.hyve.utility.ExcelUtils;
import com.hyve.utility.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.hyve.appModules.SignIn_Action;

public class TestNG_automationTC {

	ExtentReports report;
	ExtentTest logger;

	private static WebDriver driver = null;

	// public static void main(String[] args) throws Exception {

	// This is to open the Excel file. Excel path, file name and the sheet name
	// are parameters to this method
	@Test(priority = 1)
	public void testLogin() throws Exception {

		report = new ExtentReports(
				"F:\\Automation\\git-codebase\\hyve-qa-automation\\hyve-qa-auto\\Automation_Report.html");
		logger = report.startTest("testLogin");

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		logger.log(LogStatus.INFO, " Browser up and Running ");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(Constant.URL);

		SignIn_Action.Execute(driver);

		String expected = "Anuj";
		String actualtext = driver.findElement(By.className("username_name")).getText();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertEquals(actualtext, expected);
		logger.log(LogStatus.PASS, " Login Successfully and User Verified ");

		System.out.println("Login Successfully and User Verified, now it is the time to Add Product buddy.");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.findElement(By.className("logout-header")).click();

	}

	@Test(priority = 2)
	public void testCart() throws InterruptedException {
		logger = report.startTest("testCart");
		driver.get(Constant.URL);
		logger.log(LogStatus.INFO, " Browser up and go to Pryme Page ");
		driver.findElement(By.xpath("//a[@href='/pryme']")).click();
		productHyve.Buy_pryme(driver).click();
		logger.log(LogStatus.INFO, " Add Pryme into Cart Successfully");

		// driver.findElement(By.xpath("//div[2]/div[1]/div/div/div[2]/div[1]/ul/li[11]/a")).click();

		String subtotal = driver.findElement(By.xpath("//*[@id='CartForm']/table/tbody/tr/td[4]/div")).getText();
		System.out.println("subtotal = " + subtotal);

		String saleprice = driver.findElement(By.xpath("//*[@id='CartForm']/table/tbody/tr/td[3]/div")).getText();
		System.out.println("Sale Price = " + saleprice);

		String quantity = driver.findElement(By.xpath("//*[contains(@name,'qty')]")).getAttribute("value");
		System.out.println("Quantity = " + quantity);

		double isubtotal = Double.parseDouble(subtotal.replaceAll("[^0-9\\.]+", ""));
		// System.out.println("isubtotal is "+isubtotal);
		double isaleprice = Double.parseDouble(saleprice.replaceAll("[^0-9\\.]+", ""));
		// System.out.println("isaleprice is "+isaleprice);
		int iquantity = Integer.parseInt(quantity);
		double expectedsubtotal = (isaleprice * iquantity);
		System.out.println("Expected Subtotal is " + expectedsubtotal);
		Assert.assertEquals(isubtotal, expectedsubtotal);
		System.out.println("Great.. Subtotal is correct");
		logger.log(LogStatus.PASS, " Added Product quantity and price verified Successfully");
		WebElement img_pryme = driver.findElement(By.xpath("//img[contains(@title,'Pryme')]"));
		Boolean img_present = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",img_pryme);
		if (!img_present) {
			System.out.println("Added Product Image not displayed.");
		} else {
			System.out.println("Added Product Image displayed.");
		}
		logger.log(LogStatus.PASS, " Added Product Image verified Successfully");
	
	Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void testLogout() throws Exception {

		logger = report.startTest("testLogout");

		Home_Page.lnk_LogOut(driver).click();

		logger.log(LogStatus.INFO, " Logout Successfully ");

		// This is to send the PASS value to the Excel sheet in the result
		// column.

		ExcelUtils.setCellData("Pass", 1, 3);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshot_path = Utility.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, " Login Fail ", image);
		}
		report.endTest(logger);
		report.flush();
		// driver.get("F:\\Automation\\git-codebase\\hyve-qa-automation\\hyve-qa-auto\\Automation_Report.html");
		// driver.quit();
	}

}
