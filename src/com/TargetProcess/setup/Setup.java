package com.TargetProcess.setup;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import java.io.IOException;


/**
 * Created by okolotovich on 11/19/17.
 */
public class Setup {

    IOSDriver driver;
    protected boolean isSSO;

    String accountName;
    String userName;
    String password;



    //On demand NON-SSO creds
    public static final String NON_SSO_ACCOUNT = "o";
    public static final String NON_SSO_USER_NAME = "admin";
    public static final String NON_SSO_PASSWORD = "123";

    //On demand SSO creds
    public static final String SSO_ACCOUNT = "android";
    public static final String SSO_USER_NAME = "4testtommy@gmail.com";
    public static final String SSO_PASSWORD = "Okta181373";

    public Setup(boolean isSSO) throws MalformedURLException{
        if (isSSO == true){
            accountName = SSO_ACCOUNT;
            userName = SSO_USER_NAME;
            password = SSO_PASSWORD;
        }
        else {
            accountName = NON_SSO_ACCOUNT;
            userName = NON_SSO_USER_NAME;
            password = NON_SSO_PASSWORD;

        }
        this.startServer();
        this.setCapabilities();
        this.allowNotifications();
        this.login(isSSO);

    }


    public Setup() throws MalformedURLException {
        isSSO = false;
        accountName = NON_SSO_ACCOUNT;
        userName = NON_SSO_USER_NAME;
        password = NON_SSO_PASSWORD;

        this.setCapabilities();
        this.startServer();

        this.allowNotifications();
        this.login(isSSO);

    }
    protected void login(boolean isSSO){
        if(isSSO == true){
            loginToSSO();
        }
        else {
            loginToNonSSO();
        }
    }
    protected void loginToNonSSO(){
        WebElement loginButton = driver.findElement(By.name("Log In"));
        loginButton.click();
        WebElement el1 = driver.findElement(By.name("Account Name"));
        el1.sendKeys(accountName);
        WebElement userNameField = driver.findElement(By.name("Login or Email"));
        userNameField.sendKeys(userName);
        WebElement userPasswordField = driver.findElement(By.name("Password"));
        userPasswordField.sendKeys(password);
        WebElement loginButton2 = driver.findElement(By.name("Log In"));
        loginButton2.click();
        WebElement navigationBar = driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Views\"]");
        navigationBar.isDisplayed();
    };
    protected void loginToSSO(){
        WebElement loginButton = driver.findElement(By.name("SSO"));
        loginButton.click();
        WebElement el1 = driver.findElement(By.name("Account Name"));
        el1.sendKeys(accountName);
        WebElement loginButton2 = driver.findElement(By.name("Log In"));
        loginButton2.click();
        WebElement ssoUserName = driver.findElement(By.name("Username"));
        ssoUserName.sendKeys(userName);
        WebElement ssoPassword = driver.findElement(By.name("Password"));
        ssoPassword.sendKeys(password);
        WebElement ssoLogInButton  = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sign In\"]");
        ssoLogInButton.click();
        WebElement navigationBar = driver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"Views\"]");
        navigationBar.isDisplayed();
    }

    protected void setCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("app","/Users/okolotovich/Desktop/TargetProcess.app");
        capabilities.setCapability("automatioName", "ios-driver");
        capabilities.setCapability("platformVersion", "11.2");
        driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS );
    }
    protected void allowNotifications() {
        WebElement button = driver.findElement(By.name("Allow"));
        button.click();
    }

    public void startServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("/usr/bin/open -a Terminal /k \"appium -a 127.0.0.1 -p 4723");
            Thread.sleep(10000);
            System.out.println("Appium server started.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }



     public void stopServer(){
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("/usr/bin/open -a Terminal /k \"^C");
            System.out.println("Appium server stopped.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}

    /*public void horizontalSwipe(String fromElement, int x, int y){
        WebElement swipeFromElelement = driver.findElement(By.name(fromElement));
        TouchAction swipeFrom = new TouchAction().tap(fromElement);
        TouchAction moveLeft = new TouchAction().moveTo(x,y);
        TouchAction swipeLeft = new TouchAction();
        swipeLeft.tap(swipeFromElelement).moveTo(x,y).release();
    }*/

