package com.saucelabs.selenium;

import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Ross Rowe
 */
public class SauceWebDriverWrapperTest extends WrapperHelper {

    @Test
    public void wrappedInstance() throws Exception {
        DesiredCapabilities capabillities = new DesiredCapabilities(
                "firefox", "3.6.", Platform.WINDOWS);
        capabillities.setCapability("name", "Selenium 2 Test");
        WebDriver driver = new SauceWebDriverWrapper(new RemoteWebDriver(
                new URL("http://" + System.getProperty("sauce.username") + ":" + System.getProperty("sauce.accessKey") + "@ondemand.saucelabs.com:80/wd/hub"),
                capabillities));
        driver.get("http://example.saucelabs.com/");
        assertEquals("Cross browser testing with Selenium - Sauce Labs", driver.getTitle());
        driver.quit();
        assertTrue("Did not find a system output line starting with SauceOnDemandSessionID", stream.getString().indexOf("SauceOnDemandSessionID") != -1);
        assertTrue("Did not find a system output line starting with SauceOnDemandSessionID", stream.getString().indexOf("SauceOnDemandSessionID=null") == -1);
    }
    
    @Test
    public void staticMethod() throws Exception {
        DesiredCapabilities capabillities = new DesiredCapabilities(
                "firefox", "3.6.", Platform.WINDOWS);
        capabillities.setCapability("name", "Selenium 2 Test");
        WebDriver driver = new RemoteWebDriver(
                new URL("http://" + System.getProperty("sauce.username") + ":" + System.getProperty("sauce.accessKey") + "@ondemand.saucelabs.com:80/wd/hub"),
                capabillities);
        SauceWebDriverWrapper.dumpSessionId(driver);
        driver.get("http://example.saucelabs.com/");
        assertEquals("Cross browser testing with Selenium - Sauce Labs", driver.getTitle());
        driver.quit();
        assertTrue("Did not find a system output line starting with SauceOnDemandSessionID", stream.getString().indexOf("SauceOnDemandSessionID") != -1);
        assertTrue("Did not find a system output line starting with SauceOnDemandSessionID", stream.getString().indexOf("SauceOnDemandSessionID=null") == -1);
    }

}
