package com.hyve.crossBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class verifyTitle {
	
	WebDriver driver;
	@Test
	@Parameters("browser")
	public void verifypageTitle(String browserName) throws InterruptedException{
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Anuj Singh\\Softwares\\selenium-java-2.53.1\\selenium-2.53.1\\Other Jars\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\Anuj Singh\\Softwares\\selenium-java-2.53.1\\selenium-2.53.1\\Other Jars\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.hyve.buzz/");
		Thread.sleep(5000);
		System.out.println(browserName);
		System.out.println(driver.getTitle());
		driver.quit();
		
	}
	
	
	

}
