package com.shiva.tests;

import com.shiva.base.BaseTest;
import com.shiva.pages.LoginPage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyRegistration() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("student", "Password123");

        System.out.println("Login Test Executed Successfully");
    }
}