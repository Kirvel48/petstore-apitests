
## Содержание:

- Технологии и инструменты
- Запуск тестов из терминала
- Сборка в Jenkins
- Пример Allure-отчета
- Уведомления в Telegram

--- 


## Технологии и инструменты:

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/Selenium.svg" width="50" height="50"  alt="Selenium"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
</p>

---
## Запуск web-тестов из терминала
Команда для запуска тестов локально: 
```
gradle clean test
```
Команда для запуска тестов удаленно в Selenoid:
```agsl
gradle clean test -Dselenoid_url="selenoid.autotests.cloud/wd/hub" -Dbrowser_size="1920х1080" -Dbrowser="chrome"
```

## Сборка в [Jenkins](https://jenkins.autotests.cloud/job/wikiTests/)
Для запуска необходимо перейти в Build with Parameters и нажать Build.
<img src=images/Jenkins.jpg>

---

## Пример Allure-отчета
Основная страница отчета:
<img src=images/AllureStart.jpg>
Страница с шагами и подробной информацией о результате каждого кейса
<img src=images/AllureSteps.jpg>

---

## Уведомления в Telegram
Информация о результатах проходжения тестов поступает в Telegram через специального бота

<img src=images/TelegramNot.jpg>