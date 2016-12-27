package com.hyve.pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Home_Page {
	
	private static WebElement element = null;
	 
	 public static WebElement lnk_Login(WebDriver driver){
	 
	    element = driver.findElement(By.className("logout-header"));
	    //element = driver.findElement(By.xpath("//div[2]/div[1]/div/div/div/div/div[3]/div/div/div[1]/a[2]"));
	 
	    return element;
	 
	    }
	 
	 public static WebElement lnk_LogOut(WebDriver driver){
	 
		// element = driver.findElement(By.xpath("//a[@class='logout-header']"));
		// element = driver.findElement(By.className("logout-header"));
	  element = driver.findElement(By.xpath("//div[2]/div/div/div[1]/div/div/div[3]/div/div/div[1]/a[2]"));
	 
	 return element;
	 
	    }

}
