package utils.driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    protected static AppiumDriver appiumDriver;
    protected static DesiredCapabilities capabilities;

    @BeforeSuite
    public void startDriver() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage","com.mobisoft.kitapyurdu");
        capabilities.setCapability("appActivity", "com.mobisoft.kitapyurdu.main.SplashActivity");
        capabilities.setCapability("platformName", "Android");
        appiumDriver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterSuite
    public void closeDriver(){
        if(appiumDriver!=null){
            appiumDriver.quit();
        }
    }
}