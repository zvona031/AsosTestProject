package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedItemsPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"saved-lists-app\"]/main/div/div/section/ol/li")
    WebElement shoes;

    @FindBy(xpath = "//*[@id=\"saved-lists-app\"]/main/div/div/section/ol/li/div/div/div/button[1]")
    WebElement removeShoesButton;

    public SavedItemsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isOpened() {
        return driver.getTitle().contains("Saved Items");
    }

    public boolean containsShoes() {
        return shoes.getAttribute("innerText").contains("adidas Originals Deerupt trainers");
    }

    public void removeItem() {
        removeShoesButton.click();

    }
}