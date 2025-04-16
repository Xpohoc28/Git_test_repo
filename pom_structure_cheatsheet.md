
# 🧱 Шпаргалка по структуре проекта с использованием Maven (POM)

---

## 📁 Стандартная структура Maven-проекта

```
project-name/
├── pom.xml                  # Главный конфигурационный файл Maven
├── src/
│   ├── main/
│   │   └── java/            # Основной исходный код (если пишем библиотеку или приложение)
│   └── test/
│       └── java/            # Тесты (JUnit, TestNG, Selenium)
│
└── target/                  # Скомпилированные файлы (генерируется автоматически)
```

---

## 📦 pom.xml — что внутри

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>          <!-- Уникальный идентификатор проекта -->
    <artifactId>qa-project</artifactId>     <!-- Название проекта -->
    <version>1.0-SNAPSHOT</version>         <!-- Версия -->

    <dependencies>
        <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.18.1</version>
        </dependency>

        <!-- TestNG -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.9.0</version>
            <scope>test</scope>
        </dependency>

        <!-- WebDriverManager (управление драйверами) -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.7.0</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include> <!-- какие классы запускать как тесты -->
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```

---

## 💡 Полезные команды Maven

| Что делаем                 | Команда |
|---------------------------|---------|
| Собрать проект            | `mvn clean install` |
| Запустить тесты           | `mvn test` |
| Удалить `target/`         | `mvn clean` |
| Проверить зависимости     | `mvn dependency:tree` |
| Обновить зависимости      | `mvn versions:display-dependency-updates` |

---

## 🔧 Частые проблемы

- ❗ Если `chromedriver` не запускается — проверь WebDriverManager.
- ❗ Если `test` не запускаются — проверь имя файла (должно заканчиваться на `Test.java`).
- ❗ `target/` не создаётся — значит сборка (`install`) не прошла.

---

## 📌 Рекомендации

- Держи `pom.xml` в порядке — он основа всей магии.
- Используй `WebDriverManager`, чтобы не париться с драйверами.
- Тестовые классы всегда пиши в `src/test/java`.

