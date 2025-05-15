package com.stv.factory.factorytests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginButtonDisabled extends BaseTest {
    @Test
    public void loginButtonIsDisabled(){
        loginPage.clickOnAllowCookiesIfVisible();
        loginPage.attemptLogin();
        String message = loginPage.getErrorMessage();

        Assert.assertEquals(message, "Please provide a password");
    }
}
