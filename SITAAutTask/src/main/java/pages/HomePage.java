package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import main.java.base.TestBase;
import main.java.elements.Button;

public class HomePage {
	WebDriver driver=TestBase.driver;
	static final String caribbeanExploreMore_Btn_Xpath="//h4[text()='CARIBBEAN']/parent::div//a[text()='Explore More']";
	
	public Button get_CaribbeanExploreMore_Btn() {
		Button caribbeanExploreMore_Btn;
		try {
			caribbeanExploreMore_Btn=new Button(driver.findElement(By.xpath(caribbeanExploreMore_Btn_Xpath)));
			return caribbeanExploreMore_Btn;
		}catch (NoSuchElementException e) {
			System.out.println("Element with xpath"+ caribbeanExploreMore_Btn_Xpath+ " not found");
			return null;
		}
		
		
	}

}
