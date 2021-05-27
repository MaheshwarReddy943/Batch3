package org.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	
	public void failed(String testMethodName){
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   try {
			FileUtils.copyFile(srcFile,new File("C:\\Users\\LENOVO\\eclipse-workspace\\Batch3\\Screenshots\\"+testMethodName+"_"+".jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		   
	}
}
