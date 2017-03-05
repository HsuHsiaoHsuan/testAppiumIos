import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class testiOSappium {

    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.6.3");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "10.2");
        capabilities.setCapability("deviceName", "iPhone 7");
        // app 屬性的值要指向要測試的 .app 或 .ipa 檔案
        capabilities.setCapability("app", "/Users/hsuhsiaohsuan/Desktop/ios test app/testAppiumiOS.app");
        capabilities.setCapability("deviceOrientation", "portrait");


        WebDriver wd = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        clickMe(wd);

        wd.quit();
    }

    private static void clickMe(WebDriver wd) {
        wd.findElement(By.name("click me")).click();
        wd.findElement(By.name("OK")).click();
    }
}
