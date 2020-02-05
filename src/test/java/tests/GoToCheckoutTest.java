package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.checkout.CheckoutSignInPage;
import pages.common.HomePage;
import pages.common.MenClothesPage;
import pages.common.ProductPage;
import pages.common.SearchResultPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoToCheckoutTest {

    WebDriver driver;


    @BeforeMethod
    public void setup() {
        //Opening Google Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void ShoesCheckout() throws IOException, InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.clickOnMen();

        MenClothesPage mensClothesPage = new MenClothesPage(driver);
        Assert.assertTrue(mensClothesPage.isOpened(),"Men clothes page not opened correctly.");
        mensClothesPage.submitShoesSearch();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.isOpened(),"Result page not opened correctly.");
        Assert.assertTrue(searchResultPage.shoesFound(),"Wanted shoes not found on page.");
        searchResultPage.clickOnShoes();

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.areShoesOpened(),"Wanted shoes page not opened correctly.");
        productPage.selectShoesSize();
        productPage.clickAddToBag();
        Thread.sleep(1000);
        productPage.clickBag();

        Thread.sleep(2000);

        productPage.clickCheckout();

        CheckoutSignInPage checkoutSignInPage = new CheckoutSignInPage(driver);
        Assert.assertTrue(checkoutSignInPage.isOpened(),"Checkout signIn page not opened correctly");
    }

    @Test
    public void HoodieCheckout() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.clickOnMen();

        MenClothesPage mensClothesPage = new MenClothesPage(driver);
        Assert.assertTrue(mensClothesPage.isOpened(),"Men clothes page not opened correctly.");
        mensClothesPage.submitHoodieSearch();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.isOpened(),"Result page not opened correctly.");
        Assert.assertTrue(searchResultPage.hoodieFound(),"Wanted shoes not found on page.");
        searchResultPage.clickOnHoodie();

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isHoodieOpened(),"Wanted hoodie page not opened correctly.");
        productPage.selectHoodieSize();
        productPage.clickAddToBag();
        Thread.sleep(1000);
        productPage.clickBag();

        Thread.sleep(2000);

        productPage.clickCheckout();

        CheckoutSignInPage checkoutSignInPage = new CheckoutSignInPage(driver);
        Assert.assertTrue(checkoutSignInPage.isOpened(),"Checkout signIn page not opened correctly");
    }

    @AfterMethod
    public void close(){
        driver.close();
    }
}
