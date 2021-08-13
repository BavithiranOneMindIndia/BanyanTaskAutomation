package com.banyantask;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

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
    }

    public void verificationAssert(WebDriver driver) throws IOException {
        log.info("assertion Started");
        assertTrue(assertLogin(driver));
        log.info("assertion Ended");

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

}
