package Tests;

import Utils.ReadFromFile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class NdosiWebTests extends Base{

    // Verify homepage is displayed
    public void verifyHomePageIsDisplayedTest() {
        homePage.verifyHomePageIsDisplayed();
        takeScreenshots.takeSnapshots(driver, "HomePageScreenshot");
    }

    @Test (dependsOnMethods = "verifyHomePageIsDisplayedTest")
    public void clickLoginButton(){
        homePage.clickLoginButton();
       // takeScreenshots.takeSnapshots(driver, "");
    }

    @Test (dependsOnMethods = "clickLoginButton")
    public void verifyLoginPageIsDisplayed(){
        loginPage.verifyLoginPageIsDisplayed();
        takeScreenshots.takeSnapshots(driver, "LoginPageScreenshot");
    }

    @Test (dependsOnMethods = "clickLoginButton")
    public void userEnterEmail() {
        loginPage.enterEmail(ReadFromFile.email);
    }
    @Test (dependsOnMethods = "userEnterEmail")
    public void userEnterPassword() {
        loginPage.enterPassword(ReadFromFile.password);
        takeScreenshots.takeSnapshots(driver, "LoginPageFilledOutScreenshot");
    }
    @Test (dependsOnMethods = "userEnterPassword")
    public void userClicksLoginButton() {
        loginPage.clickSubmit();
    }


    @Test (dependsOnMethods = "userClicksLoginButton")
    public void verifyDashboardPageIsDisplayed(){
        dashboardPage.verifyDashboardPageIsDisplayed();
        takeScreenshots.takeSnapshots(driver, "DAshboardPageScreenshot");
    }

    @Test (dependsOnMethods = "verifyDashboardPageIsDisplayed")
    public void clickLearnButton() {
        dashboardPage.clickLearnButton();

    }

    @Test (dependsOnMethods = "clickLearnButton")
    public void clickLearningMaterialsButton(){
        dashboardPage.clickLearningMaterialsButton();
        takeScreenshots.takeSnapshots(driver, "LearnDropdownExpandedScreenshot");
    }

    @Test (dependsOnMethods = "clickLearningMaterialsButton")
    public void clickWebAutoAdvanceButton(){
        practicePage.clickWebAutoAdvanceButton();
        takeScreenshots.takeSnapshots(driver, "PracticePageScreenshot");

    }

    // This test fills out the inventory form after clicking the "Web Auto Advance" button. It waits for the form to load, interacts with various form elements to select device type, brand, storage, color, quantity, and address. It also includes commented-out assertions to verify the preview text before clicking the "Next" button to proceed.
    @Test(dependsOnMethods = "clickWebAutoAdvanceButton")
    public void fillInventoryForm() {

        //  WAIT FOR THE FORM TO LOAD BEFORE INTERACTING WITH IT
        practicePage.waitForFormToLoad();

        practicePage.selectDeviceType(ReadFromFile.deviceType);
        practicePage.selectBrand(ReadFromFile.brand);
        practicePage.selectStorage128(); // still hardcoded for now
        practicePage.selectColor(ReadFromFile.color);
        practicePage.enterQuantity(ReadFromFile.quantity);
        practicePage.enterAddress(ReadFromFile.address);
        practicePage.clickNext();
        practicePage.waitForExtrasSection();
        practicePage.shippingMethod(ReadFromFile.shipping);
        practicePage.warrantyOption(ReadFromFile.warranty);
        practicePage.setDiscountCode(ReadFromFile.discount);
        takeScreenshots.takeSnapshots(driver, "InventoryFormFilledOutScreenshot");

    }

    //close the browser after the test is done

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
