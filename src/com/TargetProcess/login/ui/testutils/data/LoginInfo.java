package com.TargetProcess.login.ui.testutils.data;

import com.gargoylesoftware.htmlunit.html.DomElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.TargetProcess.setup.BasicTest;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Created by okolotovich on 11/19/17.
 */
public class LoginInfo {
    String host;
    String login;
    String password;
    boolean isSso;
    boolean isOnsite;

    public void openlogInScreen(boolean isSso, boolean isOnsite) throws MalformedURLException {
        if(isSso){
            toggleSSO();
        }
        if (isOnsite){
            toggleOnsite();
        }
    }

    private void toggleSSO() throws MalformedURLException {
        IOSDriver driver;
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("app","/Users/okolotovich/Desktop/TargetProcess.app");
        capabilities.setCapability("automatioName", "XCUITest");
        capabilities.setCapability("platformVersion", "11.1");
        driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS );
        WebElement ssoButton = driver.findElement(By.name("SSO"));
        ssoButton.click();
    }
    private void toggleOnsite() throws MalformedURLException{
        IOSDriver driver;
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("app","/Users/okolotovich/Desktop/TargetProcess.app");
        capabilities.setCapability("automatioName", "XCUITest");
        capabilities.setCapability("platformVersion", "11.1");
        driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS );
        WebElement onsiteToggler = driver.findElement(By.name("On-Site"));
        onsiteToggler.click();
    }
}

