package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    final WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for login button
    @FindBy(id = "login")
    WebElement loginBtn;

    //Method to click login button
    public void clickLogin() {
        loginBtn.click();
    }
}
