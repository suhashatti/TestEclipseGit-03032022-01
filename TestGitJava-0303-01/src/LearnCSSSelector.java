package com.learncssselector;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnCSSSelector {

	public class LearnTakeScreenShot {

		public WebDriver driver;
		String url = "";
		String verificationError = "";

		@Before
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			url = "http://demo.automationtesting.in/Index.html";
		}

		public void testCSSCode() {
			try {
				driver.get(url);
				driver.findElement(By.cssSelector(".form-control ng-untouched ng-invalid ng-invalid-required"))
						.sendKeys("suhas");

				driver.findElement(By.cssSelector("input [placeholder='First Name']")).sendKeys("suhas");

				driver.findElement(By.cssSelector("input [placeholder='Last Name'][type'Text']")).sendKeys("hatti");
				
				
				WebElement years = driver.findElement(By.id("yearbox"));
				years.findElement(By.xpath("//option[text()='1983']")).click();
				System.out.println("Year is selected");
				
				//select the year 2022
//				for(WebElement optionValue = optionValues);
//						if(optionValue )


			} catch (Exception ex) {
				verificationError = ex.getMessage();
				System.out.println("verification Error");
			}
		}
	
	@After
	public void tierdown() {
		driver.quit();
		if (!verificationError.equals("")) {
			Assert.fail();
		}
	}
}
}
