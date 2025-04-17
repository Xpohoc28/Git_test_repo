package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {


    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Локатор до названия страницы в средней части страницы
     */

    private static final By NAME_PAGE = By.xpath("//h1[@class='text-center']");

    /**
     * Перейти по url
     * @param url ссылка в формате строки
     */
    public void openUrl(String url) {

        driver.get(url);
    }

    /**
     * Найти элемент на странице
     * @param locator путь до элемента, тип - By
     * @return element
     */
    public WebElement findElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    /**
     * Найти элементы на странице
     * @param locator путь до элементов, тип - String
     * @return список веб элементов
     */
    public List<WebElement> findElements(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    /**
     * Получить текст из элемента
     * @param locator путь до элемента, тип - By
     */
    public String getText(By locator) {
        return findElement(locator).getText();
    }

    /**
     * Получить имя страницы
     * @return имя текущей страницы
     */
    public String getPageName(){
        return getText(NAME_PAGE);
    }

    /**
     * Проверка элемент доступен
     * @return true если доступен
     */

    public boolean isElementEnabled(By locator){
        return findElement(locator).isEnabled();
    }

    /**
     * Очистить поле
     * @param locator путь до элемента, тип - By
     * **/
    public void clear(By locator) {
        findElement(locator).clear();
    }

    /**
     * Внести значение в поле
     * @param locator путь до элемента, тип - By
     * @param text текст
     */
    public void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    /**
     * Кликнуть на элемент
     * @param locator путь до элемента, тип - By
     */
    public void click(By locator) {
        findElement(locator).click();
    }

    /**
     * Метод вызывающий AssertionError
     */
    public void failure() {
        throw new AssertionError();
    }

    /**
     * Проверка - Элемент отображается
     * @param locator путь до элемента, тип - By
     * @return true если отображается
     */
    public boolean isElementDisplay(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception ex){

            return false;
        }
    }

    /**
     * Ожидание - Элемент отображается
     * @param locator путь до элемента, тип - By
     * @param second время ожидания в секундах
     */
    public void waitElementIsDisplay(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(d -> isElementDisplay(locator));
    }
}