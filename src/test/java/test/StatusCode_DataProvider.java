package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class StatusCode_DataProvider {


    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com";
    private By statusCodeBy = (By.linkText("Status Codes"));

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(statusCodeBy).click();

    }

    @Test(description="Verify code",dataProvider = "testData")
    public void test1(String code, String message) {
        driver.findElement(By.linkText(code)).click();
        WebElement warningMessage = driver.findElement(By.tagName("p"));
        Assert.assertTrue(warningMessage.getText().contains(message));


    }
    @DataProvider(name="testData")
    public Object[][] testData(){
        return new Object[][] {{"200","This page returned a 200 status code"},
                {"301","This page returned a 301 status code"},
                {"404","This page returned a 404 status code"},
                {"500","This page returned a 500 status code"}
        };
    }
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
