package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.MenClothesPage;
import pages.common.ProductPage;
import pages.common.SearchResultPage;
import pages.common.HomePage;
import pages.common.SavedItemsPage;

import java.util.concurrent.TimeUnit;

public class SavingProductTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //Opening Google Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void saveShoes () throws InterruptedException {

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
        productPage.saveProduct();
    }

    @Test
    public void checkIfShoesAdded() throws InterruptedException {
        saveShoes();

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.areShoesOpened(),"Wanted shoes page not opened correctly.");
        productPage.clickSavedItemsButton();

        SavedItemsPage savedItemsPage = new SavedItemsPage(driver);
        Assert.assertTrue(savedItemsPage.isOpened(), "Wanted saved items page not opened correctly.");
        Assert.assertTrue(savedItemsPage.containsShoes(),"Wanted shoes not saved properly.");
    }


    @Test
    public void removeShoesFromFavorites() throws InterruptedException {
        saveShoes();
        checkIfShoesAdded();
        SavedItemsPage savedItemsPage = new SavedItemsPage(driver);
        Assert.assertTrue(savedItemsPage.isOpened(), "Wanted saved items page not opened correctly.");
        savedItemsPage.removeItem();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void close(){
        driver.close();
    }
}
