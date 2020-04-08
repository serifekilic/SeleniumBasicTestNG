package homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;


import java.util.List;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Days {

    private WebDriver driver;
    private String URL = "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox";

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.createDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void days() {
        //for elements we have 8 elements (with title)
        //we can also remove it at the beginning
        List<WebElement> days = driver.findElements(By.xpath("//*[@id='gwt-debug-contentPanel']/div[2]/div/div[2]/div/div[3]/div/div/table/tbody//td"));
        //for collecting checkboxes we have 7 boxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        Random ran = new Random();
        //we have 7 check boxes
        //so that the index range should be 0 to 6


        int count = 0;
        while (count < 3) {
          int  index = ran.nextInt(checkboxes.size());
            //if my checkbox is available to click
            //then do these steps
            //in this case we avoid from saturday and sunday
            //Because those are disabled
            if (checkboxes.get(index).isEnabled()) {
                //to avoid from title (first index of days)
                //I put index+1
                //If we remove title at the beginning
                //we do not need to add +1
                if (days.get(index+1).getText().equals("Friday")) {
                    checkboxes.get(index).click();
                    System.out.println(days.get(index+1).getText());
                    checkboxes.get(index).click();
                    count++;
                    System.out.println("count = " + count);
                } else {
                    checkboxes.get(index).click();
                    System.out.println(days.get(index+1).getText());
                    checkboxes.get(index).click();
                }
            }
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
