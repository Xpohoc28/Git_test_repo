package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;

import static browser.Config.BROWSER_TYPE;

public class Browser {

    public static WebDriver createDriver() {
        WebDriver driver;

        switch (BROWSER_TYPE) {
            case "chrome":
                // Настройка ChromeDriver для Google Chrome
                WebDriverManager.chromedriver().browserVersion("135").setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                // Указываем путь к Google Chrome
                chromeOptions.setBinary("/opt/google/chrome");

                // Добавляем необходимые аргументы
                chromeOptions.addArguments(
                        "--headless",
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
                        "--remote-debugging-port=9222",
                        "--disable-gpu",
                        "--window-size=1920,1080"
                );
                chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");

                // Создаем экземпляр ChromeDriver
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                // Настройка FirefoxDriver
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new IllegalArgumentException("Некорректное имя браузера: " + BROWSER_TYPE);
        }

        // Общие настройки для всех браузеров
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }
}