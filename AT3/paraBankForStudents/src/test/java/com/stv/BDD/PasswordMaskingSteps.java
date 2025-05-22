package com.stv.BDD;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.*;

public class PasswordMaskingSteps {
    private WebDriver driver;
    private WebElement passwordField;
    private WebElement loginField;
    private final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);

    @Given("I am on the site's login page")
    public void i_am_on_the_site_s_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.wiggle.com/login");
    }

    @When("I click on Allow All button")
    public void i_click() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("onetrust-accept-btn-handler")));
        button.click();
    }

    @When("I click on the password input field")
    public void i_click_on_the_password_input_field() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("Login_Password")));
        passwordField.click();
    }

    @When("I click on the login input field")
    public void i_click_on_the_login_input_field() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("Login_EmailAddress")));
        passwordField.click();
    }

    @When("I click on the sign in button")
    public void i_click_on_the_sign_in_button() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("LoginButton")));
        signInButton.click();
    }


    @When("I type {string} into the login field")
    public void i_type_into_the_login_field(String login) {
        loginField = driver.findElement(By.id("Login_EmailAddress"));
        loginField.sendKeys(login);
    }

    @When("I type {string} into the password field")
    public void i_type_into_the_password_field(String password) {
        passwordField = driver.findElement(By.id("Login_Password"));
        passwordField.sendKeys(password);
    }

    @Then("the characters should appear as masked")
    public void the_characters_should_appear_as_masked() {
        String fieldType = passwordField.getAttribute("type");
        assertEquals("password", fieldType);
        driver.quit();
    }

    @Then("I should see {string}")
    public void i_should_see(String string){
        switch (string)
        {
            case "invalid email":
                WebElement emailError = driver.findElement(By.xpath("//*[@id=\"login\"]/span[1]"));
                assertTrue("Error message should be displayed", emailError.isDisplayed());
                break;
            case "no password":
                WebElement passError = driver.findElement(By.xpath("//*[@id=\"Login_Password-error\"]"));
                assertTrue("Error message should be displayed", passError.isDisplayed());
                break;
            case "no email":
                WebElement logError = driver.findElement(By.xpath("//*[@id=\"Login_EmailAddress-error\"]"));
                assertTrue("Error message should be displayed", logError.isDisplayed());
                break;
        }
    }
}