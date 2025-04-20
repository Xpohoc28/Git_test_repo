package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс SelectMenuPage представляет страницу с выпадающими списками на сайте demoqa.com
 * Наследуется от BasePage для использования базовых методов работы с веб-элементами
 */
public class SelectMenuPage extends BasePage {

    /**
     * Конструктор класса, принимающий экземпляр WebDriver
     * @param driver - экземпляр WebDriver для управления браузером
     */
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    /**
     * URL страницы с выпадающими списками на сайте demoqa.com
     */
    private static final String URL_DATE_SELECT_MENU_PAGE = "https://demoqa.com/select-menu";

    /**
     * XPath локатор для поиска первого выпадающего списка
     */
    private static final String DROPDOWN_FIRST_FIELD = "//div[@id='withOptGroup']/div";

    /**
     * XPath локатор для поиска второго варианта в первом выпадающем списке
     * Ищет элемент с текстом "Group 1, option 2"
     */
    private static final String DROPDOWN_SECOND_OPTION_IN_FIRST_FIELD = "//div[contains(text(),'Group 1, option 2')]";

    /**
     * XPath локатор для поиска выбранного значения в первом выпадающем списке
     * Ищет div с классом singleValue
     */
    private static final String DROPDOWN_FIRST_FIELD_VALUE = "//div[contains(@class,'singleValue')]";

    /**
     * Метод для открытия страницы с выпадающими списками
     * Использует метод openUrl из базового класса для перехода по URL
     */
    public void openSelectMenuPage(){
        openUrl(URL_DATE_SELECT_MENU_PAGE);
    }

    /**
     * Метод для клика по первому выпадающему списку
     * Открывает список для выбора значения
     */
    public void clickFirstDropDown(){
        click(By.xpath(DROPDOWN_FIRST_FIELD));
    }

    /**
     * Метод для выбора второго варианта в первом выпадающем списке
     * Кликает по элементу с текстом "Group 1, option 2"
     */
    public void setSecondOptionInFirstDropDown(){
        click(By.xpath(DROPDOWN_SECOND_OPTION_IN_FIRST_FIELD));
    }

    /**
     * Метод для проверки, что в первом выпадающем списке отображается второе значение
     * @return true если выбранное значение равно "Group 1, option 2"
     */
    public boolean isSecondOptionDisplayedInFirstField(){
        return findElement(By.xpath(DROPDOWN_FIRST_FIELD_VALUE)).getText().equals("Group 1, option 2");
    }
}