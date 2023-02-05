package org.example.testCases;

import org.example.pages.DashboardPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class Main {

    public static void main(String[] args) {

        //Set property of ChromeDriver
        System.setProperty("Webdriver.Chrome.Driver", "C:\\Users\\Tomasz Jędrzejczyk\\Desktop\\repositories\\selenium_page_object_pattern\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");

        //Instantiating Login, Home and Dashboard page using initElements()
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);

        //Click on Login button
        homePage.clickLogin();

        //Enter username & password
        loginPage.enterUsername("gunjankaushik");
        loginPage.enterPassword("Password@123");

        //Click on login button
        loginPage.clickLogin();

        //wait 10 seconds until page will load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Capture the page heading and print on console
        System.out.println("Page heading is: "+ dashboard.getHeading());

        //Verify if logged on user is correct
        dashboard.verifyUser("gunjankaushik");

        //Click on Logout button
        dashboard.clickLogout();

        //Close browser instance
        driver.quit();
    }
}