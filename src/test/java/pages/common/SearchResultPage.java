package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"product-13173563\"]/a")
    WebElement shoes;

    @FindBy(xpath = "//*[@id=\"product-12906328\"]/a")
    WebElement hoodie;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isOpened() {
        return driver.getTitle().contains("Search:");
    }

    public boolean shoesFound() {
        return shoes.getAttribute("href").contains("https://www.asos.com/adidas-originals/adidas-originals-deerupt-trainers-in-triple-white/prd/13173563?clr=white&colourWayId=16452146&SearchQuery=deerupt");
    }

    public boolean hoodieFound(){
        return hoodie.getAttribute("href").contains("https://www.asos.com/adidas-originals/adidas-originals-essentials-hoodie-with-small-logo-in-khaki/prd/12906328?clr=khaki&colourWayId=16424371&SearchQuery=adidas%20originals%20essentials%20hoodie");
    }

    public void clickOnShoes(){
        shoes.click();
    }

    public void clickOnHoodie() { hoodie.click();}
}
