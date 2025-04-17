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
- https://demoqa.com/ - сайт для тренировки написания `UI` тестов с различными формами (Используется в проекте)
- https://googlechromelabs.github.io/chrome-for-testing/ - страница для скачивания драйверов для Chrome
- https://github.com/mozilla/geckodriver/releases- страница для скачивания `Geckodriver` (Firefox)
- https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver?form=MA13LH - страница для скачивания `Edge driver`
- https://mvnrepository.com/ - Репозиторий с зависимостями
- https://maven.apache.org/download.cgi - Загрузка `Maven`
- https://www.oracle.com/java/technologies/downloads/ - Загрузка `JDK`

---

- https://github.com/MaxainNN/Liga_internship - Проект с тестами UI и полезными материалами
- https://learngitbranching.js.org/?locale=ru_RU - тренировка `git`

## Полезные статьи:

- https://habr.com/ru/companies/intec_balance/articles/884482/ - статья о `Devtools`
- https://habr.com/ru/articles/753332/ - Статья о `xpath`

