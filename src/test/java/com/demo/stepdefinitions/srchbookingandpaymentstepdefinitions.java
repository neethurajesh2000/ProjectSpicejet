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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class srchbookingandpaymentstepdefinitions {
	private  WebDriver driver;
	@Given("user is at bookinghome page")
	public void user_is_at_bookinghome_page() {
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

	@Given("user search flight")
	public void user_search_flight() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Select Destination']")).sendKeys("Bengaluru");
		 driver.findElement(By.xpath("(//div[text()='2'])[3]")).click();
		 driver.findElement(By.xpath("//div[text()='Return Date']")).click();
		 driver.findElement(By.xpath("(//div[text()='5'])[3]")).click();
		 driver.findElement(By.xpath("//div[text()='Senior Citizen']")).click();
         Thread.sleep(2000);
		 Actions act=new Actions(driver);
		 WebElement search=driver.findElement(By.xpath("//div[text()='Search Flight']"));
		 act.moveToElement(search).click().perform();
	}

	@Given("user click on the continue button")
	public void user_click_on_the_continue_button() throws InterruptedException {
		 WebElement continuebutton=driver.findElement(By.xpath("//div[@data-testid=\"continue-search-page-cta\"]"));
		 continuebutton.click();
		 Thread.sleep(2000);
	}

	@Given("user enters the bookingfirst name")
	public void user_enters_the_bookingfirst_name() {
		 WebElement bookingfirstname=driver.findElement(By.xpath("//input[@data-testid=\"first-inputbox-contact-details\"]"));
		 bookingfirstname.sendKeys("RAJESH");
	}

	@Given("user enters the bookinglast name")
	public void user_enters_the_bookinglast_name() {
		WebElement bookinglastname=driver.findElement(By.xpath("//input[@data-testid=\"last-inputbox-contact-details\"]"));
		 bookinglastname.sendKeys("THOMAS");
	}

	@Given("user enters phone no for booking")
	public void user_enters_phone_no_for_booking() {
		WebElement bookingphoneno=driver.findElement(By.xpath("//input[@data-testid=\"contact-number-input-box\"]"));
		bookingphoneno.sendKeys("6282215068");
	}

	@Given("user enters email and city for booking")
	public void user_enters_email_and_city_for_booking() throws InterruptedException {
		 WebElement bookingemail=driver.findElement(By.xpath("//input[@data-testid=\"emailAddress-inputbox-contact-details\"]"));
		 bookingemail.sendKeys("thomasphy@gmail.com");
		 WebElement bookingcity=driver.findElement(By.xpath("//input[@data-testid=\"city-inputbox-contact-details\"]"));
		 bookingcity.sendKeys("bangalore");
		 Thread.sleep(2000);
	}

	@Given("user enters name for primary customer")
	public void user_enters_name_for_primary_customer() {
		WebElement bookingpassengerfirstname=driver.findElement(By.xpath("//input[@data-testid=\"traveller-0-first-traveller-info-input-box\"]"));
		 bookingpassengerfirstname.sendKeys("RAJESH");
		 WebElement bookingpassengerlastname=driver.findElement(By.xpath("//input[@data-testid=\"traveller-0-last-traveller-info-input-box\"]"));
		 bookingpassengerlastname.sendKeys("THOMAS");
	}

	@Given("user enters phoneno and dob for primary customer")
	public void user_enters_phoneno_and_dob_for_primary_customer() throws InterruptedException {
		 WebElement bookingpassengerphoneno=driver.findElement(By.xpath("//input[@data-testid=\"traveller-0-last-traveller-info-input-box\"]"));
		 bookingpassengerphoneno.sendKeys("8590058537");
		 WebElement bookingpassengerDOB=driver.findElement(By.xpath("//input[@data-testid=\"traveller-0-date-of-birth-field\"]"));
		 driver.findElement(By.xpath("//div[text()='1963']")).click();
		 driver.findElement(By.xpath("//div[text()='May']")).click();
		 driver.findElement(By.xpath("//div[text()='27']")).click();		 
		 WebElement bookingcontinue=driver.findElement(By.xpath("//div[@data-testid=\"traveller-info-continue-cta\"]"));
		 bookingcontinue.click();
		 Thread.sleep(2000);
	}

	@Given("user select seat number")
	public void user_select_seat_number() throws InterruptedException {
		 WebElement addseat=driver.findElement(By.xpath("(//div[text()='Add'])[2]"));
		 addseat.click();
		 WebElement selectseatno=driver.findElement(By.xpath("(//div[text()='1A'])[1]"));
		 selectseatno.click();
		 Thread.sleep(2000);
	}

	@Given("user select meals")
	public void user_select_meals() throws InterruptedException {
		WebElement selectmeals=driver.findElement(By.xpath("//div[text()='Select Meals']"));
		 selectmeals.click();		 
		 WebElement meals=driver.findElement(By.xpath("//div[text()='Spinach, corn and cheese sandwich in marble bread']"));
		 meals.click();
		 WebElement done=driver.findElement(By.xpath("//div[text()='Done']"));
		 done.click();	
		 Thread.sleep(2000);
		 WebElement continuebutton2=driver.findElement(By.xpath("(//div[text()='Continue'])[2]"));
		 continuebutton2.click();
	}

	@Given("user enters the card number for payment")
	public void user_enters_the_card_number_for_payment() {
		WebElement cardFrame = driver.findElement(By.cssSelector("iframe[name='card_number_iframe_RPf488IhJzF1gkLP']"));
		// Switching to top frame
		driver.switchTo().frame(cardFrame);
		WebElement cardno=driver.findElement(By.id("card_number"));
		cardno.sendKeys("654389765");
		 driver.switchTo().defaultContent();
	}

	@Given("user enters the cardholder name for payment")
	public void user_enters_the_cardholder_name_for_payment() throws InterruptedException {
		 WebElement cardholderFrame = driver.findElement(By.cssSelector("iframe[name='name_on_card_iframe_iXEiTlPJ44E0OJ6l']"));
//			// Switching to top frame
			driver.switchTo().frame(cardholderFrame);
			WebElement cardholdername=driver.findElement(By.id("card_number"));
			cardholdername.sendKeys("rajesh");
			 driver.switchTo().defaultContent();
			 Thread.sleep(2000);
	}

	@Given("user enters the expiry month for payment")
	public void user_enters_the_expiry_month_for_payment() {
		WebElement expirymonthFrame = driver.findElement(By.cssSelector("iframe[name='card_exp_month_iframe_iXEiTlPJ44E0OJ6l']"));
//		// Switching to top frame
		driver.switchTo().frame(expirymonthFrame);
		WebElement expirymonth=driver.findElement(By.id("card_exp_month"));
		expirymonth.sendKeys("06");
		 driver.switchTo().defaultContent();
	}

	@Given("user enters the expiry year for payment")
	public void user_enters_the_expiry_year_for_payment() throws InterruptedException {
		 WebElement expiryyearFrame = driver.findElement(By.cssSelector("iframe[name='card_exp_year_iframe_iXEiTlPJ44E0OJ6l']"));
			// Switching to top frame
			driver.switchTo().frame(expiryyearFrame);
			WebElement expiryyear=driver.findElement(By.id("card_exp_year"));
			expiryyear.sendKeys("28");
			 driver.switchTo().defaultContent();
			 Thread.sleep(2000);
	}

	@When("user enters the security code for payment")
	public void user_enters_the_security_code_for_payment() {
		 WebElement securitycodeFrame = driver.findElement(By.cssSelector("iframe[name='card_exp_year_iframe_iXEiTlPJ44E0OJ6l']"));
			// Switching to top frame
			driver.switchTo().frame(securitycodeFrame);
			WebElement securitycode=driver.findElement(By.id("security_code"));
			securitycode.sendKeys("123");
			 driver.switchTo().defaultContent();
	}

	@Then("user click on the payment button")
	public void user_click_on_the_payment_button() {
		 WebElement proceedtopay=driver.findElement(By.xpath("//div[text()='Proceed to pay']"));
		 proceedtopay.click();	
		 driver.close();
	}



}
