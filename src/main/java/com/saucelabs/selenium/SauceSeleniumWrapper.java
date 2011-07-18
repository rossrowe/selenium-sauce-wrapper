package com.saucelabs.selenium;

import com.thoughtworks.selenium.CommandProcessor;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

import java.lang.reflect.Field;

/**
 * Wraps a {@link com.thoughtworks.selenium.Selenium} instance.  If the underlying instance is a {@link com.thoughtworks.selenium.DefaultSelenium}, then the 
 * session id of the instance is written to the System.out, so that it can be parsed by CI implementations (eg. Bamboo/Jenkins).
 * <p/>
 * All other logic of this class is delegated to the wrapped instance.
 * <p/>
 * 
 * @author Ross Rowe
 */
public class SauceSeleniumWrapper implements Selenium {

    private Selenium wrappedSelenium;
    private String lastSessionId;

    public SauceSeleniumWrapper(Selenium wrappedSelenium) {
        this.wrappedSelenium = wrappedSelenium;
        dumpSessionId();
    }

    /**
     * Dump the session ID, so that it can be captured by the CI server.
     */
    private void dumpSessionId() {
        lastSessionId = getSessionId();
        System.out.println("SauceOnDemandSessionID=" + lastSessionId);
    }

    public String getSessionId() {
        if (wrappedSelenium instanceof DefaultSelenium) {
            DefaultSelenium defaultSelenium = (DefaultSelenium) wrappedSelenium;
            try {
                Field commandProcessorField = DefaultSelenium.class.getDeclaredField("commandProcessor");
                commandProcessorField.setAccessible(true);
                CommandProcessor commandProcess = (CommandProcessor) commandProcessorField.get(defaultSelenium);
                Field f = commandProcess.getClass().getDeclaredField("sessionId");
                f.setAccessible(true);
                Object id = f.get(commandProcess);
                if (id != null) return id.toString();
                return lastSessionId;
            } catch (NoSuchFieldException e) {
                // failed to retrieve the session ID
            } catch (IllegalAccessException e) {
                // failed to retrieve the session ID
            }
        }
        return null;
    }

    public void setExtensionJs(String s) {
        wrappedSelenium.setExtensionJs(s);
    }

    public void start() {
        wrappedSelenium.start();
        dumpSessionId();
    }

    public void start(String s) {
        wrappedSelenium.start(s);
        dumpSessionId();
    }

    public void start(Object o) {
        wrappedSelenium.start(o);
        dumpSessionId();
    }

    public void stop() {
        wrappedSelenium.stop();
    }

    public void showContextualBanner() {
        wrappedSelenium.showContextualBanner();
    }

    public void showContextualBanner(String s, String s1) {
        wrappedSelenium.showContextualBanner(s, s1);
    }

    public void click(String s) {
        wrappedSelenium.click(s);
    }

    public void doubleClick(String s) {
        wrappedSelenium.doubleClick(s);
    }

    public void contextMenu(String s) {
        wrappedSelenium.contextMenu(s);
    }

    public void clickAt(String s, String s1) {
        wrappedSelenium.clickAt(s, s1);
    }

    public void doubleClickAt(String s, String s1) {
        wrappedSelenium.doubleClickAt(s, s1);
    }

    public void contextMenuAt(String s, String s1) {
        wrappedSelenium.contextMenuAt(s, s1);
    }

    public void fireEvent(String s, String s1) {
        wrappedSelenium.fireEvent(s, s1);
    }

    public void focus(String s) {
        wrappedSelenium.focus(s);
    }

    public void keyPress(String s, String s1) {
        wrappedSelenium.keyPress(s, s1);
    }

    public void shiftKeyDown() {
        wrappedSelenium.shiftKeyDown();
    }

    public void shiftKeyUp() {
        wrappedSelenium.shiftKeyUp();
    }

    public void metaKeyDown() {
        wrappedSelenium.metaKeyDown();
    }

    public void metaKeyUp() {
        wrappedSelenium.metaKeyUp();
    }

    public void altKeyDown() {
        wrappedSelenium.altKeyDown();
    }

    public void altKeyUp() {
        wrappedSelenium.altKeyUp();
    }

    public void controlKeyDown() {
        wrappedSelenium.controlKeyDown();
    }

    public void controlKeyUp() {
        wrappedSelenium.controlKeyUp();
    }

    public void keyDown(String s, String s1) {
        wrappedSelenium.keyDown(s, s1);
    }

