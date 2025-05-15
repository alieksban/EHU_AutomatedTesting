package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginPage;
import org.openqa.selenium.WebDriver;
import com.stv.framework.core.drivers.MyDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestFactory {

    public static WebDriver getDriver() {
        return MyDriver.getDriver();
    }

    public static LoginPage createLoginPage(WebDriver driver) {
        driver.get("https://www.wiggle.com/login");
        return new LoginPage(driver);
    }
}
