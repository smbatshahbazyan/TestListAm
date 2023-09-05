package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyWait {
    private static final int timeWait = 7;
    private static WebDriverWait explicitWaitByElement;
    public static WebElement waitToBeClickable(WebDriver driver, WebElement webElement) {
        explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(timeWait));
        return explicitWaitByElement.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public static WebElement waitToBeClickable(WebDriver driver, By by) {
        explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(timeWait));
        return  explicitWaitByElement.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static WebElement waitVisibilityOf(WebDriver driver, WebElement webElement) {
        explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(timeWait));
        return explicitWaitByElement.until(ExpectedConditions.visibilityOf(webElement));
    }
    public static void waitPresenceOfAllElementLocatedBy(WebDriver driver, By by) {
        explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(timeWait));
        explicitWaitByElement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
