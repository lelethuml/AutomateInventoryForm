##AutomateInventoryForm
An automation project built with Selenium WebDriver and TestNG. It automates the user journey on the Ndosi web application, from login through to completing an inventory form purchase and viewing the invoice.

##What it does
Verifies the homepage loads correctly
Navigates to the login page and logs in using credentials from an Excel file
Verifies the dashboard loads after login
Navigates to the Practice page via the Learn dropdown
Fills out the inventory form (device type, brand, storage, colour, quantity, address)
Selects shipping method, warranty option, and applies a discount code
Confirms the purchase
Views the invoice history

##Design patterns used
Page Object Model (POM) — each page of the web app has its own class with its elements and actions, keeping tests clean and maintainable
Data-driven testing — test data (login credentials, form inputs) is read from an Excel file using Apache POI, so you can change test data without touching the code
Listener pattern — a TestNG listener hooks into ExtentReports to automatically log pass/fail results

##Tech stack
Java 21Programming language
Selenium WebDriver 4.41.0Browser automation
TestNG 7.12.0Test framework
Apache POI 5.4.1Reading test data from Excel
ExtentReports 5.1.2HTML test reports
MavenDependency management

##Test data
Test data is stored in src/test/java/TestData/TestData_080426.xlsx under a sheet called LoginCredentials. The columns are:
email, password, deviceType, brandstoragecolor, quantity, address, shipping, warranty,discount

