package com.saucelabs.selenium;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Ross Rowe
 */
public class SauceSeleniumWrapperTest extends WrapperHelper {

    @Test
    public void wrappedInstance() throws Exception {
        Selenium selenium = new SauceSeleniumWrapper(new DefaultSelenium(
                "ondemand.saucelabs.com",
                80,
                "{\"username\": \"" + System.getProperty("sauce.username") + "\"," +
                        "\"access-key\": \"" + System.getProperty("sauce.accessKey") + "\"," +
                        "\"os\": \"Windows 2003\"," +
                        "\"browser\": \"firefox\"," +
                        "\"browser-version\": \"3.6.\"," +
                        "\"name\": \"This is an example test\"}",
                "http://example.saucelabs.com/"));

        selenium.start();
        selenium.open("/");
        assertEquals("Cross browser testing with Selenium - Sauce Labs", selenium.getTitle());
        selenium.stop();
        assertTrue("Did not find a system output line starting with SauceOnDemandSessionID", stream.getString().indexOf("SauceOnDemandSessionID") != -1);
        assertTrue("Did not find a system output line starting with SauceOnDemandSessionID", stream.getString().indexOf("SauceOnDemandSessionID=null") == -1);
    }

    @Test
    public void staticMethod() throws Exception {
        Selenium selenium = new DefaultSelenium(
                "ondemand.saucelabs.com",
                80,
                "{\"username\": \"" + System.getProperty("sauce.username") + "\"," +
                        "\"access-key\": \"" + System.getProperty("sauce.accessKey") + "\"," +
                        "\"os\": \"Windows 2003\"," +
                        "\"browser\": \"firefox\"," +
                        "\"browser-version\": \"3.6.\"," +
                        "\"name\": \"This is an example test\"}",
                "http://example.saucelabs.com/");

        selenium.start();
        SauceSeleniumWrapper.dumpSessionId(selenium);
        selenium.open("/");
        assertEquals("Cross browser testing with Selenium - Sauce Labs", selenium.getTitle());
        selenium.stop();
        assertTrue("Did not find a system output line starting with SauceOnDemandSessionID", stream.getString().indexOf("SauceOnDemandSessionID") != -1);
        assertTrue("Did not find a system output line starting with SauceOnDemandSessionID", stream.getString().indexOf("SauceOnDemandSessionID=null") == -1);
    }

}
