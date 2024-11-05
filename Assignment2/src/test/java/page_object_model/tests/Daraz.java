package page_object_model.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object_model.pages.*;
import page_object_model.utilities.Utilities;

public class Daraz extends Utilities {

    @Test
    public void searchRings() throws InterruptedException {

        BasePage baseURL = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = baseURL.loadURL("https://www.daraz.lk/");

        homePage.typeTextToSearchBox("rings");
        homePage.visibleText = "rings";

        DarazRingsPage ringsPage = homePage.clickButton();
        ringsPage.scrollPage(0, 2500);

        Assert.assertTrue(ringsPage.checkBoxCubic.isDisplayed(), "Cubic Zirconia checkbox is not displayed.");

        ringsPage.clickCheckBoxCubic();
        Thread.sleep(5000);

        //Assert.assertTrue(ringsPage.checkBoxCubic.isSelected(), "Cubic checkbox is not selected.");
    }

    @Test
    public void searchWatches() throws InterruptedException {
        BasePage baseURL = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = baseURL.loadURL("https://www.daraz.lk/");

        homePage.typeTextToSearchBox("watches");
        homePage.visibleText = "watches";

        DarazWatchesPage watchesPage = homePage.clickButton();
        Assert.assertTrue(watchesPage.list.isDisplayed(), "List icon is not displayed on the Watches page.");

        watchesPage.clickOnList();
        Thread.sleep(5000);

       // Assert.assertTrue(watchesPage.list.isDisplayed(), "Watch list link is not displayed.");
    }

    @Test
    public void searchPhones() throws InterruptedException {

        BasePage baseURL = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = baseURL.loadURL("https://www.daraz.lk/");

        homePage.typeTextToSearchBox("phones");
        homePage.visibleText = "phones";

        DarazPhonesPage phonesPage = homePage.clickButton();
        phonesPage.clickDarazPhonesLink();
        phonesPage.clickSortSelector();
        phonesPage.clickPriceLow();
        Thread.sleep(3000);

        Assert.assertTrue(phonesPage.SortSelector.isDisplayed(), "Sort selector is not displayed.");
    }

    @Test
    public void login() throws InterruptedException {

        BasePage baseURL = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = baseURL.loadURL("https://www.daraz.lk/");

        DarazLoginPage loginPage = homePage.clickLogin();
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.isLogInButtonDisplayed(), "Login button is not displayed.");

        loginPage.enterUsername("michellenikeetha@gmail.com");
        loginPage.enterPassword("12345678m@");
        loginPage.clickLogInButton();
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.isMyAccountButtonDisplayed(), "My account button is not displayed.");

        loginPage.clickMyAccountButton();
        loginPage.clickMyOrdersButton();
        Thread.sleep(3000);

    }

}
