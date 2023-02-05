package org.example.testCases;

import org.example.pages.DashboardPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class LoginTestCase {

    public static void main(String[] args) {

        //Set property of ChromeDriver
        System.setProperty("Webdriver.Chrome.Driver", "C:\\Users\\Tomasz Jędrzejczyk\\Desktop\\repositories\\selenium_page_object_pattern\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/books");

        //Instantiating Login, Home and Dashboard page using initElements()
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);

        homePage.clickLogin();
        loginPage.enterUsername("gunjankaushik");
        loginPage.enterPassword("Password@123");
        loginPage.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dashboard.verifyUser("gunjankaushik");
        dashboard.clickLogout();

        driver.quit();

    }
}