
# 🧪 Шпаргалка по автотестам на Selenium + Git + XPath

---

## 📍 Структура автотеста на Java + Selenium + TestNG

```java
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ExampleTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sampleTest() {
        driver.get("https://example.com");
        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));
        element.sendKeys("Test");
        WebElement button = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }
}
```

---

## 📜 XPath — часто используемые выражения

| Что нужно найти | XPath |
|-----------------|-------|
| По ID | `//*[@id='userName']` |
| По классу | `//*[@class='btn btn-primary']` |
| По тексту | `//*[text()='Submit']` |
| Частичное совпадение текста | `//*[contains(text(),'Sub')]` |
| По атрибуту | `//input[@placeholder='Email']` |
| Родитель → потомок | `//div[@class='container']//input` |
| Первый элемент | `(//input)[1]` |
| Последний элемент | `(//div)[last()]` |

---

## 🧠 JavaScriptExecutor в Selenium

```java
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView();", element);
```

📌 Нужен, если элемент не видно на экране, и `click()` не срабатывает.

---

## 📁 Полезные команды Git

| Что делаем | Команда |
|------------|---------|
| Клонируем репозиторий | `git clone <ссылка>` |
| Проверить статус | `git status` |
| Добавить файл | `git add <имя_файла>` |
| Добавить всё | `git add .` |
| Сделать коммит | `git commit -m "сообщение"` |
| Отправить изменения | `git push` |
| Получить изменения | `git pull` |
| Посмотреть историю | `git log` |

---

## ✅ Assert в TestNG

```java
Assert.assertEquals(actual, expected);
Assert.assertTrue(condition);
Assert.assertFalse(condition);
Assert.assertNotNull(object);
```

---

## 🛠️ Полезные методы Selenium

```java
driver.get("https://site.com"); // открыть сайт
driver.getTitle();              // получить заголовок страницы
driver.findElement(By.id("...")).click(); // клик по элементу
driver.findElement(By.name("...")).sendKeys("текст"); // ввод текста
driver.navigate().back();      // назад
driver.navigate().refresh();   // обновить
```

---

## 🤔 Добавить или нет основы Java?

Если тебе тяжело с синтаксисом — можно добавить короткий раздел с:
- типами переменных (`int`, `String`, `boolean`)
- циклами (`for`, `while`)
- условиями (`if`, `else`)
- методами и классами

Но если пока всё понятно — лучше не перегружать 💡

---

## ✍️ Советы перед экзаменом

- Подготовь проект заранее (чистый шаблон с `@BeforeClass`, `@AfterClass`, примером `@Test`)
- Сделай шпаргалку открытой в соседней вкладке или в блокноте
- Оставь себе шаблоны XPath, Assert, Git
- Лучше потренироваться 1–2 раза написать тест с нуля по заданию

Удачи! Ты справишься 💪
