package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import main.java.base.TestBase;
import main.java.elements.Button;

public class ReservationPage {
	WebDriver driver=TestBase.driver;
	static final String name_txtBx_name="Name";
	static final String phoneNumber_txtBx_name="Number";
	static final String numberOfGuests_drpDwn_name="Guests";
	static final String checkInDate_txtBx_name="date";
	static final String destination_drpDwn_name="Destination";
	static final String makeReservationNow_btn_xpath="//button[text()='Make Your Reservation Now']";
	
	static final String pageHeading_xpath="//div[@class='second-page-heading']//h2";
	
	public WebElement get_name_txtBx() {
		WebElement name_txtBx;
		try {
			name_txtBx=driver.findElement(By.name(name_txtBx_name));
			return name_txtBx;
		}catch (NoSuchElementException e) {
			System.out.println("Element with name"+ name_txtBx_name+ " not found");
			return null;
		}
	}
	
	public WebElement get_phoneNumber_txtBx() {
		WebElement phoneNumber_txtBx;
		try {
			phoneNumber_txtBx=driver.findElement(By.name(phoneNumber_txtBx_name));
			return phoneNumber_txtBx;
		}catch (NoSuchElementException e) {
			System.out.println("Element with name"+ phoneNumber_txtBx_name+ " not found");
			return null;
		}
	}
	
	public Select get_numberOfGuests_drpDwn() {
		Select numberOfGuests_drpDwn;
		try {
			numberOfGuests_drpDwn=new Select(driver.findElement(By.name(numberOfGuests_drpDwn_name)));
			return numberOfGuests_drpDwn;
		}catch (NoSuchElementException e) {
			System.out.println("Element with name"+ numberOfGuests_drpDwn_name+ " not found");
			return null;
		}
	}
	
	public WebElement get_checkInDate_txtBx() {
		WebElement checkInDate_txtBx;
		try {
			checkInDate_txtBx=driver.findElement(By.name(checkInDate_txtBx_name));
			return checkInDate_txtBx;
		}catch (NoSuchElementException e) {
			System.out.println("Element with name"+ checkInDate_txtBx_name+ " not found");
			return null;
		}
	}
	
	public Select get_destination_drpDwn() {
		Select destination_drpDwn;
		try {
			destination_drpDwn=new Select(driver.findElement(By.name(destination_drpDwn_name)));
			return destination_drpDwn;
		}catch (NoSuchElementException e) {
			System.out.println("Element with name"+ destination_drpDwn_name+ " not found");
			return null;
		}
	}
	
	public Button get_makeReservationNow_Btn() {
		Button makeReservationNow_Btn;
		try {
			makeReservationNow_Btn=new Button(driver.findElement(By.xpath(makeReservationNow_btn_xpath)));
			return makeReservationNow_Btn;
		}catch (NoSuchElementException e) {
			System.out.println("Element with xpath"+ makeReservationNow_btn_xpath+ " not found");
			return null;
		}
		
		
	}
	
	public WebElement get_pageHeading() {
		WebElement pageHeading;
		try {
			pageHeading=driver.findElement(By.xpath(pageHeading_xpath));
			return pageHeading;
		}catch(NoSuchElementException e) {
			System.out.println("Element with xpath"+ pageHeading_xpath+ " not found");
			return null;
		}
	}

}
