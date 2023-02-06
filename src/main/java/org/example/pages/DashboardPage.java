package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public DashboardPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locators for the page title and the logout button
    @FindBy(xpath = "//div[@class=\"main-header\"]")
    WebElement heading;

    @FindBy(id = "submit")
    WebElement logoutBtn;

    @FindBy(xpath = "//*[@id=\"userName-value\"]")
    WebElement loggedUser;


    //Method to capture the page heading
    public String getHeading() {
        return heading.getText();
    }

    //Method to click on Logout button
    public void clickLogout() {
        logoutBtn.click();
    }

    //Method to check if logged user is correct one
    public void verifyUser(String userName){
        if(loggedUser.getText().equalsIgnoreCase(userName))
            System.out.println("Correct username: " + loggedUser.getText());

        else
            System.out.println("Incorrect username: " + loggedUser.getText());
    }
}
