package page_object_model.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_object_model.pages.*;
import page_object_model.utilities.ExcelUtil;
import page_object_model.utilities.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Test(priority = 1)
    public void login() throws InterruptedException {

        BasePage baseURL = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = baseURL.loadURL("https://www.daraz.lk/");

        DarazLoginPage loginPage = homePage.clickLogin();
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.isLogInButtonDisplayed(), "Login button is not displayed.");

        loginPage.enterUsername("michellenikeetha@gmail.com");
        loginPage.enterPassword("12345678m@");
        DarazNavigation navigation = loginPage.clickLogInButton();
        Thread.sleep(5000);

        Assert.assertTrue(navigation.isMyAccountButtonDisplayed(), "My account button is not displayed.");

        navigation.clickMyAccountButton();
        navigation.clickMyOrdersButton();
        Thread.sleep(3000);

    }

    @Test(dependsOnMethods = "login", priority = 2)
    public void myProfile() throws InterruptedException {
        DarazNavigation navigation = PageFactory.initElements(browserFactory.getDriver(), DarazNavigation.class);

        Assert.assertTrue(navigation.isMyAccountButtonDisplayed(), "My account button is not displayed.");

        Thread.sleep(3000);
        navigation.clickMyAccountButton();
        DarazMyProfile myProfile = navigation.clickManageAccountButton();
        Thread.sleep(3000);

        Assert.assertTrue(myProfile.isManageMyAccountDisplayed(), "Manage My account title is not displayed.");

        myProfile.clickMyProfile();
        Thread.sleep(3000);

        Assert.assertTrue(myProfile.isMyProfileDisplayed(), "My profile title is not displayed.");

        myProfile.clickEditProfile();
        Thread.sleep(3000);

        Assert.assertTrue(myProfile.isEditProfileDisplayed(), "Edit profile title is not displayed.");

        myProfile.clickMonth();
        Thread.sleep(1000);
        myProfile.clickDay();
        myProfile.clickYear();
        Thread.sleep(3000);

        myProfile.saveChanges();
        Thread.sleep(3000);

        String expectedDate = "2001-03-17";
        String actualDate = myProfile.getSavedDate();
        Assert.assertEquals(actualDate, expectedDate, "The saved date is not as expected.");

    }

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() throws IOException {
        List<Object[]> loginData = ExcelUtil.getLoginData();
        return loginData.toArray(new Object[0][0]);
    }

    @Test(dataProvider = "loginData")
    public void loginWithDataProvider(String username, String password, String expectedResult) throws InterruptedException {

        BasePage baseURL = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        DarazHomePage homePage = baseURL.loadURL("https://www.daraz.lk/");

        DarazLoginPage loginPage = homePage.clickLogin();
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.isLogInButtonDisplayed(), "Login button is not displayed.");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        DarazNavigation navigation = loginPage.clickLogInButton();
        Thread.sleep(5000);

        boolean isLoginSuccessful = navigation.isMyAccountButtonDisplayed();

        if (expectedResult.equals("Success")) {
            Assert.assertTrue(isLoginSuccessful, "Expected login to succeed, but it failed.");

            navigation.clickLogoutButton();
            Thread.sleep(3000);

            Assert.assertTrue(homePage.isAnonLoginVisible(), "Login button is not displayed.");
        } else {
            Assert.assertFalse(isLoginSuccessful, "Expected login to fail, but it succeeded.");
        }
    }


}
