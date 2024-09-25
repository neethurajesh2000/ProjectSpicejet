package com.demo.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class checkinstepdefinitions {
	private  WebDriver driver;
	@Given("user is at checkinhome page")
	public void user_is_at_checkinhome_page() {
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

	@When("user click on check in button")
	public void user_click_on_check_in_button() throws InterruptedException {
		WebElement checkin=driver.findElement(By.xpath("//div[text()='check-in']"));
		 checkin.click();
		 Thread.sleep(2000);
		 String checkintittle=driver.getTitle();
		 System.out.println(checkintittle);	
		 driver.close();
	   	}



}
