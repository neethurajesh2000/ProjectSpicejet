package com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flightstatusstepdefinitions {
	private  WebDriver driver;
	@Given("user is at statushome page")
	public void user_is_at_statushome_page() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();//launching driver
		//implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		//maximize window
		driver.manage().window().maximize();
		driver.navigate().to("https://www.spicejet.com/");		
		//delete cookies
		driver.manage().deleteAllCookies();
	}

	@Given("user click the flight status button")
	public void user_click_the_flight_status_button() throws InterruptedException {
		WebElement status=driver.findElement(By.xpath("//div[text()='flight status']"));
		 status.click();
		 Thread.sleep(2000);
		 String statustittle=driver.getTitle();
		 System.out.println(statustittle);	
		 driver.close();
	}



}
