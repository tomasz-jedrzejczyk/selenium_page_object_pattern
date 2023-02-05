package org.example.testCases;

import org.example.pages.DashboardPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args){

        //Set property of ChromeDriver
        System.setProperty("Webdriver.Chrome.Driver", "C:\\Users\\Tomasz Jędrzejczyk\\Desktop\\repositories\\selenium_page_object_pattern\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");

        //Creating object of home page
        HomePage home = new HomePage(driver);

        //Creating object of Login page
        LoginPage login = new LoginPage(driver);

        //Creating object of Dashboard
        DashboardPage dashboard = new DashboardPage(driver);

        //Click on Login button
        home.clickLogin();

        //Enter username & password
        login.enterUsername("gunjankaushik");
        login.enterPassword("Password@123");

        //Click on login button
        login.clickLogin();

        //wait 10 seconds until page will load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Capture the page heading and print on console
        System.out.println("The page heading is --- " + dashboard.getHeading());

        //Click on Logout button
        dashboard.clickLogout();

        //Close browser instance
        driver.quit();
    }
}