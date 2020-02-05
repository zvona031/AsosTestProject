package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"product-add\"]/div/a")
    WebElement addToBagButton;

    @FindBy(xpath = "//*[@id=\"miniBagDropdown\"]/a/span[2]")
    WebElement bagButton;

    @FindBy(xpath = "//*[@id=\"minibag-dropdown\"]/div/div/div[3]/div/div[3]/div[2]/a/span")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"product-save\"]/div/button")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"chrome-sticky-header\"]/div[1]/div/ul[2]/li[2]/a")
    WebElement savedItemsButton;


    Select selector;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        selector = new Select(driver.findElement(By.xpath("//*[@id=\"main-size-select-0\"]")));
    }

    public boolean areShoesOpened(){
        return driver.getTitle().contains("adidas Originals Deerupt trainers");
    }

    public boolean isHoodieOpened(){
        return driver.getTitle().contains("adidas Originals essentials hoodie");
    }

    public void clickAddToBag(){
        addToBagButton.click();
    }

    public void selectShoesSize() {
        selector.selectByIndex(5);
    }

    public void selectHoodieSize() {
        selector.selectByIndex(5);
    }

    public void saveProduct() { saveButton.click(); }

    public void clickSavedItemsButton() { savedItemsButton.click();}

    public void clickBag() {
        bagButton.click();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

}
