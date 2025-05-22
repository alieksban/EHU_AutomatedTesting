package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        driver = TestFactory.getDriver();
        loginPage = TestFactory.createLoginPage(driver);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}