package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    //verify that e are on the login page
    @FindBy(id = "login-heading")
    WebElement verifyLoginHeading;


    //locate the email field
    @FindBy(id = "login-email")
    WebElement emailField;

    //locate the password field
    @FindBy(id = "login-password")
    WebElement passwordField;

    //Login button
    @FindBy(id="login-submit")
    WebElement submitButton;

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Now create methods to perform actions on the login page

    public void verifyLoginPageIsDisplayed() {
        verifyLoginHeading.isDisplayed();
    }
    public void enterEmail(String email) {                                                                               //Initially on "Sendkeys" we had an exact email, we have chnages that because we want to make the method reuasble. Now we can pass any email as an argument when we call this method to the NdosiTests class in a method userEnterEmailTest
        emailField.sendKeys(email);
    }
    public void enterPassword(String password) {                                                                          // same as in email
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        submitButton.click();
    }


}
