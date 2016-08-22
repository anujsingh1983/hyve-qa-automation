package com.hyve.automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.hyve.pageObjects.Home_Page;

import com.hyve.pageObjects.Login_Page;

public class PageObjectModel {
	
	private static WebDriver driver = null;
	 
	   public static void main(String[] args) {
	 
	     driver = new FirefoxDriver();
	 
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	     driver.get("https://www.hyve.buzz/");
	 
	     // Use page Object library now
	 
	     Home_Page.lnk_Login(driver).click();
	 
	     Login_Page.txtbx_UserName(driver).sendKeys("anuj.singh@hyve.buzz");
	 
	     Login_Page.txtbx_Password(driver).sendKeys("1234567");
	 
	     Login_Page.btn_LogIn(driver).submit();
	 
	     System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
	 
	     //Home_Page.lnk_LogOut(driver).click(); 
	 
	     //driver.quit();
	 
	     }

}
