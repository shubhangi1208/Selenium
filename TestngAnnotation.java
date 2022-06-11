package com.june2ndweek;

import org.testng.Reporter;
import org.testng.annotations.*;


public class TestngAnnotation {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod() {
        Reporter.log("afterMethod", true);
    }

    @BeforeClass
    public void beforeClass() {
        Reporter.log("beforeClass", true);
    }

    @AfterClass
    public void afterClass() {
        Reporter.log("afterClass", true);
    }

    @BeforeTest
    public void beforeTest() {
        Reporter.log("beforeTest", true);
    }

    @AfterTest
    public void afterTest() {
        Reporter.log("afterTest", true);
    }

    @BeforeSuite
    public void beforeSuite() {
        Reporter.log("beforeSuite", true);
    }

    @AfterSuite
    public void afterSuite() {
        Reporter.log("afterSuite", true);
    }

    @Test
    public void Login1() {
        System.out.println("Login 1 method");
    }

    @Test
    public void Login2() {
        System.out.println("Login 2 method");
    }

}



