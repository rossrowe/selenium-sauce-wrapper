package com.saucelabs.selenium;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Ross Rowe
 */
public class WrapperHelper {
    protected StringOutputStream stream;

    @Before
    public void setUp() throws Exception {
        System.setProperty("sauce.username", "REPLACE_ME");
        System.setProperty("sauce.accessKey", "REPLACE_ME");
        try {
            PrintStream original = System.out;
            this.stream = new StringOutputStream();
            System.setOut(new PrintStream(stream));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Populates the http proxy system properties.
     *
     * @param proxyHost
     * @param proxyPort
     * @param userName
     * @param password
     */
    public void setupProxy(String proxyHost, String proxyPort, final String userName, final String password) {
        if (StringUtils.isNotBlank(proxyHost)) {
            System.setProperty("http.proxyHost", proxyHost);
            System.setProperty("https.proxyHost", proxyHost);
        }
        if (StringUtils.isNotBlank(proxyPort)) {
            System.setProperty("http.proxyPort", proxyPort);
            System.setProperty("https.proxyPort", proxyPort);
        }
        if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)) {
            System.setProperty("http.proxyUser", userName);
            System.setProperty("https.proxyUser", userName);
            System.setProperty("http.proxyPassword", password);
            System.setProperty("https.proxyPassword", password);
        }
    }

    class StringOutputStream extends OutputStream {

        StringBuilder mBuf;

        StringOutputStream() {
            mBuf = new StringBuilder();
        }

        public void write(int bytes) throws IOException {
            mBuf.append((char)bytes);
        }

        public String getString() {
            return mBuf.toString();
        }
    }
}
