package com.hyve.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {
	public static String captureScreenshot(WebDriver driver, String screenshotName)
	{
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			 File source=ts.getScreenshotAs(OutputType.FILE);
			 
			 String dest="F:\\Automation\\git-codebase\\hyve-qa-automation\\hyve-qa-auto\\Screenshots\\"+screenshotName+".png";
			 
			 File destination=new File(dest);
			 
			 FileUtils.copyFile(source, destination);
			 
			 System.out.println("Screenshot Taken");
			 
			 return dest;
		} 
		
		catch (Exception e)
		{
			System.out.println("Exception While Taking Screenshot"+e.getMessage());
			return e.getMessage();
			
		} 
		
		
	}

}
