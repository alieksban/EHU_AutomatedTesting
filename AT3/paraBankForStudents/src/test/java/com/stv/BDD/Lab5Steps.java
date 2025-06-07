package com.stv.BDD;

import com.stv.factory.factorytests.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.*;

public class Lab5Steps extends BaseTest{
    private final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);
    @Given("I am on the site's main page")
    public void iAmOnMainPage() {
        setUpMainPage();
    }
    @When("I click on Cycle Category")
    public void iClickOnCycleCategory()
    {
        mainPage.clickOnCycleCategory();
    }
    @When("I click on Swim Category")
    public void iClickOnSwimCategory()
    {
        mainPage.clickOnSwimCategory();
    }
    @When("I click on New In filter category")
    public void iClickOnNewInCategory()
    {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("DesktopSortOptions_recent")));
        driver.findElement(By.id("DesktopSortOptions_recent")).click();
    }
    @When("I click on Home Page")
    public void iClickHomePage()
    {
        mainPage.clickOnHomePage();
    }
    @When("I click on Allow Cookies button")
    public void iClickOnAllowCookies()
    {
        mainPage.clickOnAllowCookiesIfVisible();
    }
    @Then("The New In filter is turned on")
    public void recentFilterIsOn()
    {
        assertEquals(driver.findElement(By.id("DesktopSortOptions_recent")).getCssValue("background-color"),"rgb(0, 51, 73)");
    }
}
