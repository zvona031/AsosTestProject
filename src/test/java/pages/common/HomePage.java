package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    private static String PAGE_URL="https://www.asos.com/";

    @FindBy(xpath = "//*[@id=\"chrome-sticky-header\"]/div[1]/div/ul[1]/li[2]")
    WebElement shopMen;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver,this);
    }

    public void clickOnMen() {
        shopMen.click();
    }

}
