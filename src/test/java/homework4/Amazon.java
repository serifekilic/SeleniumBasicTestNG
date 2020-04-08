package homework4;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.ThreadThrower;


import java.util.*;
import java.util.concurrent.TimeUnit;


public class Amazon {

    private WebDriver driver;
    private String URL = "https://www.amazon.com";
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.createDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().window().maximize();
    }


    @Test
    public void getAll() {
        WebElement all = driver.findElement(By.xpath("//*[text()='All']"));

        String actual = all.getText();
        String expected = "All";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void departmentsSort() {
        WebElement all = driver.findElement(By.xpath("//*[@id='searchDropdownBox' and @name='url']"));
        Select select = new Select(all);
        List<WebElement> selectAll = select.getOptions();
        boolean notSorted = false;
        for (int i = 0; i < selectAll.size() - 1; i++) {
            System.out.println(selectAll.get(i).getText());
            String first = selectAll.get(i).getText();
            String second = selectAll.get(i + 1).getText();
            if (first.compareTo(second) > 0) {
                notSorted = true;
                break;
                // >0 shows it is  not in alphabetical order
            }
        }
        Assert.assertTrue(notSorted);
    }

    @Test
    public void mainDepartments() {
        driver.get("https://www.amazon.com/gp/site-directory");

        WebElement all = driver.findElement(By.xpath("//*[@id='searchDropdownBox' and @name='url']"));
        Select select = new Select(all);
        List<WebElement> allSelect = select.getOptions();
        List<WebElement> selection = driver.findElements(By.tagName("h2"));
        Set<String> selectionList = new HashSet<>();
        Set<String> allSelectList = new HashSet<>();

        for (WebElement eachSelection : selection) {
            selectionList.add(eachSelection.getText());
        }
        for (WebElement eachAllSelect : allSelect) {
            allSelectList.add(eachAllSelect.getText());
        }

        System.out.println("allSelect.size() = " + allSelect.size());
        System.out.println("selection.size() = " + selection.size());

        Assert.assertEquals(allSelect,selectionList);
     //   Assert.assertTrue(allSelectList.containsAll(selectionList));
    }

    @Test
    public void cart() {
        //entering keys to search button
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='a-price']/span[@class='a-offscreen']"));
        Random random = new Random();
        int ran = random.nextInt(priceList.size());
        ran = ran == 0 ? 1 : ran;
        String product = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + ran + "]")).getText();
        String price = "$" +
                driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[2])[" + ran + "]")).getText() + "." +
                driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[3])[" + ran + "]")).getText();

        driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[" + ran + "]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='a-autoid-0-announce'] /span[2]")).getText(), "1");

        //Verifying equality of name
        String productTitle = driver.findElement(By.id("productTitle")).getText();
        Assert.assertEquals(productTitle, product);

        //Verifying equality of price
        String actualPrice = driver.findElement(By.id("price_inside_buybox")).getText();
        Assert.assertEquals(actualPrice, price, "Price is not same");

        //Verifying visibility of AddToCart Button
        WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
        Assert.assertTrue(addToCartBtn.isDisplayed());

    }

    @Test
    public void prime() {
        //entering keys to search button
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);

        String firstResult = driver.findElement(By.xpath("(//span[@class='sb_34-gYLw1'])[2]")).getText();

        //select Prime checkbox on the left
        driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::i")).click();
        String actualResult = driver.findElement(By.xpath("(//span[@class='sb_34-gYLw1'])[2]")).getText();
        Assert.assertEquals(actualResult, firstResult);
        driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::i)[17]")).click();
        String lastResult = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).getText();
        Assert.assertNotEquals(firstResult, lastResult);

    }

    @Test
    public void moreSpoons() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        List<WebElement> brandNames = driver.findElements(By.xpath("//div[@id='brandsRefinements']//li"));
        List<String> brandNameList1 = new ArrayList<>();
        brandNames.forEach(each -> brandNameList1.add(each.getText()));

        //select Prime checkbox on the left
        driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::i")).click();

        //. verify that same Brand names are still displayed
        List<WebElement> brandNamesPrime = driver.findElements(By.xpath("//div[@id='brandsRefinements']//li"));
        List<String> brandNamePrime2 = new ArrayList<>();
        brandNamesPrime.forEach(each -> brandNamePrime2.add(each.getText()));
        Assert.assertEquals(brandNameList1, brandNamePrime2);
    }

    @Test
    public void cheapSpoons() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        ThreadThrower.wait(2);

        //click on Price option Under $25 on the left
        driver.findElement(By.xpath("//*[.='Under $25']")).click();
        ThreadThrower.wait(3);
        List<WebElement> priceProduct = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        //verify that all results are cheaper than $25
        for (WebElement each : priceProduct) {
            int price = Integer.valueOf(each.getText());
            Assert.assertTrue(price < 25);
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
