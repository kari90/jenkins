package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.objects.BasePage;

import java.io.IOException;

public class TestBase extends BasePage {

    @BeforeMethod
    public void initialize() throws IOException {
//        DOMConfigurator.configure("src/main/resources/log4j2.xml");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        SelenideLogger.addListener("name", new LogEventListener() {
            @Override
            public void afterEvent(LogEvent logEvent) {
            }

            @Override
            public void beforeEvent(LogEvent logEvent) {
                log().info(logEvent);
            }
        });
        WebDriverRunner.addListener(new listeners.DriverEventListener());
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
        Configuration.holdBrowserOpen = false;
        Configuration.reportsFolder = "allure-results";
        Selenide.clearBrowserCookies();
        System.setProperty("file.encoding", "UTF-8");
    }

    @AfterMethod
    public void tearDown() {
    }
}