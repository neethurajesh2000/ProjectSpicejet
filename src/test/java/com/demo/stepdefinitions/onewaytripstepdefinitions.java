package com.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
public class onewaytripstepdefinitions {
	private  WebDriver driver;
	@Given("user is at one way triphome page")
	public void user_is_at_one_way_triphome_page() {
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

	@Given("user select the destination")
	public void user_select_the_destination() {
		driver.findElement(By.xpath("//input[@value='Select Destination']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("(//div[text()='2'])[3]")).click();
	}

	@Given("user select the return date")
	public void user_select_the_return_date() {
		 driver.findElement(By.xpath("//div[text()='Return Date']")).click();
	     driver.findElement(By.xpath("(//div[text()='5'])[3]")).click();
	}

	@Given("user select the category senior citizen")
	public void user_select_the_category_senior_citizen() throws InterruptedException {
		 driver.findElement(By.xpath("//div[text()='Senior Citizen']")).click();
       Thread.sleep(2000);
	}

	@Then("user click the search flight button")
	public void user_click_the_search_flight_button() throws InterruptedException {
		Actions act=new Actions(driver);
		 WebElement search=driver.findElement(By.xpath("//div[text()='Search Flight']"));
		 act.moveToElement(search).click().perform();
		 Thread.sleep(2000);
		 driver.close();
	}
}
