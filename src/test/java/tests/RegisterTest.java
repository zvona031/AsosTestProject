package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.checkout.CheckoutSignUpPage;
import pages.common.HomePage;
import pages.common.MenClothesPage;
import pages.sign_in.SignInEmailPopupPage;
import pages.sign_in.SignInPasswordPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegisterTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //Opening Google Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void RegisterWithGmail() throws IOException, InterruptedException {


        HomePage homePage = new HomePage(driver);
        homePage.clickOnMen();

        MenClothesPage mensClothesPage = new MenClothesPage(driver);
        Assert.assertTrue(mensClothesPage.isOpened(),"Men clothes page not opened correctly.");
        mensClothesPage.clickAccountButton();
        Thread.sleep(2000);
        mensClothesPage.clickJoinButton();

        CheckoutSignUpPage checkoutPage = new CheckoutSignUpPage(driver);
        Assert.assertTrue(checkoutPage.isOpened(),"Checkout page not opened correctly");
        checkoutPage.clickGoogleSign();

        String mainWindow = driver.getWindowHandle();
        for(String currentWindow: driver.getWindowHandles()){
            //Switching to popup window
            driver.switchTo().window(currentWindow);
            if(!driver.getWindowHandle().equals(mainWindow)){
                SignInEmailPopupPage signInEmailPopupPage = new SignInEmailPopupPage(driver);
                Assert.assertTrue(signInEmailPopupPage.isOpened(),"Sign in email popup page not opened correctly.");
                signInEmailPopupPage.inputEmail("zvona031@gmail.com");//
                signInEmailPopupPage.clickNextButton();
                Thread.sleep(5000);

                SignInPasswordPage signInPasswordPage = new SignInPasswordPage(driver);
                Assert.assertTrue(signInPasswordPage.isOpened(),"Sign in password popup page not opened correctly.");
                signInPasswordPage.inputPassword("dummyPassword");
                Thread.sleep(2000);

                //This test is not finished because the real mail with facebook account is required
                driver.close();
            }
        }
        //Switching back to main window
        driver.switchTo().window(mainWindow);
    }

    @Test
    public void RegisterWithEmail() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.clickOnMen();

        MenClothesPage mensClothesPage = new MenClothesPage(driver);
        Assert.assertTrue(mensClothesPage.isOpened(),"Men clothes page not opened correctly.");
        mensClothesPage.clickAccountButton();
        Thread.sleep(2000);
        mensClothesPage.clickJoinButton();

        CheckoutSignUpPage checkoutPage = new CheckoutSignUpPage(driver);
        Assert.assertTrue(checkoutPage.isOpened(),"Checkout page not opened correctly");
        checkoutPage.inputEmail("d10982808@urhen.com");
        checkoutPage.inputFirstName("TestFristName");
        checkoutPage.inputLastName("TestLastName");
        checkoutPage.inputPassword("testtest123");
        checkoutPage.inputBirthDate();
        checkoutPage.clickJoinButton();
        Thread.sleep(2000);
        //This test is not finished because there is Captcha solver at the end of registration
    }


    @AfterMethod
    public void close(){
        driver.close();
    }
}
