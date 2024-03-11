package stepdefinitions;
import java.io.IOException;

import io.cucumber.java.en.*;
import testcases.UpcomingbikesTests;
import testcases.UsedcarsTests;
import testcases.GooglesigninTests;
import testcases.Basetest;         

public class Steps {
	
	UpcomingbikesTests ut = new UpcomingbikesTests();
	 UsedcarsTests uc = new UsedcarsTests();
	 Basetest bs = new Basetest();
	 GooglesigninTests gt = new GooglesigninTests();
	@Given("Launching the zigwheels website")
	public void launching_the_zigwheels_website() {
	    // Write code here that turns the phrase above into concrete actions
		
		bs.setup();
	    
	}

	@When("Selecting upcoming bikes from new bikes menu")
	public void selecting_upcoming_bikes_from_new_bikes_menu() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    
	    ut.newBikes();
	    ut.upcomingbikes();
	}

	@When("Selecting Honda in the manufacturer dropdown")
	public void selecting_honda_in_the_manufacturer_dropdown() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		 ut.manufacturer();
	}

	@Then("Printing all upcoming honda bikes under {int} Lakhs")
	public void printing_all_upcoming_honda_bikes_under_lakhs(Integer int1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		
		ut.viewmore();
		ut.hondabikemodels();
	}

	@When("Navigating back to homepage")
	public void navigating_back_to_homepage() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		
		ut.backhome();
	    
	}

	@Then("Selecting Chennai under the used cars menu")
	public void selecting_chennai_under_the_used_cars_menu() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
	   
	    uc.Menu();
	    uc.chennaiSubmenuOption();
	}

	@Then("Printing all the popular models")
	public void printing_all_the_popular_models() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		uc.models();
	    
	}
	
	@When("Again Navigating back to homepage")
	public void again_navigating_back_to_homepage () throws IOException, InterruptedException {
		
		uc.navigateback();
		
	}

	@Then("Clicking on Login button and selecting Google as login option")
	public void clicking_on_login_button_and_selecting_google_as_login_option() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		gt.clickSignIn();
		gt.clickGoogle();
		
	}

	@When("Entering an invalid email and clicking next")
	public void entering_an_invalid_email_and_clicking_next() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		gt.eMail();
		gt.nextButton();
	    
	}

	@Then("Printing the error message")
	public void printing_the_error_message() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		gt.printErrorMesssage();
		
	    
	}
	@Then("Closing the browser")
	public void closing_the_browser() {
		bs.teardown();
	}




}
