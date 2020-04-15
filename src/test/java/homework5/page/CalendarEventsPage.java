package homework5.page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtils;

import javax.swing.*;
import java.util.List;


public class CalendarEventsPage extends AbstractPageBase {


     protected  Actions action = new Actions(driver);
     protected Select select;

    @FindBy(xpath = "//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-title' and contains(text(),'Testers Meeting')]")
    private WebElement testersMeet;

    @FindBy(xpath = "//td[text()='Testers Meeting']//..//td[@class='action-cell grid-cell grid-body-cell']")
    private WebElement threeDots;

    @FindBy(xpath = "//li[@class='launcher-item']//a[@title='View']")
    private WebElement threeDotsView;

    @FindBy(xpath = "//li[@class='launcher-item']//a[@title='Edit']")
    private WebElement threeDotsEdit;

    @FindBy(xpath = "//li[@class='launcher-item']//a[@title='Delete']")
    private WebElement threeDotsDelete;

    @FindBy(tagName = "Delete Confirmation")
    private WebElement deleteConfirmation;

    @FindBy(xpath = "//div[@class='sub-title']")
    private WebElement calendarEventsSubTitle;

    @FindBy(xpath = "//tbody[@class='ui-sortable']//tr//td[3]")
    private List<WebElement> showBtn;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    private WebElement gridSettingsBtn;

    @FindBy(xpath = "(//*[@id='container']//a)[1]")
    private WebElement saveAndCloseExpandBtn;

    @FindBy(xpath = "//*[@title='Create Calendar event' and contains(text(),'Create Calendar event')]")
    private WebElement createCalendarEventBtn;

    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[3]/li[1]")
    private WebElement saveAndCloseBtn;

    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[3]/li[2]")
    private WebElement saveAndNewBtn;

    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[3]/li[3]")
    private WebElement saveBtn;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']>span")
    private WebElement saveAndCloseText;

    @FindBy(xpath = "//a[@title='Cancel' and contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//div[@id='container']//h1")
    private WebElement allCalendarEvents;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(xpath = "//ul[@class='ui-timepicker-list']/li")
    private List<WebElement> clockList;

    @FindBy(css = "[id^='oro_calendar_event_form_allDay']")
    private WebElement allDayEventBtn;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDateBtn;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    private WebElement endDateBtn;

    @FindBy(css = "input[id^='recurrence-repeat-view']")
    private WebElement repeatCheckbox;

    @FindBy(css = "select[id^='recurrence-repeats-view']")
    private WebElement repeatsOptions;

    @FindBy(css = "div[id^='uniform-recurrence-repeats-view']>span")
    private WebElement dailyDefaultText;

    @FindBy(xpath = "(//input[3])[1]")
    private WebElement repeatEveryDropdown;

    @FindBy(xpath = "(//input[3])[2]")
    private WebElement timeDropdown;

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> radioButtons;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    private WebElement repeatEveryRadioButton;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    private WebElement endsRadioButton;

    @FindBy(xpath = "(//input[@type='radio'])[3]/following-sibling::span")
    private WebElement neverRadioButton;

    @FindBy(xpath = "(//input[@class='recurrence-subview-control__number'])[1]")
    private WebElement daysDropdown;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[3]")
    private WebElement chooseADateDropdown;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    private WebElement afterRadioButton;

    @FindBy(xpath = "(//input[@class='recurrence-subview-control__number'])[7]")
    private WebElement occurancesDropdown;

    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']")
    private WebElement summaryDropdown;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    private WebElement byRadioButton;

    @FindBy(className = "ui-datepicker-month")
    private WebElement month;

    @FindBy(className = "ui-datepicker-year")
    private WebElement year;

    @FindBy(xpath = "//*[@class='ui-state-default']")
    private List<WebElement> day;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    private WebElement weekdayRadioButton;

    @FindBy(xpath = "//div[@class='multi-checkbox-control']/select")
    private WebElement dayOptions;

    @FindBy(css = "input[type='checkbox'][value='monday']")
    private  WebElement monday;

    @FindBy(css = "input[type='checkbox'][value='friday']")
    private WebElement friday;


