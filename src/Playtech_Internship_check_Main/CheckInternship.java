package Playtech_Internship_check_Main;

import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CheckInternship {		
		WebDriver driver;
		@Before
		public void initialization() {
			//Get Chrome driver location.
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver","Chrome_Driver\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://www.playtech.ee");
		
			//Find the "Internship" tab on the playtech.ee website and click it.
			WebElement internship = driver.findElement(By.xpath("//a[contains(text(), 'Internship')]"));
			int x = internship.getLocation().x;
			int y = internship.getLocation().y;
			int width = internship.getSize().getWidth();
		    Actions act = new Actions(driver);
		    act.moveByOffset(x+width/2, y).click().perform();		
		}
		
		@Test
		public void checkInternship() {
			//Search for "Development QA Engineer (Intern)" position on the Internship page. If found confirm existence, else deny existence.
			boolean development = driver.getPageSource().contains("Development QA Engineer (Intern)");
			try {
				if (development) {
					FileOutputStream result = new FileOutputStream("results\\result.txt");
					System.setOut(new PrintStream(result));
					System.out.println("The position is shown on the page!");
				} else {
					FileOutputStream result = new FileOutputStream("results\\result.txt");
					System.setOut(new PrintStream(result));
					System.out.println("The position is not shown on the page!");
				}
			} catch(FileNotFoundException e) {
				System.out.println(e);
			}
		}

		//Close browser.
		@After
		public void close() {
			driver.quit();
		}
	}
