# 16.04.2025


## Стажировка "Основы тестирования" 


----

## 2-е практическое занятие по автоматизации тестирования

---

## План занятия

1) Написать структуру `Page Object`

```text
└── src
   ├── main
   │  └── java
   │      ├── browser # Классы конфигурации браузера
   │      │   ├── Browser.java # Инициализация и конфигурация браузера
   │      │   └── Config.java # Получение типа браузера 
   │      └── pages  # Классы с описанием страниц
   │          ├── base # Пакет для "BasePage"
   │          │  └── BasePage # Класс с общими методами для всех страниц
   │          └── demoqa # Классы для страниц DemoQA
   │             ├── CheckBoxPage.java # Локаторы и методы для страницы "Check Box"
   │             ├── DatePickerPage.java # Локаторы и методы для страницы "Date Picker"
   │             └── SelectMenuPage.java # Локаторы и методы для страницы "Select Menu"
   └── test
      └── java
          ├── base # Пакет для "BaseTest"
          │   └── BaseTest.java # Базовый класс для инициализации и завершения тестов
          └── UI  # Классы для тестирования UI (интерфейса веб-сервиса)
              ├── CheckBoxTest.java # Тест для страницы "Check Box"
              ├── DatePickerTest.java # Тест для страницы "Date Picker"
              └── SelectMenuTest.java # Тест для страницы "Select Menu"
``` 

## -- Перерыв --

2) Написать тесты для страниц :

- **Select Menu**
```text
Тесткейс :
Шаг 1:
1) Перейти на страницу

Ожидаемая реакция:
Отображается страница с заголовком "Select Menu"

Шаг 2:
1) В первом выпадающем списке выбрать второе значение

Ожидаемая реакция:
В первом поле с выпадающем списком отображается второе значение
```
- **Date Picker**
```text
Тесткейс :
Шаг 1:
1) Перейти на страницу

Ожидаемая реакция:
Отображается страница с заголовком "Date Picker"

Шаг 2:
1) Нажать на поле с первым календарем
2) В первом календаре выбрать установит дату - 12.03.2024

Ожидаемая реакция:
В первом поле с первым календарем отображается дата - 12.03.2024
```
- **Check Box**
```text
Тесткейс :
Шаг 1:
1) Перейти на страницу

Ожидаемая реакция:
Отображается страница с заголовком "Check Box"

Шаг 2:
1) Отметить чекбокс "Home"
2) Отметить чекбокс "Desktop"

Ожидаемая реакция:
Чекбокс "Desktop" отмечен
```

3) Изучить вкладки `Console` и `Sources` в `Devtools`

4) Запустить группу тестов , сформировать отчет с результатами тестов

**Д/З** :

1) Описать `Page` классы для тестов : `TextBoxTest` и `RadioButtonTest`
2) Выполнить рефакторинг `TextBoxTest` и `RadioButtonTest`

## Полезные ссылки:
- https://demoqa.com/ - сайт для тренировки написания `UI` тестов с различными формами
- https://googlechromelabs.github.io/chrome-for-testing/ - страница для скачивания драйверов для Chrome
- https://github.com/mozilla/geckodriver/releases - страница для скачивания `Geckodriver` (Firefox)
- https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver - страница для скачивания `Edge driver`
- https://mvnrepository.com/ - Репозиторий с зависимостями
- https://maven.apache.org/download.cgi - Загрузка `Maven`
- https://www.oracle.com/java/technologies/downloads/ - Загрузка `JDK`
- https://github.com/MaxainNN/Liga_internship - Проект с тестами UI и полезными материалами
- https://learngitbranching.js.org/?locale=ru_RU - тренировка `git`

## Шпаргалка по автоматизации тестирования на Java + Selenium

