package com.hyve.priceVerification;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.hyve.pageObjects.Home_Page;

import com.hyve.pageObjects.Login_Page;
import com.hyve.pageObjects.productHyve;
import com.hyve.utility.ExcelUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPriceVerification {

	public static void Execute(WebDriver driver) throws Exception {

		// This is to get the values from Excel sheet, passing parameters (Row
		// num &amp; Col num)to getCellData method

		String sUserName = ExcelUtils.getCellData(1, 1);

		String sPassword = ExcelUtils.getCellData(1, 2);

		Home_Page.lnk_Login(driver).click();

		Login_Page.txtbx_UserName(driver).sendKeys(sUserName);

		Login_Page.txtbx_Password(driver).sendKeys(sPassword);

		Thread.sleep(3000);

		Login_Page.btn_LogIn(driver).submit();

		Thread.sleep(5000);
			
		//Home_Page.lnk_LogOut(driver).click();

	}

}
