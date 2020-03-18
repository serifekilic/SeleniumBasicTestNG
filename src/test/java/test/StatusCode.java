package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ThreadThrower;


public class StatusCode {


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

    @Test
    public void test9() {
        driver.findElement(By.linkText("200")).click();
        WebElement warningMessage = driver.findElement(By.tagName("p"));
        Assert.assertTrue(warningMessage.isDisplayed());
        String expected = "This page returned a 200 status code.";
        boolean actual = warningMessage.getText().contains(expected);
        ThreadThrower.wait(2);

        if (actual) {
            System.out.println("“This page returned a 200 status code”");
        } else {
            System.out.println("error");
        }
        //  Assert.assertEquals(actual,expected);
    }

    @Test
    public void test10() {
        driver.findElement(By.linkText("301")).click();
        WebElement warningMessage = driver.findElement(By.tagName("p"));
        Assert.assertTrue(warningMessage.isDisplayed());
        String expected = "This page returned a 301 status code.";
        boolean actual = warningMessage.getText().contains(expected);
        ThreadThrower.wait(2);

        if (actual) {
            System.out.println("“This page returned a 301 status code”");
        } else {
            System.out.println("error");
        }
    }

    @Test
    public void test11() {
        driver.findElement(By.linkText("404")).click();
        WebElement warningMessage = driver.findElement(By.tagName("p"));
        Assert.assertTrue(warningMessage.isDisplayed());
        String expected = "This page returned a 404 status code.";
        boolean actual = warningMessage.getText().contains(expected);
        ThreadThrower.wait(2);

        if (actual) {
            System.out.println("“This page returned a 404 status code”");
        } else {
            System.out.println("error");
        }
    }

    @Test
    public void test12() {
        driver.findElement(By.linkText("500")).click();
        WebElement warningMessage = driver.findElement(By.tagName("p"));
        Assert.assertTrue(warningMessage.isDisplayed());
        String expected = "This page returned a 500 status code.";
        boolean actual = warningMessage.getText().contains(expected);
        ThreadThrower.wait(2);

        if (actual) {
            System.out.println("“This page returned a 500 status code”");
        } else {
            System.out.println("error");
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
