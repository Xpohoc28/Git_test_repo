package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

public class DatePickerPage extends BasePage {

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL_DATE_PICKER_PAGE = "https://demoqa.com/date-picker";

    private static final String SELECT_DATE_ELEMENT = "//input[@id='datePickerMonthYearInput']";

    /**
     * Выбрать день в календаре
     * @param number число (день)
     * @return xpath до выбранного дня
     */
    private String dayInDatePicker(int number){
        return String.format("//div[@role='option' and text()='%s']", number);
    }

    private static final String MONTH_SELECT = "//select[contains(@class, 'month')]";

    private static final String YEAR_SELECT = "//select[contains(@class, 'year')]";

    private static final String RESULT_DATE_INPUT = "//input[@value='03/12/2024']";


    /**
     * Открыть страницу - "Date Picker"
     */
    public void openDatePickerPage(){
        openUrl(URL_DATE_PICKER_PAGE);
    }

    /**
     * Нажать на элемент с выбором даты
     */
    public void clickDatePicker(){
        click(By.xpath(SELECT_DATE_ELEMENT));
    }

    /**
     * Выбрать месяц
     * @param month название месяца
     */
    public void selectMonth(String month) {
        Select monthSelect = new Select(findElement(By.xpath(MONTH_SELECT)));
        monthSelect.selectByVisibleText(month);
    }

    /**
     * Выбрать год
     * @param year год
     */
    public void selectYear(String year) {
        Select yearSelect = new Select(findElement(By.xpath(YEAR_SELECT)));
        yearSelect.selectByValue(year);
    }

    /**
     * Выбрать дату 12.03.2024
     */
    public void setDate(){
        selectYear("2024");
        selectMonth("March");
        click(By.xpath(dayInDatePicker(12)));
    }

    /**
     * Проверка отображения input со значением - 03/12/2024
     * @return true если элемент отображается
     */
    public boolean isResultDateDisplayed(){
        return isElementDisplay(By.xpath(RESULT_DATE_INPUT));
    }
}