package com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginstepdefinitions {
	private  WebDriver driver;
	@Given("user is at home page")
	public void user_is_at_home_page() {
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

	@When("user click on the login button")
	public void user_click_on_the_login_button() {
		WebElement loginbutton=driver.findElement(By.xpath("//div[text()='Login']"));
		loginbutton.click();
	}

	@When("user enters the mobile number")
	public void user_enters_the_mobile_number() {
		WebElement loginmobile =driver.findElement(By.xpath("//input[@data-testid='user-mobileno-input-box']"));
		loginmobile.sendKeys("6282215068");
	}

	@When("user enter password")
	public void user_enter_password() {
		WebElement loginpassword =driver.findElement(By.xpath("//input[@type='password']"));
		loginpassword.sendKeys("Raj@1234");
	}

	@Then("user click on login button for signin")
	public void user_click_on_login_button_for_signin() throws InterruptedException {
		WebElement loginbutton1=driver.findElement(By.xpath("//div[@data-testid=\"login-cta\"]"));
		loginbutton1.click();	
		Thread.sleep(2000);	
		driver.close();
	}
}
