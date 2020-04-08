package homework4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.util.ArrayList;
import java.util.List;

public class ValidLinks {

    private WebDriver driver;

    @Test
    public void validLinks(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=DriverFactory.createDriver("chrome");
        driver.get("https://www.selenium.dev/documentation/en/");


        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        List<String>allLinksString=new ArrayList<>();
        for( WebElement eachLink: allLinks){
            allLinksString.add(eachLink.getAttribute("href"));
        }
       Assert.assertTrue(!allLinksString.contains(null), "There is invalid link!!!");

        }
    }


