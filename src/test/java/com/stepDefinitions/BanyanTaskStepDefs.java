package com.stepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.banyantask.MainPageBanyanTask;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
public class BanyanTaskStepDefs extends MainPageBanyanTask {

    WebDriver driver;
    static Logger log = Logger.getLogger(BanyanTaskStepDefs.class);

    @Given("^Access WebDriverManager For BanyanTask$")
    public void access_web_driver_manager_for_banyan_task() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Then("^Launch chrome browser for BanyanTask$")
    public void launch_chrome_browser_for_banyan_task() throws IOException {
        // Launching sample website
        driver.get(getValueFromDataConfig("Live.Web.Url"));
        // driver.get("https://www.onemindindia.com/home");
        driver.getWindowHandle();
        driver.manage().window().maximize();
    }

    @Then("^Click Login for BanyanTask$")
    public void click_Login_for_BanyanTask() throws IOException {
        clickLoginButton(driver);
    }

    @Then("^Enter Phone number for BanyanTask$")
    public void enter_phone_number_for_BanyanTask() throws IOException {
        enterPhoneNumber(driver, getValueFromDataConfig("MobileNumber"));
    }

    @Then("^Enter otp$")
    public void enter_otp() throws IOException {
        enterOtp(driver, getValueFromDataConfig("OTP"));

    }

    @Then("^Then click countinue button BanyanTask$")
    public void then_Click_countinue_button() throws InterruptedException, IOException {
        clickCountinueButton(driver);
        Thread.sleep(3000);
    }

    @Then("^Wait action for \"([^\"]*)\" seconds BanyanTask$")
    public void wiat_time(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Then("^assert login$")
    public void assert_login() throws IOException{
        verificationAssert(driver);
    }

    @Then("^Quit driver$")
    public void quit_driver(){
        
    }

}
