package org.stepdefinition;

import org.baseclass.BaseClas;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition_ extends BaseClas{

	@Given("user launch that url and is go on to login page")
	public void user_launch_that_url_and_is_go_on_to_login_page() {
		browserLaunch("chrome");
	    urlLaunch("https://www.saucedemo.com/");
	    maximize();
	}
	
	@When("User enter the {string} in username field")
	public void user_enter_the_in_username_field(String user) {
	    driver.findElement(By.xpath("//*[@id=\'user-name\']")).sendKeys(user);
	    
	}
	
	@When("User enter the {string} in password field")
	public void user_enter_the_in_password_field(String pass) {
	    WebElement passw = driver.findElement(By.id("password"));
	    passw.sendKeys(pass);
	}
	
	@Then("User click the login button and  it goes to search hotel page if give only valid username and password")
	public void user_click_the_login_button_and_it_goes_to_search_hotel_page_if_give_only_valid_username_and_password() {
	    driver.findElement(By.xpath("//*[@id=\'login-button\']")).click();
	}





	
}

	