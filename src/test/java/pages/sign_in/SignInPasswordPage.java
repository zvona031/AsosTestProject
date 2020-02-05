package pages.sign_in;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPasswordPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]")
    private WebElement nextButton;

    public SignInPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isOpened(){
        return driver.getTitle().contains("Sign in") || driver.getTitle().contains("Prijava");
    }

    public void inputPassword(String password){
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void clickNextButton(){
        nextButton.click();
    }

}