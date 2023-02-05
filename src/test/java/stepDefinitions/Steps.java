package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.example.managers.PageObjectManager;
import org.example.pages.DashboardPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver driver;
    HomePage homePage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    PageObjectManager pageObjectManager;

    @Given("^user is on Home Page$")
    public void user_is_on_Home_Page(){
        System.setProperty("Webdriver.Chrome.Driver", "C:\\Users\\Tomasz Jędrzejczyk\\Desktop\\repositories\\selenium_page_object_pattern\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.navigateTo_HomePage();
    }


    @When("^user clicks on login button$")
    public void userClicksOnLoginButton() {
        homePage.clickLogin();
    }

    @And("^user enter userName$")
    public void userEnterUserName() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.enterUserName("gunjankaushik");
    }

    @And("^user enter password$")
    public void userEnterPassword() {
        loginPage.enterPassword("Password@123");
    }

    @And("^user logs in$")
    public void userLogsIn() {
        loginPage.clickLogin();
    }

    @And("^correct user is logged in$")
    public void correctUserIsLoggedIn() {
        dashboardPage = pageObjectManager.getDashboardPage();
        dashboardPage.verifyUser("gunjankaushik");
        driver.quit();
    }
}
