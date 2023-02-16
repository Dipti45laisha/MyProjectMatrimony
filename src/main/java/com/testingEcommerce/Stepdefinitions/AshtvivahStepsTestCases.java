package com.testingEcommerce.Stepdefinitions;

import org.testng.Assert;

import com.testingEcommerce.Keyword.Keyword;
import com.testingEcommerce.Utils.FileUtils;

import io.cucumber.java.en.Then;

public class AshtvivahStepsTestCases {
	
	@Then("User Click On Sign In button")
	public void clikonsigninbutton() throws InterruptedException {
		Keyword.clickOn("css", "a.btn-primary");
		// Keyword.clickOn(LocatorType.CSS,Locator.signin_btn);
	}

	@Then("User have to Send On Email")
	public void sendTextonemailAddress() throws InterruptedException {
		Thread.sleep(2000);
		Keyword.enterText("css","input[name=\"email\"]","sdgtbnv@givmail.com");
	}

	@Then("User have to send Password")
	public void sendTextonPassword() {
		Keyword.enterText("css","input[name=\"password\"]","detteshgjksfawrwe");
	}

	@Then("User have To click on Sign In button")
	public void clickOnSigninButton() throws InterruptedException {
		Thread.sleep(3000);
		Keyword.clickOn("css","button[type=\"submit\"]");
	}

	@Then("User should sign in to the Application Successfully")
	public void verifyTitleofhomePage() {	
	String ExpectedTitle = "आजच मोफत नोंदणी करा, आणि मना सारखे स्थळे बघायला सुरुवात करा.";
	String actualTitle = Keyword.driver.getTitle();
	Assert.assertEquals(actualTitle, ExpectedTitle);
	}

}
