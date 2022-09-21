package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static FileReader fr;
	public static Properties pr = new Properties();
	
	public static ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	
	
	
    @BeforeMethod
	public void setUp() throws IOException {
    	
    	htmlReporter = new ExtentHtmlReporter("C:\\Users\\sbhutkar\\eclipse-workspace\\SeleniumAutomationFramework\\TestAutomationFramework\\src\\test\\resources\\reports\\extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		if (driver==null) {
			fr = new FileReader("C:\\Users\\sbhutkar\\eclipse-workspace\\SeleniumAutomationFramework\\TestAutomationFramework\\src\\test\\resources\\configFiles\\config.properties");
			pr.load(fr);
		}
		
		if(pr.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(pr.getProperty("testurl"));
		}
		else if(pr.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(pr.getProperty("testurl"));
		}

	}
	
    @AfterMethod
	public void tearDown() {
    	extent.flush();
    	driver.close();
		
	}

}