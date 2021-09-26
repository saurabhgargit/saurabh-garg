package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.BaseClass;
import utils.Service;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SuiteConfig extends BaseClass {

    @BeforeSuite
    public void beforeSuite() throws Exception {
        initializeSuite();
    }

    @BeforeMethod
    public void beforeMethod(){

        URL appiumServerURL = Service.service.getUrl();

        driver = new AndroidDriver<AndroidElement>(appiumServerURL, capabilities);

        System.out.println("Created connection to the appium server with the capabilities set.");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("Implicit wait is set.");

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        tearDown();
    }




}
