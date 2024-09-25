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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class roundtripstepdefinitions {
	private  WebDriver driver;
	@Given("user is at round trip home page")
	public void user_is_at_round_trip_home_page() {
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

	@Given("user click on the round trip button")
	public void user_click_on_the_round_trip_button() {
		 WebElement roundway=driver.findElement(By.xpath("//div[text()='round trip']"));
		 roundway.click();
	}

	@Given("user select destination for round trip")
	public void user_select_destination_for_round_trip() {
		 driver.findElement(By.xpath("//input[@value='Select Destination']")).sendKeys("Bengaluru");
	     driver.findElement(By.xpath("(//div[text()='7'])[3]")).click();
	}

	@Given("user selec the return date for round trip")
	public void user_selec_the_return_date_for_round_trip() {
		driver.findElement(By.xpath("//div[text()='Return Date']")).click();
	    driver.findElement(By.xpath("(//div[text()='12'])[3]")).click();
	}

	@When("user select the category")
	public void user_select_the_category() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Senior Citizen']")).click();
       Thread.sleep(2000);
	}

	@Then("user click on the search flight button for round trip")
	public void user_click_on_the_search_flight_button_for_round_trip() {
		Actions act=new Actions(driver);
		 WebElement search=driver.findElement(By.xpath("//div[text()='Search Flight']"));
		 act.moveToElement(search).click().perform();	
		 driver.close();
	}



}
