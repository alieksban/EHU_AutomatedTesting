package com.stv.factory.factorypages;
import com.stv.framework.core.drivers.MyDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected static WebDriver getDriver() {
        return MyDriver.getDriver();
    }
    public BasePage(WebDriver driver)    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
