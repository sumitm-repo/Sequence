package fullauto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisappearingElement {
     static WebDriver driver =new ChromeDriver();

	public static void main(String[] args) throws IOException {
		//disappear(driver);
		readdata();
	}

//	public static void disappear(WebDriver driver) {
//		driver.findElement(By.xpath("//a[contains(text(),'Disappearing Elements')]")).click();
//
//		List<WebElement> list = driver.findElements(By.id("content"));
//		
////		String[] array = { "Home", "About", "Contact Us", "Portfolio", "Gallery" };
////		String text = "Gallery";
//
//		for(int i=0; i<list.size();i++) {
//			
//			
//			String txt = list.get(i).getText();
//			
//			if(txt.equals("Gallery") ) {
//				driver.findElement(By.linkText("Gallery")).click();
//			}
//			else {
//				driver.navigate().refresh();
//			}
//			
//		}
//		
////		boolean found = false;
////		for (String element : array) {
////			if (element.equals(text)) {
////				found = true;
////				System.out.println("found");
////				break;
////			}
////		}
//
//	}
	
	public static void readdata() throws IOException {
		String excelFilePath = "C:\\\\Users\\\\HP\\\\Downloads\\\\ProcessedAdjustments20240704072002.xlsx";

        // Load the Excel file
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("ProcessedAdjustments");
        XSSFRow row = (XSSFRow) sheet.getRow(0);
        XSSFCell cell = row.getCell(0);
		String value = cell.getStringCellValue();
		System.out.println(value);
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Inputs")).click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys(value);
		

	}

}
