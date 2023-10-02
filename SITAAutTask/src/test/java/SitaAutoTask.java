package test.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.base.TestBase;
import main.java.pages.ExploreCountryPage;
import main.java.pages.HomePage;
import main.java.pages.ReservationPage;
import main.java.utils.MyUtils;

public class SitaAutoTask extends TestBase {
	HomePage homePage=new HomePage();
	ExploreCountryPage exploreCountryPage=new ExploreCountryPage();
	ReservationPage reservationPage=new ReservationPage();
	
	
	
	@Test(priority=1)
	public void exploreCaribbean() {
		//Click the button "Explore More" against Caribbean on Home page
		homePage.get_CaribbeanExploreMore_Btn().click();
		
		//Verify if user is navigated to Explore Caribbean Page
		String actualPageHeading=exploreCountryPage.get_pageHeading().getText();
		Assert.assertEquals(actualPageHeading, "Welcome To Caribbean","Not on Explore Caribbean Page");
	}
	
	@Test(priority=2)
	public void reserveKingston() {
		//Click the button "Make a Reservation" for Kingston
		exploreCountryPage.get_makeReservationKingston_Btn().click();
		
		//Verify if user is navigated to Make Reservation Page
		String actualPageHeading=reservationPage.get_pageHeading().getText();
		Assert.assertEquals(actualPageHeading, "Make Your Reservation","Not on Reservation Page");
	}
	
	@Test(priority=3)
	@Parameters({"name","phone","numOfGuests","destination"})
	public void makeReservation(String name,String phone,String numOfGuests,String destination) {
		//Enter Reservation form data
		reservationPage.get_name_txtBx().sendKeys(name);
		reservationPage.get_phoneNumber_txtBx().sendKeys(phone);
		reservationPage.get_numberOfGuests_drpDwn().selectByVisibleText(numOfGuests);
		reservationPage.get_destination_drpDwn().selectByVisibleText(destination);
		
		//Enter checkIn date as current date + 2 days
		Date currentDate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		Calendar c=Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, 2);
		Date currentDatePlusTwo=c.getTime();		
		reservationPage.get_checkInDate_txtBx().sendKeys(sdf.format(currentDatePlusTwo));
		
		//Click the button- Make Reservation Now
		reservationPage.get_makeReservationNow_Btn().click();
		
		//Prepare the expected URL that the user is navigated to after clicking "Make Reservation Now" button
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		String expectedURL;
		String expectedBaseURL="https://sitatesting.github.io/AutomationTest/reservation.html";
		expectedURL=expectedBaseURL+"?Name="+MyUtils.urlEncode(name)+"&Number="+MyUtils.urlEncode(phone) +"&Guests="+MyUtils.urlEncode(numOfGuests)+"&date="+sdf.format(currentDatePlusTwo)+"&Destination="+MyUtils.urlEncode(destination)+"#";
		
		//Verify if user is navigated to the correct URL with the entered form data passed as query parameters		
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL,"Incorrect reservation details passed on");
	}
	
	@AfterTest
	public void tearDown(){
		closeBrowser();
	}
	
	
	

}