    public void keyUp(String s, String s1) {
        wrappedSelenium.keyUp(s, s1);
    }

    public void mouseOver(String s) {
        wrappedSelenium.mouseOver(s);
    }

    public void mouseOut(String s) {
        wrappedSelenium.mouseOut(s);
    }

    public void mouseDown(String s) {
        wrappedSelenium.mouseDown(s);
    }

    public void mouseDownRight(String s) {
        wrappedSelenium.mouseDownRight(s);
    }

    public void mouseDownAt(String s, String s1) {
        wrappedSelenium.mouseDownAt(s, s1);
    }

    public void mouseDownRightAt(String s, String s1) {
        wrappedSelenium.mouseDownRightAt(s, s1);
    }

    public void mouseUp(String s) {
        wrappedSelenium.mouseUp(s);
    }

    public void mouseUpRight(String s) {
        wrappedSelenium.mouseUpRight(s);
    }

    public void mouseUpAt(String s, String s1) {
        wrappedSelenium.mouseUpAt(s, s1);
    }

    public void mouseUpRightAt(String s, String s1) {
        wrappedSelenium.mouseUpRightAt(s, s1);
    }

    public void mouseMove(String s) {
        wrappedSelenium.mouseMove(s);
    }

    public void mouseMoveAt(String s, String s1) {
        wrappedSelenium.mouseMoveAt(s, s1);
    }

    public void type(String s, String s1) {
        wrappedSelenium.type(s, s1);
    }

    public void typeKeys(String s, String s1) {
        wrappedSelenium.typeKeys(s, s1);
    }

    public void setSpeed(String s) {
        wrappedSelenium.setSpeed(s);
    }

    public String getSpeed() {
        return wrappedSelenium.getSpeed();
    }

    public String getLog() {
        return wrappedSelenium.getLog();
    }

    public void check(String s) {
        wrappedSelenium.check(s);
    }

    public void uncheck(String s) {
        wrappedSelenium.uncheck(s);
    }

    public void select(String s, String s1) {
        wrappedSelenium.select(s, s1);
    }

    public void addSelection(String s, String s1) {
        wrappedSelenium.addSelection(s, s1);
    }

    public void removeSelection(String s, String s1) {
        wrappedSelenium.removeSelection(s, s1);
    }

    public void removeAllSelections(String s) {
        wrappedSelenium.removeAllSelections(s);
    }

    public void submit(String s) {
        wrappedSelenium.submit(s);
    }

    public void open(String s, String s1) {
        wrappedSelenium.open(s, s1);
    }

    public void open(String s) {
        wrappedSelenium.open(s);
    }

    public void openWindow(String s, String s1) {
        wrappedSelenium.openWindow(s, s1);
    }

    public void selectWindow(String s) {
        wrappedSelenium.selectWindow(s);
    }

    public void selectPopUp(String s) {
        wrappedSelenium.selectPopUp(s);
    }

    public void deselectPopUp() {
        wrappedSelenium.deselectPopUp();
    }

    public void selectFrame(String s) {
        wrappedSelenium.selectFrame(s);
    }

    public boolean getWhetherThisFrameMatchFrameExpression(String s, String s1) {
        return wrappedSelenium.getWhetherThisFrameMatchFrameExpression(s, s1);
    }

    public boolean getWhetherThisWindowMatchWindowExpression(String s, String s1) {
        return wrappedSelenium.getWhetherThisWindowMatchWindowExpression(s, s1);
    }

    public void waitForPopUp(String s, String s1) {
        wrappedSelenium.waitForPopUp(s, s1);
    }

    public void chooseCancelOnNextConfirmation() {
        wrappedSelenium.chooseCancelOnNextConfirmation();
    }

    public void chooseOkOnNextConfirmation() {
        wrappedSelenium.chooseOkOnNextConfirmation();
    }

    public void answerOnNextPrompt(String s) {
        wrappedSelenium.answerOnNextPrompt(s);
    }

    public void goBack() {
        wrappedSelenium.goBack();
    }

    public void refresh() {
        wrappedSelenium.refresh();
    }

    public void close() {
        wrappedSelenium.close();
    }

    public boolean isAlertPresent() {
        return wrappedSelenium.isAlertPresent();
    }

    public boolean isPromptPresent() {
        return wrappedSelenium.isPromptPresent();
    }

    public boolean isConfirmationPresent() {
        return wrappedSelenium.isConfirmationPresent();
    }

