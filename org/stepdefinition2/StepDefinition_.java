package org.stepdefinition2;

import org.baseclass.BaseClas;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition_ extends BaseClas{

	@Given("User launch the Url")
	public void user_launch_the_url() {
		browserLaunch("chrome");
		urlLaunch("https://www.amazon.in");
		maximize();
	}

	@When("USer click the Signin button and goes to signin page")
	public void u_ser_click_the_signin_button_and_goes_to_signin_page() {
		driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click();
	}


	@When("User enter the {string} in field")
	public void user_enter_the_in_field(String numormail) {
		driver.findElement(By.name("email")).sendKeys(numormail);
	}


	@When("User click continue")
	public void user_click_continue() {
		driver.findElement(By.id("continue")).click();
	}


	@When("User enter the {string} in fieldd")
	public void user_enter_the_in_fieldd(String password) {

		driver.findElement(By.name("password")).sendKeys(password);

	}

	@When("User click the again continue button to login and It goes to home page")
	public void user_click_the_again_continue_button_to_login_and_it_goes_to_home_page() {
		driver.findElement(By.id("signInSubmit")).click();

	}


	@When("User enter the {string} in search field")
	public void user_enter_the_in_search_field(String mobiles) {

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(mobiles);
	}


	@Then("User click the search button and It goes to its Display page")
	public void user_click_the_search_button_and_it_goes_to_its_display_page() {

		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}


}

