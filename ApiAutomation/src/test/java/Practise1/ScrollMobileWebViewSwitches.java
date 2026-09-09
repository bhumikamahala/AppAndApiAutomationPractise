package Practise1;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ScrollMobileWebViewSwitches {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "OnePlus");
        capabilities.setCapability("platformVersion", "15.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiActivity");

        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        AndroidDriver driver=new AndroidDriver(url,capabilities);

        System.out.println("Application started successfully");

    }
}
