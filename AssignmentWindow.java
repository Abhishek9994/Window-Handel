package JustPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentWindow {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void Window() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();

		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> it = Windows.iterator();
		String ParatID = it.next();
		String ChildID = it.next();

		driver.switchTo().window(ChildID);

		System.out.println(driver.findElement(By.xpath("//div[@class='example']")).getText());

		driver.switchTo().window(ParatID);

		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
