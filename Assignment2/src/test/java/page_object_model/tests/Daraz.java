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
}
