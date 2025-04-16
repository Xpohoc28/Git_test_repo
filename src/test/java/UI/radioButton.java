package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class radioButton {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY,"eager");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void step_01() {
        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadioButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", yesRadioButton);
        yesRadioButton.click();

        WebElement successElement = driver.findElement(By.xpath("//span[@class='text-success']"));
        String successElementText = successElement.getText();

        Assert.assertEquals(successElementText, "Yes");
    }

    @Test
    public void step_02() {
        driver.get("https://demoqa.com/radio-button");

        WebElement impressiveRadioButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", impressiveRadioButton);
        impressiveRadioButton.click();

        WebElement successElement = driver.findElement(By.xpath("//span[@class='text-success']"));
        String successElementText = successElement.getText();

        Assert.assertEquals(successElementText, "Impressive");
    }
}
