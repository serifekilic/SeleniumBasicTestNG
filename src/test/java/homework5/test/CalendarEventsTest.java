package homework5.test;

import homework5.page.CalendarEventsPage;
import homework5.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateTimeUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CalendarEventsTest extends AbstractTestBase {



    @Test
    public void testCase1(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.findThreeDots();
        Assert.assertTrue(calendarEventsPage.threeDotsEdit().isDisplayed());
        Assert.assertTrue(calendarEventsPage.threeDotsDelete().isDisplayed());
        Assert.assertTrue(calendarEventsPage.threeDotsView().isDisplayed());
    }
    @Test
    public void testCase2(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickGridSettings();
        calendarEventsPage.deselectOptions();
    }
    @Test
    public void testCase3_saveAndClose(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.saveAndCloseExpand();
        String actual=calendarEventsPage.saveAndClose();
        //warning message emerge after click.
        Assert.assertEquals(actual,"This value should not be blank.");
    }
    @Test
    public void testCase3_saveAndNew(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.saveAndCloseExpand();
        String actual2=calendarEventsPage.saveAndNew();
        //warning message emerge after click.
        Assert.assertEquals(actual2,"This value should not be blank.");
    }
    @Test
    public void testCase3_save(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.saveAndCloseExpand();
        String actual3=calendarEventsPage.save();
        //warning message emerge after click.
        Assert.assertEquals(actual3,"This value should not be blank.");
    }
    @Test
    public void testCase4(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.clickCancel();
        String actual=calendarEventsPage.getAllCalendarEventsTitle();
        Assert.assertEquals(actual, "All Calendar Events");
    }
    @Test
    public void testCase5(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        String start=calendarEventsPage.findStartTime();
        String end=calendarEventsPage.findEndTime();
        String format = "h:mm a";//format 5:15 AM for example
        long actual = DateTimeUtilities.getTimeDifference(start, end, format);
        Assert.assertEquals(actual, 1, "Time difference is not correct");
    }
    @Test
    public void testCase6(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.enterStartTime();
        String end= calendarEventsPage.findEndTime();
        Assert.assertTrue(end.contains("10:00 PM"));

        }
        @Test
    public void testCase7(){
            LoginPage loginPage=new LoginPage();
            CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
            loginPage.login();
            calendarEventsPage.navigateTo("Activities","Calendar Events");
            calendarEventsPage.createCalendarEvent();
            Assert.assertTrue(calendarEventsPage.allDayEvent());
            Assert.assertFalse( calendarEventsPage.startTimeBox() );
            Assert.assertFalse(calendarEventsPage.endTimeBox());
            Assert.assertTrue(calendarEventsPage.startDateBox());
            Assert.assertTrue(calendarEventsPage.endDateBox());

        }
    @Test
    public void testCase8(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        Assert.assertTrue( calendarEventsPage.repeatCheckBoxIsSelected() );
        Assert.assertEquals(calendarEventsPage.isDailySelected(),"Daily");
        List<String> expected=new ArrayList<>(Arrays.asList("Daily","Weekly","Monthly","Yearly"));
        Assert.assertEquals(calendarEventsPage.getRepeatsOptions(),expected);
    }
    @Test
    public void testCase9(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        Assert.assertTrue( calendarEventsPage.repeatCheckBoxIsSelected() );
        Assert.assertTrue(calendarEventsPage.isRepeatEverySelected());
        Assert.assertTrue(calendarEventsPage.isEndsRadioSelected());
        Assert.assertEquals(calendarEventsPage.getNeverRadioButton(),"Never");
        Assert.assertEquals(calendarEventsPage.getSummaryDropdownText(),"Summary:\n" +"Daily every 1 day");
    }
    @Test
    public void testCase10(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.repeatCheckBoxIsSelected();
        calendarEventsPage.clickAfterButton();
        calendarEventsPage.clickOccurancesDropdown();
        calendarEventsPage.sendKeysOccurancesDropdown();
        String expected="Summary:\n" +
                "Daily every 1 day, end after 10 occurrences";
        Assert.assertEquals(calendarEventsPage.getSummaryDropdownText(),expected);
    }
    @Test
    public void testCase11(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.repeatCheckBoxIsSelected();
        calendarEventsPage.clickByRadioButton();
        calendarEventsPage.clickChooseDateDropdown();
        calendarEventsPage.selectMonthOnChooseDateDropdown();
        calendarEventsPage.selectYearOnChooseDateDropdown();
        calendarEventsPage.selectDayOnChooseDateDropdown();
        String expected="Summary:\n" +
                "Daily every 1 day, end by Nov 18, 2021";
        Assert.assertEquals(calendarEventsPage.getSummaryDropdownText(),expected);
    }
    @Test
    public void testCase12(){
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.repeatCheckBoxIsSelected();
        calendarEventsPage.selectWeekly();
        calendarEventsPage.selectDaysOnRepeatOnOptions();
        String expected="Summary:\n" +
                "Weekly every 1 week on Monday, Friday";
        Assert.assertEquals(calendarEventsPage.getSummaryDropdownText(),expected);
    }
    }

