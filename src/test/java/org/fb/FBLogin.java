package org.fb;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class FBLogin {

	WebDriver driver;

	@Given("^The user is in facebook home page$")
	public void the_user_is_in_facebook_home_page(DataTable url) throws Throwable {
		Map<String, String> urlMap = url.asMap(String.class, String.class);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\CHANDRASEKAR\\eclipse-workspace\\BP\\Selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(urlMap.get("url"));
		driver.manage().window().maximize();
	}

	@When("^The user enters username and password$")
	public void the_user_enters_username_and_password(DataTable credentials) throws Throwable {
		List<Map<String, String>> credentialMaps = credentials.asMaps(String.class,String.class);
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys(credentialMaps.get(0).get("email"));
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys(credentialMaps.get(0).get("password"));
	}

	@When("^The user clicks login button$")
	public void the_user_clicks_login_button() throws Throwable {
		WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
		btnLogin.click();
	}

	@Then("^The user should see an error in a new page$")
	public void the_user_should_see_an_error_in_a_new_page() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'_53ij')]")).getText());
	
	
	}

}
