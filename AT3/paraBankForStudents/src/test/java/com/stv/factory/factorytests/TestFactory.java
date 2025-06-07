package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainPage;
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
    public static MainPage createMainPage(WebDriver driver){
        driver.get("https://www.wiggle.com");
        return new MainPage(driver);
    }
}
