package JustPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandel {

	WebDriver driver;

	@BeforeMethod
	public void SetUP() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();

	}

	@Test
	public void Window() {

		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();

		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		String paratID = it.next();
		String childID = it.next();

		driver.switchTo().window(childID);

		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];
		driver.switchTo().window(paratID);
		driver.findElement(By.id("username")).sendKeys(emailId);

	}

}
