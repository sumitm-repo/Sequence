package fullauto;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HerokuappAuto2 {
	WebDriver driver= new EdgeDriver();

	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver= new EdgeDriver();
//		driver.get("https://omayo.blogspot.com/");
//		driver.manage().window().maximize();
//		
//		driver.findElement(By.linkText("Open a popup window")).click();
//		
//		driver.findElement(By.id("link2")).click();
//		
//		Set<String> handles = driver.getWindowHandles();
//			for (String windows : handles) {
//				driver.switchTo().window(windows);
//				String text1 = driver.findElement(By.xpath( "/div[@class='example']")).getText();
//				System.out.println(text1);
		HerokuappAuto2.alertP();
//			}
			
	}
	
	public static void alertP() {
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		WebElement b = driver.findElement(By.xpath("//a[contains(text(),'Basic Auth')]"));
		boolean b1=b.isEnabled();
		System.out.println(b1);
		driver.quit();
	}
	

}
