package fullauto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

<<<<<<< HEAD
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class SequenceMethod {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws IOException, InterruptedException {
        SequenceMethod run = new SequenceMethod();
        run.launch();
        run.checkbox();
        run.contextClick();
        run.disappear();
        run.hover();
        run.closeBrowser();
      
    }

    @BeforeMethod
    public void launch() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        takeScreenshot("launch");
    }

    @Test(priority = 1, invocationCount = 2)
    public void checkbox() throws IOException {
        driver.findElement(By.linkText("Checkboxes")).click();
        WebElement checkbox = driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]"));
        checkbox.click();
        System.out.println("Checkbox selected: " + checkbox.isSelected());
        takeScreenshot("checkbox");
        driver.navigate().back();
    }

    @Test(priority = 2)
    public void contextClick() {
       
        driver.findElement(By.linkText("Context Menu")).click();
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        new Actions(driver).contextClick(hotSpot).perform();
        driver.switchTo().alert().accept();
        driver.navigate().back();
    }

    @Test(priority = 3)
    public void disappear() throws IOException {
        driver.findElement(By.linkText("Disappearing Elements")).click();
        boolean found = false;

        while (!found) {
            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='row']//li//a"));
            for (WebElement el : elements) {
                if ("Gallery".equals(el.getText())) {
                    el.click();
                    found = true;
                    System.out.println("Gallery found: " + found);
                    takeScreenshot("disappear");
                    driver.navigate().to("https://the-internet.herokuapp.com/");
                    break;
                }
            }
            if (!found) driver.navigate().refresh();
        }
    }

    @Test(priority = 4)
    public void hover() throws IOException {
        driver.findElement(By.linkText("Hovers")).click();
        WebElement avatar = driver.findElement(By.xpath("//div[@class='example']//div[2]"));
        new Actions(driver).moveToElement(avatar).perform();
        avatar.click();
        takeScreenshot("hover");
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }



    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public static void takeScreenshot(String fileName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\git\\repository\\project1\\Screenshot\\" + fileName + ".png");
            org.apache.commons.io.FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.err.println("Screenshot failed: " + e.getMessage());
        }
    }
=======
import org.apache.commons.io.FileUtils;
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
	public void checkbox() throws IOException {
		//CHECKBOXES
		driver.findElement(By.linkText("Checkboxes")).click();
		driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]")).click();
		boolean check =driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]")).isSelected();
		System.out.println(check);
		takeScreenshot("check1");
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
					try {
						takeScreenshot("disppear");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		public void hover() throws InterruptedException, IOException{
		driver.findElement(By.xpath("//a[contains(text(),'Hovers')]")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='example']//div[2]"))).perform();
		driver.findElement(By.xpath("//div[@class='example']//div[2]")).click();
		takeScreenshot("hover1");
		driver.navigate().to("https://the-internet.herokuapp.com/");
		
		}		
		
		@AfterClass
		public void closeb() {
			driver.quit();
		}
		public static void takeScreenshot(String fileName) throws IOException{
			// Take screenshot and store as a file format
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// now copy the screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, 
					new File("C:\\git\\repository\\project1\\Screenshot\\" + fileName +".png"));

		}
		
	
	
>>>>>>> 295d27d64953ee0c197789c3d593b37c9f1d7e2a
}
