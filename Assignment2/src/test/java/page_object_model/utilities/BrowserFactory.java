package page_object_model.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    static BrowserFactory browserFactory;

    ThreadLocal<WebDriver> threadLocal = ThreadLocal.withInitial(()-> {
        WebDriver driver = null;
        String browserType = System.getProperty("browser", "chrome");
        switch (browserType) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                new RuntimeException("Invalid browser type: " + browserType);
        }
        driver.manage().window().maximize();
        return driver;
    });

    private BrowserFactory() {}

    public static BrowserFactory getBrowserFactory() {
        if (browserFactory == null) {
            browserFactory = new BrowserFactory();
        }
        return browserFactory;
    }

    public WebDriver getDriver() {
        return threadLocal.get();
    }
}
