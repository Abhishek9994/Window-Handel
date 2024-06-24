package JustPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	WebDriver driver;

	@BeforeMethod
	public void SetUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

	}

	@Test
	public void dropdown() throws InterruptedException {

		/*
		 * WebElement drop =
		 * driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); Select
		 * sel = new Select(drop); sel.selectByIndex(3);
		 * System.out.println(sel.getFirstSelectedOption().getText());
		 * sel.selectByVisibleText("AED");
		 * System.out.println(sel.getFirstSelectedOption().getText());
		 * sel.selectByValue("INR");
		 * System.out.println(sel.getFirstSelectedOption().getText());
		 */

		// For auto suggestion dropdowns

		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(2000);
		List<WebElement> Options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement Option : Options) {
			if (Option.getText().equalsIgnoreCase("India")) {
				Option.click();
				break;
			}

		}

	}

}
