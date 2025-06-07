package com.stv.factory.factorypages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//*[@id=\"login\"]/span[1]")
    private WebElement emailError;

    @FindBy(xpath = "//*[@id=\"Login_Password-error\"]")
    private WebElement passError;

    @FindBy(xpath = "//*[@id=\"Login_EmailAddress-error\"]")
    private WebElement logError;


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
    public void writeEmail(String login)
    {
        emailField.sendKeys(login);
    }
    public void writePassword(String password)
    {
        passwordField.sendKeys(password);
    }
    public String getPasswordType()
    {
        return passwordField.getAttribute("type");
    }
    public boolean invalidEmailShown()
    {
        return emailError.isDisplayed();
    }
    public boolean noPasswordShown()
    {
        return passError.isDisplayed();
    }
    public boolean noEmailShown()
    {
        return logError.isDisplayed();
    }
    public void clickSignIn(WebDriverWait wait){
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("LoginButton")));
        signInButton.click();
    }
    public void clickLoginField(WebDriverWait wait){
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("Login_EmailAddress")));
        passwordField.click();
    }
    public void clickPasswordField(WebDriverWait wait){
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(
                loginButton));
        passwordField.click();
    }
}