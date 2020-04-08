package homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Links {

    private WebDriver driver;
    private String URL = "https://www.w3schools.com/";

    @Test
    public void links() {

        driver = DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElements(By.tagName("a"));

        for (WebElement each : list) {
            if (each.isDisplayed()) {
                System.out.println("Text: " + each.getText() + " " + "href: " + each.getAttribute("href"));
            }
        }

        driver.quit();
    }
}
