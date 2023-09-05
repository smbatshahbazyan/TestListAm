package components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseComponent {
    protected WebElement superElement;

    public BaseComponent(WebElement superElement) {
        this.superElement = superElement;
        PageFactory.initElements(superElement, this);
    }
}
