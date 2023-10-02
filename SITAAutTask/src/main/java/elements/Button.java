package main.java.elements;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import main.java.base.TestBase;

public class Button{
	WebElement button;
	WebDriver driver=TestBase.driver;
	
	public Button(WebElement button){
		this.button=button;
	}
	
	public void click() {
		
		try {
			button.click();
		}catch(ElementClickInterceptedException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({ block: 'center' });",button);
			button.click();
		}
	}

}
