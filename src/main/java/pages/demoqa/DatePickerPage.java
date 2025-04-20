package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

/**
 * Класс DatePickerPage представляет страницу с выбором даты на сайте demoqa.com
 * Наследуется от BasePage для использования базовых методов работы с веб-элементами
 */
public class DatePickerPage extends BasePage {

    /**
     * Конструктор класса, принимающий экземпляр WebDriver
     * @param driver - экземпляр WebDriver для управления браузером
     */
    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    /**
     * URL страницы с выбором даты на сайте demoqa.com
     */
    private static final String URL_DATE_PICKER_PAGE = "https://demoqa.com/date-picker";

    /**
     * XPath локатор для поиска поля ввода даты
     */
    private static final String SELECT_DATE_ELEMENT = "//input[@id='datePickerMonthYearInput']";

    /**
     * Метод для формирования XPath локатора дня в календаре
     * @param number - число (день месяца)
     * @return XPath локатор для выбранного дня
     */
    private String dayInDatePicker(int number){
        return String.format("//div[@role='option' and text()='%s']", number);
    }

    /**
     * XPath локатор для выпадающего списка выбора месяца
     */
    private static final String MONTH_SELECT = "//select[contains(@class, 'month')]";

    /**
     * XPath локатор для выпадающего списка выбора года
     */
    private static final String YEAR_SELECT = "//select[contains(@class, 'year')]";

    /**
     * XPath локатор для проверки результата выбора даты
     * Ожидаемое значение - 03/12/2024
     */
    private static final String RESULT_DATE_INPUT = "//input[@value='03/12/2024']";

    /**
     * Метод для открытия страницы с выбором даты
     * Использует метод openUrl из базового класса для перехода по URL
     */
    public void openDatePickerPage(){
        openUrl(URL_DATE_PICKER_PAGE);
    }

    /**
     * Метод для клика по полю выбора даты
     * Открывает календарь для выбора даты
     */
    public void clickDatePicker(){
        click(By.xpath(SELECT_DATE_ELEMENT));
    }

    /**
     * Метод для выбора месяца в календаре
     * @param month - название месяца на английском языке
     * Использует класс Select для работы с выпадающим списком
     */
    public void selectMonth(String month) {
        Select monthSelect = new Select(findElement(By.xpath(MONTH_SELECT)));
        monthSelect.selectByVisibleText(month);
    }

    /**
     * Метод для выбора года в календаре
     * @param year - год в формате строки
     * Использует класс Select для работы с выпадающим списком
     */
    public void selectYear(String year) {
        Select yearSelect = new Select(findElement(By.xpath(YEAR_SELECT)));
        yearSelect.selectByValue(year);
    }

    /**
     * Метод для установки конкретной даты (12 марта 2024 года)
     * Последовательно выполняет:
     * 1. Выбор года 2024
     * 2. Выбор месяца March
     * 3. Выбор дня 12
     */
    public void setDate(){
        selectYear("2024");
        selectMonth("March");
        click(By.xpath(dayInDatePicker(12)));
    }

    /**
     * Метод для проверки отображения выбранной даты
     * @return true если поле с выбранной датой отображается на странице
     */
    public boolean isResultDateDisplayed(){
        return isElementDisplay(By.xpath(RESULT_DATE_INPUT));
    }
}