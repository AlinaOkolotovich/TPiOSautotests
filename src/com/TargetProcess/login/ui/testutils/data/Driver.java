package com.TargetProcess.login.ui.testutils.data;

import io.appium.java_client.ios.IOSDriver;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by okolotovich on 11/19/17.
 */
public class Driver {

    public void setupDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("app", "/Users/okolotovich/Desktop/TargetProcess.app");
        capabilities.setCapability("automatioName", "XCUITest");
        capabilities.setCapability("platformVersion", "11.1");

        IOSDriver DRIVER = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        DRIVER.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
}