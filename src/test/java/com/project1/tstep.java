package com.project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tstep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		launch();
	}
	
   @Test(priority=2,description="Second priority")
	public static void launch() {
		
	    System.setProperty("webdriver.chrome.driver", ".//Browser//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

	}
   @Test(priority =1,description="First priority")
   public static void display() {
	   
	   System.out.println("This has the first prioroty.");
   }

}
