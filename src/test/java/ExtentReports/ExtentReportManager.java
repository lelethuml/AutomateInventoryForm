package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    private static final String reportDir = System.getProperty("user.dir") + "/Reports/NdosiAutomationReport.html";

    private  static ExtentReports extentReports;  // holds the test results and generates the report

    private  static ExtentSparkReporter extentSparkReporter; // responsible for creating the HTML report with nice UI and formatting

    public static ExtentReports extentReports(){
        extentReports = new ExtentReports(); // Create an instance of ExtentReports\

        extentSparkReporter = new ExtentSparkReporter(new File(reportDir));

        // Attach the reporter to the main ExtentReports object
        // Without this, nothing will be written to the HTML file
        extentReports.attachReporter(extentSparkReporter);


        // Set the title that appears in the browser tab when you open the report
        extentSparkReporter.config().setDocumentTitle("Extent Report");

        // Optional: Change the look of the report
        extentSparkReporter.config().setTheme(Theme.DARK);

        // Set the big title/name shown at the top of the report
        extentSparkReporter.config().setReportName("Ndosi Automation");

        // Add useful system/environment information to the report
        // This helps when debugging (e.g., was it run on Windows or Mac?)
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Execution Machine", System.getProperty("user.name"));


        // Return the fully configured object so the listener can use it
        return extentReports;


    }
}
