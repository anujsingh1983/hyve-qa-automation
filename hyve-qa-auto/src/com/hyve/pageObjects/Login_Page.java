package com.hyve.pageObjects;

import org.openqa.selenium.*;

public class Login_Page {
	
	private static WebElement element = null;
	 
    public static WebElement txtbx_UserName(WebDriver driver){
 
         element = driver.findElement(By.id("UserEmail"));
 
         return element;
 
         }
 
     public static WebElement txtbx_Password(WebDriver driver){
 
         element = driver.findElement(By.id("UserPassword"));
 
         return element;
 
         }
 
     public static WebElement btn_LogIn(WebDriver driver){
 
    	  element = driver.findElement(By.xpath("//button[@value='Log In']"));
    	 //element = driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/div[2]/div/div/form/div[3]/button"));
 
         return element;
 
         }
 

}
