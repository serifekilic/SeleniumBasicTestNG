package homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TodaysDate {


    private WebDriver driver;
    private String URL = "http://practice.cybertekschool.com/dropdown";

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);

    }

    @Test
    public void todaysDate() {

        //  String expected=LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MMMM-d"));

        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));

        String selectedYear = year.getFirstSelectedOption().getText();
        String selectedMonth = month.getFirstSelectedOption().getText();
        String selectedDay = day.getFirstSelectedOption().getText();
        String actualDate = selectedMonth + " " + selectedDay + ", " + selectedYear;
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
        Assert.assertEquals(actualDate, expectedDate);

    }

    @Test
    public void YearMonthsDays() {
        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));


        Random ran = new Random();
        int index = ran.nextInt(year.getOptions().size());
        year.selectByIndex(index);
        // same-->   year.selectByIndex(new Random().nextInt( year.getOptions().size()));
        List<String> months31 = new ArrayList<>(Arrays.asList(new String[]{"January", "March", "May", "July", "August", "October", "December"}));
        int febDays;

        if (isLeapYear(Integer.valueOf(year.getFirstSelectedOption().getText()))) {
            febDays = 29;
        } else {
            febDays = 28;
        }

        for (int i = 0; i < 12; i++) {
            month.selectByIndex(i);
            if (months31.contains(month.getFirstSelectedOption().getText())) {
                Assert.assertEquals(day.getOptions().size(), 31);
            } else if (month.getFirstSelectedOption().getText().equals("February")) {
                Assert.assertEquals(day.getOptions().size(), febDays);
            } else {
                Assert.assertEquals(day.getOptions().size(), 30);
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
    public boolean isLeapYear(int year){
        if((year%4==0|| year%400==0)&& year%100!=0){
        return true;
        }else
            return false;
        }
    }


