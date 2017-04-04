package com.hyve.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productHyve {
	private static WebElement element = null;
	
	public static WebElement pryme(WebDriver driver){
		element = driver.findElement(By.xpath("//a[@href='/pryme']"));
		return element;
	}
	public static WebElement buzz(WebDriver driver){
		element = driver.findElement(By.xpath("//a[@href='/buzz']"));
		return element;
	}
	public static WebElement storm(WebDriver driver){
		element = driver.findElement(By.xpath("//a[@href='/storm']"));
		return element;
	}
	
	public static WebElement Buy_pryme(WebDriver driver){
		element = driver.findElement(By.xpath("//a[@id='149']"));
		return element;
	}
	public static WebElement Buy_buzz(WebDriver driver){
		element = driver.findElement(By.xpath("//a[@id='2']"));
		return element;
	}
	public static WebElement Buy_storm(WebDriver driver){
		element = driver.findElement(By.xpath("//a[@id='1']"));
		return element;
	}

}
