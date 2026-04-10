package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DashboardPage {

    WebDriver driver;

    //constructor
    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }

    // verify that the dashboard page is displayed by checking the URL contains "dashboard"
    public void verifyDashboardPageIsDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("dashboard"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"),
                "User is not on the Dashboard page");
    }

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button")
    WebElement learnButton;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]")
    WebElement learningMaterialsButton;

    public void clickLearnButton(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(learnButton));
        learnButton.click();
    }

    //had to add explicit wait as it fails because the element is not available yet

    public void clickLearningMaterialsButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(learnButton));
        learnButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(learningMaterialsButton));
        learningMaterialsButton.click();
    }


}
