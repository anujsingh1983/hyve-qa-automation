package com.hyve.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class findElements {
	
	public static void main(String[] args)
	{
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.hyve.buzz/");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int linkCount=links.size();
		System.out.println("Number of Links present in this Web page = "+linkCount);
		if(linkCount>0)
		{
			for(WebElement link:links)
				System.out.println(link.getText());
		}
		
		driver.quit();
	}

}