    public String getAlert() {
        return wrappedSelenium.getAlert();
    }

    public String getConfirmation() {
        return wrappedSelenium.getConfirmation();
    }

    public String getPrompt() {
        return wrappedSelenium.getPrompt();
    }

    public String getLocation() {
        return wrappedSelenium.getLocation();
    }

    public String getTitle() {
        return wrappedSelenium.getTitle();
    }

    public String getBodyText() {
        return wrappedSelenium.getBodyText();
    }

    public String getValue(String s) {
        return wrappedSelenium.getValue(s);
    }

    public String getText(String s) {
        return wrappedSelenium.getText(s);
    }

    public void highlight(String s) {
        wrappedSelenium.highlight(s);
    }

    public String getEval(String s) {
        return wrappedSelenium.getEval(s);
    }

    public boolean isChecked(String s) {
        return wrappedSelenium.isChecked(s);
    }

    public String getTable(String s) {
        return wrappedSelenium.getTable(s);
    }

    public String[] getSelectedLabels(String s) {
        return wrappedSelenium.getSelectedLabels(s);
    }

    public String getSelectedLabel(String s) {
        return wrappedSelenium.getSelectedLabel(s);
    }

    public String[] getSelectedValues(String s) {
        return wrappedSelenium.getSelectedValues(s);
    }

    public String getSelectedValue(String s) {
        return wrappedSelenium.getSelectedValue(s);
    }

    public String[] getSelectedIndexes(String s) {
        return wrappedSelenium.getSelectedIndexes(s);
    }

    public String getSelectedIndex(String s) {
        return wrappedSelenium.getSelectedIndex(s);
    }

    public String[] getSelectedIds(String s) {
        return wrappedSelenium.getSelectedIds(s);
    }

    public String getSelectedId(String s) {
        return wrappedSelenium.getSelectedId(s);
    }

    public boolean isSomethingSelected(String s) {
        return wrappedSelenium.isSomethingSelected(s);
    }

    public String[] getSelectOptions(String s) {
        return wrappedSelenium.getSelectOptions(s);
    }

    public String getAttribute(String s) {
        return wrappedSelenium.getAttribute(s);
    }

    public boolean isTextPresent(String s) {
        return wrappedSelenium.isTextPresent(s);
    }

    public boolean isElementPresent(String s) {
        return wrappedSelenium.isElementPresent(s);
    }

    public boolean isVisible(String s) {
        return wrappedSelenium.isVisible(s);
    }

    public boolean isEditable(String s) {
        return wrappedSelenium.isEditable(s);
    }

    public String[] getAllButtons() {
        return wrappedSelenium.getAllButtons();
    }

    public String[] getAllLinks() {
        return wrappedSelenium.getAllLinks();
    }

    public String[] getAllFields() {
        return wrappedSelenium.getAllFields();
    }

    public String[] getAttributeFromAllWindows(String s) {
        return wrappedSelenium.getAttributeFromAllWindows(s);
    }

    public void dragdrop(String s, String s1) {
        wrappedSelenium.dragdrop(s, s1);
    }

    public void setMouseSpeed(String s) {
        wrappedSelenium.setMouseSpeed(s);
    }

    public Number getMouseSpeed() {
        return wrappedSelenium.getMouseSpeed();
    }

    public void dragAndDrop(String s, String s1) {
        wrappedSelenium.dragAndDrop(s, s1);
    }

    public void dragAndDropToObject(String s, String s1) {
        wrappedSelenium.dragAndDropToObject(s, s1);
    }

    public void windowFocus() {
        wrappedSelenium.windowFocus();
    }

    public void windowMaximize() {
        wrappedSelenium.windowMaximize();
    }

    public String[] getAllWindowIds() {
        return wrappedSelenium.getAllWindowIds();
    }

    public String[] getAllWindowNames() {
        return wrappedSelenium.getAllWindowNames();
    }

    public String[] getAllWindowTitles() {
        return wrappedSelenium.getAllWindowTitles();
    }

    public String getHtmlSource() {
        return wrappedSelenium.getHtmlSource();
    }

    public void setCursorPosition(String s, String s1) {
        wrappedSelenium.setCursorPosition(s, s1);
    }

    public Number getElementIndex(String s) {
        return wrappedSelenium.getElementIndex(s);
    }

    public boolean isOrdered(String s, String s1) {
        return wrappedSelenium.isOrdered(s, s1);
    }

