package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс CheckBoxPage представляет страницу с чекбоксами на сайте demoqa.com
 * Наследуется от BasePage для использования базовых методов работы с веб-элементами
 */
public class CheckBoxPage extends BasePage {

    /**
     * Конструктор класса, принимающий экземпляр WebDriver
     * @param driver - экземпляр WebDriver для управления браузером
     */
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    /**
     * URL страницы с чекбоксами на сайте demoqa.com
     */
    private static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/checkbox";

    /**
     * XPath локатор для поиска input элемента чекбокса
     * Использует форматирование строки для подстановки имени чекбокса
     * Ищет input с типом checkbox, за которым следует span с указанным текстом
     */
    private static final String CHECK_BOX_INPUT_XPATH = "//input" +
            "[@type='checkbox'][following-sibling::span[text()='%s']]";

    /**
     * XPath локатор для поиска видимой части чекбокса (квадратика для нажатия)
     * Расширяет CHECK_BOX_INPUT_XPATH, добавляя поиск span с классом rct-checkbox
     */
    private static final String CHECK_BOX_XPATH = CHECK_BOX_INPUT_XPATH +
            "/following-sibling::span[@class='rct-checkbox']";

    /**
     * XPath локатор для поиска кнопки "Toggle" (свернуть/развернуть)
     * Находится перед input элементом чекбокса
     */
    private static final String BUTTON_TOGGLE = CHECK_BOX_INPUT_XPATH + "/../preceding-sibling::button[@title='Toggle']";

    /**
     * XPath локатор для проверки состояния списка чекбоксов (свернут/развернут)
     * Использует форматирование строки для подстановки состояния (collapsed/expanded)
     */
    private static final String LIST_CHECKBOX_XPATH = CHECK_BOX_INPUT_XPATH + "/ancestor::li[contains(@class,'%s')]";

    /**
     * Метод для открытия страницы с чекбоксами
     * Использует метод openUrl из базового класса для перехода по URL
     */
    public void openCheckBoxPage(){
        openUrl(URL_TEXT_BOX_PAGE);
    }

    /**
     * Метод для получения текущего состояния чекбокса (отмечен/не отмечен)
     * @param checkBoxName - название чекбокса
     * @return true если чекбокс отмечен, false если не отмечен
     */
    public boolean getCheckBoxState(String checkBoxName){
        return findElement(By.xpath(String.format(CHECK_BOX_INPUT_XPATH,checkBoxName))).isSelected();
    }

    /**
     * Метод для установки чекбокса в нужное состояние
     * @param checkBoxName - название чекбокса
     * @param state - желаемое состояние (true - отмечен, false - не отмечен)
     * Если текущее состояние не совпадает с желаемым, кликает по чекбоксу
     */
    public void setCheckBox(String checkBoxName, boolean state){
        if (!getCheckBoxState(checkBoxName) == state){
            click(By.xpath(String.format(CHECK_BOX_XPATH,checkBoxName)));
        }
    }

    /**
     * Метод для проверки видимости чекбокса на странице
     * @param checkBoxName - название чекбокса
     * @return true если чекбокс отображается на странице
     */
    public boolean isCheckBoxDisplay(String checkBoxName){
        return isElementDisplay(By.xpath(String.format(CHECK_BOX_XPATH,checkBoxName)));
    }

    /**
     * Метод для проверки, что список чекбоксов свернут
     * @param checkBoxName - название чекбокса
     * @return true если список свернут (не отображаются вложенные чекбоксы)
     */
    public boolean isListCheckBoxClosed(String checkBoxName){
        return isElementDisplay(By.xpath(String.format(LIST_CHECKBOX_XPATH,checkBoxName,"collapsed")));
    }

    /**
     * Метод для открытия списка чекбоксов
     * @param checkBoxName - название чекбокса
     * Если чекбокс не отображается или список уже развернут, метод завершается
     * В противном случае кликает по кнопке Toggle для разворачивания списка
     */
    public void openListCheckBox(String checkBoxName){
        if (!isCheckBoxDisplay(checkBoxName)){
            failure();
        }
        if (isListCheckBoxClosed(checkBoxName)){
            click(By.xpath(String.format(BUTTON_TOGGLE,checkBoxName)));
        }
    }
}