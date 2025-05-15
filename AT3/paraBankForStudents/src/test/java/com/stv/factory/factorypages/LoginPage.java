package com.stv.factory.factorypages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends BasePage {

    private final By allowAllButton = By.cssSelector("button#onetrust-accept-btn-handler");

    // Locators using @FindBy and @FindBys
    @FindBy(id = "Login_EmailAddress")
    private WebElement emailField;

    @FindBy(id = "Login_Password")
    private WebElement passwordField;

    @FindBy(id = "LoginButton")
    private WebElement loginButton;

    @FindBy(id = "Login_Password-error")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Page services
    public LoginPage enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public boolean isPasswordMasked() {
        return "password".equals(passwordField.getAttribute("type"));
    }

    public LoginPage attemptLogin() {
        loginButton.click();
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
    public void clickOnAllowCookiesIfVisible() {
        WebElement allowCookiesButton = getDriver().findElement(allowAllButton);

        if (allowCookiesButton.isDisplayed())
            allowCookiesButton.click();
    }
}