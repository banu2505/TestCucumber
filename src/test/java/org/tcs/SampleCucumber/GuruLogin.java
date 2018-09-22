package org.tcs.SampleCucumber;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GuruLogin {
	WebDriver driver;
	@Given("^The user is in Guru home page$")
	public void the_user_is_in_Guru_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\CHANDRASEKAR\\eclipse-workspace\\BP\\Selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/v4/");
	}

	@When("^The user enters user id and password$")
	public void the_user_enters_user_id_and_password(DataTable credentials) {
		List<Map<String,String>> credentialsMaps = credentials.asMaps(String.class, String.class);
		driver.findElement(By.name("uid")).sendKeys(credentialsMaps.get(1).get("username"));
		driver.findElement(By.name("password")).sendKeys(credentialsMaps.get(1).get("password"));
	}

	@When("^The user clicks reset button$")
	public void the_user_clicks_reset_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("btnReset")).click();
	}

	@Then("^The user should see the fields cleared$")
	public void the_user_should_see_the_fields_cleared(){
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("",driver.findElement(By.name("uid")).getAttribute("Value"));
		Assert.assertEquals("",driver.findElement(By.name("password")).getAttribute("Value"));
	}

}
