package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ThreadThrower;


public class TestCase6 {

    private WebDriver driver;
    private String URL = "https://www.tempmailaddress.com/";
    private String URL2 = "https://practice-cybertekschool.herokuapp.com";
    private By fakeEmailBy = By.xpath("//span[@id='email']");
    private By enterSignUpPageBy = By.xpath("//a[@href='/sign_up']");
    private By fullnameBy = By.cssSelector("input[name='full_name']");
    private By emailBy = By.cssSelector("input[name='email']");
    private By gotEmailBy = By.xpath("//tbody/tr/td[1]");
    private By emailFromBy = By.cssSelector("span[id='odesilatel']");
    private By subjectBy = By.id("predmet");

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ThreadThrower.wait(3);


    }

    @Test
    public void test6() {
        driver.get(URL);
        String fakeEmail = driver.findElement(fakeEmailBy).getText();

        driver.navigate().to(URL2);
        ThreadThrower.wait(2);
        driver.findElement(enterSignUpPageBy).click();
        driver.findElement(fullnameBy).sendKeys("Tara");
        ThreadThrower.wait(2);
        driver.findElement(emailBy).sendKeys(fakeEmail, Keys.ENTER);
        ThreadThrower.wait(2);
        WebElement warningMessage = driver.findElement(By.tagName("h3"));
        String actual = warningMessage.getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertTrue(warningMessage.isDisplayed());
        Assert.assertEquals(actual, expected);
        System.out.println(actual);
        driver.navigate().to(URL);
        WebElement text1 = driver.findElement(gotEmailBy);
        Assert.assertTrue(text1.isDisplayed());
        String actualText1 = text1.getText().trim();
        String expectedText1 = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualText1, expectedText1);
        text1.click();
        WebElement sender = driver.findElement(emailFromBy);
        String actualText2 = sender.getText();
        String expectedTest2 = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualText2, expectedTest2);
        WebElement subject = driver.findElement(subjectBy);
        String actualSubject = subject.getText();
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualSubject, expectedSubject);

    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

}
