package Playtech_Internship_check_Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CheckInternship {

	public static void main(String[] args) {
		
		//Get Chrome driver location.
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Taavi\\Downloads\\Selenium project files\\chromedriver_win32\\chromedriver.exe");
		
		
		//Set Chrome options to enable control by 3rd party applications.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//Launch Chrome in a maximized window.
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		//URL to direct Chrome to.
		driver.get("https://www.playtech.ee");
		
		//Find the "Internship" tab on the playtech.ee website and click it.
		WebElement internship = driver.findElement(By.xpath("//a[contains(text(), 'Internship')]"));
		internship.isDisplayed();
		internship.isEnabled();
		internship.click();
		
		//Search for "Development QA Engineer (Intern)" position on the Internship page. If found confirm existence, else deny existence.
		boolean development = driver.getPageSource().contains("Development QA Engineer (Intern)");
		if (development) {
			System.out.println("The position is shown on the page!");
		} else {
			System.out.println("The position is not shown on the page!");
		}
		
		//Close Chrome.
		driver.quit();

	}

}
