package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;

public class DriverEventListener implements WebDriverEventListener {

    private static Logger logger = LogManager.getLogger(DriverEventListener.class);

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        logger.info("Trying to accept alert");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        logger.info("Alert was accepted");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        logger.info("Alert was dismissed");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        logger.info("Trying to dismiss alert");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {
        logger.info("Trying to navigate to:" + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver webDriver) {
        logger.info("Navigated to: " + url);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        logger.info("Trying to navigate back");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        logger.info("Navigated back");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        logger.info("Trying to navigate forward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        logger.info("Navigated forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        logger.info("Trying to refresh page");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        logger.info("Refreshed page");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Trying to find element with locator " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Found element with locator " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Trying to click on element");
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Clicked on element");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        if (charSequences == null) {
            logger.info("Trying to clear field with location " + webElement.getLocation());
        } else {
            logger.info("Trying to type text " + Arrays.toString(charSequences));
        }
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        if (charSequences == null) {
            logger.info("Cleared field with location " + webElement.getLocation());
        } else {
            logger.info("Typed text " + Arrays.toString(charSequences));
        }
    }

    @Override
    public void beforeScript(String script, WebDriver webDriver) {
        logger.info("Trying to execute script: " + script);
    }

    @Override
    public void afterScript(String script, WebDriver webDriver) {
        logger.info("Executed script");
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver webDriver) {
        logger.info("Trying to switch to window " + windowName);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver webDriver) {
        logger.info("Switched window " + windowName);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        logger.info("Trying to get screenshot");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        logger.info("Done screenshot");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        logger.info("Trying to get text for WebElement");
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        logger.info("Taken text of WebElement. Text wast " + s);
    }
}