    public void findThreeDots(){
        BrowserUtils.waitForPageToLoad(20);
        action.moveToElement(threeDots).perform();
    }
    public WebElement threeDotsView() {
        BrowserUtils.waitForPageToLoad(10);
     return wait.until(ExpectedConditions.visibilityOf(threeDotsView));
    }
    public WebElement threeDotsEdit() {
        BrowserUtils.waitForPageToLoad(20);
     return   wait.until(ExpectedConditions.visibilityOf(threeDotsEdit));
    }
    public WebElement threeDotsDelete() {
        BrowserUtils.waitForPageToLoad(20);
    return wait.until(ExpectedConditions.visibilityOf(threeDotsDelete));
    }
    public void clickGridSettings() {
        BrowserUtils.waitForPageToLoad(29);
        wait.until(ExpectedConditions.elementToBeClickable(gridSettingsBtn)).click();
    }
    public void deselectOptions() {
        BrowserUtils.waitForPageToLoad(29);
        for (int i = 1; i < showBtn.size(); i++) {
            showBtn.get(i).click();
        }
        BrowserUtils.wait(3);
    }
    public void createCalendarEvent() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEventBtn)).click();
    }
    public void saveAndCloseExpand() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseExpandBtn)).click();
    }
    public String saveAndClose() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseBtn)).click();
        BrowserUtils.waitForPageToLoad(20);
        return saveAndCloseText.getText();
    }
    public String saveAndNew() {
        wait.until(ExpectedConditions.elementToBeClickable(saveAndNewBtn)).click();
        BrowserUtils.waitForPageToLoad(20);
        return saveAndCloseText.getText();
    }
    public String save() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
        BrowserUtils.waitForPageToLoad(20);
        return saveAndCloseText.getText();
    }
    public void clickCancel() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Cancel' and contains(text(),'Cancel')]")));
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
        BrowserUtils.waitForPageToLoad(5);
    }
    public String getAllCalendarEventsTitle() {
        BrowserUtils.waitForPageToLoad(30);
        BrowserUtils.wait(5);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='container']//h1"))).getText();
    }
    public String findStartTime() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")));
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }
    public String findEndTime() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }
    public void enterStartTime(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(startTime)).click();
        BrowserUtils.waitForPageToLoad(3);
        for (int i = 0; i <clockList.size() ; i++) {
           if(i==42){
               clockList.get(42).click();
               break;
           }
        }
    }
    public boolean allDayEvent(){
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable( allDayEventBtn)).click();
        BrowserUtils.wait(2);
       return wait.until(ExpectedConditions.visibilityOf( allDayEventBtn)).isSelected();
    }
    public boolean startTimeBox(){
        BrowserUtils.waitForPageToLoad(20);
     return  startTime.isDisplayed();
    }
    public boolean endTimeBox(){
        BrowserUtils.waitForPageToLoad(20);
        return endTime.isDisplayed();
    }
    public boolean startDateBox(){
        BrowserUtils.waitForPageToLoad(20);
        return wait.until(ExpectedConditions.elementToBeClickable(startDateBtn)).isDisplayed();
    }
    public boolean endDateBox(){
        BrowserUtils.waitForPageToLoad(20);
        return wait.until(ExpectedConditions.elementToBeClickable(endDateBtn)).isDisplayed();
    }
    public boolean repeatCheckBoxIsSelected(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable( repeatCheckbox)).click();
        BrowserUtils.wait(4);
        return wait.until(ExpectedConditions.elementToBeClickable(repeatCheckbox)).isSelected();
    }
    public String isDailySelected(){
        BrowserUtils.waitForPageToLoad(20);
        return  dailyDefaultText.getText();
    }
    public List<String> getRepeatsOptions(){
        BrowserUtils.waitForPageToLoad(20);
        select=new Select(repeatsOptions);
        List<WebElement>repeatsOptionsList=select.getOptions();
        return BrowserUtils.getTextFromWebElements(repeatsOptionsList);
       }
    public boolean isRepeatEverySelected(){
        BrowserUtils.waitForPageToLoad(20);
        return repeatEveryRadioButton.isSelected();
    }
    public boolean isEndsRadioSelected(){
        BrowserUtils.waitForPageToLoad(20);
        return endsRadioButton.isSelected();
    }
    public String getNeverRadioButton(){
        BrowserUtils.waitForPageToLoad(20);
        return neverRadioButton.getText();
    }
    public void clickAfterButton(){
        BrowserUtils.waitForPageToLoad(20);
        afterRadioButton.click();
    }
    public void clickOccurancesDropdown( ) {
        BrowserUtils.waitForPageToLoad(20);
        occurancesDropdown.click();
    }
    public void sendKeysOccurancesDropdown(){
        BrowserUtils.waitForPageToLoad(20);
        occurancesDropdown.sendKeys("10");
    }
    public String getSummaryDropdownText(){
        BrowserUtils.waitForPageToLoad(30);
        BrowserUtils.wait(4);
        summaryDropdown.click();
        return wait.until(ExpectedConditions.visibilityOf(summaryDropdown )).getText();
    }
    public void clickByRadioButton(){
        BrowserUtils.waitForPageToLoad(20);
        byRadioButton.click();
    }
    public void clickChooseDateDropdown(){
        BrowserUtils.waitForPageToLoad(20);
        chooseADateDropdown.click();
    }
    public void selectMonthOnChooseDateDropdown( ) {
        BrowserUtils.waitForPageToLoad(20);
        month.click();
        select=new Select(month);
        select.selectByValue("10");
    }
    public void selectYearOnChooseDateDropdown(){
        BrowserUtils.waitForPageToLoad(20);
        year.click();
        select=new Select(year);
        select.selectByVisibleText("2021");
    }
    public void selectDayOnChooseDateDropdown(){
        BrowserUtils.waitForPageToLoad(20);
        day.get(17).click();
        BrowserUtils.wait(3);
    }
    public void selectWeekly(){
        BrowserUtils.waitForPageToLoad(20);
        select=new Select(repeatsOptions);
        select.selectByValue("weekly");
    }
    public void  selectDaysOnRepeatOnOptions(){
        BrowserUtils.waitForPageToLoad(20);
        monday.click();
        BrowserUtils.wait(4);
        friday.click();
        BrowserUtils.wait(3);
    }
    }




