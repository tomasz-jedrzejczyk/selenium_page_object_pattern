package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args){

        //Set property of ChromeDriver
        // Optional. If not specified, WebDriver searches the PATH for chromedriver
        System.setProperty("Webdriver.Chrome.Driver", "C:\\Users\\Tomasz Jędrzejczyk\\Desktop\\repositories\\selenium_page_object_pattern\\chromedriver\\chromedriver.exe");

        //Instantiating chrome driver
        WebDriver driver = new ChromeDriver();

        //Opening web application
        driver.get("https://demoqa.com/books");

        //Implement wait for 10 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Locating the Login button and clicking on it
        driver.findElement(By.id("login")).click();

        //Locating the username & password and passing the credentials
        driver.findElement(By.id("userName")).sendKeys("gunjankaushik");
        driver.findElement(By.id("password")).sendKeys("Password@123");

        //Click on the login button
        driver.findElement(By.id("login")).click();

        //Print the web page heading
        System.out.println("The page title is : " +driver.findElement(By.xpath("//*[@id=\"app\"]//div[@class=\"main-header\"]")).getText());

        //Click on Logout button
        driver.findElement(By.id("submit")).click();

        //Close driver instance
        driver.quit();
    }
}