package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DarazRingsPage extends BasePage{

    @FindBy(xpath = "//span[text()='Cubic Zirconia']")
    //@FindBy(xpath = "//input[class='ant-checkbox-input']")
    private WebElement checkBoxCubic;

    public DarazRingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckBoxCubic() {
        checkBoxCubic.click();
    }

}