    public Number getElementPositionLeft(String s) {
        return wrappedSelenium.getElementPositionLeft(s);
    }

    public Number getElementPositionTop(String s) {
        return wrappedSelenium.getElementPositionTop(s);
    }

    public Number getElementWidth(String s) {
        return wrappedSelenium.getElementWidth(s);
    }

    public Number getElementHeight(String s) {
        return wrappedSelenium.getElementHeight(s);
    }

    public Number getCursorPosition(String s) {
        return wrappedSelenium.getCursorPosition(s);
    }

    public String getExpression(String s) {
        return wrappedSelenium.getExpression(s);
    }

    public Number getXpathCount(String s) {
        return wrappedSelenium.getXpathCount(s);
    }

    public Number getCssCount(String s) {
        return wrappedSelenium.getCssCount(s);
    }

    public void assignId(String s, String s1) {
        wrappedSelenium.assignId(s, s1);
    }

    public void allowNativeXpath(String s) {
        wrappedSelenium.allowNativeXpath(s);
    }

    public void ignoreAttributesWithoutValue(String s) {
        wrappedSelenium.ignoreAttributesWithoutValue(s);
    }

    public void waitForCondition(String s, String s1) {
        wrappedSelenium.waitForCondition(s, s1);
    }

    public void setTimeout(String s) {
        wrappedSelenium.setTimeout(s);
    }

    public void waitForPageToLoad(String s) {
        wrappedSelenium.waitForPageToLoad(s);
    }

    public void waitForFrameToLoad(String s, String s1) {
        wrappedSelenium.waitForFrameToLoad(s, s1);
    }

    public String getCookie() {
        return wrappedSelenium.getCookie();
    }

    public String getCookieByName(String s) {
        return wrappedSelenium.getCookieByName(s);
    }

    public boolean isCookiePresent(String s) {
        return wrappedSelenium.isCookiePresent(s);
    }

    public void createCookie(String s, String s1) {
        wrappedSelenium.createCookie(s, s1);
    }

    public void deleteCookie(String s, String s1) {
        wrappedSelenium.deleteCookie(s, s1);
    }

    public void deleteAllVisibleCookies() {
        wrappedSelenium.deleteAllVisibleCookies();
    }

    public void setBrowserLogLevel(String s) {
        wrappedSelenium.setBrowserLogLevel(s);
    }

    public void runScript(String s) {
        wrappedSelenium.runScript(s);
    }

    public void addLocationStrategy(String s, String s1) {
        wrappedSelenium.addLocationStrategy(s, s1);
    }

    public void captureEntirePageScreenshot(String s, String s1) {
        wrappedSelenium.captureEntirePageScreenshot(s, s1);
    }

    public void rollup(String s, String s1) {
        wrappedSelenium.rollup(s, s1);
    }

    public void addScript(String s, String s1) {
        wrappedSelenium.addScript(s, s1);
    }

    public void removeScript(String s) {
        wrappedSelenium.removeScript(s);
    }

    public void useXpathLibrary(String s) {
        wrappedSelenium.useXpathLibrary(s);
    }

    public void setContext(String s) {
        wrappedSelenium.setContext(s);
    }

    public void attachFile(String s, String s1) {
        wrappedSelenium.attachFile(s, s1);
    }

    public void captureScreenshot(String s) {
        wrappedSelenium.captureScreenshot(s);
    }

    public String captureScreenshotToString() {
        return wrappedSelenium.captureScreenshotToString();
    }

    public String captureNetworkTraffic(String s) {
        return wrappedSelenium.captureNetworkTraffic(s);
    }

    public void addCustomRequestHeader(String s, String s1) {
        wrappedSelenium.addCustomRequestHeader(s, s1);
    }

    public String captureEntirePageScreenshotToString(String s) {
        return wrappedSelenium.captureEntirePageScreenshotToString(s);
    }

    public void shutDownSeleniumServer() {
        wrappedSelenium.shutDownSeleniumServer();
    }

    public String retrieveLastRemoteControlLogs() {
        return wrappedSelenium.retrieveLastRemoteControlLogs();
    }

    public void keyDownNative(String s) {
        wrappedSelenium.keyDownNative(s);
    }

    public void keyUpNative(String s) {
        wrappedSelenium.keyUpNative(s);
    }

    public void keyPressNative(String s) {
        wrappedSelenium.keyPressNative(s);
    }
}
