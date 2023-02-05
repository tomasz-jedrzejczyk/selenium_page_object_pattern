package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for username field
    @FindBy(id = "userName")
    WebElement userName;

    //Locator for password field
    @FindBy(id = "password")
    WebElement password;

    //Locator for login button
    @FindBy(id = "login")
    WebElement loginBtn;

    //Method to enter username
    public void enterUsername(String user) {
        userName.sendKeys(user);
    }

    //Method to enter password
    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    //Method to click on Login button
    public void clickLogin() {
        loginBtn.click();
    }
}
