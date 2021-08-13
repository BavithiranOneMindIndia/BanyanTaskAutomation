package com.banyantask;

import java.util.HashMap;
import java.util.Map;

import com.browserstack.local.Local;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MainPageLocalBanyanTask extends SuperClass {

    private static Local localInstance;
    public static String userName = "bavithiranramesh1";
    public static String accessKey = "Ske79rFvf8RZsz3rPo9e";

    public static void setupLocal() throws Exception {
        localInstance = new Local();
        Map<String, String> options = new HashMap<String, String>();
        options.put("key", accessKey);
        localInstance.start(options);
    }

    public static void tearDownLocal() throws Exception {
        localInstance.stop();
    }

    public void launch_BrowserStackLocal() throws Exception {

        // Start the BrowserStack Local binary
        setupLocal();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set your access credentials
        capabilities.setCapability("browserstack.user", userName);
        capabilities.setCapability("browserstack.key", accessKey);

        // Set URL of the application under test
        capabilities.setCapability("app", "bs://<app-id>");

        // Specify device and os_version for testing
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");

        // Set the browserstack.local capability to true
        capabilities.setCapability("browserstack.local", true);

        // Set other BrowserStack capabilities
        capabilities.setCapability("project", "BanyanTask-AutomationProject");
        capabilities.setCapability("build", "1.0-Banyan");
        capabilities.setCapability("name", "local_test");

    }

}
