package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Chrome {

	WebDriver driver;

	@BeforeTest
	public void launch() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

	}

	@Test
	public void open() throws InterruptedException {

		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		driver.findElement(By.id("male")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-check-input'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[6]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='custom-file']")).click();
	}

	@Test(invocationCount = 1)
	public void w() throws InterruptedException {
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[6]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='custom-file']")).click();
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
