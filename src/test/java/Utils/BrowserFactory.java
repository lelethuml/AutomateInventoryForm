package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver startBrowser(String browserChoice, String url){

        if (browserChoice.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();

    }else
        if (browserChoice.equalsIgnoreCase("Firefox")){
        driver = new FirefoxDriver();
    }else
        if (browserChoice.equalsIgnoreCase("Edge")){
        driver = new EdgeDriver();
    }else
    {
        driver = new InternetExplorerDriver();
    }

        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
//    @Test
//    public void launchBrowser(){
//        startBrowser("edge", "https://ndosisimplifiedautomation.vercel.app/");
//    }

}

