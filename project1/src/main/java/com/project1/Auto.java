package com.project1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class  Auto {
   
	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", ".//Browser//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		String url = driver.getCurrentUrl();
		System.out.println(url);

		        
		Point pos =driver.manage().window().getPosition();
		System.out.println(pos);
		driver.close();
		 
		
		
	
		
	}
 
}

