package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MenClothesPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"chrome-search\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"myAccountDropdown\"]/button")
    private WebElement accountButton;

    @FindBy(xpath = "//*[@id=\"myaccount-dropdown\"]/div/div/div[1]/div/span/a[2]")
    private WebElement joinButton;

    @FindBy(xpath = "//*[@id=\"chrome-header\"]/header/div[1]/div/div/button")
    private WebElement cookiesAcceptanceButton;

    private WebElement countryImage;
    private  WebElement updatePreferencesButton;
    private WebElement countryButton;
    private Select countrySelector;
    private Select currencySelector;

    public MenClothesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        countryButton = driver.findElement(By.xpath("/html/body/div[2]/header/div[3]/div/ul/li[3]/div/button"));
    }

    public boolean isOpened() {
        return driver.getTitle().contains("Men's Clothes");
    }

    public boolean isCountryZimbabwe() {
        return countryImage.getAttribute("alt").contentEquals("Zimbabwe");
    }

    public void findCountryImage() {
        //Element couldn't be found by xpath
        countryImage = driver.findElement(By.cssSelector("#chrome-header > header > div._3FDhT9y.VTBBowk > div > ul > li:nth-child(3) > div > button > img"));
    }

    public void submitShoesSearch(){
        searchInput.clear();
        searchInput.sendKeys("deerupt");
        searchInput.sendKeys(Keys.ENTER);
    }

    public void submitHoodieSearch(){
        searchInput.clear();
        searchInput.sendKeys("Adidas Originals Essentials Hoodie");
        searchInput.sendKeys(Keys.ENTER);
    }

    public void findCountrySelector(){
        countrySelector = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
    }

    public void findCurrencySelector(){
        currencySelector = new Select(driver.findElement(By.xpath("//*[@id=\"currency\"]")));
    }

    public void findUpdatePreferencesButton(){
        //Element couldn't be found by xpath
        updatePreferencesButton = driver.findElement(By.cssSelector("#chrome-header > header > div._1cCqZXW > div.e-NFhL6 > div > section > form > div._38wf6A6 > button"));
    }

    public void acceptCookies(){
        cookiesAcceptanceButton.click();
    }

    public void clickAccountButton(){
        accountButton.click();
    }

    public void clickJoinButton(){
        joinButton.click();
    }

    public void clickCountryButton() { countryButton.click();}

    public void selectCountry() { countrySelector.selectByVisibleText("Zimbabwe");}

    public void selectCurrency() { currencySelector.selectByIndex(1);}

    public void clickUpdatePreferencesButton(){ updatePreferencesButton.click();}
}
