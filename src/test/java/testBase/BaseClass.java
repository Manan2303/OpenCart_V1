package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // log file
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties pr;



	@SuppressWarnings("deprecation")
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os","browser","url"})

	public void setup(String os, String br,String URL) throws IOException {

		//		for loading config file  
		FileReader file = new FileReader("C:\\Users\\sriva\\eclipse-workspace\\OpenCart_V1\\src\\test\\resources\\config.properties");//path where config file is placed.
		pr= new Properties();
		pr.load(file);
		//for access log
		logger = LogManager.getLogger(this.getClass());
		
		
		//********************************************************************
		
		// Selenium Grid for Cross browser testing 

		// if we use selenium grid for parallel testing
		
		if(pr.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities= new DesiredCapabilities();


			// OS  comes from xml file which is declared in setup method

			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("Mac")) {				
				capabilities.setPlatform(Platform.MAC);

			}
			else {
				System.out.println("No matching for Operating system");
				return;
			}


			// Browser
			switch(br.toLowerCase()) {
			case "chrome": 
				capabilities.setBrowserName("chrome"); 
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;

			default:
				System.out.println("Browser Not match");
				return;
			}
			
			driver = new RemoteWebDriver(new URL("http://192.168.23.34:4444/wd/hub"),capabilities);  // call remote webdrive only in case of selenium grid or remote testing


		}
		// end of if in remote access using selenium grid

		//--------------------------------------------------------------------
		//if user local system

		if(pr.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase()) {
			case "chrome": 
				driver = new ChromeDriver();
				break;

			case "edge": 
				driver=new EdgeDriver();
				break;

			case "firefox": 
				driver=new FirefoxDriver();
				break;

			default:
				System.out.println("Invalid Choice");
				return;
			}

		}

		//-----------------------------------------------------------------------------


		//********************************************************************

		// Code before using selenium grid 

		//		switch(br.toLowerCase()) {
		//		case "chrome": driver = new ChromeDriver(); break;
		//		case "edge": driver=new EdgeDriver();break;
		//		case "firefox": driver=new FirefoxDriver();break;
		//		default:
		//			System.out.println("Invalid Choice");
		//			return;
		//		}

		// **************************************************************************


		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//by using parameter concept through xml.
		driver.get(URL);
		//driver.get(pr.getProperty("appURL")); // reading url through properties file
		driver.manage().window().maximize();
	}
	
	@AfterClass (groups = {"Sanity","Regression","Master","dataDriven"})
	public void teardown() {
		driver.close();
	}
	
	
	
	
	// ***************************************************************
	 // Generate random string or number 
	
	public String randomString() {

		String randomSting =  RandomStringUtils.randomAlphabetic(5);
		return randomSting;
	}

	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);

		return (str+"@"+num);
	}
//       *************************************************************************
	
	
	// Capturing screen shot of failure test case and display in extent report 
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath; 
		
		// return the scrrenshot in report .
		//If we not use return statement we can capturing the screenshot but not place the screenshot.
//      *******************************************************************************************************************************************************************
	}



}
