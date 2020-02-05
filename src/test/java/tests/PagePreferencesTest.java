package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.MenClothesPage;
import pages.common.HomePage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PagePreferencesTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //Opening Google Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void ChangeCountryAndCurrency() throws IOException, InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.clickOnMen();

        MenClothesPage mensClothesPage = new MenClothesPage(driver);
        Assert.assertTrue(mensClothesPage.isOpened(),"Men clothes page not opened correctly.");
        mensClothesPage.acceptCookies();
        mensClothesPage.clickCountryButton();
        Thread.sleep(1000);
        mensClothesPage.findCountrySelector();
        mensClothesPage.selectCountry();
        Thread.sleep(1000);
        mensClothesPage.findCurrencySelector();
        mensClothesPage.selectCurrency();
        Thread.sleep(1000);
        mensClothesPage.findUpdatePreferencesButton();
        Thread.sleep(1000);
        mensClothesPage.clickUpdatePreferencesButton();
        Thread.sleep(1000);
        mensClothesPage.findCountryImage();
        Assert.assertTrue(mensClothesPage.isCountryZimbabwe(),"Preferences not updated correctly");
        //After changing every preference, I need to find next button,
        //because there were problems with finding all buttons at the beginning of the test

    }

    @AfterMethod
    public void close(){
        driver.close();
    }
}
