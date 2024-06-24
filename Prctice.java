package JustPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prctice {

	WebDriver driver;

	@BeforeMethod
	public void SetUp() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void First() {

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}

	@AfterMethod
	public void TearDown() {

		driver.close();
	}

}
