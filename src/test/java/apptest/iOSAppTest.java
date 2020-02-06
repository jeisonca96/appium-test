package apptest;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class iOSAppTest {

    IOSDriver driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String testName = "Testing iOS App with Java";
    String accessKey = System.getenv("eyJ4cC51Ijo3OTIyMzE2LCJ4cC5wIjo3OTIyMzE1LCJ4cC5tIjoiTVRVNE1Ea3pPRFF3TlRZd05RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4OTYyOTk0OTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.YczD5g_HH-M8eZxjFTk_kazSXMhdA-iPTABfR8DjTD0");

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        //install the app on the device
        dc.setCapability(MobileCapabilityType.APP, "http://d242m5chux1g9j.cloudfront.net/EriBank.ipa");
        //get an iOS device
        dc.setCapability("platformName", "iOS");
        dc.setCapability("autoDismissAlerts", true);
        //launch the app
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");

        driver = new IOSDriver(new URL("https://cloud.seetest.io:443/wd/hub"), dc);
    }

    @Test
    public void testYouriOSApp() {

        driver.findElement(By.xpath("//*[@text='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='loginButton']")).click();
        driver.findElement(By.xpath("//*[@text='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='Phone']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@text='Name']")).sendKeys("Test");
        driver.findElement(By.xpath("//*[@text='Amount']")).sendKeys("10");
        driver.findElement(By.xpath("//*[@text='Country']")).sendKeys("US");
        driver.findElement(By.xpath("//*[@text='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();

    }

    @After
    public void tearDown() {
        if (driver != null)
        {
            driver.quit();
            System.out.println("Report URL : " + driver.getCapabilities().getCapability("reportUrl"));

        }
    }

}