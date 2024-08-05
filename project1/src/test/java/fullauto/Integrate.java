package fullauto;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Integrate {
	public void fileUpload(WebDriver driver) {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'File Upload')]")).click();
		WebElement fileInput =driver.findElement(By.xpath("//input[@id='file-upload']"));

		String filePath ="C:\\Users\\HP\\Downloads\\No Settle Transactions Report20240715072412.xlsx";
		fileInput.sendKeys(filePath);
		
//		WebElement file =driver.findElement(By.id("drag-drop-upload"));
//		WebDriverWait wait= new WebDriverWait(10,TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.elementToBeSelected(file))
//		String filepath="C:\\Users\\HP\\Downloads\\No Settle Transactions Report20240715072412.xlsx";
//		file.sendKeys(filepath);
		
		
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
	}


}
