package main.java.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	static public WebDriver driver;
	
	public TestBase() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://sitatesting.github.io/AutomationTest/index.html");
	}
	
		
	
	
	public void closeBrowser() {
		driver.quit();
	}

}
