package Tests;

import Utils.ReadFromFile;
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
}
