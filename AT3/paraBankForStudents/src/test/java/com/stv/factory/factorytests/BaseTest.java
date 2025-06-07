package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    @BeforeMethod
    public void setUp() {
        driver = TestFactory.getDriver();
        loginPage = TestFactory.createLoginPage(driver);
    }
    public void setUpMainPage(){
        driver = TestFactory.getDriver();
        mainPage = TestFactory.createMainPage(driver);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}