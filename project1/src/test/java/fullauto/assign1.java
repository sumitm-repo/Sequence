package fullauto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class assign1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://fitpeo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")).click();
		WebElement element=driver.findElement(By.xpath("//body[@class=\"__variable_469f07 __variable_122d8d __variable_5f3c75 __variable_4a931b __variable_be5ae6\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		List<WebElement> boxes = driver.findElements(By.xpath("//div[@class=\"MuiBox-root css-7ztaza\"]"));
		for(WebElement many : boxes) {
			
		}
//		driver.close();
	}

}
