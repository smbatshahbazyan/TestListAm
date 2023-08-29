package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyWait {
   public static int timeWait = 7;
    public static WebDriverWait explicitWaitByElement;
    public static WebElement waitToBeClickable(WebDriver driver, WebElement webElement) {
        explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(timeWait));
        explicitWaitByElement.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }
    public static WebElement waitToBeClickable(WebDriver driver, By by) {
        explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(timeWait));
        explicitWaitByElement.until(ExpectedConditions.elementToBeClickable(by));
        return driver.findElement(by);
    }
    public static WebElement waitVisibilityOf(WebDriver driver, WebElement webElement) {
        explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(timeWait));
        explicitWaitByElement.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
    public static void waitPresenceOfAllElementLocatedBy(WebDriver driver, By by) {
        explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(timeWait));
        explicitWaitByElement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
