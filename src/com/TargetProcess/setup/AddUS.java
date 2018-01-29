package com.TargetProcess.setup;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebDriver;
import org.junit.runners.MethodSorters;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.Element;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import com.TargetProcess.login.ui.testutils.data.Driver;
import org.openqa.selenium.internal.FindsByName;



/**
 * Created by okolotovich on 11/7/17.
 */
public class AddUS extends Setup{

    Setup test = new Setup(isSSO=false);
    public AddUS() throws MalformedURLException {
    }

@Test
    public void addUS() throws MalformedURLException {
        WebElement addTab = driver.findElement(By.name("Add"));
        addTab.click();
/*
        IOSElement list = (IOSElement) driver.findElement(By.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeScrollView"));
        MobileElement listOfEntities = list
                .findElement(MobileBy
                        .IosUIAutomation("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\" Release\"));"));
        assertNotNull(listOfEntities.getLocation());
        listOfEntities.click();
        WebElement release = driver.findElement(By.name("Release"));
        release.getLocation();
        driver.switchTo();

*/
    }

//    @Before
//    public void basicTest() throws MalformedURLException {
//        driverSetup.setCapabilities();
//        AccountCredentials sso = new AccountCredentials("NON_SSO");
//        sso.chooseAccountType("NON_SSO");
//    }
//
//    @Test
//    public void allowNotifications() {
//        WebElement button = driver.findElement(By.tagName("Allow"));
//        button.click();
//    }

}




