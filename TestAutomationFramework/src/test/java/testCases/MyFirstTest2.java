package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.openqa.selenium.OutputType;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import base.BaseTest;
import pages.LoginPage;

public class MyFirstTest2 extends BaseTest {

	@Test
	public static void loginTest1() throws InterruptedException, IOException {

		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

		LoginPage lp = new LoginPage(driver);

		lp.clickSignInLink();
		lp.setEmailId("sandeep.bhutkar@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

		File TakesScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(TakesScreenshot, new File(
				"C:\\Users\\sbhutkar\\eclipse-workspace\\SeleniumAutomationFramework\\TestAutomationFramework\\src\\test\\resources\\Screenshots\\screen1.png"));

		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[3]/div[2]/form[1]/div[2]/div[2]/div[2]/input"))
				.sendKeys("aikon58n");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[3]/div[2]/form[1]/button/span")).click();
		Thread.sleep(2000);

	}

	@Test
	public static void loginTest2() throws InterruptedException, IOException {

		ExtentTest test = extent.createTest("MySecondTest", "Sample description");

		LoginPage lp = new LoginPage(driver);

		lp.clickSignInLink();
		lp.setEmailId("sandeep.bhutkar@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

		File TakesScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(TakesScreenshot, new File(
				"C:\\Users\\sbhutkar\\eclipse-workspace\\SeleniumAutomationFramework\\TestAutomationFramework\\src\\test\\resources\\Screenshots\\screen1.png"));

		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");

		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[3]/div[2]/form[1]/div[2]/div[2]/div[2]/input"))
				.sendKeys("aikon58n");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[3]/div[2]/form[1]/button/span")).click();
		Thread.sleep(2000);
	}
}
