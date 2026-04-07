package Tests;

import Utils.ReadFromFile;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class NdosiWebTests extends Base{

    // Verify homepage is displayed
    public void verifyHomePageIsDisplayedTest() {
        homePage.verifyHomePageIsDisplayed();
    }

    @Test (dependsOnMethods = "verifyHomePageIsDisplayedTest")
    public void clickLoginButton(){
        homePage.clickLoginButton();
    }

    @Test (dependsOnMethods = "clickLoginButton")
    public void verifyLoginPageIsDisplayed(){
        loginPage.verifyLoginPageIsDisplayed();
    }

    @Test (dependsOnMethods = "clickLoginButton")
    public void userEnterEmail() {
        loginPage.enterEmail(ReadFromFile.email);
    }
    @Test (dependsOnMethods = "userEnterEmail")
    public void userEnterPassword() {
        loginPage.enterPassword(ReadFromFile.password);
    }
    @Test (dependsOnMethods = "userEnterPassword")
    public void userClicksLoginButton() {
        loginPage.clickSubmit();
    }


    @Test (dependsOnMethods = "userClicksLoginButton")
    public void verifyDashboardPageIsDisplayed(){
        dashboardPage.verifyDashboardPageIsDisplayed();
    }

    @Test (dependsOnMethods = "verifyDashboardPageIsDisplayed")
    public void clickLearnButton() {
        dashboardPage.clickLearnButton();

    }
    @Test (dependsOnMethods = "clickLearnButton")
    public void clickLearningMaterialsButton(){
        dashboardPage.clickLearningMaterialsButton();
    }

    @Test (dependsOnMethods = "clickLearningMaterialsButton")
    public void clickWebAutoAdvanceButton(){
        practicePage.clickWebAutoAdvanceButton();
    }

    // This test fills out the inventory form after clicking the "Web Auto Advance" button. It waits for the form to load, interacts with various form elements to select device type, brand, storage, color, quantity, and address. It also includes commented-out assertions to verify the preview text before clicking the "Next" button to proceed.
    @Test(dependsOnMethods = "clickWebAutoAdvanceButton")
    public void fillInventoryForm() {

        //  WAIT FOR THE FORM TO LOAD BEFORE INTERACTING WITH IT
        practicePage.waitForFormToLoad();

        practicePage.selectDeviceType("Phone");
        practicePage.selectBrand("Apple");
        practicePage.selectStorage128();
        practicePage.selectColor("Black");
        practicePage.enterQuantity("2");
        practicePage.enterAddress("28 Albert str");

        // VERIFY PREVIEW
        //String preview = practicePage.getPreviewText();
        //Assert.assertTrue(preview.contains("Apple"));
       // Assert.assertTrue(preview.contains("128GB"));

        practicePage.clickNext();

        practicePage.shippingMethod("Express (+R25)");
        practicePage.warrantyOption("1 Year (+R50)");
        practicePage.setDiscountCode("10");
        practicePage.clickPurchaseButton();
        practicePage.clickViewHistoryButton();
        //practicePage.closeInvoiceHistoryButton();



    }

}
