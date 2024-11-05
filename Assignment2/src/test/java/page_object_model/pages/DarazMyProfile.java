package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_object_model.utilities.Log;

public class DarazMyProfile extends BasePage{

    @FindBy(xpath = "//a[contains(text(), 'Manage My Account')]")
    public WebElement manageMyAccount;

    @FindBy(xpath = "//a[contains(text(), 'My Profile')]")
    public WebElement myProfile;

    @FindBy(xpath = "//button[text()='EDIT PROFILE']")
    public WebElement editProfile;

    @FindBy(xpath = "//a[text()='Edit Profile']")
    public WebElement editProfileTitle;

//    @FindBy(xpath = "//span[text()='Month']")
    @FindBy(xpath = "//span[@id='month']")
    public WebElement month;

//    @FindBy(xpath = "//span[text()='Day']")
    @FindBy(xpath = "//span[@id='day']")
    public WebElement day;

//    @FindBy(xpath = "//span[text()='Year']")
    @FindBy(xpath = "//span[@id='year']")
    public WebElement year;

    @FindBy(xpath = "//li[@value='3']")
    public WebElement monthMarch;

    @FindBy(xpath = "//li[@value='17']")
    public WebElement day17;

    @FindBy(xpath = "//li[@value='2001']")
    public WebElement year2001;

    @FindBy(xpath = "//button[text()='SAVE CHANGES']")
    public WebElement saveChanges;

    @FindBy(xpath = "//*[@id='container']/div/div[1]/div[4]/div")
    //@FindBy(xpath = "//div[@data-spm-anchor-id='a2o42.my_profile.1.i1.4a1c2f8973jm1R']")
    public WebElement savedDate;

    public DarazMyProfile(WebDriver driver) {
        super(driver);
        Log.info("Daraz My Profile Page initialized");
    }

    public boolean isManageMyAccountDisplayed() {
        Log.info("Check if ManageMyAccount is Displayed");
        return manageMyAccount.isDisplayed();
    }

    public boolean isMyProfileDisplayed() {
        Log.info("Check if My Profile is Displayed");
        return myProfile.isDisplayed();
    }

    public void clickMyProfile() {
        Log.info("Click My Profile");
        myProfile.click();
    }

    public void clickEditProfile() {
        Log.info("Click Edit Profile");
        editProfile.click();
    }

    public boolean isEditProfileDisplayed() {
        Log.info("Check if Edit Profile is Displayed");
        return editProfileTitle.isDisplayed();
    }

    public void clickMonth() {
        Log.info("Click Month");
        month.click();
        monthMarch.click();
    }

    public void clickDay() throws InterruptedException {
        Log.info("Click Day");
        day.click();
        Thread.sleep(1000);
        day17.click();
    }

    public void clickYear() throws InterruptedException {
        Log.info("Click Year");
        year.click();
        Thread.sleep(1000);
        year2001.click();
    }

    public void saveChanges() {
        Log.info("Save Changes");
        saveChanges.click();
    }

    public String getSavedDate() {
        Log.info("Retrieve saved date");
        return savedDate.getText();
    }

}
