package org.example.testCases;

import org.example.pages.Dashboard;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginTestCase {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Set property of ChromeDriver
        System.setProperty("Webdriver.Chrome.Driver", "C:\\Users\\Tomasz Jędrzejczyk\\Desktop\\repositories\\selenium_page_object_pattern\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.get("https://demoqa.com/books");


        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);

        homePage.clickLogin();
        loginPage.enterUsername("gunjankaushik");
        loginPage.enterPassword("Password@123");
        loginPage.clickLogin();
        Thread.sleep(3000);
        dashboard.verifyUser("gunjankaushik");
        dashboard.clickLogout();

        driver.quit();

    }
}