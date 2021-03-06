package com.stepDefinitions;

import java.net.MalformedURLException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.banyantask.MainPageBanyanTask;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
public class BanyanTaskStepDefs extends MainPageBanyanTask {

    WebDriver driver;

    WebDriver browserStackDriver;
    public static final String USERNAME = "bavithiranramesh1";
    public static final String AUTOMATE_KEY = "Ske79rFvf8RZsz3rPo9e";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    static Logger log = Logger.getLogger(BanyanTaskStepDefs.class);

    @Given("^Access WebDriverManager For BanyanTask$")
    public void access_web_driver_manager_for_banyan_task() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Then("Launch chrome using grid node")
    public void launch_chrome_using_grid_node() throws MalformedURLException{
        //Define desired capabilities
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		//Chrome option  
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		options.setHeadless(true);
		
		//Hub URL
		String huburl ="http://192.168.0.91:42127/wd/hub";
		 
		// Create driver with hub address and capability
		driver=new RemoteWebDriver(new URL(huburl), options);
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
    public void assert_login() throws IOException, InterruptedException {
        verificationAssert(driver);
        mainTaskAddedButton(driver);
    }

    @Then("^assert project availabilty$")
    public void assert_project_availability() throws IOException {
        assertProjectAvailableOrNot(driver);
    }

    @Then("^assert task availability$")
    public void assert_task_availability() throws IOException {
        assertTaskAvailableOrNot(driver);

    }

    @Then("^Quit driver$")
    public void quit_driver() {
        quitDriver(driver);
    }

    @Given("^Integrating browserstack$")
    public void integration_browserStack() throws MalformedURLException {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "chrome");
        capsHashtable.put("browser_version", "latest");
        capsHashtable.put("os", "Windows");
        capsHashtable.put("os_version", "10");
        capsHashtable.put("build", "BanyanTask-browserstack-build-1");
        capsHashtable.put("name", "Thread 1");

        // Execute caps
        String key;
        DesiredCapabilities caps = new DesiredCapabilities();
        // Iterate over the hashtable and set the capabilities
        Set<String> keys = capsHashtable.keySet();
        Iterator<String> itr = keys.iterator();
        while (itr.hasNext()) {
            key = itr.next();
            caps.setCapability(key, capsHashtable.get(key));
        }

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @Then("^Launch chrome browser using browserStack$")
    public void launch_browserStack_using_browerStack() throws IOException {

        driver.get(getValueFromDataConfig("Live.Web.Url"));
        // driver.get("https://www.onemindindia.com/home");
        driver.getWindowHandle();
        driver.manage().window().maximize();
    }

    @Then("^Click Login for BanyanTask using browserStack$")
    public void click_Login_for_BanyanTask_using_browserStack() throws IOException {
        clickLoginButton(driver);
    }

    @Then("^Enter Phone number for BanyanTask using browserStack$")
    public void enter_phone_number_for_BanyanTask_using_browserStack() throws IOException {
        enterPhoneNumber(driver, getValueFromDataConfig("MobileNumber"));
    }

    @Then("^Enter otp using browserStack$")
    public void enter_otp_using_browserStack() throws IOException {
        enterOtp(driver, getValueFromDataConfig("OTP"));

    }

    @Then("^Then click countinue button BanyanTask using browserStack$")
    public void then_Click_countinue_button_using_browserStack() throws InterruptedException, IOException {
        clickCountinueButton(driver);
        Thread.sleep(3000);
    }

    @Then("^Wait action for \"([^\"]*)\" seconds BanyanTask using browserStack$")
    public void wiat_time_using_browserStack(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Then("^assert login using browserStack$")
    public void assert_login_using_browserStack() throws IOException {
        verificationAssert(driver);
    }

    @Then("^assert project availabilty using browserStack$")
    public void assert_project_availability_using_browserstack() throws IOException {
        assertProjectAvailableOrNot(driver);
    }

    @Then("^assert task availability using browserStack$")
    public void assert_task_availability_using_browserStack() throws IOException {
        assertTaskAvailableOrNot(driver);

    }

    @Then("Enter panic password")
    public void ente_panic_password() throws IOException {
        enterPanicPassword(driver);
    }

    @Then("^Quit driver using browserStack$")
    public void quit_driver_using_browserStack() {
        quitDriver(driver);
    }

}
