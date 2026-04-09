package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticePage extends BasePage{
    //WebDriver driver;

    @FindBy(id = "tab-btn-web")
    WebElement webAutoAdvanceButton;

    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;

    @FindBy(id = "brand")
    WebElement brandDropdown;

    @FindBy(css = "#storage-128GB")
    WebElement storage128;

    @FindBy(id = "color")
    WebElement colorDropdown;

    @FindBy(id = "quantity")
    WebElement quantityField;

    @FindBy(id = "address")
    WebElement addressField;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    // Preview
    //@FindBy(id = "previewCard")
    //WebElement previewCard;

    @FindBy(id="shipping-option-express")
    WebElement shippingExpress;

    @FindBy(id="warranty-option-1yr")
    WebElement warranty1yr;

    @FindBy(id="discount-code")
    WebElement discountCode;

    @FindBy(id="purchase-device-btn")
    WebElement purchaseButton;

    @FindBy(id="view-history-btn")
    WebElement viewHistoryButton;

    @FindBy(css = "button[id^='view-invoice-']")
    WebElement viewInvoiceButton;

   // @FindBy(id="close-invoice-history-btn")
    //WebElement closeInvoiceHistoryButton;

    //constructor
    public PracticePage(WebDriver driver) {
        super(driver); //  passes driver to BasePage
        PageFactory.initElements(driver, this);
    }

    public void waitForFormToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(deviceTypeDropdown));
    }

    public void clickWebAutoAdvanceButton() {
        webAutoAdvanceButton.click();
    }

    public void selectDeviceType(String value) {
        selectDropdownByText(deviceTypeDropdown, value);
    }

    public void selectBrand(String value) {
        new Select(brandDropdown).selectByVisibleText(value);
    }

    public void selectStorage128() {
        storage128.click();
    }

    public void selectColor(String value) {
        new Select(colorDropdown).selectByVisibleText(value);
    }

    public void enterQuantity(String qty) {
        quantityField.clear();
        quantityField.sendKeys(qty);
    }

    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

//    public String getPreviewText() {
//        return previewCard.getText();
//    }

    public void clickNext() {
        waitForClickability(nextButton);
        nextButton.click();
    }
    public void waitForExtrasSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(shippingExpress));
    }

    public void shippingMethod(String method) {
        waitForClickability(shippingExpress);
        shippingExpress.click();
    }

    public void warrantyOption(String option) {
            warranty1yr.click();
    }
    public void setDiscountCode(String code) {
        discountCode.sendKeys(code);
    }

    public void clickPurchaseButton() {
        purchaseButton.click();
    }

    // ✅ UPDATED METHOD WITH WAIT
    public void clickViewHistoryButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(viewHistoryButton));
        viewHistoryButton.click();
    }
    public void viewInvoiceHistory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(viewInvoiceButton));
        viewInvoiceButton.click();
    }

//    public void waitForButtonVisibility() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(viewHistoryButton));
//    }

//    public void closeInvoiceHistoryButton(){
//        closeInvoiceHistoryButton.click();
//    }






}
