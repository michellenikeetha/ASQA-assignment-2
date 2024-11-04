package page_object_model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class BasePage {

    protected WebDriver driver = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public DarazHomePage loadURL(String url) {
        driver.get(url);
        return PageFactory.initElements(driver, DarazHomePage.class);
    }

    public void scrollPage(int x, int y) {
        new Actions(driver).scrollByAmount(x,y).perform();
    }

}
