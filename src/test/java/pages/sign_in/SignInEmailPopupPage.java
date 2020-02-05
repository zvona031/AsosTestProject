package pages.sign_in;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInEmailPopupPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"headingText\"]/span")
    private WebElement heading;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/span/span")
    private WebElement nextButton;

    public SignInEmailPopupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isOpened(){
        return heading.getText().contains("Prijava") || heading.getText().contains("Sign in");
    }

    public void inputEmail(String email){
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void clickNextButton(){
        nextButton.click();
    }
}
