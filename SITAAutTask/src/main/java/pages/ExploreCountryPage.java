package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import main.java.base.TestBase;
import main.java.elements.Button;

public class ExploreCountryPage {
 WebDriver driver=TestBase.driver;	
 static final String makeReservationKingston_Btn_Xpath="//div[@class='weekly-offers']//div[@class='owl-item active']//h4[text()='Kingston']/parent::div//div[@class='main-button']";
 static final String pageHeading_Xpath="//div[@class='about-main-content']//h2";
	
	public Button get_makeReservationKingston_Btn() {
		Button makeReservationKingston_Btn;
		try {
			makeReservationKingston_Btn=new Button(driver.findElement(By.xpath(makeReservationKingston_Btn_Xpath)));
			return makeReservationKingston_Btn;
		}catch (NoSuchElementException e) {
			System.out.println("Element with xpath"+ makeReservationKingston_Btn_Xpath+ " not found");
			return null;
		}
		
		
	}
	
	public WebElement get_pageHeading() {
		WebElement pageHeading;
		try {
			pageHeading=driver.findElement(By.xpath(pageHeading_Xpath));
			return pageHeading;
		}catch(NoSuchElementException e) {
			System.out.println("Element with xpath"+ pageHeading_Xpath+ " not found");
			return null;
		}
	}
}
