package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class CheckBoxPage extends BasePage {

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/checkbox";

    /**
     * Локатор до Input элемента чекбокса
     */
    private static final String CHECK_BOX_INPUT_XPATH = "//input" +
            "[@type='checkbox'][following-sibling::span[text()='%s']]";

    /**
     * Локатор до чекбокса для нажатия
     */
    private static final String CHECK_BOX_XPATH = CHECK_BOX_INPUT_XPATH +
            "/following-sibling::span[@class='rct-checkbox']";

    /**
     * Локатор до пиктограммы "Свернуть/развернуть"
     */
    private static final String BUTTON_TOGGLE = CHECK_BOX_INPUT_XPATH + "/../preceding-sibling::button[@title='Toggle']";

    /**
     * Локатор для проверки , что строки свернуты/развернуты
     */
    private static final String LIST_CHECKBOX_XPATH = CHECK_BOX_INPUT_XPATH + "/ancestor::li[contains(@class,'%s')]";

    /**
     * Открыть страницу с элементами "Check Box"
     */
    public void openCheckBoxPage(){
        openUrl(URL_TEXT_BOX_PAGE);
    }

    /**
     * Получение статуса состояния чекбокса
     * @param checkBoxName путь до элемента, тип - String
     * @return true если отмечен
     */
    public boolean getCheckBoxState(String checkBoxName){
        return findElement(By.xpath(String.format(CHECK_BOX_INPUT_XPATH,checkBoxName))).isSelected();
    }

    /**
     * Переводит чек-бокс в нужное состочние
     * @param checkBoxName - Название чек-бокса
     * @param state нужное состояние, true если чек-бокс должен быть активным, false - если нет
     */
    public void setCheckBox(String checkBoxName, boolean state){
        if (!getCheckBoxState(checkBoxName) == state){
            click(By.xpath(String.format(CHECK_BOX_XPATH,checkBoxName)));
        }
    }

    /**
     * Проверка отображения чек-бокса на форме
     * @param checkBoxName название чек-бокса
     * @return true если отображается
     */
    public boolean isCheckBoxDisplay(String checkBoxName){
        return isElementDisplay(By.xpath(String.format(CHECK_BOX_XPATH,checkBoxName)));
    }

    /**
     * Проверка , что не отображаются внутренние чекбоксы
     * @param checkBoxName название чек-бокса
     * @return true если не отображается
     */
    public boolean isListCheckBoxClosed(String checkBoxName){
        return isElementDisplay(By.xpath(String.format(LIST_CHECKBOX_XPATH,checkBoxName,"collapsed")));
    }

    /**
     * Метод открытия списка чек-боксов нажатием на toggle рядом с чек-боксом для открытия списка
     * @param checkBoxName название чек-бокса
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