package com.saucelabs.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.util.List;
import java.util.Set;

/**
 * Wraps a {@link WebDriver} instance.  If the underlying instance is a {@link RemoteWebDriver}, then the 
 * {@link org.openqa.selenium.remote.SessionId} of the instance is written to the System.out, so that it
 * can be parsed by CI implementations (eg. Bamboo/Jenkins).
 * <p/>
 * All other logic of this class is delegated to the wrapped instance.
 * <p/>
 * 
 * @author Ross Rowe
 */
public class SauceWebDriverWrapper implements WebDriver {
    private WebDriver wrappedDriver;

    public SauceWebDriverWrapper(WebDriver wrappedDriver) {
        this.wrappedDriver = wrappedDriver;
        dumpSessionId();
    }

    public WebDriver getWrappedDriver() {
        return wrappedDriver;
    }

    /**
     * Dump the session ID, so that it can be captured by the CI server.
     */
    private void dumpSessionId() {
        if (wrappedDriver instanceof RemoteWebDriver) {
            RemoteWebDriver remoteWebDriver = (RemoteWebDriver) wrappedDriver;
            SessionId lastSessionId = remoteWebDriver.getSessionId();
            if (lastSessionId != null) {
                System.out.println("SauceOnDemandSessionID=" + lastSessionId.toString());
            }
        }
    }

    public void get(String s) {
        wrappedDriver.get(s);
    }

    public String getCurrentUrl() {
        return wrappedDriver.getCurrentUrl();
    }

    public String getTitle() {
        return wrappedDriver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return wrappedDriver.findElements(by);
    }

    public WebElement findElement(By by) {
        return wrappedDriver.findElement(by);
    }

    public String getPageSource() {
        return wrappedDriver.getPageSource();
    }

    public void close() {
        wrappedDriver.close();
    }

    public void quit() {
        wrappedDriver.quit();
    }

    public Set<String> getWindowHandles() {
        return wrappedDriver.getWindowHandles();
    }

    public String getWindowHandle() {
        return wrappedDriver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return wrappedDriver.switchTo();
    }

    public Navigation navigate() {
        return wrappedDriver.navigate();
    }

    public Options manage() {
        return wrappedDriver.manage();
    }
}
