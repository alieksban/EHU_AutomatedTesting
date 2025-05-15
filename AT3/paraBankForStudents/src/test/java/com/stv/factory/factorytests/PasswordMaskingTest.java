package com.stv.factory.factorytests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordMaskingTest extends BaseTest {
    @Test
    public void passwordMasked(){
        loginPage.enterPassword("testPassword123");
        boolean isMasked = loginPage.isPasswordMasked();

        Assert.assertTrue(isMasked, "Password should be masked but is visible");
    }
}
