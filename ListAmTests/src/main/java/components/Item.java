package components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Item extends BaseComponent {
    public Item(WebElement superElement) {
        super(superElement);
    }

    @FindBy(xpath = "//a[contains(@href,'item')]//div[@class='p']")
    private WebElement priceAndCurrency;
    @FindBy(xpath = "//a[contains(@href,'item')]//div[@class='l']")
    private WebElement title;
    @FindBy(xpath = "//a[contains(@href,'item')]//div[@class='at']")
    private WebElement location;
    @FindBy(xpath = "//a[contains(@href,'item')]//div[@class='at']")
    private WebElement currency;

    public int getPrice() {
        return Integer.parseInt(priceAndCurrency.getText().replaceAll("\\D", ""));
    }

    public String getTitle() {
        return title.getText();
    }

    public String getLocation() {
        String[] locationSplit = location.getText().split(",");
        return locationSplit[0];
    }

    public String getCurrency() {
        String[] currencySplit = priceAndCurrency.getText().split(" ");
        return currencySplit[1];
    }
}
