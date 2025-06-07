package com.stv.BDD;


import com.stv.factory.factorytests.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.*;

public class CucumberSteps extends BaseTest {
    private final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);

    @Given("I am on the site's login page")
    public void i_am_on_the_site_s_login_page() {
        setUp();
    }

    @When("I click on Allow All button")
    public void i_click() {
        loginPage.clickOnAllowCookiesIfVisible();
    }

    @When("I click on the password input field")
    public void i_click_on_the_password_input_field() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        loginPage.clickPasswordField(wait);
    }

    @When("I click on the login input field")
    public void i_click_on_the_login_input_field() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        loginPage.clickLoginField(wait);
    }

    @When("I click on the sign in button")
    public void i_click_on_the_sign_in_button() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        loginPage.clickSignIn(wait);
    }

    @When("I type {string} into the login field")
    public void i_type_into_the_login_field(String login) {
        loginPage.writeEmail(login);
    }

    @When("I type {string} into the password field")
    public void i_type_into_the_password_field(String password) {
        loginPage.writePassword(password);
    }

    @Then("the characters should appear as masked")
    public void the_characters_should_appear_as_masked() {
        String fieldType = loginPage.getPasswordType();
        assertEquals("password", fieldType);
        driver.quit();
    }

    @Then("I should see {string}")
    public void i_should_see(String string){
        switch (string)
        {
            case "invalid email":
                assertTrue("Error message should be displayed", loginPage.invalidEmailShown());
                break;
            case "no password":
                assertTrue("Error message should be displayed", loginPage.noPasswordShown());
                break;
            case "no email":
                assertTrue("Error message should be displayed", loginPage.noEmailShown());
                break;
        }
        driver.quit();
    }
}
