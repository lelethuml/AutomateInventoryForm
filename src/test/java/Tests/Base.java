package Tests;

import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PracticePage;
import Utils.BrowserFactory;
import Utils.TakeScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class Base {

    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.startBrowser("edge", "https://ndosisimplifiedautomation.vercel.app/");

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
    PracticePage practicePage = PageFactory.initElements(driver, PracticePage.class);
    TakeScreenshots takeScreenshots = new TakeScreenshots();



}


