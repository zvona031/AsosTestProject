package pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutSignUpPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"signup-google\"]/div/div[2]")
    private WebElement googleButton;

    @FindBy(xpath = "//*[@id=\"Email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"FirstName\"]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[@id=\"LastName\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@id=\"Password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"register\"]")
    private WebElement joinButton;

    private Select birthDaySelect;

    private Select birthMonthSelect;

    private Select birthYearSelect;

    public CheckoutSignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        birthDaySelect = new Select(driver.findElement(By.xpath("//*[@id=\"BirthDay\"]")));
        birthMonthSelect = new Select(driver.findElement(By.xpath("//*[@id=\"BirthMonth\"]")));
        birthYearSelect = new Select(driver.findElement(By.xpath("//*[@id=\"BirthYear\"]")));
    }

    public boolean isOpened(){
        return driver.getTitle().contains("Join ASOS");
    }

    public void clickGoogleSign(){
        googleButton.click();
    }

    public void inputEmail(String email){
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void inputFirstName(String firstName){
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
    }

    public void inputPassword(String password){
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void inputBirthDate(){
        birthMonthSelect.selectByIndex(3);
        birthDaySelect.selectByIndex(3);
        birthYearSelect.selectByIndex(30);
    }

    public void clickJoinButton(){
        joinButton.click();
    }
}
