package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticePage {
    WebDriver driver;

    @FindBy(id = "tab-btn-web")
    WebElement webAutoAdvanceButton;

    //constructor
    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWebAutoAdvanceButton() {
        webAutoAdvanceButton.click();
    }


}
