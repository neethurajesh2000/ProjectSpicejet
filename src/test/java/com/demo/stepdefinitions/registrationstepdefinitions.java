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

public class registrationstepdefinitions {
	private  WebDriver driver;
	@Given("user is at websitehome page")
	public void user_is_at_websitehome_page() {
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

	@When("user click on the signup button")
	public void user_click_on_the_signup_button() throws InterruptedException {
		 WebElement signupbutton=driver.findElement(By.xpath("//div[contains(text(),'Signup')]"));
	     signupbutton.click();
	     Thread.sleep(2000);
	     Set<String> windowhandles= driver.getWindowHandles();
		 List<String> listwindows=new ArrayList<>(windowhandles);
		 driver.switchTo().window(listwindows.get(1));
	}

	@When("user select the element")
	public void user_select_the_element() throws InterruptedException {
		WebElement selectelement=driver.findElement(By.xpath("(//select[contains(@class,'form-control form-select')])[1]"));
		 Select select=new Select(selectelement);
		 select.selectByIndex(2);
		 Thread.sleep(1000);
	}

	@When("user enters the first name")
	public void user_enters_the_first_name() {
		 WebElement firstname=driver.findElement(By.id("first_name"));
		 firstname.sendKeys("maya");
	}

	@When("user enter the last name")
	public void user_enter_the_last_name() {
		 WebElement lastname=driver.findElement(By.id("last_name"));
		 lastname.sendKeys("maya");
	}

	@When("user select country")
	public void user_select_country() throws InterruptedException {
		 WebElement selectelement1=driver.findElement(By.xpath("//select[@class='form-control form-select']"));
		 Select select1=new Select(selectelement1);
		 select1.selectByVisibleText("India");
		 Thread.sleep(1000);
	}

	@When("user enter the date of birth")
	public void user_enter_the_date_of_birth() throws InterruptedException {
		 driver.findElement(By.id("dobDate")).click();			 
		  WebElement selectelement2=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		  Select select2=new Select(selectelement2);
		  select2.selectByIndex(3);
		  Thread.sleep(1000);
		  WebElement selectelement3=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		  Select select3=new Select(selectelement3);
		  select3.selectByIndex(5);
		  Thread.sleep(1000);		 
		  driver.findElement(By.xpath("//div[text()='6']")).click();
	}

	@When("user enter the mobile number")
	public void user_enter_the_mobile_number() throws InterruptedException {
		JavascriptExecutor js1= (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		WebElement mobilenumber=driver.findElement(By.xpath("//input[@placeholder='+91 01234 56789']"));
		mobilenumber.sendKeys("6282215068");
	}

	@When("user enter the email")
	public void user_enter_the_email() {
		WebElement email=driver.findElement(By.id("email_id"));
		email.sendKeys("maya@gmail.com");
	}

	@When("user enter the password and confirm password")
	public void user_enter_the_password_and_confirm_password() {
		WebElement password=driver.findElement(By.id("new-password"));
		password.sendKeys("maya123567");
		WebElement confirmpassword=driver.findElement(By.id("c-password"));
		confirmpassword.sendKeys("maya123567");
	}

	@When("user click on the conditions")
	public void user_click_on_the_conditions() {
		WebElement conditions=driver.findElement(By.id("defaultCheck1"));
		conditions.click();
	}

	@Then("user click on the submit button")
	public void user_click_on_the_submit_button() throws InterruptedException {
		WebElement submitbutton=driver.findElement(By.xpath("//button[text()='Submit']"));
		  submitbutton.click();
		  Thread.sleep(2000);		  
		  driver.navigate().back();
		  driver.close();
	}
}
