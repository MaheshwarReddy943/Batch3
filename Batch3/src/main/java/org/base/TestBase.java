package org.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
public class TestBase {
	public static WebDriver driver;
	public static Properties prps;
	public static Logger Logger =null;
	public TestBase() {
		
			try {
				prps = new Properties();
				FileInputStream ip = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\Batch3\\src\\main\\java\\config\\prop.propertices");
				prps.load(ip);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}	
	}
	@BeforeTest
    public void loadLog4j() throws  FileNotFoundException,IOException
    {
        Properties prop_log = new Properties();
       
        FileInputStream log4 = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\Batch3\\src\\main\\resources\\log4j.properties");
        prop_log.load(log4);
       
        PropertyConfigurator.configure(prop_log);
    }
	
	public static void intialization() {
		String browserName=prps.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prps.getProperty("cpath"));
			driver = new ChromeDriver();	
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.Driver", prps.getProperty("fpath"));
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", prps.getProperty("epath"));
			driver=new EdgeDriver();
		}
		else {
			System.out.println("please enter the valid browser which you are using");
		}
		driver.get(prps.getProperty("url"));
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
