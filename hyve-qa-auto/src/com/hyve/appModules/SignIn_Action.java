package com.hyve.appModules;

import org.openqa.selenium.WebDriver;

import com.hyve.pageObjects.Home_Page;

import com.hyve.pageObjects.Login_Page;

import com.hyve.utility.ExcelUtils;

public class SignIn_Action {
	
	public static void Execute(WebDriver driver) throws Exception{
		 
		//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method

		String sUserName = ExcelUtils.getCellData(1, 1);

		String sPassword = ExcelUtils.getCellData(1, 2);

		Home_Page.lnk_Login(driver).click();

		Login_Page.txtbx_UserName(driver).sendKeys(sUserName);

		Login_Page.txtbx_Password(driver).sendKeys(sPassword);

		Login_Page.btn_LogIn(driver).click();

    }


}
