package Practise1;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

// BUTTON CLICK , TEXT BOX ENTER TEXT , SELECT CHECKBOX , SELECT RADIO BUTTON
public class ClickButtonTextBoxRadioButton {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
       //  WebDriver driver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Medium Phone");
        capabilities.setCapability("platformVersion", "API 36");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiActivity");

        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        AndroidDriver driver=new AndroidDriver(url,capabilities);

        System.out.println("Application started successfully");

        // click on view button , unique nahi h kafi elements h same id se tho particular idex jo select karna h vo provide kar diya index
        driver.findElements(By.id("text1")).get(10).click();

        // enter the text in textbox
        driver.findElement(By.id("text2")).sendKeys("ABC");

        // select the checkbox
        driver.findElement(By.id("checkbox1")).click();

        // radio button
        driver.findElement(By.id("radio2")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
