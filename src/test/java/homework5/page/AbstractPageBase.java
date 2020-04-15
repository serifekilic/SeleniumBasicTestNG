package homework5.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserUtils;
import utilities.Driver;

/*
/**
 * This class will be extended by page classes
 * And common webelements/locators can be stored here
 * Since navigation menu doesn't belong to particular page
 * We cannot really create a dedicated page class to store
 * elements from that menu
 */
//test classes will extend => TestBase
//Page classes will extend=> PageBase
//We come up with method that will wrap up locator not to have duplication
// by using webElements directly in test class
public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait=new WebDriverWait(driver,15);

    @FindBy(css="#user-menu > a ")
    protected WebElement currentUser;
    //bu web elementin subclassta gozukmesini istiyoruz, o yuzden protected yaptik

    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    /**
     * Method for vytrack navigation. Provide tab name and module name to navigate
     * @param tabName, like Dashboards, Fleet or Customers
     * @param moduleName, like Vehicles, Vehicles Odometer and Vehicles Costs
     */
    public void navigateTo(String tabName, String moduleName) {
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);

        BrowserUtils.wait(4);

        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();

        //increase this wait rime if still failing
        BrowserUtils.wait(4);
    }
}