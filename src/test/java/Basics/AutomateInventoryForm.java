package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class AutomateInventoryForm
{
    WebDriver driver;
@Test
    public void loginAndNavigateToInventoryForm() throws InterruptedException
{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");

        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button")).click(); // login page
        driver.findElement(By.id("login-email")).sendKeys("Dora@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("Letsdoit!");
        driver.findElement(By.id("login-submit")).click();

    // WAIT for navigation to dashboard
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // here we creating an object "wait" of WebDriverWait class and we are passing driver and duration as parameters
    wait.until(ExpectedConditions.urlContains("dashboard"));  //dashboard page

    //Verify that the user is on the dashboard page by URL
    String currentUrl = driver.getCurrentUrl();
    Assert.assertTrue(currentUrl.contains("dashboard"), "User is not on the Dashboard page");

    //Click learn
    driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button")).click();
    Thread.sleep(1000);

    //click Learning materials
    driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]")).click();

    //Verify that the user is on the Web Automation Advance page

    //Click Web Automation Advance
    driver.findElement(By.id("tab-btn-web")).click(); //web automation advance page (Automation category)


    //Click Inventory form requirements dropdown
    driver.findElement(By.xpath("//*[@id=\"assessment-instructions\"]/summary")).click(); //not done

    Thread.sleep(2000);
    //device type dropdown
//    WebElement dropdown = driver.findElement(By.id("deviceType"));
//    Select select = new Select(dropdown);
//    select.selectByVisibleText("Phone");

    // Use the helper method instead of repeating code
    selectDropdownOption("deviceType", "Phone");
    selectDropdownOption("brand", "Apple");


    Thread.sleep(2000);
    //Click on storage dropdown and select 128GB
    WebElement element = driver.findElement(By.cssSelector("#storage-128GB"));
    element.click();
    selectDropdownOption("color", "Blue");
//
//    Thread.sleep(2000);
   driver.findElement(By.id("quantity")).sendKeys("2");
    driver.findElement(By.id("address")).sendKeys("28 Albert str, Marshaltown");

    //Verify the preview section

    //Click Next button
    driver.findElement(By.id("inventory-next-btn")).click();

    //Extras
    //Shipping Method
    WebElement element1 = driver.findElement(By.cssSelector("#shipping-option-express"));
    element1.click();

    //Warranty
    WebElement element2 = driver.findElement(By.cssSelector("#warranty-option-1yr"));
    element2.click();

    //Discount code
    driver.findElement(By.id("discount-code")).sendKeys("10");

    //Verify
Thread.sleep(2000);
    //Click Confirm purchase
    driver.findElement(By.id("purchase-device-btn")).click();

    //Verify order confirmation
    Thread.sleep(2000);
    //Click view invoice button
    driver.findElement(By.id("view-history-btn")).click();

    //Invoice History

}
    public void selectDropdownOption(String dropdownId, String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id(dropdownId)));
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
}

