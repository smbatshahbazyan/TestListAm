package helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MyActions {
    public static Actions myActions(WebDriver driver){
        return new Actions(driver);
    }
}
