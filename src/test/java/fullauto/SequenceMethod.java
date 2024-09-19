package fullauto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.IReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SequenceMethod {
 static WebDriver driver= new ChromeDriver();

	public static void main(String[] args) throws IOException, InterruptedException {
		SequenceMethod run=new SequenceMethod();
		run.launch();
		run.checkbox();
		run.contextClick();
		run.disappear();
		run.hover();
	    run.closeb();
		run.excel();
//		Integrate integ =new Integrate();
//		integ.digestauth(driver);
//    	integ.fileUpload(driver);
	}

	private WebElement element;
	@BeforeMethod
	public void launch() {
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("file");
		//String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	@Test(priority=1,invocationCount=2)
	public void checkbox() {
		//CHECKBOXES
		driver.findElement(By.linkText("Checkboxes")).click();
		driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]")).click();
		boolean check =driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]")).isSelected();
		System.out.println(check);
		driver.navigate().back();
		}
	@Test(priority=2)
	public void contextClick() {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.linkText("Context Menu")).click();
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		actions.contextClick(elementLocator).perform();
//		actions.sendKeys(Keys.ALT).sendKeys(Keys.ARROW_RIGHT);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.navigate().back();	
	}
	
	@Test(priority=3,invocationCount=1)
	public void disappear() {
		driver.findElement(By.xpath("//a[contains(text(),'Disappearing Elements')]")).click();

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='row']//li//a"));

		Boolean fount =  false;
		
		while(!fount) {
			
			for(int i=0; i<list.size();i++) {
				
				
				String txt = list.get(i).getText();
				
				if(txt.equals("Gallery") ) {
					driver.findElement(By.linkText("Gallery")).click();
					fount = true;
					System.out.println(fount);
					driver.navigate().to("https://the-internet.herokuapp.com/");
					
					
				}	
			}
			
			driver.navigate().refresh();
		}
		
	}
	
	

		public void excel() throws IOException {
			File fis=new File("‪C:\\Users\\HP\\Downloads\\ProcessedAdjustments20240704072002.xlsx");
			
			FileInputStream fls = new FileInputStream(fis);
			
			XSSFWorkbook workbook=new XSSFWorkbook(fls);

			XSSFSheet sheet=workbook.getSheet("ProcessedAdjustments");
			XSSFRow row = sheet.getRow(0);
			XSSFCell cell = row.getCell(0);
			
			System.out.println(cell.getStringCellValue());
			
			driver.findElement(By.xpath("//input[@type='number']"));
			
		}
		@Test(priority=4)
		public void hover() throws InterruptedException{
		driver.findElement(By.xpath("//a[contains(text(),'Hovers')]")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='example']//div[2]"))).perform();
		driver.findElement(By.xpath("//div[@class='example']//div[2]")).click();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		
		}		
		
		@AfterClass
		public void closeb() {
			driver.quit();
		}
		
	
	
}
