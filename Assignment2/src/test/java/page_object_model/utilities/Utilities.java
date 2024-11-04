package page_object_model.utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Utilities {

    protected BrowserFactory browserFactory;

    @BeforeTest
    public void initialize_browser(){
        browserFactory = BrowserFactory.getBrowserFactory();
    }

    @AfterTest
    public void close_browser(){
        browserFactory.getDriver().quit();
    }
}
