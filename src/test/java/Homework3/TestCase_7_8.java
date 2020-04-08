package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ThreadThrower;

public class TestCase_7_8 {


    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com/";
    private By autocompleteBy = By.linkText("Autocomplete");
    private By countryBy = By.xpath("//input[@id='myCountry']");
    private By autoResultBy = By.linkText("You selected: United States of America");
    private By fileUploadBy = By.xpath("//a[@href='/upload']");


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        ThreadThrower.wait(3);
    }

    @Test
    public void test7() {
        driver.findElement(fileUploadBy).click();
        ThreadThrower.wait(3);
        WebElement upload = driver.findElement(By.id("file-upload"));

        String filePath = System.getProperty("user.dir")+"/pom.xml";
      //  String filePath = "test.txt";
        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        ThreadThrower.wait(3);
       WebElement fileName= driver.findElement(By.id("uploaded-files"));
       String actual=fileName.getText();
       String expected="pom.xml";
       Assert.assertEquals(actual,expected);
        System.out.println("Subject is: "+actual);
        Assert.assertTrue(fileName.isDisplayed());

    }


    @Test
    public void test8() {
        driver.findElement(autocompleteBy).click();
        ThreadThrower.wait(3);
        WebElement country = driver.findElement(countryBy);
        country.sendKeys("United States of America", Keys.RETURN);
        driver.findElement(By.cssSelector("input[type='button']")).click();
        ThreadThrower.wait(3);
        WebElement text = driver.findElement(By.cssSelector("p[id='result']"));
        Assert.assertTrue(text.isDisplayed());
        ThreadThrower.wait(3);
        String actual = text.getText();
        System.out.println(actual);
        String expected = "You selected: United States of America";
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
