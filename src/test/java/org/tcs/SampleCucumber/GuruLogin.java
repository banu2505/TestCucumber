package org.tcs.SampleCucumber;

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

	@Given("^The user logged in as manager$")
	public void the_user_logged_in_as_manager(DataTable credentials) throws Throwable {
		List<Map<String, String>> credentialMaps = credentials.asMaps(String.class, String.class);
		driver.findElement(By.name("uid")).sendKeys(credentialMaps.get(0).get("mngrid"));
		driver.findElement(By.name("password")).sendKeys(credentialMaps.get(0).get("mngrpass"));
		driver.findElement(By.name("btnLogin")).click();
	}

	@Given("^The user navigates to new customer page$")
	public void the_user_navigates_to_new_customer_page() throws Throwable {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();	
	}

	@When("^The user enters the customer details with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void the_user_enters_the_customer_details_with(String custname, String gender, String dob, String address, String city, String state, String pin, String phno, String email, String pass) throws Throwable {
		driver.findElement(By.name("name")).sendKeys(custname);
		if(gender.equals("male")) {
		driver.findElement(By.xpath("//input[@type='radio' and @value='m']")).click();
		} else if(gender.equals("female")) {
			driver.findElement(By.xpath("//input[@type='radio' and @value='f']")).click();
		}
		driver.findElement(By.name("dob")).sendKeys(dob);
		driver.findElement(By.name("addr")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("pinno")).sendKeys(pin);
		driver.findElement(By.name("telephoneno")).sendKeys(phno);
		driver.findElement(By.name("emailid")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pass);
		
	}

	@When("^The user submits the form$")
	public void the_user_submits_the_form() throws Throwable {
		driver.findElement(By.name("sub")).click();
	
	}

	@Then("^The user should see the success message$")
	public void the_user_should_see_the_success_message() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains("Customer"));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Registered')]")).getText().contains("Successfully"));
		List<WebElement> tRows= driver.findElements(By.tagName("tr"));
		String custID = tRows.get(4).getText();
		System.out.println(custID);
		//for (WebElement rows:tRows) {
			//List<WebElement> tData=driver.findElements(By.tagName("td"));
			//if (t)
			
		//}
	}
	


}
