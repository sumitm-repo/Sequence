package fullauto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
}
