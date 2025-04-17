package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonTest {

    public WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY,"eager");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(description = "Перейти на страницу 'Radio Button' и отметить радиобатон 'Yes'")
    public void step_01(){
        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadioButton = driver.findElement(By.xpath("//input[@type='radio']" +
                "/following-sibling::label[contains(., 'Yes')]"));

        yesRadioButton.click();

        WebElement successElement = driver.findElement(By.xpath("//span[@class='text-success']"));
        String successElementText = successElement.getText();

        Assert.assertEquals(successElementText,"Yes");
    }

    @Test(description = "Отметить радиобатон 'Impressive'")
    public void step_02(){
        WebElement impressiveRadioButton = driver.findElement(By.xpath("//input[@type='radio']" +
                "/following-sibling::label[contains(., 'Impressive')]"));

        impressiveRadioButton.click();

        WebElement successElement = driver.findElement(By.xpath("//span[@class='text-success']"));
        String successElementText = successElement.getText();

        Assert.assertEquals(successElementText,"Impressive");
    }
}