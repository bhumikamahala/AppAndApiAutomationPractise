package Practise1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

// BUTTON CLICK , TEXT BOX ENTER TEXT , SELECT CHECKBOX , SELECT RADIO BUTTON
public class ClickButtonTextBoxRadioButton1 {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
       //  WebDriver driver = new ChromeDriver();
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Medium Phone");

        // Use the Android version (or omit this line)
        // options.setPlatformVersion("16");

        options.setAppPackage("in.swiggy.android.toing");
        options.setAppActivity("in.swiggy.android.HomeIcon");

        URL url = URI.create("http://127.0.0.1:4723").toURL();

        AndroidDriver driver=new AndroidDriver(url,options);

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