## Содержание
1. [Полезные ссылки](#полезные-ссылки)
2. [Шпаргалка по Selenium WebDriver](#шпаргалка-по-selenium-webdriver)
3. [Шпаргалка по Java для тестирования](#шпаргалка-по-java-для-тестирования)
4. [Шпаргалка по XPath](#шпаргалка-по-xpath)
5. [Полезные советы](#полезные-советы)
6. [Полезные статьи](#полезные-статьи)

## Полезные ссылки
- [DemoQA](https://demoqa.com/) - сайт для тренировки написания `UI` тестов с различными формами
- [Chrome for Testing](https://googlechromelabs.github.io/chrome-for-testing/) - страница для скачивания драйверов для Chrome
- [Geckodriver](https://github.com/mozilla/geckodriver/releases) - страница для скачивания `Geckodriver` (Firefox)
- [Edge WebDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver) - страница для скачивания `Edge driver`
- [Maven Repository](https://mvnrepository.com/) - Репозиторий с зависимостями
- [Maven Download](https://maven.apache.org/download.cgi) - Загрузка `Maven`
- [JDK Download](https://www.oracle.com/java/technologies/downloads/) - Загрузка `JDK`
- [Liga Internship](https://github.com/MaxainNN/Liga_internship) - Проект с тестами UI и полезными материалами
- [Learn Git Branching](https://learngitbranching.js.org/?locale=ru_RU) - тренировка `git`

## Шпаргалка по XPath

### Основы XPath
```java
// Поиск по ID
By.xpath("//*[@id='elementId']")

// Поиск по классу
By.xpath("//*[@class='className']")

// Поиск по имени
By.xpath("//*[@name='elementName']")

// Поиск по тегу
By.xpath("//div")
By.xpath("//input")
By.xpath("//button")
```

### Атрибуты и их комбинации
```java
// Поиск по нескольким атрибутам
By.xpath("//input[@type='text' and @name='username']")

// Поиск по частичному совпадению атрибута
By.xpath("//*[contains(@class, 'partial-class')]")

// Поиск по началу значения атрибута
By.xpath("//*[starts-with(@id, 'prefix')]")

// Поиск по окончанию значения атрибута
By.xpath("//*[ends-with(@id, 'suffix')]")
```

### Поиск по тексту
```java
// Точное совпадение текста
By.xpath("//*[text()='Точный текст']")

// Частичное совпадение текста
By.xpath("//*[contains(text(), 'Часть текста')]")

// Поиск по тексту с учетом регистра
By.xpath("//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='текст']")
```

### Навигация по DOM
```java
// Поиск родительского элемента
By.xpath("//span/parent::div")

// Поиск дочерних элементов
By.xpath("//div/child::span")

// Поиск предшествующих элементов
By.xpath("//input/preceding::label")

// Поиск следующих элементов
By.xpath("//label/following::input")

// Поиск предков
By.xpath("//span/ancestor::div")

// Поиск потомков
By.xpath("//div/descendant::span")
```

### Индексы и позиции
```java
// Выбор первого элемента
By.xpath("(//div)[1]")

// Выбор последнего элемента
By.xpath("(//div)[last()]")

// Выбор предпоследнего элемента
By.xpath("(//div)[last()-1]")

// Выбор элементов по позиции
By.xpath("//div[position() > 1 and position() < 5]")
```

### Примеры сложных XPath
```java
// Поиск кнопки внутри div с определенным классом
By.xpath("//div[contains(@class, 'container')]//button[text()='Submit']")

// Поиск input после label с определенным текстом
By.xpath("//label[contains(text(), 'Username')]/following::input[1]")

// Поиск элемента с определенным атрибутом внутри родителя с другим атрибутом
By.xpath("//div[@class='parent']//input[@type='text']")

// Поиск элемента, который содержит определенный текст и имеет определенный класс
By.xpath("//*[contains(text(), 'Search') and contains(@class, 'button')]")
```

### Оптимизация XPath
```java
// Плохо: абсолютный путь
By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div[5]/input")

// Хорошо: относительный путь
By.xpath("//input[@id='search']")

// Плохо: использование индексов
By.xpath("(//div)[3]")

// Хорошо: использование уникальных атрибутов
By.xpath("//div[@id='unique-id']")

// Плохо: длинные цепочки
By.xpath("//div/div/div/div/span")

// Хорошо: прямое указание элемента
By.xpath("//span[@class='target']")
```

### Примеры из реальной практики
```java
// Поиск чекбокса по тексту метки
By.xpath("//input[@type='checkbox'][following-sibling::span[text()='Remember me']]")

// Поиск кнопки в модальном окне
By.xpath("//div[contains(@class, 'modal')]//button[text()='Confirm']")

// Поиск элемента в таблице
By.xpath("//table//tr[td[text()='John']]/td[2]")

// Поиск элемента в выпадающем списке
By.xpath("//select[@id='country']/option[text()='Russia']")

// Поиск элемента в меню
By.xpath("//nav//a[contains(@class, 'menu-item') and text()='Products']")
```

## Шпаргалка по Selenium WebDriver

### Основные методы WebDriver
```java
// Открытие URL
driver.get("https://example.com");
driver.navigate().to("https://example.com");

// Навигация
driver.navigate().back();    // Назад
driver.navigate().forward(); // Вперед
driver.navigate().refresh(); // Обновить страницу

// Управление окном
driver.manage().window().maximize(); // Максимизировать окно
driver.manage().window().minimize(); // Минимизировать окно
driver.manage().window().fullscreen(); // Полноэкранный режим

// Получение информации о странице
driver.getTitle();      // Заголовок страницы
driver.getCurrentUrl(); // Текущий URL
driver.getPageSource(); // Исходный код страницы
```

### Поиск элементов
```java
// Поиск по ID
driver.findElement(By.id("elementId"));

// Поиск по имени
driver.findElement(By.name("elementName"));

// Поиск по классу
driver.findElement(By.className("className"));

// Поиск по тегу
driver.findElement(By.tagName("tagName"));

// Поиск по XPath
driver.findElement(By.xpath("//div[@class='example']"));

// Поиск по CSS селектору
driver.findElement(By.cssSelector(".example"));

// Поиск по тексту ссылки
driver.findElement(By.linkText("Link Text"));
driver.findElement(By.partialLinkText("Partial Link Text"));

// Поиск нескольких элементов
List<WebElement> elements = driver.findElements(By.xpath("//div"));
```

### Работа с элементами
```java
// Клик по элементу
element.click();

// Ввод текста
element.sendKeys("Text to input");

// Очистка поля
element.clear();

// Получение текста
String text = element.getText();

// Получение атрибута
String value = element.getAttribute("attributeName");

// Проверка видимости
boolean isVisible = element.isDisplayed();

// Проверка активности
boolean isEnabled = element.isEnabled();

// Проверка выбранности (для чекбоксов и радио-кнопок)
boolean isSelected = element.isSelected();

// Получение размеров и координат
element.getSize();      // Размеры элемента
element.getLocation();  // Координаты элемента
element.getRect();      // Размеры и координаты
```

### Ожидания (Waits)
```java
// Явное ожидание
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));

// Часто используемые условия ожидания
ExpectedConditions.visibilityOfElementLocated()  // Элемент виден
ExpectedConditions.presenceOfElementLocated()    // Элемент присутствует в DOM
ExpectedConditions.elementToBeClickable()        // Элемент кликабелен
ExpectedConditions.textToBePresentInElement()    // Текст присутствует в элементе
ExpectedConditions.titleContains()               // Заголовок содержит текст

// Неявное ожидание
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

### Работа с выпадающими списками (Select)
```java
Select select = new Select(driver.findElement(By.id("dropdown")));

// Выбор по видимому тексту
select.selectByVisibleText("Option Text");

// Выбор по значению
select.selectByValue("optionValue");

// Выбор по индексу
select.selectByIndex(0);

// Получение выбранного значения
select.getFirstSelectedOption().getText();

// Получение всех опций
List<WebElement> options = select.getOptions();
```

### Работа с фреймами
```java
// Переключение на фрейм по индексу
driver.switchTo().frame(0);

// Переключение на фрейм по имени или ID
driver.switchTo().frame("frameName");

// Переключение на фрейм по элементу
driver.switchTo().frame(driver.findElement(By.id("frameId")));

// Возврат к основному контексту
driver.switchTo().defaultContent();
```

### Работа с JavaScript
```java
JavascriptExecutor js = (JavascriptExecutor) driver;

// Выполнение JavaScript
js.executeScript("alert('Hello!');");

// Прокрутка страницы
js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

// Клик через JavaScript
js.executeScript("arguments[0].click();", element);
```

### Работа с файлами
```java
// Загрузка файла
element.sendKeys("C:/path/to/file.txt");

// Скачивание файла
// Настройка профиля Chrome для скачивания
ChromeOptions options = new ChromeOptions();
options.addArguments("download.default_directory=C:/Downloads");
```

## Шпаргалка по Java для тестирования

### Основы Java
```java
// Объявление переменных
int number = 10;
String text = "Hello";
boolean flag = true;

// Массивы
int[] numbers = {1, 2, 3};
String[] words = new String[5];

// Списки
List<String> list = new ArrayList<>();
list.add("item");
list.get(0);
list.size();

// Условные операторы
if (condition) {
    // код
} else if (anotherCondition) {
    // код
} else {
    // код
}

// Циклы
for (int i = 0; i < 10; i++) {
    // код
}

for (String item : list) {
    // код
}

while (condition) {
    // код
}

// Методы
public void methodName() {
    // код
}

public String methodWithReturn() {
    return "value";
}

public void methodWithParams(String param1, int param2) {
    // код
}
```

### Аннотации TestNG
```java
@Test
public void testMethod() {
    // код теста
}

@BeforeMethod
public void setUp() {
    // код перед каждым тестом
}

@AfterMethod
public void tearDown() {
    // код после каждого теста
}

@BeforeClass
public void beforeClass() {
    // код перед классом
}

@AfterClass
public void afterClass() {
    // код после класса
}

@BeforeSuite
public void beforeSuite() {
    // код перед набором тестов
}

@AfterSuite
public void afterSuite() {
    // код после набора тестов
}
```

### Page Object Pattern
```java
public class LoginPage {
    private WebDriver driver;
    
    // Локаторы
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
```

### Работа с исключениями
```java
try {
    // код, который может вызвать исключение
} catch (NoSuchElementException e) {
    // обработка исключения
    System.out.println("Элемент не найден: " + e.getMessage());
} catch (TimeoutException e) {
    // обработка другого исключения
} finally {
    // код, который выполнится в любом случае
}
```

### Логирование
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClass {
    private static final Logger logger = LoggerFactory.getLogger(TestClass.class);
    
    public void testMethod() {
        logger.info("Начало теста");
        logger.debug("Отладочная информация");
        logger.error("Ошибка", exception);
    }
}
```

### Работа с датами
```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Текущая дата
LocalDate today = LocalDate.now();

// Форматирование даты
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String formattedDate = today.format(formatter);

// Парсинг даты
LocalDate date = LocalDate.parse("12/03/2024", formatter);

// Операции с датами
LocalDate tomorrow = today.plusDays(1);
LocalDate lastMonth = today.minusMonths(1);
```

## Полезные советы

1. **XPath советы**:
   - Используйте относительные пути вместо абсолютных
   - Избегайте использования индексов в XPath
   - Используйте contains() для частичного совпадения текста
   - Комбинируйте атрибуты для более точного поиска

2. **Оптимизация тестов**:
   - Используйте явные ожидания вместо неявных
   - Минимизируйте количество поисков элементов
   - Используйте кэширование элементов
   - Избегайте Thread.sleep()

3. **Отладка**:
   - Используйте точки останова в IDE
   - Добавляйте логирование
   - Делайте скриншоты при ошибках
   - Используйте DevTools для анализа элементов

4. **Поддержка кода**:
   - Следуйте принципам DRY (Don't Repeat Yourself)
   - Используйте константы для часто используемых значений
   - Комментируйте сложные участки кода
   - Создавайте вспомогательные методы для часто используемых операций

## Полезные статьи:

- https://habr.com/ru/companies/intec_balance/articles/884482/ - статья о `Devtools`
- https://habr.com/ru/articles/753332/ - Статья о `xpath`

