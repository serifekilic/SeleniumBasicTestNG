package Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ThreadThrower;



public class RegistrationForm_TestCase1_2_3_4_5 {


    private WebDriver driver;
    private String URL = "http://practice.cybertekschool.com/";
    private By firstNameBy = By.cssSelector("input[name='firstname']");
    private By lastNameBy = By.cssSelector("input[name='lastname']");
    private By userNameBy = By.cssSelector("input[name='username']");
    private By emailBy = By.cssSelector("input[name='email']");
    private By passwordBy = By.cssSelector("input[name='password']");
    private By phoneBy = By.cssSelector("input[name='phone']");
    private By dateOfBirthBy = By.xpath("//input[@name='birthday']");
    private By submitBy = By.id("wooden_spoon");
    private By departmentBy = By.cssSelector("select[name='department']");
    private By jobTitleBy = By.cssSelector("select[name='job_title']");
    private By maleBy = By.cssSelector("input[value='male']");

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        ThreadThrower.wait(3);
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @Test
    public void testCase1() {
        driver.findElement(dateOfBirthBy).sendKeys("2020/12/09", Keys.ENTER);
        ThreadThrower.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]"));
        String actual = warningMessage.getText();
        String expected = "The date of birth is not valid";
        Assert.assertEquals(actual, expected, "The date of birth is not valid");
        Assert.assertTrue(warningMessage.isDisplayed());


    }

    @Test
    public void testCase2() {

        String expected1 = "c++";
        String expected2 = "java";
        String expected3 = "JavaScript";
        WebElement lan1 = driver.findElement(By.id("inlineCheckbox1"));
        lan1.click();
        WebElement lan2 = driver.findElement(By.id("inlineCheckbox2"));
        lan2.click();
        WebElement lan3 = driver.findElement(By.id("inlineCheckbox3"));
        lan3.click();

        Assert.assertTrue(lan1.isDisplayed());
        Assert.assertTrue(lan2.isDisplayed());
        Assert.assertTrue(lan3.isDisplayed());

//            String actual1=lan1.getText();
//            String actual2=lan2.getText();
//            String actual3=lan2.getText();
//
//        Assert.assertEquals(actual1, expected1);
//        Assert.assertEquals(actual2, expected2);
//        Assert.assertEquals(actual3, expected3);

    }

    @Test
    public void testCase3() {
        driver.findElement(firstNameBy).sendKeys("a", Keys.ENTER);
        ThreadThrower.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());

    }

    @Test
    public void testCase4() {
        driver.findElement(lastNameBy).sendKeys("a", Keys.ENTER);
        ThreadThrower.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());

    }

    @Test
    public void testCase5() {
        Select selectDepartment = new Select(driver.findElement(departmentBy));
        selectDepartment.selectByValue("DA");

        Select selectJobTitle = new Select(driver.findElement(jobTitleBy));
        selectJobTitle.selectByVisibleText("Product Owner");
        ThreadThrower.wait(3);

        WebElement lan2 = driver.findElement(By.id("inlineCheckbox2"));
        lan2.click();
        ThreadThrower.wait(3);

        driver.findElement(submitBy).click();
        ThreadThrower.wait(3);


        driver.findElement(firstNameBy).sendKeys("Altan", Keys.ENTER);
        driver.findElement(lastNameBy).sendKeys("Bucuk", Keys.ENTER);
        driver.findElement(userNameBy).sendKeys("altanbucuk", Keys.ENTER);
        driver.findElement(emailBy).sendKeys("altanbucuk@gmail.com", Keys.ENTER);
        driver.findElement(passwordBy).sendKeys("bucukbucuk", Keys.ENTER);
        driver.findElement(phoneBy).sendKeys("123-123-1234", Keys.ENTER);
        driver.findElement(maleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("12/12/2000", Keys.ENTER);
        ThreadThrower.wait(5);

        String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/p")).getText();
        ThreadThrower.wait(3);
        String expected = "You've successfully completed registration!";
        System.out.println(actual);
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