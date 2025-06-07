package com.stv.factory.factorypages;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class MainPage extends BasePage {
    private final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);
    @FindBy(id = "lnkTopLevelMenu_5076198")
    private WebElement swimCategory;
    @FindBy(id = "lnkTopLevelMenu_5074969")
    private WebElement cycleCategory;
    @FindBy(xpath = "/html/body/div[6]/div[1]/div/div/div/header/div[1]/div/div/div/div[1]/a")
    private WebElement homeButton;
    private final By allowAllButton = By.cssSelector("button#onetrust-accept-btn-handler");

    public void clickOnHomePage()
    {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
    }
    public void clickOnCycleCategory()
    {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(cycleCategory));
        cycleCategory.click();
    }
    public void clickOnSwimCategory()
    {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(swimCategory));
        swimCategory.click();
    }
    public MainPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnAllowCookiesIfVisible() {
        WebElement allowCookiesButton = getDriver().findElement(allowAllButton);

        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(allowCookiesButton));
        if (allowCookiesButton.isDisplayed())
            allowCookiesButton.click();
    }
}
