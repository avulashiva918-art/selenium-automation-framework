package com.shiva.tests;

import com.shiva.base.BaseTest;
import com.shiva.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("student", "WrongPassword");

        System.out.println("Login Test Executed Successfully");
    }
}