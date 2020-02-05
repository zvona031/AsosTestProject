package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSignInPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]")
    WebElement heading;

    public CheckoutSignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isOpened(){
        System.out.println(heading.getText());
        return heading.getText().contains("CHECKOUT");
    }
}
