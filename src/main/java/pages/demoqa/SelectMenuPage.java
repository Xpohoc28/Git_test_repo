package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL_DATE_SELECT_MENU_PAGE = "https://demoqa.com/select-menu";

    private static final String DROPDOWN_FIRST_FIELD = "//div[@id='withOptGroup']/div";

    private static final String DROPDOWN_SECOND_OPTION_IN_FIRST_FIELD = "//div[contains(text(),'Group 1, option 2')]";

    private static final String DROPDOWN_FIRST_FIELD_VALUE = "//div[contains(@class,'singleValue')]";


    public void openSelectMenuPage(){
        openUrl(URL_DATE_SELECT_MENU_PAGE);
    }

    /**
     * Нажать на первое поле с выпадающим списком
     */
    public void clickFirstDropDown(){
        click(By.xpath(DROPDOWN_FIRST_FIELD));
    }

    /**
     * В первом выпадающем списке выбрать второе значение
     */
    public void setSecondOptionInFirstDropDown(){
        click(By.xpath(DROPDOWN_SECOND_OPTION_IN_FIRST_FIELD));
    }

    /**
     * Проверка - В первом поле с выпадающим списком отображается второе значение
     */
    public boolean isSecondOptionDisplayedInFirstField(){
        return findElement(By.xpath(DROPDOWN_FIRST_FIELD_VALUE)).getText().equals("Group 1, option 2");
    }
}