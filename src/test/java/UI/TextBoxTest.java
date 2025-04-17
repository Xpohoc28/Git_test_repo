package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBoxTest {

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

    @Test(description = "Перейти на страницу 'Text Box' , внести валидные значения во все поля ," +
            " нажать на кнопку 'Submit'")
    public void step_01(){
        driver.get("https://demoqa.com/text-box");

        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='userName']"));
        userNameInput.sendKeys("Maxim");

        WebElement userEmailInput = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmailInput.sendKeys("max@yandex.ru");

        WebElement currentAddressTextArea = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddressTextArea.sendKeys("Kursk");

        WebElement permanentAddressTextArea = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddressTextArea.sendKeys("Kursk");

        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", button);
        button.click();

        WebElement userNameOutput = driver.findElement(By.xpath("//p[@id='name']"));
        WebElement userEmailOutput = driver.findElement(By.xpath("//p[@id='email']"));
        WebElement currentAddressOutput = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement permanentAddressOutput = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

        String name = userNameOutput.getText();
        String email = userEmailOutput.getText();
        String currAddress = currentAddressOutput.getText();
        String permAddress = permanentAddressOutput.getText();

        System.out.println("Name : " + name + " , email : " + email
                + " , current address : " + currAddress + " , permanent address : " + permAddress);

//        Assert.assertTrue(name.contains("Kursk"),"Message");
        Assert.assertEquals(email,"Email:max@yandex.ru");
    }

    @Test(description = "Получить title страницы - DemoQA")
    public void step_02(){
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "DEMOQA");
        System.out.println("Title : " + pageTitle);
    }
}