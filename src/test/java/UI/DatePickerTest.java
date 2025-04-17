package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.DatePickerPage;

public class DatePickerTest extends BaseTest {

    private DatePickerPage datePickerPage;

    @BeforeClass
    public void beforeClass(){
        System.out.println("Setting up before class in DatePickerTest.");
        datePickerPage = new DatePickerPage(driver);
    }

    @Test(description = "Перейти на страницу 'Date Picker'")
    public void step_01(){
        datePickerPage.openDatePickerPage();
        Assert.assertEquals(datePickerPage.getPageName(), "Date Picker");
    }

    @Test(description = "Нажать на элемент с выбором даты , выбрать дату 12.03.2024")
    public void step_02(){
        datePickerPage.clickDatePicker();
        datePickerPage.setDate();
        Assert.assertTrue(datePickerPage.isResultDateDisplayed());
    }
}