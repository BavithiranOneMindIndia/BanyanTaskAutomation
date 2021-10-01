package com.banyantask;

import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageBanyanTask extends SuperClass {

    String addressText;
    static Logger log = Logger.getLogger(MainPageBanyanTask.class);

    public void clickLoginButton(WebDriver driver) throws IOException {
        getwaitdriver(driver)
                .until(ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("ah.login")));
        driver.findElement(getValueFromElementAddressConfig("ah.login")).click();
        log.info("clickLoginButton");

    }

    public void enterPhoneNumber(WebDriver driver, String phoneNumber) throws IOException {

        getwaitdriver(driver).until(ExpectedConditions
                .visibilityOfElementLocated(getValueFromElementAddressConfig("signInForm.phoneNumberField")));
        driver.findElement(getValueFromElementAddressConfig("signInForm.phoneNumberField")).sendKeys(phoneNumber);
        log.info("enterPhoneNumber");
    }

    public void enterOtp(WebDriver driver, String otp) throws IOException {
        getwaitdriver(driver)
                .until(ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("ah.enter.otp")));
        driver.findElement(getValueFromElementAddressConfig("ah.enter.otp")).sendKeys(otp);
        log.info("enterOtp");
    }

    public void mainOptionButtonClick(WebDriver driver) throws IOException {
        getwaitdriver(driver).until(
                ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("mainOptionButton")));
        driver.findElement(getValueFromElementAddressConfig("mainOptionButton")).click();
        log.info("mainOptionButtonClick");

    }

    public void clickCountinueButton(WebDriver driver) throws IOException {
        getwaitdriver(driver).until(
                ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("phCountinueButton")));
        driver.findElement(getValueFromElementAddressConfig("phCountinueButton")).click();
        log.info("clickCountinueButton");
    }

    public void getUserNameText(WebDriver driver) throws IOException {
        getwaitdriver(driver).until(
                ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("ah.getUserText")));

        System.out.println(driver.findElement(getValueFromElementAddressConfig("ah.getUserText")).getText());
        log.info("getUserNameText");
        driver.navigate().refresh();
    }

    public void verificationAssert(WebDriver driver) throws IOException {
        log.info("assertion Started");
        assertTrue(assertLogin(driver));
        log.info("assertion Ended");

    }

    public void assertProjectAvailableOrNot(WebDriver driver) throws IOException {
        log.info("Project assertion Started");
        assertTrue(assertProjectAvailable(driver));
        log.info("Project assertion Started");
    }

    public void assertTaskAvailableOrNot(WebDriver driver) throws IOException {
        log.info("Task assertion Started");
        assertTrue(assertTaskAvailable(driver));
        log.info("Task assertion Started");
    }

    public void enterPanicPassword(WebDriver driver) throws IOException {
        getwaitdriver(driver).until(
                ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("banyan.panic.1")));
        driver.findElement(getValueFromElementAddressConfig("banyan.panic.1")).sendKeys("1");
        driver.findElement(getValueFromElementAddressConfig("banyan.panic.2")).sendKeys("2");
        driver.findElement(getValueFromElementAddressConfig("banyan.panic.3")).sendKeys("3");
        driver.findElement(getValueFromElementAddressConfig("banyan.panic.4")).sendKeys("4");
        driver.findElement(getValueFromElementAddressConfig("banyan.panic.5")).sendKeys("5");
        driver.findElement(getValueFromElementAddressConfig("banyan.panic.6")).sendKeys("6");
        getwaitdriver(driver).until(
                ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("banyan.authen")));
        driver.findElement(getValueFromElementAddressConfig("banyan.authen")).click();

    }

    public void mainTaskAddedButton(WebDriver driver) throws InterruptedException {

        String cssSelectorForHost1 = ".fab-icon.ng-star-inserted.md.ion-activatable.ion-focusable.hydrated";
        Thread.sleep(1000);
        WebElement shadowDomHostElement = driver
                .findElement(By.cssSelector(".fab-icon.ng-star-inserted.md.ion-activatable.ion-focusable.hydrated"));
        WebElement last = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
                shadowDomHostElement);
        Thread.sleep(1000);
        last.findElement(By.cssSelector(".button-inner"));

    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
        log.info("quitDriver");

    }

    boolean assertLogin(WebDriver driver) throws IOException {
        addressText = getwaitdriver(driver)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(getValueFromElementAddressConfig("banyan.loginVerification")))
                .getText();
        System.out.println(addressText);
        if (driver.findElement(getValueFromElementAddressConfig("banyan.loginVerification")).isDisplayed() == true) {
            return true;

        } else {
            return false;

        }

    }

    boolean assertProjectAvailable(WebDriver driver) throws IOException {

        getwaitdriver(driver).until(ExpectedConditions
                .visibilityOfElementLocated(getValueFromElementAddressConfig("banyan.ProjectCard.available")));

        if (driver.findElement(getValueFromElementAddressConfig("banyan.ProjectCard.available"))
                .isDisplayed() == true) {
            return true;

        } else {
            return false;

        }

    }

    boolean assertTaskAvailable(WebDriver driver) throws IOException {

        getwaitdriver(driver).until(ExpectedConditions
                .visibilityOfElementLocated(getValueFromElementAddressConfig("banyan.taskCard.available")));

        if (driver.findElement(getValueFromElementAddressConfig("banyan.taskCard.available")).isDisplayed() == true) {
            return true;

        } else {
            return false;

        }

    }

    // BrowserStack

    public void browserStack_integration() {

    }

}
