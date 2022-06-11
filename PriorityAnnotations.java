package com.june2ndweek;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityAnnotations {
    @Test(priority = 1)
    public void signup(){
        System.out.println("signup method");
    }
    @Test(priority = 1)
    public void quit(){
        System.out.println("quit method");
    }
    @Test(priority = 2)
    public void login(){
        System.out.println("login method");
    }
    @Test(priority = 3)
    public void abc(){
        System.out.println("abc method");
    }
    @Test(invocationCount = 3)
    public void multipleTimes(){
        System.out.println("signup method");
    }
    @Test(dependsOnMethods = "create")
    public void post(){
        System.out.println("post method");
    }
    @Test()
    public void create(){
        System.out.println("create method");
        //Assert.fail();
    }
    @Test(enabled = false)
    public void delete(){
        System.out.println("delete method");
    }
}
